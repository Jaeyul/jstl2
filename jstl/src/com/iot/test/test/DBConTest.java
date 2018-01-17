package com.iot.test.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConTest {

   public static Connection getCon() {
      String url = "jdbc:mariadb://localhost:3306/iot2";
      String user = "root";
      String password = "test";
      Connection con = null;
      try {
         Class.forName("org.mariadb.jdbc.Driver");
         con = DriverManager.getConnection(url, user, password);
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
      return con;
   }
}