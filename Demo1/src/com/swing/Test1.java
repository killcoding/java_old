/*
 * swing���ʹ��
 * ��ѡ��JRadioButton����ѡ��JCheckBox
 * ע�⣺ͬһ�鵥ѡ��ť�����ȴ���ButtonGroupȻ��ѵ�ѡ���������ButtonGroup��
 * 
 */
package com.swing;
import java.awt.*;
import javax.swing.*;

public class Test1 extends JFrame{

	//�������
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;
	JRadioButton jrb1,jrb2;
	ButtonGroup bg;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 test1 = new Test1();
		
	}
	
	//���캯��
	public Test1()
	{
		//�������
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jl1 = new JLabel("����Ա�");
		jl2 = new JLabel("ϲ�����˶�");
		
		jb1 = new JButton("ȷ��ע��");
		jb2 = new JButton("ȡ��ע��");
		
		jcb1 = new JCheckBox("����");
		jcb2 = new JCheckBox("����");
		jcb3 = new JCheckBox("����");
		
		jrb1 = new JRadioButton("��");
		jrb2 = new JRadioButton("Ů");
		//ע���������ѡ����뵽һ��BUTTONGROUP
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//���ò��ֹ�����
		this.setLayout(new GridLayout(3,1));
		
		//��������Panel
		jp1.add(jl2);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		jp2.add(jl1);
		jp2.add(jrb1);
		jp2.add(jrb2);
		jp3.add(jb1);
		jp3.add(jb2);
		
		//������
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//���ô���
		this.setTitle("ע�����");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�Դ���
		this.setVisible(true);
	}

}
