/*
 * ѡ�����JTabbedPane
 * qq��½����
 * 
 */
package com.swing;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.*;
import javax.swing.border.Border;
public class Test5 extends JFrame{

	//��������һ��ͼƬ����jlabel��
	JLabel jl1;
	//�ϲ�����������ť
	JButton jb1,jb2,jb3;
	JPanel jp1;
	
	//�в�����
	JTabbedPane jtp;	//ѡ�����
	JPanel jp2,jp3,jp4;
	JLabel jl2,jl3,jl4,jl5,jl6,jl7;
	//���ú���
	JTextField jtf;
	//��������
	JPasswordField jpf;
	JButton jb4;
	//�����½����ס����
	JCheckBox jcb1,jcb2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test5 test5 = new Test5();
	}
	//���캯��
	public Test5()
	{
		//�������
		jl2 = new JLabel("qq����",JLabel.CENTER);
		jl6 = new JLabel("�ֻ�����",JLabel.CENTER);
		jl7 = new JLabel("����",JLabel.CENTER);
		jl3 = new JLabel("qq����",JLabel.CENTER);
		jl4 = new JLabel("��������",JLabel.CENTER);
		//�����������������
		jl4.setFont(new Font("����",Font.PLAIN,16));
		jl4.setForeground(Color.blue);	//����������ɫ
		jl5 = new JLabel("<html><a href = 'www.qq.com'>�������뱣��</a>");//��������
		jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//�ƶ��������ǩ��ʱ�����С��
		//��������
		jtf = new JTextField();
		//���������
		jpf = new JPasswordField();
		jb4 = new JButton(new ImageIcon("images/qq.jpg"));//��ť���з���ͼƬ
		
		jcb1 = new JCheckBox("�����½");
		jcb2 = new JCheckBox("��ס����");
		
		//�������򣬷���һ��label��ͼƬ
		//jl1 = new JLabel(new ImageIcon("images/keai.jpg"));
		
		//�ϲ�����
		jp1 = new JPanel();
		jb1 = new JButton("��½");
		jb2 = new JButton("ȡ��");
		jb3 = new JButton("����");
		//�в�����
		jtp = new JTabbedPane();
		jp2 = new JPanel();
		jp3 = new JPanel();
		//jp3.setBackground(Color.red);//���ñ�����ɫ
		jp4 = new JPanel();
		jp4.setBackground(new Color(0,0,255));
		
		//�������ӵ�ѡ�������
		jtp.add("qq����",jp2);
		jtp.add("�ֻ�����",jp3);
		jtp.add("��������",jp4);
		
		//���ò���
		jp2.setLayout(new GridLayout(3,3));
		jp3.setLayout(new GridLayout(3,3,3,3));
		jp4.setLayout(new GridLayout(3,3));
		//������
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		jp2.add(jl2);
		jp2.add(jtf);
		jp2.add(jb4);
		jp2.add(jl3);
		jp2.add(jpf);
		jp2.add(jl4);
		jp2.add(jcb1);
		jp2.add(jcb2);
		jp2.add(jl5);
		
		jp3.add(jl6);
		jp3.add(jtf);
		jp3.add(jb4);
		jp3.add(jl3);
		jp3.add(jpf);
		jp3.add(jl4);
		jp3.add(jcb1);
		jp3.add(jcb2);
		jp3.add(jl5);
		//this.add(jl1,BorderLayout.NORTH);
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jtp,BorderLayout.CENTER);
		
		//չ�����
		ImageIcon icon = new ImageIcon("images/qq.jpg");
		this.setIconImage(icon.getImage());
		this.setTitle("����");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
