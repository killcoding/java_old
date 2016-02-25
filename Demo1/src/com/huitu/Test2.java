/**
 * ̹�˴�ս1.0
 */
package com.huitu;

import java.awt.*;
import javax.swing.*;
public class Test2 extends JFrame{

	MyPanel mp = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test2 test2 = new Test2();
	}
	//���캯��
	public Test2()
	{
		mp = new MyPanel();
		
		this.add(mp);
		this.setSize(400,300);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

}

//�ҵ����
class MyPanel extends JPanel
{
	//�����Լ���һ��̹��
	Hero hero = null;
	
	//���캯��
	public MyPanel()
	{
		hero = new Hero(30,10);
	}
	
	//��дPaint����
	public void paint(Graphics g)
	{	
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		//���û��ʵ���ɫ
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
	}
	
	//���ڻ���̹�˵ĺ���
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//�ж���ʲô���͵�̹��
		switch(type)
		{
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		//�жϷ���
		switch(direct)
		{
		case 0:
			//����̹��(��Ҫ��װ��һ������)
			//1.���������
			g.fill3DRect(x, y, 5, 30,false);//����
			//�����������
			g.fill3DRect(x+15, y, 5, 30,false);
			//�����м����
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//����Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//��������
			g.drawLine(x+10, y, x+10, y+10);
			break;
		}
	}
}
//̹����ĸ���
class Tank
{
	//��ʾ̹�˵ĺ�����
	int x = 0;
	//̹��������
	int y = 0;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	//
	public Tank(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
}

//�ҵ�̹��
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x,y);//��仰ʲô��˼��,��ʾ���ø��๹�캯��
	}
}