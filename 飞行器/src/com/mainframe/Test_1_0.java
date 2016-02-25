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
	//�������
	JButton send,open,close,draw,ins_p,ins_i,ins_d,ots_p,ots_i,ots_d;  //������ť ���Ʒ������ݺ͹رս���
	JPanel jp1,jp2,jp3,jp4,jp5;//���ϲ����ڷŰ�ť,�������ڷ��÷������ݺͶ˿ں���ʾ,�м䲿�ֵ�panel
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,
					   jl8,jl9,jl10,jl11,
					   jl12,jl13,jl14,jl15,
					   jl16,jl17,jl18,jl19,
					   jl20,jl21,jl22,jl23,
					   jl24,jl25,jl26,jl27;
					   
	TextField ang_x,ang_y,ang_z,height;//������ʾ���ı���
	TextField ins_p_tex,ins_i_tex,ins_d_tex,ots_p_tex,ots_i_tex,ots_d_tex;//������Ϊ�������ݵ��ı���
    /*********************�˿ڵı���******************************/
	String potrName;
	static CommPortIdentifier portId;
	InputStream inputstream;
	OutputStream outputstream;
    SerialPort serialPort = null;
	static StringBuffer buffer;//���ڶ�������
	Boolean recieve;//�������ݶ����־
	static Enumeration<CommPortIdentifier> portList;
	byte data[] = new byte[256];//�������ݵĻ�����
    String one,two,three,four,five,six,seven,eight,nine,ten;
	 private void  shiliass()
	 {
			jp1 = new JPanel();		//�ϲ�
			jp2 = new JPanel();		//����
			jp3 = new JPanel();		//Center
			jp3.setLayout(new FlowLayout(0));//����������
			jp4 = new JPanel();		//����
			jp4.setLayout(new GridLayout(6,5,3,30));
			jp5 = new JPanel();		//�Ұ��
			
			/*labelʵ����*/
			jl1 = new JLabel();//��ʾ���ں�
			jl2 = new JLabel("��ǰ����Ϊ��");
			jl3 = new JLabel("�ұ߲�"); 
			jl4 = new JLabel("x��ĽǶ�"); jl5 = new JLabel("1");   jl6 = new JLabel("�ڻ�P");jl7 = new JLabel("1");
/*���뷽ʽ*/	jl4.setHorizontalAlignment(JLabel.RIGHT);jl6.setHorizontalAlignment(JLabel.RIGHT);
			jl8 = new JLabel("y��ĽǶ�"); jl9 = new JLabel("1");   jl10 = new JLabel("�ڻ�I");jl11 = new JLabel("1");
			jl8.setHorizontalAlignment(JLabel.RIGHT);jl10.setHorizontalAlignment(JLabel.RIGHT);
			jl12 = new JLabel("z��ĽǶ�");jl13 = new JLabel("1");  jl14 = new JLabel("�ڻ�D");jl15 = new JLabel("1");
			jl12.setHorizontalAlignment(JLabel.RIGHT);jl14.setHorizontalAlignment(JLabel.RIGHT);
			jl16 = new JLabel("��ǰ�߶�");   jl17 = new JLabel("1");     jl18 = new JLabel("�⻷P");jl19 = new JLabel("1");
			jl16.setHorizontalAlignment(JLabel.RIGHT);				jl18.setHorizontalAlignment(JLabel.RIGHT);
			jl20 = new JLabel("1");   jl21 = new JLabel("1");     jl22 = new JLabel("�⻷I");jl23 = new JLabel("1");
																  jl22.setHorizontalAlignment(JLabel.RIGHT);
			jl24 = new JLabel("1");   jl25 = new JLabel("1");     jl26 = new JLabel("�⻷D");jl27 = new JLabel("1");
																  jl26.setHorizontalAlignment(JLabel.RIGHT);
			
			/*textAeraʵ����*/
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
			
			open = new JButton("��");
			send = new JButton("����");
			close = new JButton("�ر�");
			draw = new JButton("�鿴����");
			ins_p = new JButton("�޸�");
			ins_i = new JButton("�޸�");
			ins_d = new JButton("�޸�");
			ots_p = new JButton("�޸�");
			ots_i = new JButton("�޸�");
			ots_d = new JButton("�޸�");
	 }
	 private void addass()
	 {
		 //��ӽ�panel
		 /********************�ϲ���ť*******************/
			jp1.add(open);	
			jp1.add(send);
			jp1.add(close);
			jp1.add(draw);
			 /********************�������*******************/
			jp2.add(jl2);
			jp2.add(jl1);
			//���
			jp4.add(jl4);	jp4.add(ang_x);	jp4.add(jl6);	jp4.add(ins_p_tex);  jp4.add(ins_p);
			jp4.add(jl8);	jp4.add(ang_y);	jp4.add(jl10);	jp4.add(ins_i_tex); jp4.add(ins_i);
			jp4.add(jl12);	jp4.add(ang_z);	jp4.add(jl14);	jp4.add(ins_d_tex); jp4.add(ins_d);
			jp4.add(jl16);	jp4.add(height);jp4.add(jl18);	jp4.add(ots_p_tex); jp4.add(ots_p);
			jp4.add(jl20);	jp4.add(jl21);	jp4.add(jl22);	jp4.add(ots_i_tex); jp4.add(ots_i);
			jp4.add(jl24);	jp4.add(jl25);	jp4.add(jl26);	jp4.add(ots_d_tex); jp4.add(ots_d);
			
			//�Ҳ�
			jp5.add(jl3);
			/*Center�����������panel*/
			jp3.add(jp4);
			jp3.add(jp5);
			
			//��panel��ӵ�frame
			this.add(jp1,BorderLayout.SOUTH);
			this.add(jp3);
			this.add(jp2,BorderLayout.NORTH);
	 }
	 private  void setListener()
	 {
		//ע�����
			send.addActionListener(this);
			open.addActionListener(this);
			close.addActionListener(this);
			draw.addActionListener(this);
			
			//���ü�������
			send.setActionCommand("send");
			open.setActionCommand("open");
			close.setActionCommand("close");
			draw.setActionCommand("draw");
	 }

	//���캯��
	public MyWindow1()
	{
		//ʵ��������
		shiliass();
		//������
		addass();
		//ע�����
		setListener();
		//in_message.setEditable(false);
		
		//���ô���
		this.setTitle("�����������");
		this.setSize(800,500);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//��ʾ����
		this.setVisible(true);
	}
	/*���صڼ������ź������ݵı��*/
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
	/*�����ڽ��յ�������*/
	private void disposeResiveData(byte[] read){
		/*У��֡ͷȷ��������ȷ����*/
		if(read[0]=='A'){
			if(read[1]=='A'){
				if(read[2]=='A'){
					/*�жϹ��ܺ�,�ڼ������ź�����ݵ�ǰ��λΪ���ܺ�*/
					/*fonction 01*/
					System.out.println(new String(read));
					if(read[getComma(1,read)-1]==','){
						byte[] temp0 = new byte[10];
						for(int i=getComma(1,read),j=0;i<getComma(2,read)-1;i++,j++){
							temp0[j]=read[i];
						}
						one = new String(temp0);
						ang_x.setText(one);
						System.out.println("����"+one+"�ѽ���");
					}
					if(read[getComma(2,read)-1]==','){
						byte[] temp1 = new byte[10];
						/*fonction 02*/
						for(int i=getComma(2,read),j=0;i<getComma(3,read)-1;i++,j++){
							temp1[j]=read[i];
						}
						two = new String(temp1);
						
						ang_y.setText(two);
						System.out.println("����"+two+"�ѽ���");
					}
					
				}
			}
		}
	}
	/*����Ҫ���͵�����*/
	private void disposeSendData(JTextField jtf){
		data = jtf.getText().getBytes();//��ȡҪ���͵�����
		try {
			outputstream = serialPort.getOutputStream();
			outputstream.write(data);//����д�������
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
			portList = CommPortIdentifier.getPortIdentifiers(); //�õ���ǰ�����ϵĶ˿�
			if(portList.hasMoreElements()){
				while (portList.hasMoreElements()) 
				{  
					portId = portList.nextElement();
					if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
					{//�ж�����˿������Ǵ���
						jl1.setText(portId.getName());
						if (portId.getName().equals(jl1.getText())) {
						//�򿪴���
	                    try {
	                    		serialPort = (SerialPort)portId.open("OOPSD", 2000);
							} catch (PortInUseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "����æµ...","����",JOptionPane.WARNING_MESSAGE);				
							}
	                    try {
	                        //���������
	                        inputstream = serialPort.getInputStream();
	                    } catch (IOException e1) {}
	                  //���ô��ڼ���
	                    try {
	                        serialPort.addEventListener((SerialPortEventListener) this);
	                    } catch (TooManyListenersException e1) {}
	                    
	                    serialPort.notifyOnDataAvailable(true);
	                    
	                    /* ���ô���ͨѶ���� */
	                    try {
	                        serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
	                                SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
	                    } catch (UnsupportedCommOperationException e1) {}
	                   
						}
					}
			    }
			}
			else{
				JOptionPane.showMessageDialog(null, "δ�ҵ�����","����",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getActionCommand().equals("send"))
		{
			 
		}
		
		if(e.getActionCommand().equals("close"))
		{
			serialPort.close(); // �رմ���
			JOptionPane.showMessageDialog(null, "�����ѹر�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
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
	        case SerialPortEvent.DATA_AVAILABLE:/*Data available at the serial port���˿��п������ݡ������������飬������ն�*/
	        	byte[] readBuffer = new byte[256];//�������ݽ��ջ�����
	        	//String readStr="";//���������ַ�����
	            int numBytes=0;//���ڽ��������ַ�����
	            String readStr = new String();
	        	try {
	                while (inputstream.available() > 0) {
	                     numBytes= inputstream.read(readBuffer);
	                }
	            readStr = new String(readBuffer);
	            System.out.println("���ݳ���Ϊ"+numBytes+"��������"+readStr);
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

