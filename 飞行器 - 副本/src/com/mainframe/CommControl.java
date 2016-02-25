package com.mainframe;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.mainframe.DisposeReceivedData;
import com.mainframe.MyWindow;
public class CommControl implements SerialPortEventListener{

	private DisposeReceivedData drd = new DisposeReceivedData();
    /*********************�˿ڵı���******************************/
	String potrName;
	static CommPortIdentifier portId;
	InputStream inputstream;
	OutputStream outputstream;
    SerialPort serialPort = null;
	static StringBuffer buffer;//���ڶ�������
	Boolean recieve;//�������ݶ����־
	static Enumeration<CommPortIdentifier> portList;
	String receiveString = "";
	byte[] receiveArray = new byte[256];
	
	/**�򿪴��ڵķ���**/
	 public void OpenComm()
	 {
		 portList = CommPortIdentifier.getPortIdentifiers(); //�õ���ǰ�����ϵĶ˿�
		 if(portList.hasMoreElements()){
			while (portList.hasMoreElements()) 
			{ 
				portId = (CommPortIdentifier) portList.nextElement();
				if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
				{//�ж�����˿������Ǵ���
					MyWindow.jl1.setText(portId.getName());
					System.out.println("�˿�����"+portId.getName());
                 try {
                 		serialPort = (SerialPort)portId.open("OOPSD", 2000);
						} catch (PortInUseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "����æµ...","����",JOptionPane.WARNING_MESSAGE);
						}
                 try {
                     //���������
                     inputstream = serialPort.getInputStream();
                 } catch (IOException e1) {}
               //���ô��ڼ���
                 try {
                     serialPort.addEventListener((SerialPortEventListener) this);
                 } catch (TooManyListenersException e1) {}
                 
                 serialPort.notifyOnDataAvailable(true);
                 
                 /* ���ô���ͨѶ���� */
                 try {
                     serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
                             SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                 } catch (UnsupportedCommOperationException e1) {}
                
				}
		    }
		 }
		 else{
				JOptionPane.showMessageDialog(null, "δ�ҵ�����","����",JOptionPane.WARNING_MESSAGE);
			}
	 }
	 /**�������ݵķ���
	  *���ã������ݽ���������ͨ�����ڷ��ͳ�ȥ
	  * **/
	 public void SendData(int data)
	 {
		 try {
				outputstream = serialPort.getOutputStream();
				outputstream.write(data);
				outputstream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
	 }
	 /**�رմ���**/
	 public void close()
	 {
		 serialPort.close(); // �رմ���
	 }

		@Override
		public void serialEvent(SerialPortEvent arg0) {
			// TODO Auto-generated method stub
			 switch(arg0.getEventType()) {
		        case SerialPortEvent.BI:/*Break interrupt,ͨѶ�ж�*/
		        case SerialPortEvent.OE:/*Overrun error����λ����*/
		        case SerialPortEvent.FE:/*Framing error����֡����*/
		        case SerialPortEvent.PE:/*Parity error��У�����*/
		        case SerialPortEvent.CD:/*Carrier detect���ز����*/
		        case SerialPortEvent.CTS:/*Clear to send���������*/
		        case SerialPortEvent.DSR:/*Data set ready�������豸����*/
		        case SerialPortEvent.RI:/*Ring indicator������ָʾ*/
		        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:/*Output buffer is empty��������������*/
		            break;
		        case SerialPortEvent.DATA_AVAILABLE:/*Data available at the serial port���˿��п������ݡ������������飬������ն�*/
		            byte[] readBuffer = new byte[256];
		            String str = null;
		            int i=0;
		            try {
		            	while((i=inputstream.read(readBuffer)) == -1){
		            		
		            	}
		            	//System.out.println("�յ�����"+i+"  "+(char)i);
		            	str = new String(readBuffer).trim();
		            	receiveString += str;
		            	if(receiveString.endsWith(";")){
		            		System.out.println("��������Ϊ"+receiveString);
		            		drd.disposeResiveData(receiveString,receiveString.length());
		            		receiveString = "";
		            	}
		            	
		       /**********************�������������ݲ��ȶ�******************************/     	 
		            	
//		                while (inputstream.available() > 0) {
//		                     numBytes= inputstream.read(readBuffer);
//		                }
//		                str = new String(readBuffer).trim();
//		            	receiveString += str;
//		            	if(receiveString.endsWith(";")){
//		            		System.out.println("��������Ϊ"+receiveString);
//		            		receiveString = "";
//		            	}
//		                 
		            } catch (IOException e) {}
				try {
					inputstream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		            break;            
		        }
		    }
		
	
	
	
}

