package org.example;

import org.json.simple.JSONObject;

import java.sql.Date;
import java.util.Arrays;

public class DBclass {
    /*  JSONObject[] objs = new JSONObject[j];
    int id = rs.getInt("user_id");
    int operationId = rs.getInt("operation_id");
    int operationSum = rs.getInt("operation_sum");
    int code = 1;
    Date operationDate = rs.getDate("operation_date");
    String operationType = rs.getString("operation_type"); */
    int a = 0;
    int b = 0;
    int v = 0;
    int d = 0;



    public void dbput() {
        int j = 0;
            for(int i = 0; i < 10; i++) {
                j++;
               a++;
               b++;
               v++;
                d++;
int[] a1 = new int[j+1];
a1[j] = a;
System.out.println(Arrays.toString(a1));

                //JSONObject[] objs = new JSONObject[j+1];
      // objs[j].put("a", a);
    }
}}



