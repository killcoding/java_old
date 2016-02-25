
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

class S_Frame extends Frame implements ActionListener,SerialPortEventListener {
    
	//检测系统中可用的通讯端口类
    static CommPortIdentifier portId;
    //Enumeration 为枚举型类,在util中
    static Enumeration<CommPortIdentifier> portList;
    
    //输入输出流
    InputStream inputStream;
    OutputStream outputStream;
    
    //RS-232的串行口
    SerialPort serialPort;
    
    Thread readThread;
    String str = "";
    
    //界面
    Panel p = new Panel();
    TextArea in_message = new TextArea("打开COM1,波特率9600,数据位8,停止位1.");
    TextArea out_message = new TextArea("X010600Y");
    Button btnOpen = new Button("打开串口, 发送数据");
    Button btnClose = new Button("关闭串口, 停止发送数据");
    byte data[] = new byte[10240];
    
    //设置判断要是否关闭串口的标志
    boolean mark;

    //构造方法：安排窗体
    S_Frame() {
        super("串口发送数据");
        setSize(200, 200);
        setVisible(true);
        add(out_message, "Center");
        add(p, "North");
        p.add(btnOpen);
        p.add(btnClose);
        add(in_message, "South");
        btnOpen.addActionListener(this);
        btnClose.addActionListener(this);
    }
    
    //实现ActionListener接口的方法，发生操作时调用
    //点击按扭打开串口
    public void actionPerformed(ActionEvent event) {
        
        //getSource是ActionEvent的父类java.util.EventObject的方法
        //如果点击关闭按钮
        if (event.getSource() == btnClose) {
            serialPort.close(); // 关闭串口
            mark = true; // 用于中止线程的run()方法
            in_message.setText("串口COM1已经关闭,停止发送数据.");
        } 
        //点击打开串口按钮
          else {
            mark = false;
            //从文本区按字节读取数据到字节数组
            data = out_message.getText().getBytes();
            
            //获取系统中所有的通讯端口
            portList = CommPortIdentifier.getPortIdentifiers();
            //用循环结构找出串口
            while (portList.hasMoreElements()) {
                //强制转换为通讯端口类型
                portId =  portList.nextElement();
                //判断是否为串口
                if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                    if (portId.getName().equals("COM17")) {
                        //打开串口
                        try {
                            serialPort = (SerialPort) portId.open("testSerialPort", 2000);
                        } catch (PortInUseException e) {}
                        
                        try {
                            //打开输出流
                            outputStream = serialPort.getOutputStream();
                            //向设备发送数据
                            outputStream.write(data);
                            //获得输入流
                            inputStream = serialPort.getInputStream();
                        } catch (IOException e) {}
                        
                        //设置串口监听
                        try {
                            serialPort.addEventListener((SerialPortEventListener) this);
                        } catch (TooManyListenersException e) {}
                        
                        serialPort.notifyOnDataAvailable(true);
                        
                        /* 设置串口通讯参数 */
                        try {
                            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
                                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                        } catch (UnsupportedCommOperationException e) {}
                    }
                }
            in_message.setText("串口已经打开,正在每2秒钟发送一次数据.....");
            }
        }
    }

    public void serialEvent(SerialPortEvent event) { 
        byte[] readBuffer = new byte[20]; 
        try { 
            inputStream = serialPort.getInputStream(); 
        } catch (IOException e) {} 
        try { 
            /**//* 从线路上读取数据流 */ 
            while (inputStream.available() > 0) { 
                int numBytes = inputStream.read(readBuffer); 
    
            } // while end 
            str = new String(readBuffer); 
    
            //接收到的数据存放到文本区中 
            in_message.append(str + " "); 
        } catch (IOException e) {} 
    }
}

/**
 * SendComm主方法
 * @author warm
 *
 */
public class SendComm {
    public static void main(String args[]) {
        S_Frame S_win = new S_Frame();
        S_win.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        S_win.pack();
    }
}

