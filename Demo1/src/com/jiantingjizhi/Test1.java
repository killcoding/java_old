/*
 * 事件处理机制,采用委派事件模型
 * 暂时使用JPanel的背景颜色功能演示监听机制
 * 注意：监听需要先注册，
 * 如jb1.addActionListener(this);//在事件源上添加监听者
 * 括号中为监听此事件的相关类，只有监听的类才会接受到事件源发出的时间处理请求
 */
package com.jiantingjizhi;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;//事件处理包
public class Test1 extends JFrame implements ActionListener{

	/**
	 * @param args
	 */
	JPanel mp = new JPanel();
	JButton jb1 = null;
	JButton jb2 = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test1  test1 = new Test1();
	}
	
	public Test1()
	{
		mp = new JPanel();
		jb1 = new JButton("黑色");
		
		jb2 = new JButton("红色");
		
		this.add(jb1,BorderLayout.NORTH);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		//注册监听
		jb1.addActionListener(this);//在事件源上添加监听者
		//制定action命令
		jb1.setActionCommand("黑色");
		
		jb2.addActionListener(this);
		jb2.setActionCommand("红色");
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

	@Override
	//对事件处理的方法
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断是哪个事件源发声
		if(e.getActionCommand().equals("黑色"))
		{
			System.out.println("按下黑色");
			mp.setBackground(Color.black);
		}else if(e.getActionCommand().equals("红色"))
		{
			System.out.println("按下红色");
			mp.setBackground(Color.red);
		}
	}

}

//class MyPanel extends JPanel
//{
//	public void paint(Graphics g)
//	{
//		super.paint(g);
//		
//		
//	
//	}
//}