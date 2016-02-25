/*
 * swing组件使用
 * 单选框JRadioButton，复选框JCheckBox
 * 注意：同一组单选按钮必须先创建ButtonGroup然后把单选框组件放入ButtonGroup中
 * 
 */
package com.swing;
import java.awt.*;
import javax.swing.*;

public class Test1 extends JFrame{

	//定义组件
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;
	JRadioButton jrb1,jrb2;
	ButtonGroup bg;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 test1 = new Test1();
		
	}
	
	//构造函数
	public Test1()
	{
		//创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jl1 = new JLabel("你的性别");
		jl2 = new JLabel("喜欢的运动");
		
		jb1 = new JButton("确认注册");
		jb2 = new JButton("取消注册");
		
		jcb1 = new JCheckBox("足球");
		jcb2 = new JCheckBox("篮球");
		jcb3 = new JCheckBox("网球");
		
		jrb1 = new JRadioButton("男");
		jrb2 = new JRadioButton("女");
		//注意吧两个单选框放入到一个BUTTONGROUP
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//设置布局管理器
		this.setLayout(new GridLayout(3,1));
		
		//添加组件到Panel
		jp1.add(jl2);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		jp2.add(jl1);
		jp2.add(jrb1);
		jp2.add(jrb2);
		jp3.add(jb1);
		jp3.add(jb2);
		
		//添加组件
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//设置窗体
		this.setTitle("注册界面");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//显窗体
		this.setVisible(true);
	}

}
