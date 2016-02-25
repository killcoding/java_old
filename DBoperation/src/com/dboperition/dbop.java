/*通过jdbc操作数据库
 * 操作STUDENTS表
 * 1.先进性数据源的配置，再面板，系统 ，管理工具，odbc
 * 2.再程序中连接数据源
 * 
 * */
package com.dboperition;
import java.sql.*;

public class dbop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		Connection ct= null;
		ResultSet rs = null;
		
		try {
			//1.加载驱动:把需要的驱动程序加入内存
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("成功加载驱动");
			//2.得到连接 制定连接到哪个数据源（之前设置的）
			ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=School","sa","feiyang");//选择的是windows验证，所以不需要用户名和密码的验证
			System.out.println("成功得到连接");
			//3.创建statement或者preparedstatement
			//主要用于发送sql语句
			
			ps = ct.prepareStatement("select ID from STUDENTS");
			//4执行语句[查询用之下的，增删改用update]
			rs = ps.executeQuery();
			//循环取出内容
			while(rs.next())//指针指向第一个内容的前面
			{
				System.out.println(rs.getInt(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//关闭一些资源
			
			}
	}

}
