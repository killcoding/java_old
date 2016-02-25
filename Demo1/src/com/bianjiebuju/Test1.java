/**
 * BorderLayout演示（边界布局演示）
 * 1.继承JFrame
 * 2.定义组件
 * 3.创建组件（构造函数内部）
 * 4.添加组件（把创建爱你好组件添加到程序中应该存在的位置）
 * 5.对顶层容器的窗体进行设置
 * 6.显示窗体
 */

package com.bianjiebuju;

import java.awt.*;
import javax.swing.*;

public class Test1 extends JFrame {

	//定义组件,5个按钮组件
	JButton jb1,jb2,jb3,jb4,jb5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 test1 = new Test1();
	}
	
	//创建构造函数
	public Test1()
	{
		//创建组件
		jb1 = new JButton("中部");
		jb2 = new JButton("北部");
		jb3 = new JButton("南部");
		jb4 = new JButton("东部");
		jb5 = new JButton("西部");
		
		//添加各个组件，本类继承了JFrame，可用this
		this.add(jb1, BorderLayout.CENTER);
		this.add(jb2, BorderLayout.NORTH);
		this.add(jb3, BorderLayout.SOUTH);
		this.add(jb4, BorderLayout.EAST);
		this.add(jb5, BorderLayout.WEST);
		
		//设置窗体属性
		this.setTitle("边界布局范例");				//设置窗体标题
		this.setSize(300, 200);		//设置大小
		this.setLocation(200, 200);//设置窗体相对屏幕左上角的位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置退出时关闭窗口
		
		//显示窗体
		this.setVisible(true);//实现窗体的显示
		
	}

}
