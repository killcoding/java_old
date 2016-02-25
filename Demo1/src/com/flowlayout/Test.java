/**
 * 流式布局范例练习（FlowLayout）
 * 流式布局默认是居中对齐的,可以在布局管理器中设置对齐方式
 */
package com.flowlayout;

import java.awt.*;

import javax.swing.*;

public class Test extends JFrame{

	//定义需要的组件
	JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test = new Test();
	}
	//创建构造函数
	public Test()
	{
		//创建组件
		jb1 = new JButton("按钮1");
		jb2 = new JButton("按钮2");
		jb3 = new JButton("按钮3");
		jb4 = new JButton("按钮4");
		jb5 = new JButton("按钮5");
		
		//添加组件
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		
		//设置布局管理器
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//设置窗体属性
		this.setTitle("流式布局范例");				//设置窗体标题
		this.setSize(300, 200);		//设置大小
		this.setLocation(200, 200);//设置窗体相对屏幕左上角的位置
		//禁止用户改变窗口大小
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置退出时关闭窗口
				
		//显示窗体
		this.setVisible(true);//实现窗体的显示
		
	}

}
