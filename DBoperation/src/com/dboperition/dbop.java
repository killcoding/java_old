/*ͨ��jdbc�������ݿ�
 * ����STUDENTS��
 * 1.�Ƚ�������Դ�����ã�����壬ϵͳ �������ߣ�odbc
 * 2.�ٳ�������������Դ
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
			//1.��������:����Ҫ��������������ڴ�
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("�ɹ���������");
			//2.�õ����� �ƶ����ӵ��ĸ�����Դ��֮ǰ���õģ�
			ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=School","sa","feiyang");//ѡ�����windows��֤�����Բ���Ҫ�û������������֤
			System.out.println("�ɹ��õ�����");
			//3.����statement����preparedstatement
			//��Ҫ���ڷ���sql���
			
			ps = ct.prepareStatement("select ID from STUDENTS");
			//4ִ�����[��ѯ��֮�µģ���ɾ����update]
			rs = ps.executeQuery();
			//ѭ��ȡ������
			while(rs.next())//ָ��ָ���һ�����ݵ�ǰ��
			{
				System.out.println(rs.getInt(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ر�һЩ��Դ
			
			}
	}

}
