/*
 * java绘图原理
 * 在jpanel上画
 * 窗口最大化，最小化时paint会自动调用
 * 
 */
package com.huitu;

import javax.swing.*;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import java.awt.*;
public class Test1 extends JFrame {

	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test1 test1 = new Test1();
	}
	public Test1()
	{
		mp = new MyPanel();
		
		this.add(mp);
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}

//定义自己的panel类(自己的面板，是自己绘图的区域)
/*class MyPanel extends JPanel
{
	//覆盖JPANEL中的paint方法
	public void paint(Graphics g)//gtaphics是画笔 是绘图的重要类
	{
		//调用父类完成初始化
		//这句话不能省
		System.out.println("被调用paint");
		super.paint(g);
		//先话一个○
		//g.drawOval(10, 10, 30, 30);
		//画直线
		//g.drawLine(10, 10, 30, 10);
		//画举行边框
		//g.drawRect(10, 10, 40, 40);
		//画填充矩形
		//设置矩形颜色
//		g.setColor(Color.blue);
//		g.fillRect(10, 10, 30, 20);
//		g.setColor(Color.red);
//		g.fillRect(50, 60, 30, 20);
		//画出图片
//		Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/keai.jpg"));
//		
//		g.drawImage(im, 10,10, 800, 600, this);
		//画字符串
//		g.setColor(Color.red);//需要在写字体钱设置
//		g.setFont(new Font("华文彩云",Font.BOLD,50));
//		g.drawString("字符串显示", 100, 100);
		
		
		
		
	}
}*/
