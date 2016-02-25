/*
 * 选项卡窗格JTabbedPane
 * qq登陆界面
 * 
 */
package com.swing;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.*;
import javax.swing.border.Border;
public class Test5 extends JFrame{

	//北部区域，一张图片放在jlabel中
	JLabel jl1;
	//南部区域两个按钮
	JButton jb1,jb2,jb3;
	JPanel jp1;
	
	//中部区域
	JTabbedPane jtp;	//选项卡窗格
	JPanel jp2,jp3,jp4;
	JLabel jl2,jl3,jl4,jl5,jl6,jl7;
	//放置号码
	JTextField jtf;
	//放置密码
	JPasswordField jpf;
	JButton jb4;
	//隐身登陆，记住密码
	JCheckBox jcb1,jcb2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test5 test5 = new Test5();
	}
	//构造函数
	public Test5()
	{
		//创建组件
		jl2 = new JLabel("qq号码",JLabel.CENTER);
		jl6 = new JLabel("手机号码",JLabel.CENTER);
		jl7 = new JLabel("邮箱",JLabel.CENTER);
		jl3 = new JLabel("qq密码",JLabel.CENTER);
		jl4 = new JLabel("忘记密码",JLabel.CENTER);
		//设置忘记密码的字体
		jl4.setFont(new Font("宋体",Font.PLAIN,16));
		jl4.setForeground(Color.blue);	//设置字体颜色
		jl5 = new JLabel("<html><a href = 'www.qq.com'>申请密码保护</a>");//设置连接
		jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//移动到这个标签上时鼠标变成小手
		//输入号码框
		jtf = new JTextField();
		//输入密码框
		jpf = new JPasswordField();
		jb4 = new JButton(new ImageIcon("images/qq.jpg"));//按钮框中放入图片
		
		jcb1 = new JCheckBox("隐身登陆");
		jcb2 = new JCheckBox("记住密码");
		
		//北部区域，放入一个label的图片
		//jl1 = new JLabel(new ImageIcon("images/keai.jpg"));
		
		//南部区域
		jp1 = new JPanel();
		jb1 = new JButton("登陆");
		jb2 = new JButton("取消");
		jb3 = new JButton("帮助");
		//中部区域
		jtp = new JTabbedPane();
		jp2 = new JPanel();
		jp3 = new JPanel();
		//jp3.setBackground(Color.red);//设置背景颜色
		jp4 = new JPanel();
		jp4.setBackground(new Color(0,0,255));
		
		//将面板添加到选项卡窗格上
		jtp.add("qq号码",jp2);
		jtp.add("手机号码",jp3);
		jtp.add("电子邮箱",jp4);
		
		//设置布局
		jp2.setLayout(new GridLayout(3,3));
		jp3.setLayout(new GridLayout(3,3,3,3));
		jp4.setLayout(new GridLayout(3,3));
		//添加组件
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		jp2.add(jl2);
		jp2.add(jtf);
		jp2.add(jb4);
		jp2.add(jl3);
		jp2.add(jpf);
		jp2.add(jl4);
		jp2.add(jcb1);
		jp2.add(jcb2);
		jp2.add(jl5);
		
		jp3.add(jl6);
		jp3.add(jtf);
		jp3.add(jb4);
		jp3.add(jl3);
		jp3.add(jpf);
		jp3.add(jl4);
		jp3.add(jcb1);
		jp3.add(jcb2);
		jp3.add(jl5);
		//this.add(jl1,BorderLayout.NORTH);
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jtp,BorderLayout.CENTER);
		
		//展现组件
		ImageIcon icon = new ImageIcon("images/qq.jpg");
		this.setIconImage(icon.getImage());
		this.setTitle("聊天");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
