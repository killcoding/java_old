/*
 * 
 */
package com.swing;
import java.awt.*;
import javax.swing.*;

public class Test3 extends JFrame{

	//�������
	JSplitPane jsp;			//��ִ���
	JList jls;
	JLabel jla;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test3 test3 = new Test3();
	}
	
	public Test3()
	{
		//�������
		String []words = {"asd","adsf","wer","werds"};
		jls = new JList(words);
		
		jla = new JLabel(new ImageIcon("images/keai.jpg"));
		//��ִ���
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jls,jla);
	
		//���ò�ִ��ڿ����շű仯
		jsp.setOneTouchExpandable(true);
		//���ò��ֹ�����
		
		//������
		this.add(jsp);
		
		this.setSize(200,200);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

}
