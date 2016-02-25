/*
 * 用rxtx包实现
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
	/**********************界面控件********************************/
	JTextField jtf=null;
	JButton jb = null;
	 /*********************端口的变量******************************/
		String potrName;
		static CommPortIdentifier portId;
		InputStream inputstream;
		OutputStream outputstream;
	    SerialPort serialPort = null;
		static StringBuffer buffer;//串口读入数据
		Boolean recieve;//有新数据读入标志
		static Enumeration<CommPortIdentifier> portList;
		byte data[] = new byte[10240];
		 String str = "";
		 public MyComm()
		 {
			 jtf = new JTextField(20);
			 jb = new JButton("发送");
			 jb.addActionListener(this);
			 this.add(jtf,"North");
			 this.add(jb,"South");
			 this.setSize(300,200);
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 this.setVisible(true);
			 /****************串口初始化****************************************/
			 portList = CommPortIdentifier.getPortIdentifiers(); //得到当前连接上的端口
			 while(portList.hasMoreElements()){
				 portId = portList.nextElement();
				 if(portId.getPortType()==CommPortIdentifier.PORT_SERIAL)//是串口
				 {
					 System.out.println(portId.getName());
					 //打开串口
					 try {
						 
						 serialPort = (SerialPort)portId.open("MyComm",2000);//打开串口的方法
						 inputstream = serialPort.getInputStream();//获得输入流
						 serialPort.addEventListener((SerialPortEventListener) this);//设置监
						
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
	        case SerialPortEvent.BI:/*Break interrupt,通讯中断*/
	        case SerialPortEvent.OE:/*Overrun error，溢位错误*/
	        case SerialPortEvent.FE:/*Framing error，传帧错误*/
	        case SerialPortEvent.PE:/*Parity error，校验错误*/
	        case SerialPortEvent.CD:/*Carrier detect，载波检测*/
	        case SerialPortEvent.CTS:/*Clear to send，清除发送*/
	        case SerialPortEvent.DSR:/*Data set ready，数据设备就绪*/
	        case SerialPortEvent.RI:/*Ring indicator，响铃指示*/
	        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:/*Output buffer is empty，输出缓冲区清空*/
	            break;
	        case SerialPortEvent.DATA_AVAILABLE:
	        	 byte[] readBuffer = new byte[256];//数据缓存区
		            String readStr="";
		            int numBytes=0;
		            try {
		                while (inputstream.available() > 0) {
		                     numBytes= inputstream.read(readBuffer);//返回数据字节数
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
