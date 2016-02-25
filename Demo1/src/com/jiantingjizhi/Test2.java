
/*
 * 键盘监听事件
 * 通过键盘上下左右间控制小球运动
 */
package com.jiantingjizhi;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Test2 extends JFrame{

	//定义变量
	MyPanel1 mp = new MyPanel1();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test2 test2 = new Test2();
		
	}
	//构造函数
	public Test2()
	{
		this.add(mp);
		//注册键盘监听
		this.addKeyListener(mp);
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

//定义面板
class MyPanel1 extends JPanel implements KeyListener
{ 
	int x = 10;
	int y = 10;
	public void paint(Graphics g)
	{
		super.paint(g);
		//画一个实心圆
		g.fillOval(x, y, 10, 10);
		
		
	}

	@Override
	//不显示字符的键被按下
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//键被按下
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("被按下"+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_DOWN)//此处必须是code
		{
			y++;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)//此处必须是code
		{
			y--;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)//此处必须是code
		{
			x++;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)//此处必须是code
		{
			x--;
		}
		//调用repaint函数，来使paint被重画
		this.repaint();
	}

	@Override
	//键被松开
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}