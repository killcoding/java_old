package com.mainframe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class WriteData extends JFrame implements ActionListener{
	
	JPanel north = new JPanel();
	JPanel second = new JPanel();
	JPanel checkbox = new JPanel();
	
	JLabel loct = new JLabel("保存位置");
	static JTextField locationchoose = new JTextField(40);
	JButton choose = new JButton("...");
	JLabel filename = new JLabel(("文件名称"));
	JLabel writeF = new JLabel("写入频率");
	JLabel promopt = new JLabel("选择要写入的数据:");
	static JTextField f = new JTextField(8);
	static JTextField name = new JTextField(20);
	JButton start = new JButton("开始写入");
	static JCheckBox angx = new JCheckBox("角度X");
	
	static String filePath;//文件存储位置
	static Boolean flag = true;//标志写入还是停止
	
	
	public WriteData(){
		
		locationchoose.setText("E:\\数据存储");		
		choose.setSize(20,20);
		choose.addActionListener(this);
		start.addActionListener(this);
		f.setText("300");
		north.setBounds(0, 0, 600, 35);
		north.setLayout(new FlowLayout(0,10,0));
		north.add(loct);
		north.add(locationchoose);
		north.add(choose);
		second.setBounds(0, 35, 600, 35);
		second.setLayout(new FlowLayout(0,10,0));
		second.add(filename);
		second.add(name);
		second.add(writeF);
		second.add(f);
		second.add(start);
		promopt.setBounds(10, 65, 300, 35);
		checkbox.add(angx);
		checkbox.setLayout(new FlowLayout(0,10,0));
		checkbox.setBounds(0, 100, 600, 35);
		
		this.setLayout(null);
		this.add(north);
		this.add(second);
		this.add(promopt);
		this.add(checkbox);
		this.setTitle("保存数据");
		this.setSize(600,250);
		this.setLocation(750,100);
		this.setVisible(true);
	}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==choose){
		try {
			JFrame f  = new JFrame();
			JFileChooser jfc = new JFileChooser("E:\\数据存储");
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			try {
			    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} 
			catch (Exception e1) {
			    e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(jfc);
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        	int returnVal = jfc.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION){       
            		filePath= jfc.getSelectedFile().getAbsolutePath();//这个就是你选择的文件夹的路径
            		locationchoose.setText(filePath);
                     } 	
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	if(e.getSource()==start){
		if(WriteData.angx.isSelected()){
			System.out.println("选定");
		}
		if(start.getText().equals("停止写入")){
			System.out.println("修改标志位为false");
			flag = false;
		}
		
		if(start.getText().equals("开始写入")){
			start.setText("停止写入");
			Savedata sd = new Savedata();
			Thread t = new Thread(sd);
			t.start();
			//System.out.println("成功"+name.getText());
		}
		
	}
}
	
}
class Savedata implements Runnable{
	 int datalocation = 0;//数据写入的行标
	//打开文件
	WritableWorkbook book;
	Savedata(){
		try {
			if(WriteData.filePath==null){
				WriteData.filePath=WriteData.locationchoose.getText();
			}
			//打开文件
			book=Workbook.createWorkbook(new File(WriteData.filePath+"/"+WriteData.name.getText()+".xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		//生成名为“第一页”的工作表，参数0表示这是第一页
		WritableSheet sheet=book.createSheet("第一页",0);
		while(true){	
			try
			{
				//在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
				//以及单元格内容为test
				Label label=new Label(0,datalocation++,"test");
				//将定义好的单元格添加到工作表中
				sheet.addCell(label);
				try {
					Thread.sleep(Integer.parseInt(WriteData.f.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}		
				/*生成一个保存数字的单元格
				必须使用Number的完整包路径，否则有语法歧义
				单元格位置是第二列，第一行，值为789.123*/
				jxl.write.Number number = new jxl.write.Number(1,0,789.123);
				sheet.addCell(number);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			if(WriteData.flag  == false){
				//System.out.println("点击停止按钮");
				try {
					//写入数据并关闭文件
					book.write();
					book.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
				
		}
		//System.out.println("已经显示完");
	}
}
