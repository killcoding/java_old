
/*
 * 一些swing组件使用，创建一个登陆框
 * 用到：标签JLable，文本框LTextField，密码框JPasswordField
 */
package com.swing;
import java.awt.*;
import javax.swing.*;

public class Test extends JFrame {

	//定义组件
	JPanel jp1,jp2,jp3;		//	
	JLabel jl1,jl2;			//标签组件
	JButton jb1,jb2;	//按钮组件
	JTextField jt1;		//文本框组件
	JPasswordField jps;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test = new Test();
	}
	
	//构造函数
	public Test()
	{
		//创建组价
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jl1 = new JLabel("用户名");
		jl2 = new JLabel("密    码");
		jb1 = new JButton("登陆");
		jb2 = new JButton("取消");
		jt1 = new JTextField(10);
		jps = new JPasswordField(10);
		
		//设置布局管理器
		this.setLayout(new GridLayout(3,1));
		
		//加入各个组件
		jp1.add(jl1);
		jp1.add(jt1);
		jp2.add(jl2);
		jp2.add(jps);
		jp3.add(jb1);
		jp3.add(jb2);
		
		//将面板组件加入到JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//设置窗体
		this.setTitle("登陆窗口");
		this.setSize(300, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//显示
		this.setVisible(true);
	}

}
