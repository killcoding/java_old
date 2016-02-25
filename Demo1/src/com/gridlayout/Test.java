/**
 * GridLayout(���񲼾�)
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
	
	//���캯��
	public Test()
	{
		//�������
		for(int i=0;i<size;i++)
		{
			jbs[i] = new JButton(String.valueOf(i));
		}
		
		//���ò��ֹ�������
		this.setLayout(new GridLayout(3,3,20,20));	//������������
		//������
		for(int i=0;i<size;i++)
		{
			this.add(jbs[i]);
		}
		
		//���ô�������
		this.setTitle("���񲼾�");
		this.setSize(300, 200);
		this.setLocation(200, 200);
		this.setResizable(false);//���ڴ�С������ı�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ʾ����
		this.setVisible(true);
	}

}
