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
public class UserRegister extends HttpServlet {

  private static final Logger log = Logger.getLogger(UserRegister.class);
  public UserRegister() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      request.getServletContext().getRequestDispatcher("/register.jsp")
          .forward(request, response);
    } catch (Exception ex) {
      log.error(ex.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String password = request.getParameter("password");
    String confirm = request.getParameter("passwordConfirm");

    boolean passwordsMatch = passwordCheck(password, confirm);

    if (passwordsMatch) {
      getRegistrationData(request, response);
    } else {
      String message = "User registration failed, mismatched passwords.";
      failRegistration(message, request, response);
    }
  }

  private static void getRegistrationData(HttpServletRequest request, HttpServletResponse response) {

    User newUser = new User();

    newUser.setEmail(request.getParameter("email"));
    newUser.setUsername(request.getParameter("username"));
    newUser.setPassword(request.getParameter("password"));

    boolean success = registerUser(newUser);

    if (success) {
      log.info(newUser.getUsername() + " successfully registered.");
      try {
        request.setAttribute("reg_success", true);
        request.setAttribute("message", newUser.getUsername() + " successfully registered! Please log in.");
        request.getServletContext().getRequestDispatcher("/")
            .forward(request, response);
      } catch (Exception ex) {
        log.error(ex.getMessage());
      }
    } else {
      failRegistration(newUser.getUsername() + " registration failed.", request,
          response);
    }
  }

  private static boolean registerUser (final User newUser){
    try {
      SessionFactory factory = HibernateUtil.getSessionFactory();
      Session session = factory.openSession();
      session.beginTransaction();
      session.save(newUser);
      session.getTransaction().commit();
      session.close();
      return true;
    } catch (Exception ex) {
      log.error(ex.getMessage());
    }

    return false;
  }

  private static void failRegistration (String message, HttpServletRequest request, HttpServletResponse response){
    log.error(message);

    try {
      request.setAttribute("reg_success", false);
      request.setAttribute("message", message);
      request.getServletContext().getRequestDispatcher("/register.jsp")
          .forward(request, response);
    } catch (Exception ex) {
      log.error(ex.getMessage());
    }
  }

  private static boolean passwordCheck(final String password, final String confirm) {
    return password.equals(confirm);
  }
}
