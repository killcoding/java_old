/*
 * 部分控件讲解
 * 下拉框JComboBOX/列表框组件JList/滚动窗格组件JScrollPane
 */
package com.swing;

import javax.swing.*;
import java.awt.*;

public class Test2 extends JFrame{

	JPanel jp1,jp2;
	JLabel jl1,jl2;
	JComboBox jcb1;
	JList jls;
	JScrollPane jsp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test2 test2 = new Test2();
	}
	
	//构造函数
	public Test2()
	{
		//创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jl1 = new JLabel("你的籍贯");
		jl2 = new JLabel("你学校");
		
		//下拉框创建
		String []jg = {"背景","邯郸","上海","广州"};
		jcb1 = new JComboBox(jg);
		System.out.println(jcb1.getSelectedItem());
		
		String []sch = {"山大","北大","清华","浙大"};
		jls = new JList(sch);
		//设置你希望现实多少选项
		jls.setVisibleRowCount(2);
		jsp = new JScrollPane(jls);
		
		
		//设置布局
		this.setLayout(new GridLayout(3,1));
		
		//添加组件
		jp1.add(jl1);
		jp1.add(jcb1);
		jp2.add(jl2);
		jp2.add(jsp);
		
		this.add(jp1);
		this.add(jp2);
		
		this.setSize(300,300);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

}
