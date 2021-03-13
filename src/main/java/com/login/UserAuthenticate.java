package com.login;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class UserAuthenticate extends HttpServlet {

  private static final Logger log = Logger.getLogger(UserAuthenticate.class);

  public UserAuthenticate() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {
    try {
      request.getServletContext().getRequestDispatcher("/login.jsp")
          .forward(request, response);
    } catch (Exception ex) {
      log.error(ex.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    User resultUser = new User();

    try {
      SessionFactory factory = HibernateUtil.getSessionFactory();
      Session session = factory.openSession();

      String hql = "FROM User U WHERE U.username = :username";
      Query query = session.createQuery(hql);
      query.setParameter("username", username);
      resultUser = (User)query.getSingleResult();

      session.close();
    } catch (Exception ex) {
      log.error(ex.getMessage());
    }

    if (resultUser.getUsername() == null) {
      log.error(username + " not found.");
      loginFail(username + " not found. Please try again.", request, response);

    } else {

      boolean authentic = authenticatePass(resultUser, password);

      if (authentic) {
        log.info(username + " successfully logged in.");
        try {
          request.setAttribute("login_username", username);
          request.getServletContext().getRequestDispatcher("/landing.jsp")
              .forward(request, response);
        } catch (Exception ex) {
          log.error(ex.getMessage());
        }

      } else {
        log.error(username + " login failed. Wrong password.");
        loginFail("Incorrect password entered. Please try again.", request, response);
      }
    }
  }

  private static boolean authenticatePass(final User user, final String password) {
    return user.getPassword().equals(password);
  }

  private static void loginFail(String message, HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    try {
      request.setAttribute("message", message);
      request.getServletContext().getRequestDispatcher("/index.jsp")
          .forward(request, response);
    } catch (Exception ex) {
      log.error(ex.getMessage());
    }
  }
}
