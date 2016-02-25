/**
 * 坦克大战1.0
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
	//构造函数
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

//我的面板
class MyPanel extends JPanel
{
	//定义自己的一个坦克
	Hero hero = null;
	
	//构造函数
	public MyPanel()
	{
		hero = new Hero(30,10);
	}
	
	//重写Paint函数
	public void paint(Graphics g)
	{	
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		//设置画笔的颜色
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
	}
	
	//用于画出坦克的函数
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//判断是什么类型的坦克
		switch(type)
		{
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		//判断方向
		switch(direct)
		{
		case 0:
			//画出坦克(需要封装成一个函数)
			//1.画出左面的
			g.fill3DRect(x, y, 5, 30,false);//矩形
			//画出右面矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//画出中间矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//画出竖线
			g.drawLine(x+10, y, x+10, y+10);
			break;
		}
	}
}
//坦克类的父类
class Tank
{
	//表示坦克的横坐标
	int x = 0;
	//坦克纵坐标
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

//我的坦克
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x,y);//这句话什么意思？,表示调用父类构造函数
	}
}