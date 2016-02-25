/*
 * 多种布局管理器的使用
 * JPanel布局默认是FlowLayout
 */

package com.jpanel;
import java.awt.*;
import javax.swing.*;

public class Test extends JFrame{

	//定义需要的组件
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test = new Test();
	}

	//构造函数
	public Test()
	{
		//创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jb1 = new JButton("按钮1");
		jb2 = new JButton("按钮2");
		jb3 = new JButton("按钮3");
		jb4 = new JButton("按钮4");
		jb5 = new JButton("按钮5");
		jb6 = new JButton("按钮6");
		
		//设置布局，JFrame默认是边界布局
		
		//添加组件,添加到panel
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		
		//将panel添加到jfeame
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.add(jb6,BorderLayout.CENTER);
		
		//设置窗体
		this.setTitle("多种布局管理器使用");
		this.setSize(300,300);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//显示窗体
		this.setVisible(true);
	}
}
