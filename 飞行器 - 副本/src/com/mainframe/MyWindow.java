package com.mainframe;

import com.mainframe.CommControl;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.panel.draw.MyPanel;
import com.mainframe.DisplayReceivedData;;

public class MyWindow extends JFrame implements ActionListener
{
	private CommControl cc = new CommControl();
	//�������
	JMenuBar menubar = new JMenuBar();
	JMenu file = new JMenu("�ļ�");
	JMenu edit = new JMenu("�鿴");
	JMenu help = new  JMenu("����");
	JMenuItem exitMenu = new JMenuItem("�˳�");
	JMenuItem flyState = new JMenuItem("����״̬");
	JMenuItem savedata = new JMenuItem("�洢����");
	JMenuItem protocol = new JMenuItem("����Э��");
	JButton send,open,close,draw,ins_p,ins_i,ins_d,ots_p,ots_i,ots_d;  //������ť ���Ʒ������ݺ͹رս���
	JPanel jp1,jp2,jp3,jp4,jp5;//���ϲ����ڷŰ�ť,�������ڷ��÷������ݺͶ˿ں���ʾ,�м䲿�ֵ�panel
	public JLabel jl2,jl3,jl4,jl5,jl6,jl7,
					   jl8,jl9,jl10,jl11,
					   jl12,jl13,jl14,jl15,
					   jl16,jl17,jl18,jl19,
					   jl20,jl21,jl22,jl23,
					   jl24,jl25,jl26,jl27;
	static JLabel jl1;
	static TextField ang_x,ang_y,ang_z,height;
	TextField ins_p_tex,ins_i_tex,ins_d_tex,ots_p_tex,ots_i_tex,ots_d_tex,speed;//������Ϊ�������ݵ��ı���
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
			jl20 = new JLabel("��ǰ����");   jl21 = new JLabel("1");     jl22 = new JLabel("�⻷I");jl23 = new JLabel("1");
			jl20.setHorizontalAlignment(JLabel.RIGHT);													  jl22.setHorizontalAlignment(JLabel.RIGHT);
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
			speed = new TextField(8);
			
			open = new JButton("�򿪴���");
			open.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			send = new JButton("��������");
			close = new JButton("�رմ���");
			close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
			//jp1.add(send);
			jp1.add(close);
			jp1.add(draw);
			 /********************��ʾ�������*******************/
			jp2.add(jl2);
			jp2.add(jl1);
			/*******************�м����****************************/
			//���
			jp4.add(jl4);	jp4.add(ang_x);	jp4.add(jl6);	jp4.add(ins_p_tex);  jp4.add(ins_p);
			jp4.add(jl8);	jp4.add(ang_y);	jp4.add(jl10);	jp4.add(ins_i_tex); jp4.add(ins_i);
			jp4.add(jl12);	jp4.add(ang_z);	jp4.add(jl14);	jp4.add(ins_d_tex); jp4.add(ins_d);
			jp4.add(jl16);	jp4.add(height);jp4.add(jl18);	jp4.add(ots_p_tex); jp4.add(ots_p);
			jp4.add(jl20);	jp4.add(speed);	jp4.add(jl22);	jp4.add(ots_i_tex); jp4.add(ots_i);
			jp4.add(jl24);	jp4.add(jl25);	jp4.add(jl26);	jp4.add(ots_d_tex); jp4.add(ots_d);
			
			//�Ҳ�
			jp5.add(jp2);
			/*Center�����������panel*/
			jp3.add(jp4);
			jp3.add(jp5);
			
			//��panel��ӵ�frame
			this.add(jp1,BorderLayout.SOUTH);
			this.add(jp3);
			this.add(menubar,BorderLayout.NORTH);
	 }
	 private  void setListener()
	 {
		//ע�����
			send.addActionListener(this);
			open.addActionListener(this);
			close.addActionListener(this);
			draw.addActionListener(this);
			flyState.addActionListener(this);
			savedata.addActionListener(this);
			protocol.addActionListener(this);
			
			//���ü�������
			send.setActionCommand("send");
			open.setActionCommand("open");
			close.setActionCommand("close");
			draw.setActionCommand("draw");
			help.add(protocol);
			edit.add(flyState);
			edit.add(savedata);
			file.add(exitMenu);
			menubar.add(file);
			menubar.add(edit);
			menubar.add(help);
	 }
	//���캯��
	public MyWindow()
	{
		//ʵ��������
		shiliass();
		//������
		addass();
		//ע�����
		setListener();
		//in_message.setEditable(false);
		
		//���ô���
		ImageIcon ico = new ImageIcon("resource/ico.jpg");
		this.setIconImage(ico.getImage());
		this.setTitle("�����������");
		this.setSize(550,470);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//��ʾ����
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("open"))
		{ 	
			cc.OpenComm();
		}
		/*�˴���������Ҫ���ݷ��Ͳ�ͬ������������*/
		if(e.getActionCommand().equals("send"))
		{
			 
		}
		if(e.getActionCommand().equals("close"))
		{
			cc.close();
		}
		if(e.getActionCommand().equals("draw")){
			//new MyPanel();
			cc.SendData(Integer.parseInt(ins_p_tex.getText(),16));//�������ݲ���
		}
		if(e.getSource()==flyState){//�鿴����״̬����
			FlyState fs = new FlyState();
			System.out.println("asdf");
		}
		if(e.getSource()==savedata){
			WriteData wd = new WriteData();
		}
		if(e.getSource()==protocol){//����Э�齲���ļ�
			try {
				Desktop.getDesktop().open(new File("resource/protocol.txt"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}

