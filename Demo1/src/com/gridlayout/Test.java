/**
 * GridLayout(网格布局)
 * 
 */
package com.gridlayout;
import java.awt.*;

import javax.swing.*;

public class Test extends JFrame{
	
	int size = 9;
	JButton jbs[] = new JButton[size];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test = new Test();
	}
	
	//构造函数
	public Test()
	{
		//创建组件
		for(int i=0;i<size;i++)
		{
			jbs[i] = new JButton(String.valueOf(i));
		}
		
		//设置布局管理器、
		this.setLayout(new GridLayout(3,3,20,20));	//设置三行三列
		//添加组件
		for(int i=0;i<size;i++)
		{
			this.add(jbs[i]);
		}
		
		//设置窗体属性
		this.setTitle("网格布局");
		this.setSize(300, 200);
		this.setLocation(200, 200);
		this.setResizable(false);//串口大小不允许改变
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//显示窗体
		this.setVisible(true);
	}

}
