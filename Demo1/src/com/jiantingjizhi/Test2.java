
/*
 * ���̼����¼�
 * ͨ�������������Ҽ����С���˶�
 */
package com.jiantingjizhi;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Test2 extends JFrame{

	//�������
	MyPanel1 mp = new MyPanel1();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test2 test2 = new Test2();
		
	}
	//���캯��
	public Test2()
	{
		this.add(mp);
		//ע����̼���
		this.addKeyListener(mp);
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

//�������
class MyPanel1 extends JPanel implements KeyListener
{ 
	int x = 10;
	int y = 10;
	public void paint(Graphics g)
	{
		super.paint(g);
		//��һ��ʵ��Բ
		g.fillOval(x, y, 10, 10);
		
		
	}

	@Override
	//����ʾ�ַ��ļ�������
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//��������
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("������"+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_DOWN)//�˴�������code
		{
			y++;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)//�˴�������code
		{
			y--;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)//�˴�������code
		{
			x++;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)//�˴�������code
		{
			x--;
		}
		//����repaint��������ʹpaint���ػ�
		this.repaint();
	}

	@Override
	//�����ɿ�
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}