/*
 * 
 */
package com.swing;
import java.awt.*;
import javax.swing.*;

public class Test3 extends JFrame{

	//定义组件
	JSplitPane jsp;			//拆分窗口
	JList jls;
	JLabel jla;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test3 test3 = new Test3();
	}
	
	public Test3()
	{
		//创建组件
		String []words = {"asd","adsf","wer","werds"};
		jls = new JList(words);
		
		jla = new JLabel(new ImageIcon("images/keai.jpg"));
		//拆分窗格
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jls,jla);
	
		//设置拆分窗口可以收放变化
		jsp.setOneTouchExpandable(true);
		//设置布局管理器
		
		//添加组件
		this.add(jsp);
		
		this.setSize(200,200);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

}
