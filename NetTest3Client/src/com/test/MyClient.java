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
		jb = new JButton("发送消息");
		jtf = new JTextField(10);
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jp.add(jtf);//天假组件给Jpanel
		jp.add(jb);
		jb.addActionListener(this);
		jtf.addKeyListener(this);
		jb.setActionCommand("发送消息");
		this.add(jsp,"Center");
		this.add(jp,"South");
		
		this.setTitle("聊天客户端");
		this.setSize(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			Socket s = new Socket("222.175.103.14",999);//设置监听的IP地址可端口号
			
			//要读取数据需要用到
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			//如果连接成功就可以发数据给服务器
			//通过pw向s输入数据，true表示及时刷新
			pw = new PrintWriter(s.getOutputStream(),true);
			//pw.println("客户段数据");
			while(true)
			{
				String info = br.readLine();
				jta.append("服务器："+info+"\r\n");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("发送消息"))
		{
			String info = jtf.getText();
			pw.println(info);
			jta.append("客户端："+info+"\r\n");
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
			jta.append("客户端："+info+"\r\n");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
