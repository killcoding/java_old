/**
 *显示内容：X,Y,Z三轴的加速度
 *		  X,Y,Z三轴的角度
 *		    经纬度
 *		  气压计测量高度
 *		  卫星数量（确定gps已经打开切搜星成功）
 *       
 */

package com.mainframe;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlyState extends JFrame{

	JButton jb = new JButton("dfasd");
	
	public FlyState(){
		
		this.add(jb);
		this.setTitle("飞行器飞行状态数据");
		this.setSize(400,300);
		this.setLocation(750,350);
		this.setVisible(true);
	}
	
}
