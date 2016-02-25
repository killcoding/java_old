package com.panel.draw;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MyPanel extends JFrame{
	public MyPanel()
	{
		Panel1 p = new Panel1();
		this.add(p);
		this.setSize(300,200);
		this.setVisible(true);
	}
		
		
}
class Panel1 extends JPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
		//»­Ö±Ïß
		g.drawLine(10, 10, 30, 10);
	}
	public void drawFcu()
	{
		
	}
}
