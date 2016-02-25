package com.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.*;
import javax.print.attribute.standard.Severity;
import javax.swing.*;

public class MyServer extends JFrame implements ActionListener,KeyListener{

	/**
	 * @param args
	 */
	JPanel jp;	//
	JButton jb;
	JTextField jtf;
	JTextArea jta;
	JScrollPane jsp;
	PrintWriter pw;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer mc = new MyServer();
	}
	
	public MyServer()
	{
		jp = new JPanel();
		jb = new JButton("������Ϣ");
		jtf = new JTextField(10);
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jp.add(jtf);//��������Jpanel
		jp.add(jb);
		//ע�����
		jb.addActionListener(this);
		jtf.addKeyListener(this);
		jb.setActionCommand("������Ϣ");
		this.add(jsp,"Center");
		this.add(jp,"South");
		
		this.setTitle("��������");
		this.setSize(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
				ServerSocket ss = new ServerSocket(999);
				Socket s = ss.accept();
				System.out.println("������");
				//Ҫ��ȡ������Ҫ�õ�
				InputStreamReader isr = new InputStreamReader(s.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				pw = new PrintWriter(s.getOutputStream(),true);
				while(true)
				{
					String res = br.readLine();//��ȡ����������
					
					jta.append("�ͻ��ˣ�"+res+"\r\n");
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("������Ϣ"))
		{
			String info = jtf.getText();
			pw.println(info);
			jta.append("��������"+info+"\r\n");
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("������"+e.getKeyChar());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("������"+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			String info = jtf.getText();
			pw.println(info);
			jta.append("�������ˣ�"+info+"\r\n");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}