/*
 * ���ֿؼ�����
 * ������JComboBOX/�б�����JList/�����������JScrollPane
 */
package com.swing;

import javax.swing.*;
import java.awt.*;

public class Test2 extends JFrame{

	JPanel jp1,jp2;
	JLabel jl1,jl2;
	JComboBox jcb1;
	JList jls;
	JScrollPane jsp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test2 test2 = new Test2();
	}
	
	//���캯��
	public Test2()
	{
		//�������
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jl1 = new JLabel("��ļ���");
		jl2 = new JLabel("��ѧУ");
		
		//�����򴴽�
		String []jg = {"����","����","�Ϻ�","����"};
		jcb1 = new JComboBox(jg);
		System.out.println(jcb1.getSelectedItem());
		
		String []sch = {"ɽ��","����","�廪","���"};
		jls = new JList(sch);
		//������ϣ����ʵ����ѡ��
		jls.setVisibleRowCount(2);
		jsp = new JScrollPane(jls);
		
		
		//���ò���
		this.setLayout(new GridLayout(3,1));
		
		//������
		jp1.add(jl1);
		jp1.add(jcb1);
		jp2.add(jl2);
		jp2.add(jsp);
		
		this.add(jp1);
		this.add(jp2);
		
		this.setSize(300,300);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

}
