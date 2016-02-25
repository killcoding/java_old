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
	//�������
	public JButton send,open,close;  //������ť ���Ʒ������ݺ͹رս���
	JPanel jp1;
	TextArea in_message = new TextArea();
	TextField out_message = new TextField(20);
    byte data[] = new byte[10240];
    private String ReadStr=null;//���ڽ��մ��ڷ��ͻ���������
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
	//���캯��
	public MyWindow()
	{
		//ʵ��������
		jp1 = new JPanel();
		open = new JButton("��");
		send = new JButton("����");
		close = new JButton("�ر�");

		//��ӽ�panel
		jp1.add(open);
		jp1.add(send);
		jp1.add(close);
		
		//��panel��ӵ�frame
		this.add(jp1,BorderLayout.SOUTH);
		this.add(in_message,BorderLayout.CENTER);
		this.add(out_message,BorderLayout.NORTH);
		
		//ע�����
		send.addActionListener(this);
		open.addActionListener(this);
		close.addActionListener(this);
		
		//���ü�������
		send.setActionCommand("send");
		open.setActionCommand("open");
		close.setActionCommand("close");

		//in_message.setEditable(false);
		//���ô���
		this.setTitle("�����������");
		this.setSize(800,500);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		//��ʾ����
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("open"))
		{
			new CommControl().OpenComm();//������һ�����ķ����򿪴���
		}
		if(e.getActionCommand().equals("send"))
		{
			data = out_message.getText().getBytes();
            new CommControl().SendData(data);
			
		}
		if(e.getActionCommand().equals("close"))
		{
			new CommControl().close();
			System.out.println("�˿��ѹر�");
			in_message.setText("�����Ѿ��ر�,ֹͣ��������.");
		}
	}
	 
}


