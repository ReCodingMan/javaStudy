package jdbc.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {

    public static void main(String[] args) {

        Statement stmt = null;
        Connection conn = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、定义 sql
            String sql = "insert into student values(null,'mary',1)";
            //3、获取 Connection 对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "");
            //4、获取执行 sql 对象 Statement
            stmt = conn.createStatement();
            //5、执行 sql
            int count = stmt.executeUpdate(sql);

            System.out.println(count);
            if(count > 0){
                System.out.println("添加成功!");
            }else{
                System.out.println("添加失败!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
