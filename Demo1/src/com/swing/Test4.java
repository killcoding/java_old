/*
 * JTextArea  多行文本框组件
 * qq聊天器
 * 多行文本框组件可滚动处理(将文本框放入JScrollPane中)
 */
package com.swing;
import java.awt.*;
import javax.swing.*;

public class Test4 extends JFrame{

	//定义组件
	JTextArea jta=null;
	JScrollPane jsp =null;
	JPanel jp1;
	JComboBox jcb;
	JTextField jtf;
	JButton jb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test4 test4 = new Test4();
	}
	
	public Test4()
	{
		//创建组件
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jp1 = new JPanel();
		String []name = {"ad","ad"};
		jcb = new JComboBox(name);
		jtf = new JTextField(10);
		jb = new JButton("发送");
		
		//设置布局管理器
		
		//添加组件
		jp1.add(jcb);
		jp1.add(jtf);
		jp1.add(jb);
		
		this.add(jsp);	//默认放中间
		this.add(jp1,BorderLayout.SOUTH);
		
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setTitle("聊天");
		this.setIconImage((new ImageIcon("images/qq.jpg")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
