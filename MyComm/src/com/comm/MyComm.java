/*
 * ��rxtx��ʵ��
 * */
package com.comm;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyComm extends JFrame implements SerialPortEventListener,ActionListener{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyComm mc = new MyComm();
	}
	/**********************����ؼ�********************************/
	JTextField jtf=null;
	JButton jb = null;
	 /*********************�˿ڵı���******************************/
		String potrName;
		static CommPortIdentifier portId;
		InputStream inputstream;
		OutputStream outputstream;
	    SerialPort serialPort = null;
		static StringBuffer buffer;//���ڶ�������
		Boolean recieve;//�������ݶ����־
		static Enumeration<CommPortIdentifier> portList;
		byte data[] = new byte[10240];
		 String str = "";
		 public MyComm()
		 {
			 jtf = new JTextField(20);
			 jb = new JButton("����");
			 jb.addActionListener(this);
			 this.add(jtf,"North");
			 this.add(jb,"South");
			 this.setSize(300,200);
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 this.setVisible(true);
			 /****************���ڳ�ʼ��****************************************/
			 portList = CommPortIdentifier.getPortIdentifiers(); //�õ���ǰ�����ϵĶ˿�
			 while(portList.hasMoreElements()){
				 portId = portList.nextElement();
				 if(portId.getPortType()==CommPortIdentifier.PORT_SERIAL)//�Ǵ���
				 {
					 System.out.println(portId.getName());
					 //�򿪴���
					 try {
						 
						 serialPort = (SerialPort)portId.open("MyComm",2000);//�򿪴��ڵķ���
						 inputstream = serialPort.getInputStream();//���������
						 serialPort.addEventListener((SerialPortEventListener) this);//���ü�
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					 serialPort.notifyOnDataAvailable(true);
					 try {
						 serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, 
				 					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				 }
			 }
			 
		 }
		@Override
		public void serialEvent(SerialPortEvent arg0) {
			// TODO Auto-generated method stub
			switch(arg0.getEventType()) {
	        case SerialPortEvent.BI:/*Break interrupt,ͨѶ�ж�*/
	        case SerialPortEvent.OE:/*Overrun error����λ����*/
	        case SerialPortEvent.FE:/*Framing error����֡����*/
	        case SerialPortEvent.PE:/*Parity error��У�����*/
	        case SerialPortEvent.CD:/*Carrier detect���ز����*/
	        case SerialPortEvent.CTS:/*Clear to send���������*/
	        case SerialPortEvent.DSR:/*Data set ready�������豸����*/
	        case SerialPortEvent.RI:/*Ring indicator������ָʾ*/
	        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:/*Output buffer is empty��������������*/
	            break;
	        case SerialPortEvent.DATA_AVAILABLE:
	        	 byte[] readBuffer = new byte[256];//���ݻ�����
		            String readStr="";
		            int numBytes=0;
		            try {
		                while (inputstream.available() > 0) {
		                     numBytes= inputstream.read(readBuffer);//���������ֽ���
		                }
		                readStr = new String(readBuffer);
		                System.out.println(readStr);
		            }catch (Exception e) {
							// TODO: handle exception
						}
		            try {
		            	inputstream.close();
					} catch (Exception e) {
						// TODO: handle exception
					}
		            break;
		}
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb){
				data = jtf.getText().getBytes();
				 try {
						outputstream = serialPort.getOutputStream();
						outputstream.write(data);
						outputstream.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		}

}
