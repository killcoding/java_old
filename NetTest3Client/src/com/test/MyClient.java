package com.test;

import java.awt.BorderLayout;
import java.net.Socket;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;

public class MyClient extends JFrame implements ActionListener,KeyListener{

	/**
	 * @param args
	 */
	JPanel jp;	//
	JButton jb;
	JTextField jtf;
	JTextArea jta;
	JScrollPane jsp;
	PrintWriter pw = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient mc = new MyClient();
	}
	
	public MyClient()
	{
		jp = new JPanel();
		jb = new JButton("������Ϣ");
		jtf = new JTextField(10);
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jp.add(jtf);//��������Jpanel
		jp.add(jb);
		jb.addActionListener(this);
		jtf.addKeyListener(this);
		jb.setActionCommand("������Ϣ");
		this.add(jsp,"Center");
		this.add(jp,"South");
		
		this.setTitle("����ͻ���");
		this.setSize(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			Socket s = new Socket("222.175.103.14",999);//���ü�����IP��ַ�ɶ˿ں�
			
			//Ҫ��ȡ������Ҫ�õ�
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			//������ӳɹ��Ϳ��Է����ݸ�������
			//ͨ��pw��s�������ݣ�true��ʾ��ʱˢ��
			pw = new PrintWriter(s.getOutputStream(),true);
			//pw.println("�ͻ�������");
			while(true)
			{
				String info = br.readLine();
				jta.append("��������"+info+"\r\n");
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
			jta.append("�ͻ��ˣ�"+info+"\r\n");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			String info = jtf.getText();
			pw.println(info);
			jta.append("�ͻ��ˣ�"+info+"\r\n");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
