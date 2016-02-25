package com.hgh;

/****************************************** 
*�������ļ����ƣ�SendComm.java 
* ���ܣ��Ӵ��п�COM1�з������� 
******************************************/  
import java.awt.*;  
import java.awt.event.*;  
import java.io.*;  
import java.util.*;  
import javax.comm.*; //����ʹ�ÿ�Դ��RXTX  
class S_Frame extends Frame implements Runnable,ActionListener  
{  
	/*���ϵͳ�п��õ�ͨѶ�˿��� */  
	static CommPortIdentifier portId; 
	
	/*Enumeration Ϊö������,��util�� */  
	static Enumeration<CommPortIdentifier> portList;  
	OutputStream outputStream; 
	
	/*RS-232�Ĵ��п� */  
	SerialPort serialPort;  
	Thread readThread;  
	Panel p=new Panel();  
	TextField in_message=new TextField("��COM1,������9600,����λ8,ֹͣλ1.");  
	TextArea out_message=new TextArea();  
	Button btnOpen=new Button("�򿪴���, ��������");  
	Button btnClose=new Button("�رմ���, ֹͣ��������");  
	byte data[]=new byte[10240]; 
	
	/*�����ж�Ҫ�Ƿ�رմ��ڵı�־*/  
	boolean mark;  
	/*���Ŵ���*/  
	S_Frame()  
	{ super("���ڷ�������");  
	setSize(200,200);  
	setVisible(true);  
	add(out_message,"Center");  
	add(p,"North");  
	p.add(btnOpen);  
	p.add(btnClose);  
	add(in_message,"South");  
	btnOpen.addActionListener(this);  
	btnClose.addActionListener(this);  
} //R_Frame() end  
/*�����Ť�򿪴���.*/  
public void actionPerformed(ActionEvent event) {  
	if (event.getSource()==btnClose){  
		serialPort.close(); //�رմ���  
		mark=true; //������ֹ�̵߳�run()����  
		in_message.setText("����COM1�Ѿ��ر�,ֹͣ��������.");  
	}  
	else { mark=false;  
		/*���ı������ֽڶ�ȡ����*/  
		data=out_message.getText().getBytes();  
		/*�򿪴���*/  
		start();  
		in_message.setText("����COM1�Ѿ���,����ÿ2���ӷ���һ������.....");  
		}  
} //actionPerformed() end  
	/*�򿪴���,�������̷߳�������*/  
public void start(){  
	/*��ȡϵͳ�����е�ͨѶ�˿� */  
	portList=CommPortIdentifier.getPortIdentifiers();  
	/* ��ѭ���ṹ�ҳ����� */  
	while (portList.hasMoreElements()){  
		/*ǿ��ת��ΪͨѶ�˿�����*/  
		portId=portList.nextElement();  
		if(portId.getPortType() == CommPortIdentifier.PORT_SERIAL){  
		if (portId.getName().equals("COM17")) {  
		/*�򿪴��� */  
		try {  
				serialPort = (SerialPort) portId.open("ReadComm", 2000);  
			}  
		catch (PortInUseException e) { }  
		/*���ô��������*/  
		try {  
				outputStream = serialPort.getOutputStream();  
			}  
		catch (IOException e) {}  
		} //if end  
	} //if end  
	} //while end  
	/*�����̷߳�������*/  
	try{  
		readThread = new Thread(this);  
		//�̸߳���ÿ����һ�����ݣ�����2����  
		readThread.start();  
		}  
	catch (Exception e) { }  
	} //start() end  
	/*��������,����2���Ӻ��ط�*/  
public void run() {  
	/*���ô���ͨѶ����*/  
	try {  
		serialPort.setSerialPortParams(9600,  
		SerialPort.DATABITS_8,  
		SerialPort.STOPBITS_1,  
		SerialPort.PARITY_NONE);  
		}  
	catch (UnsupportedCommOperationException e) { }  
	/*����������(������data[]�е����ݷ��ͳ�ȥ)*/  
	try {  
			outputStream.write(data);  
		}  
	catch (IOException e) { }  
	/*�������ݺ�����2����,Ȼ�����ط�*/  
	try { Thread.sleep(2000);  
	if (mark)  
	{
		return; //����run����,�����߳�����  
	}  
	start();  
	}  
	catch (InterruptedException e) { }  
	} //run() end  
} //��S_Frame end  
public class Test01  
{
	public static void main(String args[])  
	{ 
		S_Frame S_win=new S_Frame();  
		S_win.addWindowListener(new WindowAdapter()  {public void windowClosing(WindowEvent e)  
		{System.exit(0); }  });  
		S_win.pack();  
	}  
}
