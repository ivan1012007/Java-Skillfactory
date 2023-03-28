package org.example;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
 //import org.json.simple.JSONObject;
import org.json.*;


import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Stack;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import static javax.swing.UIManager.getInt;
@Controller
@RequestMapping("/app")

public class App {

    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "vanush";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
@GetMapping("/getMoney")
@RequestMapping(value = "/getMoney", method = RequestMethod.GET)
@ResponseBody
    public JSONObject getMoney(int user_id) {
        JSONObject obj = new JSONObject();
        JSONObject obj1 = new JSONObject();
        String userid = "UserId";
        String userbalance = "UserBalance";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "vanush";
        String user_id1 = String.valueOf(user_id);
        String[] query = new String[3];
        query[0] = "SELECT * FROM user_balance WHERE user_id = ";
        query[1] = user_id1;
        query[2] = ";";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(Arrays.toString(query).replace(",", "")  //remove the commas
                     .replace("[", "")  //remove the right bracket
                     .replace("]", "")  //remove the left bracket
                     .trim())) {
            pst.execute();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                int balance = rs.getInt("user_balance");
                int code = 1;
                obj.put(userid, id);
                obj.put(userbalance, balance);
                obj.put("Код", code);
                System.out.println(obj);
            }
            return obj;
        } catch (SQLException ex) {
            int code = -1;
            obj.put("Код", code);
            obj.put("Значение:", ex.getMessage());
            //  System.out.println(obj);
            return obj;
        }
    }
    @RequestMapping(value = "/putMoney", method = RequestMethod.PUT)
    public JSONObject putMoney(int user_id, int sum) {
        String userid = "UserId";
        String userbalance = "UserBalance";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "vanush";
        JSONObject jsn = new JSONObject();
        JSONObject jsn1 = new JSONObject();
        JSONObject jsn2 = new JSONObject();
        String sumput = String.valueOf(sum);
        String MoneySum[] = new String[6];
        String sum1 = String.valueOf(sum);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String op1 = dtf.format(now);
        String user_id1 = String.valueOf(user_id);
        String addToOperations[] = new String[9];
        addToOperations[0] = "insert into operations ( ";
        addToOperations[1] = "user_id";
        addToOperations[2] = ", operation_type, operation_sum, operation_date) values ( ";
        addToOperations[3] = user_id1;
        addToOperations[4] = ", 'MoneyPut', ";
        addToOperations[5] = sumput;
        addToOperations[6] = ", '";
        addToOperations[7] = op1;
        addToOperations[8] = "');";
        String task = addToOperations[0] + addToOperations[1] + addToOperations[2] + addToOperations[3] + addToOperations[4] + addToOperations[5] + addToOperations[6] + addToOperations[7] + addToOperations[8];
        //System.out.println(task);
        MoneySum[0] = "UPDATE user_balance SET user_balance = user_balance +";
        MoneySum[1] = sum1;
        MoneySum[2] = "WHERE";
        MoneySum[3] = "user_id =";
        MoneySum[4] = user_id1;
        MoneySum[5] = ";";
        int limit = 100000;
        if (sum < limit) {
            try (Connection con = DriverManager.getConnection(url, user, password);
                 Connection con2 = DriverManager.getConnection(url, user, password);
                 PreparedStatement task1 = con2.prepareStatement(task);
                 PreparedStatement pst = con.prepareStatement(Arrays.toString(MoneySum).replace(",", "")  //remove the commas
                         .replace("[", "")  //remove the right bracket
                         .replace("]", "")  //remove the left bracket
                         .trim())) {
                pst.execute();
                task1.execute();
                jsn.put("Код", 1);
                jsn.put("Значение:", "Успех");
                System.out.println(jsn);
                return jsn;
            } catch (SQLException ex) {
                int code = -1;
                jsn1.put("Код", code);
                jsn1.put("Значение:", ex.getMessage());
                System.out.println(jsn1);
                return jsn1;
            }
        } else {
            int code = 0;
            jsn2.put("Код", code);
            jsn2.put("Значение:", "Слишком большая сумма");
            System.out.println(jsn2);
            return jsn2;
        }
    }

    @RequestMapping(value = "/putMoney", method = RequestMethod.PUT)
    public JSONObject takeMoney(int user_id, int sum) {
int compare = getMoney(user_id).getInt("UserBalance");
        JSONObject obj1 = new JSONObject();
if (compare < sum) { int code = 0;
    obj1.put("Код:", code);
    obj1.put("Значение:", "Недостаточно средств для снятия!");
    System.out.println(obj1);
return obj1;
} else {
        String userid = "UserId";
        String userbalance = "UserBalance";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "vanush";
        String user_id1 = String.valueOf(user_id);
        String sum1 = String.valueOf(sum);
        String[] query = new String[3];
        query[0] = "SELECT * FROM user_balance WHERE user_id = ";
        query[1] = user_id1;
        query[2] = ";";
        String sumtake = String.valueOf(sum);
        String MoneySum[] = new String[6];
        // String sum1 = String.valueOf(sum);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String op1 = dtf.format(now);
        String user_id12 = String.valueOf(user_id);
        String addToOperations[] = new String[9];
        addToOperations[0] = "insert into operations ( ";
        addToOperations[1] = "user_id";
        addToOperations[2] = ", operation_type, operation_sum, operation_date) values ( ";
        addToOperations[3] = user_id12;
        addToOperations[4] = ", 'MoneyTake', ";
        addToOperations[5] = sumtake;
        addToOperations[6] = ", '";
        addToOperations[7] = op1;
        addToOperations[8] = "');";
        String task = addToOperations[0] + addToOperations[1] + addToOperations[2] + addToOperations[3] + addToOperations[4] + addToOperations[5] + addToOperations[6] + addToOperations[7] + addToOperations[8];
        System.out.println(task);
        JSONObject jsn = new JSONObject();
        JSONObject jsn1 = new JSONObject();
        try (Connection con = DriverManager.getConnection(url, user, password);
             Connection con1 = DriverManager.getConnection(url, user, password);
             PreparedStatement pst1 = con1.prepareStatement(task);
             PreparedStatement pst = con.prepareStatement(Arrays.toString(query).replace(",", "")  //remove the commas
                     .replace("[", "")  //remove the right bracket
                     .replace("]", "")  //remove the left bracket
                     .trim())) {
            pst.execute();
            pst1.execute();
            ResultSet rs = pst.executeQuery();
            int balance1 = rs.getInt("user_balance");

        } catch (SQLException ex1) {
            int code = -1;
            obj1.put("Код", code);
            obj1.put("Значение:", ex1.getMessage());
        }
        String[] query2 = new String[6];
        query2[0] = "UPDATE user_balance SET user_balance = user_balance - ";
        query2[1] = sum1;
        query2[2] = " WHERE ";
        query2[3] = "user_id = ";
        query2[4] = user_id1;
        query2[5] = ";";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst1 = con.prepareStatement(Arrays.toString(query2).replace(",", "")  //remove the commas
                     .replace("[", "")  //remove the right bracket
                     .replace("]", "")  //remove the left bracket
                     .trim())) {

            pst1.execute();
            // int balance = pst1.
            // if (sum1 >= balance)
            obj1.put("Код", 1);
            obj1.put("Значение:", "успех");
            System.out.println(obj1);
            return obj1;
        } catch (SQLException ex) {
            int code = -1;
            obj1.put("Код", code);
            obj1.put("Значение:", ex.getMessage());
            System.out.println(jsn1);
            return obj1;
        }

    } }

    public JSONObject getOperationList(int user_id, String date1, String date2) {
        JSONObject obj = new JSONObject();
        JSONObject obj1 = new JSONObject();
        /* String datess1 = String.valueOf(dates1);
        String datess2 = String.valueOf(dates2); */
        String userid = "UserId";
        String userbalance = "UserBalance";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "vanush";
        String user_id1 = String.valueOf(user_id);

        // String sum1 = String.valueOf(sum);
        if ((date1 == null && date2 == null) || (date1 == null && date2 != null) || (date1 != null && date2 == null)) {
            String[] query = new String[3];
            query[0] = "SELECT * FROM operations WHERE user_id = ";
            query[1] = user_id1;
            query[2] = ";";
            JSONObject jsn = new JSONObject();
            JSONObject jsn1 = new JSONObject();
            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pst = con.prepareStatement(Arrays.toString(query).replace(",", "")  //remove the commas
                         .replace("[", "")  //remove the right bracket
                         .replace("]", "")  //remove the left bracket
                         .trim())) {
                //   pst.execute();
                String[] getRSar = new String[0];
                //String[] getRS = new String[];
                int i = 0;
                int j = 1;
                // JSONObject[] objs = new JSONObject[i];
                ResultSet rs = pst.executeQuery();

                List<JSONObject> returns = new Stack<>();
                List<JSONObject> returnsa = new ArrayList<>();
                while (rs.next()) {
                    i++;
                    j++;
                    String[] getRS = new String[i + 1];
                    JSONObject[] objs = new JSONObject[j];
                    int id = rs.getInt("user_id");
                    int operationId = rs.getInt("operation_id");
                    int operationSum = rs.getInt("operation_sum");
                    int code = 1;
                    Date operationDate = rs.getDate("operation_date");
                    String operationType = rs.getString("operation_type");
                    /*  objs[i].put("operationId", operationId);
                    objs[i].put("userid", id);
                    objs[i].put("operationSum", operationSum);
                    objs[i].put("operationType", operationType);
                    objs[i].put("operationDate",operationDate);
                    objs[i].put("Код", code); */
                   /* obj.put("operationId", operationId);
                    obj.put("userid", id);
                    obj.put("operationSum", operationSum);
                    obj.put("operationType", operationType);
                    obj.put("operationDate",operationDate);
                    obj.put("Код", code); */
                    //returns.add();
                    // returnsa.add(objs[i]);
                    getRS[i] = "user_id: " + id + " operation_id: " + operationId + " operation_sum: " + operationSum + " Код: " + code + " operationDate: " + operationDate + " operation_type: " + operationType;
                    System.out.println(getRS[i]);
                }


            } catch (SQLException ex1) {
                int code = -1;
                obj.put("Код", code);
                obj.put("Значение:", ex1.getMessage());
                System.out.println(obj);
                return obj;
            }
        } else {
            Date dates1 = java.sql.Date.valueOf(date1);
            Date dates2 = java.sql.Date.valueOf(date2);
            String[] query = new String[7];
            query[0] = "SELECT * FROM operations WHERE user_id = ";
            query[1] = user_id1;
            query[2] = "and operation_date >= '";
            query[3] = date1;
            query[4] = "' and operation_date <= '";
            query[5] = date2;
            query[6] = "';";

            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pst = con.prepareStatement(Arrays.toString(query).replace(",", "")  //remove the commas
                         .replace("[", "")  //remove the right bracket
                         .replace("]", "")  //remove the left bracket
                         .trim())) {
                ResultSet rs = pst.executeQuery();
                int i=0;

                while (rs.next()) {
                    i++;
                    JSONObject[] objs = new JSONObject[i+1];
                    String[] getRS = new String[i+1];
                    for (int j = 0; j<objs.length; j++);
                    int id = rs.getInt("user_id");
                    int operationId = rs.getInt("operation_id");
                    int operationSum = rs.getInt("operation_sum");
                    int code = 1;
                    Date operationDate = rs.getDate("operation_date");
                    String operationType = rs.getString("operation_type");
                    getRS[i] = "user_id: " + id + " operation_id: " + operationId + " operation_sum: " + operationSum + " Код: " + code + " operationDate: " + operationDate + " operation_type: " + operationType;
                    System.out.println(getRS[i]);
                    objs[i].put("operationId", operationId);
                    objs[i].put("userid", id);
                    objs[i].put("operationSum", operationSum);
                    objs[i].put("operationType", operationType);
                    objs[i].put("operationDate",operationDate);
                    objs[i].put("Код", code);
                    System.out.println(objs);
                    //return obj;
                }


            } catch (SQLException ex1) {
                int code = -1;
                obj.put("Код", code);
                obj.put("Значение:", ex1.getMessage());
                System.out.println(obj);
                return obj;
        }
        return obj1;
    }
      return obj1;
    }

    public JSONObject transferMoney(int id1, int id2, int sum){
    JSONObject obj1 = new JSONObject();
    int BalanceId1 = getMoney(id1).getInt("UserBalance");
    if (BalanceId1 < sum) {
        obj1.put("Значение", "Недостаточно средств для перевода");
        obj1.put("Код:", 0);
        System.out.println(obj1);
        return obj1;
    }
       else if (sum >= 100000) {
            int code1 = 0;
            obj1.put("Код:", code1);
            obj1.put("Значение", "Сумма перевода превышает максимально возможную");
            System.out.println(obj1);
            return obj1;
        } else  {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String op1 = dtf.format(now);
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "vanush";
        String user_id1 = String.valueOf(id1);
        String user_id2 = String.valueOf(id2);
        String TransferSum = String.valueOf(sum);
        String[] query1 = new String[5];
        query1[0] = "UPDATE user_balance set user_balance = user_balance - ";
        query1[1] = TransferSum;
        query1[2] = " WHERE user_id = ";
        query1[3] = user_id1;
        query1[4] = ";";
        String[] query2 = new String[5];
        query2[0] = "UPDATE user_balance set user_balance = user_balance + ";
        query2[1] = TransferSum;
        query2[2] = " WHERE user_id = ";
        query2[3] = user_id2;
        query2[4] = ";";
        String[] query3 = new String[9];
        query3[0] = "insert into operations ( ";
        query3[1] = "user_id";
        query3[2] = ", operation_type, operation_sum, operation_date) values ( ";
        query3[3] = user_id1;
        query3[4] = ", 'TransferToSomeone', ";
        query3[5] = TransferSum;
        query3[6] = ", '";
        query3[7] = op1;
        query3[8] = "');";
        String[] query4 = new String[9];
        query4[0] = "insert into operations ( ";
        query4[1] = "user_id";
        query4[2] = ", operation_type, operation_sum, operation_date) values ( ";
        query4[3] = user_id2;
        query4[4] = ", 'TransferFromSomeone', ";
        query4[5] = TransferSum;
        query4[6] = ", '";
        query4[7] = op1;
        query4[8] = "');";
        String task1 = query3[0] + query3[1] + query3[2] + query3[3] + query3[4] + query3[5] + query3[6] + query3[7] + query3[8];
        String task2 = query4[0] + query4[1] + query4[2] + query4[3] + query4[4] + query4[5] + query4[6] + query4[7] + query4[8];
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(Arrays.toString(query1).replace(",", "")  //remove the commas
                     .replace("[", "")  //remove the right bracket
                     .replace("]", "")  //remove the left bracket
                     .trim());
             PreparedStatement pst1 = con.prepareStatement(Arrays.toString(query2).replace(",", "")  //remove the commas
                     .replace("[", "")  //remove the right bracket
                     .replace("]", "")  //remove the left bracket
                     .trim());
             PreparedStatement pst2 = con.prepareStatement(task1);
        PreparedStatement pst3 = con.prepareStatement((task2))) {

            pst.execute();
            pst1.execute();
            System.out.println(task1);
            System.out.println(task2);
            pst2.execute();
            pst3.execute();
            int code = 1;
            String znach = "Успех";
            obj1.put("Код", code);
            obj1.put("Значение", znach);
            System.out.println(obj1);
            return obj1;

        } catch (SQLException ex1) {
            int code = -1;
            obj1.put("Код", code);
            obj1.put("Значение:", ex1.getMessage());
System.out.println(obj1);
            return obj1;
        }
    }
}
}


