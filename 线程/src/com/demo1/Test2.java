/*
 * ��runnable�ӿ�ʵ���߳�
 */
package com.demo1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test2 extends JFrame implements ActionListener{

	JPanel jp = new JPanel();
	JTextField jt = new JTextField(10);
	JButton jb = new JButton("���");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test2 te=new Test2();
		//����������
		Dog dog = new Dog();
		//����һ���̶߳���
		Thread t = new Thread(dog);
		t.start();
	} 
	public Test2() {
		// TODO Auto-generated constructor stub
		jp.setLayout(new FlowLayout());
	    jb.addActionListener(this);
		jp.add(jb);
		jp.add(jt);
		this.add(jp);
		
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			System.out.println("�����ť");
			Dog dog = new Dog();
			Thread t = new Thread(dog);
			t.start();
		}
	}

}


class Dog implements Runnable
{
	int time=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//����һ��
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			time++;
			System.out.println("hello"+time);
			if(time==10)
			{
				break;
			}
		}
	}
	
}