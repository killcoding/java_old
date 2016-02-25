package com.mainframe;
import com.panel.*;
import com.panel.draw.MyPanel;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class Test_1_0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindow1 mw = new MyWindow1();
		
		
	}

}


class MyWindow1 extends JFrame implements ActionListener,SerialPortEventListener
{
	//定义变量
	JButton send,open,close,draw,ins_p,ins_i,ins_d,ots_p,ots_i,ots_d;  //两个按钮 控制发送数据和关闭界面
	JPanel jp1,jp2,jp3,jp4,jp5;//最南部用于放按钮,北部用于放置发送内容和端口号显示,中间部分的panel
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,
					   jl8,jl9,jl10,jl11,
					   jl12,jl13,jl14,jl15,
					   jl16,jl17,jl18,jl19,
					   jl20,jl21,jl22,jl23,
					   jl24,jl25,jl26,jl27;
					   
	TextField ang_x,ang_y,ang_z,height;//用于显示的文本区
	TextField ins_p_tex,ins_i_tex,ins_d_tex,ots_p_tex,ots_i_tex,ots_d_tex;//用于作为发送数据的文本区
    /*********************端口的变量******************************/
	String potrName;
	static CommPortIdentifier portId;
	InputStream inputstream;
	OutputStream outputstream;
    SerialPort serialPort = null;
	static StringBuffer buffer;//串口读入数据
	Boolean recieve;//有新数据读入标志
	static Enumeration<CommPortIdentifier> portList;
	byte data[] = new byte[256];//发送数据的缓冲区
    String one,two,three,four,five,six,seven,eight,nine,ten;
	 private void  shiliass()
	 {
			jp1 = new JPanel();		//南部
			jp2 = new JPanel();		//北部
			jp3 = new JPanel();		//Center
			jp3.setLayout(new FlowLayout(0));//设置流布局
			jp4 = new JPanel();		//左半侧
			jp4.setLayout(new GridLayout(6,5,3,30));
			jp5 = new JPanel();		//右半侧
			
			/*label实例化*/
			jl1 = new JLabel();//显示串口号
			jl2 = new JLabel("当前串口为：");
			jl3 = new JLabel("右边侧"); 
			jl4 = new JLabel("x轴的角度"); jl5 = new JLabel("1");   jl6 = new JLabel("内环P");jl7 = new JLabel("1");
/*对齐方式*/	jl4.setHorizontalAlignment(JLabel.RIGHT);jl6.setHorizontalAlignment(JLabel.RIGHT);
			jl8 = new JLabel("y轴的角度"); jl9 = new JLabel("1");   jl10 = new JLabel("内环I");jl11 = new JLabel("1");
			jl8.setHorizontalAlignment(JLabel.RIGHT);jl10.setHorizontalAlignment(JLabel.RIGHT);
			jl12 = new JLabel("z轴的角度");jl13 = new JLabel("1");  jl14 = new JLabel("内环D");jl15 = new JLabel("1");
			jl12.setHorizontalAlignment(JLabel.RIGHT);jl14.setHorizontalAlignment(JLabel.RIGHT);
			jl16 = new JLabel("当前高度");   jl17 = new JLabel("1");     jl18 = new JLabel("外环P");jl19 = new JLabel("1");
			jl16.setHorizontalAlignment(JLabel.RIGHT);				jl18.setHorizontalAlignment(JLabel.RIGHT);
			jl20 = new JLabel("1");   jl21 = new JLabel("1");     jl22 = new JLabel("外环I");jl23 = new JLabel("1");
																  jl22.setHorizontalAlignment(JLabel.RIGHT);
			jl24 = new JLabel("1");   jl25 = new JLabel("1");     jl26 = new JLabel("外环D");jl27 = new JLabel("1");
																  jl26.setHorizontalAlignment(JLabel.RIGHT);
			
			/*textAera实例化*/
			ang_x = new TextField(10);
			ang_y = new TextField(10);
			ang_z = new TextField(10);
			height = new TextField(10);
			ins_p_tex=new TextField(6);
			ins_i_tex=new TextField(6);
			ins_d_tex=new TextField(6);
			ots_p_tex=new TextField(6);
			ots_i_tex=new TextField(6);
			ots_d_tex=new TextField(6);
			
			open = new JButton("打开");
			send = new JButton("发送");
			close = new JButton("关闭");
			draw = new JButton("查看曲线");
			ins_p = new JButton("修改");
			ins_i = new JButton("修改");
			ins_d = new JButton("修改");
			ots_p = new JButton("修改");
			ots_i = new JButton("修改");
			ots_d = new JButton("修改");
	 }
	 private void addass()
	 {
		 //添加进panel
		 /********************南部按钮*******************/
			jp1.add(open);	
			jp1.add(send);
			jp1.add(close);
			jp1.add(draw);
			 /********************北部组件*******************/
			jp2.add(jl2);
			jp2.add(jl1);
			//左侧
			jp4.add(jl4);	jp4.add(ang_x);	jp4.add(jl6);	jp4.add(ins_p_tex);  jp4.add(ins_p);
			jp4.add(jl8);	jp4.add(ang_y);	jp4.add(jl10);	jp4.add(ins_i_tex); jp4.add(ins_i);
			jp4.add(jl12);	jp4.add(ang_z);	jp4.add(jl14);	jp4.add(ins_d_tex); jp4.add(ins_d);
			jp4.add(jl16);	jp4.add(height);jp4.add(jl18);	jp4.add(ots_p_tex); jp4.add(ots_p);
			jp4.add(jl20);	jp4.add(jl21);	jp4.add(jl22);	jp4.add(ots_i_tex); jp4.add(ots_i);
			jp4.add(jl24);	jp4.add(jl25);	jp4.add(jl26);	jp4.add(ots_d_tex); jp4.add(ots_d);
			
			//右侧
			jp5.add(jl3);
			/*Center添加左右两个panel*/
			jp3.add(jp4);
			jp3.add(jp5);
			
			//将panel添加到frame
			this.add(jp1,BorderLayout.SOUTH);
			this.add(jp3);
			this.add(jp2,BorderLayout.NORTH);
	 }
	 private  void setListener()
	 {
		//注册监听
			send.addActionListener(this);
			open.addActionListener(this);
			close.addActionListener(this);
			draw.addActionListener(this);
			
			//设置监听命令
			send.setActionCommand("send");
			open.setActionCommand("open");
			close.setActionCommand("close");
			draw.setActionCommand("draw");
	 }

	//构造函数
	public MyWindow1()
	{
		//实例化对象
		shiliass();
		//添加组件
		addass();
		//注册监听
		setListener();
		//in_message.setEditable(false);
		
		//设置窗体
		this.setTitle("四旋翼飞行器");
		this.setSize(800,500);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//显示窗体
		this.setVisible(true);
	}
	/*返回第几个逗号后面数据的标号*/
	private int getComma(int num,byte[] str){
		int i,j=0;
		for(i=0;i<str.length;i++){
			if(str[i]==','){
				j++;
			}
			if(j==num){
				return(i+1);
			}
			if(str[i]=='\0'){
				return (i+1);
			}
		}
		return 0;
		
	}
	/*处理串口接收到的数据*/
	private void disposeResiveData(byte[] read){
		/*校验帧头确保数据正确传输*/
		if(read[0]=='A'){
			if(read[1]=='A'){
				if(read[2]=='A'){
					/*判断功能号,第几个逗号后的数据的前两位为功能号*/
					/*fonction 01*/
					System.out.println(new String(read));
					if(read[getComma(1,read)-1]==','){
						byte[] temp0 = new byte[10];
						for(int i=getComma(1,read),j=0;i<getComma(2,read)-1;i++,j++){
							temp0[j]=read[i];
						}
						one = new String(temp0);
						ang_x.setText(one);
						System.out.println("数据"+one+"已接受");
					}
					if(read[getComma(2,read)-1]==','){
						byte[] temp1 = new byte[10];
						/*fonction 02*/
						for(int i=getComma(2,read),j=0;i<getComma(3,read)-1;i++,j++){
							temp1[j]=read[i];
						}
						two = new String(temp1);
						
						ang_y.setText(two);
						System.out.println("数据"+two+"已接受");
					}
					
				}
			}
		}
	}
	/*处理要发送的数据*/
	private void disposeSendData(JTextField jtf){
		data = jtf.getText().getBytes();//获取要发送的数据
		try {
			outputstream = serialPort.getOutputStream();
			outputstream.write(data);//数据写入输出流
			outputstream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("open"))
		{
			//data = out_message.getText().getBytes();
			portList = CommPortIdentifier.getPortIdentifiers(); //得到当前连接上的端口
			if(portList.hasMoreElements()){
				while (portList.hasMoreElements()) 
				{  
					portId = portList.nextElement();
					if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
					{//判断如果端口类型是串口
						jl1.setText(portId.getName());
						if (portId.getName().equals(jl1.getText())) {
						//打开串口
	                    try {
	                    		serialPort = (SerialPort)portId.open("OOPSD", 2000);
							} catch (PortInUseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "串口忙碌...","警告",JOptionPane.WARNING_MESSAGE);				
							}
	                    try {
	                        //获得输入流
	                        inputstream = serialPort.getInputStream();
	                    } catch (IOException e1) {}
	                  //设置串口监听
	                    try {
	                        serialPort.addEventListener((SerialPortEventListener) this);
	                    } catch (TooManyListenersException e1) {}
	                    
	                    serialPort.notifyOnDataAvailable(true);
	                    
	                    /* 设置串口通讯参数 */
	                    try {
	                        serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
	                                SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
	                    } catch (UnsupportedCommOperationException e1) {}
	                   
						}
					}
			    }
			}
			else{
				JOptionPane.showMessageDialog(null, "未找到串口","警告",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getActionCommand().equals("send"))
		{
			 
		}
		
		if(e.getActionCommand().equals("close"))
		{
			serialPort.close(); // 关闭串口
			JOptionPane.showMessageDialog(null, "串口已关闭","提示",JOptionPane.INFORMATION_MESSAGE);
			jl1.setText("");
		}
		if(e.getActionCommand().equals("draw")){
			new MyPanel();
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
	        case SerialPortEvent.DATA_AVAILABLE:/*Data available at the serial port，端口有可用数据。读到缓冲数组，输出到终端*/
	        	byte[] readBuffer = new byte[256];//串口数据接收缓冲区
	        	//String readStr="";//串口数据字符串流
	            int numBytes=0;//串口接收数据字符个数
	            String readStr = new String();
	        	try {
	                while (inputstream.available() > 0) {
	                     numBytes= inputstream.read(readBuffer);
	                }
	            readStr = new String(readBuffer);
	            System.out.println("内容长度为"+numBytes+"串口内容"+readStr);
	                if(numBytes==11){
	  	              disposeResiveData(readBuffer);
	                }
//	            readStr="";
	            } catch (IOException e) {}
			try {
				inputstream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            break;            
	        }
	    }
	
}

