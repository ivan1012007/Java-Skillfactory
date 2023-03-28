package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class Main {
    public static void main(String[] args){


       // App app = new App();
        //app.connect();
//app.testing(3);
        //app.transferMoney(1,3,5000);
        //app.getMoney(3);
        App app = new App();
        app.getMoney(1);
        app.putMoney(1,6000);
        app.takeMoney(1,5000);
        app.getMoney(1);
      //app.getOperationList(1,"2023-03-15", "2023-03-19");








    }
}


