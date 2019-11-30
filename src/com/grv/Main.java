package com.grv;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection conn = DBUtil.getConnection();
        // Statement
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Student (id, name) VALUES (?, ?)");
        String query1 = "INSERT INTO Student (id, name) ";
        Scanner sc = new Scanner(System.in);
        int count = 3;

        // Saving 3 Rows in DB
        while(count > 0) {
            System.out.println("Enter id");
            int id = sc.nextInt();
            System.out.println("Enter name");
            String name = sc.next();

            ps.setInt(1, id);
            ps.setString(2, name);


            ps.executeUpdate();
            count--;
        }


        System.out.println("Success");
        System.out.println("Reading from Database : ");
        // Execute Query
        String query = "select * from Student";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        // Getting all rows from db;
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id +  "  " + name);
        }
    }
}
