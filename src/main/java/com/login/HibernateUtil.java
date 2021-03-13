package com.login;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static final Logger log = Logger.getLogger(HibernateUtil.class);
  private static SessionFactory sessionFactory;

  static {
    try {
      Configuration config = new Configuration();
      config.configure("hibernate.cfg.xml");
      config.addAnnotatedClass(User.class);
      //config.addResource("EProduct.hbm.xml");

      StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
          .configure().build();

      Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
      sessionFactory = metaData.getSessionFactoryBuilder().build();

    } catch (Exception ex) {
      log.error(ex.getMessage());
      log.error(ex.getStackTrace());
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
