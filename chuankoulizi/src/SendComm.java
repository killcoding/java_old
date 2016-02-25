
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
    
	//���ϵͳ�п��õ�ͨѶ�˿���
    static CommPortIdentifier portId;
    //Enumeration Ϊö������,��util��
    static Enumeration<CommPortIdentifier> portList;
    
    //���������
    InputStream inputStream;
    OutputStream outputStream;
    
    //RS-232�Ĵ��п�
    SerialPort serialPort;
    
    Thread readThread;
    String str = "";
    
    //����
    Panel p = new Panel();
    TextArea in_message = new TextArea("��COM1,������9600,����λ8,ֹͣλ1.");
    TextArea out_message = new TextArea("X010600Y");
    Button btnOpen = new Button("�򿪴���, ��������");
    Button btnClose = new Button("�رմ���, ֹͣ��������");
    byte data[] = new byte[10240];
    
    //�����ж�Ҫ�Ƿ�رմ��ڵı�־
    boolean mark;

    //���췽�������Ŵ���
    S_Frame() {
        super("���ڷ�������");
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
    
    //ʵ��ActionListener�ӿڵķ�������������ʱ����
    //�����Ť�򿪴���
    public void actionPerformed(ActionEvent event) {
        
        //getSource��ActionEvent�ĸ���java.util.EventObject�ķ���
        //�������رհ�ť
        if (event.getSource() == btnClose) {
            serialPort.close(); // �رմ���
            mark = true; // ������ֹ�̵߳�run()����
            in_message.setText("����COM1�Ѿ��ر�,ֹͣ��������.");
        } 
        //����򿪴��ڰ�ť
          else {
            mark = false;
            //���ı������ֽڶ�ȡ���ݵ��ֽ�����
            data = out_message.getText().getBytes();
            
            //��ȡϵͳ�����е�ͨѶ�˿�
            portList = CommPortIdentifier.getPortIdentifiers();
            //��ѭ���ṹ�ҳ�����
            while (portList.hasMoreElements()) {
                //ǿ��ת��ΪͨѶ�˿�����
                portId =  portList.nextElement();
                //�ж��Ƿ�Ϊ����
                if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                    if (portId.getName().equals("COM17")) {
                        //�򿪴���
                        try {
                            serialPort = (SerialPort) portId.open("testSerialPort", 2000);
                        } catch (PortInUseException e) {}
                        
                        try {
                            //�������
                            outputStream = serialPort.getOutputStream();
                            //���豸��������
                            outputStream.write(data);
                            //���������
                            inputStream = serialPort.getInputStream();
                        } catch (IOException e) {}
                        
                        //���ô��ڼ���
                        try {
                            serialPort.addEventListener((SerialPortEventListener) this);
                        } catch (TooManyListenersException e) {}
                        
                        serialPort.notifyOnDataAvailable(true);
                        
                        /* ���ô���ͨѶ���� */
                        try {
                            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
                                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                        } catch (UnsupportedCommOperationException e) {}
                    }
                }
            in_message.setText("�����Ѿ���,����ÿ2���ӷ���һ������.....");
            }
        }
    }

    public void serialEvent(SerialPortEvent event) { 
        byte[] readBuffer = new byte[20]; 
        try { 
            inputStream = serialPort.getInputStream(); 
        } catch (IOException e) {} 
        try { 
            /**//* ����·�϶�ȡ������ */ 
            while (inputStream.available() > 0) { 
                int numBytes = inputStream.read(readBuffer); 
    
            } // while end 
            str = new String(readBuffer); 
    
            //���յ������ݴ�ŵ��ı����� 
            in_message.append(str + " "); 
        } catch (IOException e) {} 
    }
}

/**
 * SendComm������
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

