package com.example.test.Drools.Kie;

import com.mysql.cj.MysqlConnection;

import java.sql.*;
import java.util.*;

public class getTables {
    private static final String address = "jdbc:mysql://127.0.0.1/test?characterEncoding=utf-8&serverTimezone=GMT&useSSL=false";
    private static final String userName = "root";
    private static final String password = "root";

    public static void main(String[] args) throws SQLException {
        //获取连接
        Connection connection = getConnection(address,userName,password);

        //获取表名
        ResultSet tmp = getResultSet(connection,"show tables from test");

        //清洗SQL结果，获取表名集合}
        ArrayList TablesResult = result(tmp,"TABLE_NAME");


        for (Object object : TablesResult) {
            System.out.println("表名："+(String)object);
            ResultSet resultSet = getResultSet(connection,
                    "select COLUMN_NAME,DATA_TYPE,COLUMN_COMMENT " +
                    "from information_schema.COLUMNS" +
                    " where table_name = '"+(String)object+"' and table_schema = 'test';");
            ArrayList columnName = result(resultSet,"COLUMN_NAME");
            System.out.println("表内字段名："+columnName);
            System.out.println();
        }
    }

    public static Connection getConnection(String address,String userName,String password){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(address,userName,password);
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet getResultSet(Connection connection, String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        return resultSet;
    }

    public static ArrayList result(ResultSet resultSet,String target) throws SQLException {
        ArrayList<Map> temp = new ArrayList<>();
        ArrayList result = new ArrayList();

        ResultSetMetaData keys = resultSet.getMetaData();
        int columnCount = keys.getColumnCount();//获取行的数量

        while (resultSet.next()) {
            Map rowData = new HashMap();//声明Map
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(keys.getColumnName(i), resultSet.getObject(i));//获取键名及值
            }
            temp.add(rowData);
        }
        for (Map map : temp) {
            result.add(map.get(target));
        }
        return result;
    }

}
