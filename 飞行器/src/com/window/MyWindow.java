package com.window;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.comm.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyWindow extends JFrame implements ActionListener
{
	//定义变量
	public JButton send,open,close;  //两个按钮 控制发送数据和关闭界面
	JPanel jp1;
	TextArea in_message = new TextArea();
	TextField out_message = new TextField(20);
    byte data[] = new byte[10240];
    private String ReadStr=null;//用于接收串口发送回来的数据
	public void setReadStr(String readStr) {
		ReadStr = readStr;
	}
	private void ChangeInMes()
	{
		if(ReadStr!=null)
		{
			 in_message.append(ReadStr + " ");
			 ReadStr = null;
		}
	}
	//构造函数
	public MyWindow()
	{
		//实例化对象
		jp1 = new JPanel();
		open = new JButton("打开");
		send = new JButton("发送");
		close = new JButton("关闭");

		//添加进panel
		jp1.add(open);
		jp1.add(send);
		jp1.add(close);
		
		//将panel添加到frame
		this.add(jp1,BorderLayout.SOUTH);
		this.add(in_message,BorderLayout.CENTER);
		this.add(out_message,BorderLayout.NORTH);
		
		//注册监听
		send.addActionListener(this);
		open.addActionListener(this);
		close.addActionListener(this);
		
		//设置监听命令
		send.setActionCommand("send");
		open.setActionCommand("open");
		close.setActionCommand("close");

		//in_message.setEditable(false);
		//设置窗体
		this.setTitle("四旋翼飞行器");
		this.setSize(800,500);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		//显示窗体
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("open"))
		{
			new CommControl().OpenComm();//调用另一个包的方法打开串口
		}
		if(e.getActionCommand().equals("send"))
		{
			data = out_message.getText().getBytes();
            new CommControl().SendData(data);
			
		}
		if(e.getActionCommand().equals("close"))
		{
			new CommControl().close();
			System.out.println("端口已关闭");
			in_message.setText("串口已经关闭,停止发送数据.");
		}
	}
	 
}


