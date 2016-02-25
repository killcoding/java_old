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
	
	JLabel loct = new JLabel("����λ��");
	static JTextField locationchoose = new JTextField(40);
	JButton choose = new JButton("...");
	JLabel filename = new JLabel(("�ļ�����"));
	JLabel writeF = new JLabel("д��Ƶ��");
	JLabel promopt = new JLabel("ѡ��Ҫд�������:");
	static JTextField f = new JTextField(8);
	static JTextField name = new JTextField(20);
	JButton start = new JButton("��ʼд��");
	static JCheckBox angx = new JCheckBox("�Ƕ�X");
	
	static String filePath;//�ļ��洢λ��
	static Boolean flag = true;//��־д�뻹��ֹͣ
	
	
	public WriteData(){
		
		locationchoose.setText("E:\\���ݴ洢");		
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
		this.setTitle("��������");
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
			JFileChooser jfc = new JFileChooser("E:\\���ݴ洢");
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
            		filePath= jfc.getSelectedFile().getAbsolutePath();//���������ѡ����ļ��е�·��
            		locationchoose.setText(filePath);
                     } 	
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	if(e.getSource()==start){
		if(WriteData.angx.isSelected()){
			System.out.println("ѡ��");
		}
		if(start.getText().equals("ֹͣд��")){
			System.out.println("�޸ı�־λΪfalse");
			flag = false;
		}
		
		if(start.getText().equals("��ʼд��")){
			start.setText("ֹͣд��");
			Savedata sd = new Savedata();
			Thread t = new Thread(sd);
			t.start();
			//System.out.println("�ɹ�"+name.getText());
		}
		
	}
}
	
}
class Savedata implements Runnable{
	 int datalocation = 0;//����д����б�
	//���ļ�
	WritableWorkbook book;
	Savedata(){
		try {
			if(WriteData.filePath==null){
				WriteData.filePath=WriteData.locationchoose.getText();
			}
			//���ļ�
			book=Workbook.createWorkbook(new File(WriteData.filePath+"/"+WriteData.name.getText()+".xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		//������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ
		WritableSheet sheet=book.createSheet("��һҳ",0);
		while(true){	
			try
			{
				//��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0)
				//�Լ���Ԫ������Ϊtest
				Label label=new Label(0,datalocation++,"test");
				//������õĵ�Ԫ����ӵ���������
				sheet.addCell(label);
				try {
					Thread.sleep(Integer.parseInt(WriteData.f.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}		
				/*����һ���������ֵĵ�Ԫ��
				����ʹ��Number��������·�����������﷨����
				��Ԫ��λ���ǵڶ��У���һ�У�ֵΪ789.123*/
				jxl.write.Number number = new jxl.write.Number(1,0,789.123);
				sheet.addCell(number);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			if(WriteData.flag  == false){
				//System.out.println("���ֹͣ��ť");
				try {
					//д�����ݲ��ر��ļ�
					book.write();
					book.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
				
		}
		//System.out.println("�Ѿ���ʾ��");
	}
}
