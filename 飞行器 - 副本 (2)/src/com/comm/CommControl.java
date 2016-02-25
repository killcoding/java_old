package com.comm;
import com.window.*;
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
public class CommControl implements SerialPortEventListener{

    /*********************�˿ڵı���******************************/
	String potrName;
	static CommPortIdentifier portId;
	InputStream inputstream;
	OutputStream outputstream;
    SerialPort serialPort = null;
	static StringBuffer buffer;//���ڶ�������
	Boolean recieve;//�������ݶ����־
	static Enumeration<CommPortIdentifier> portList;
	/**�򿪴��ڵķ���**/
	 public void OpenComm()
	 {
		 portList = CommPortIdentifier.getPortIdentifiers(); //�õ���ǰ�����ϵĶ˿�
			while (portList.hasMoreElements()) 
			{  
				portId = (CommPortIdentifier) portList.nextElement();
				if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
				{//�ж�����˿������Ǵ���
					System.out.println(portId.getName());
					
					if (portId.getName().equals("COM3")) {
					//�򿪴���
                 try {
                 		serialPort = (SerialPort)portId.open("OOPSD", 2000);
						} catch (PortInUseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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
	 }
	 /**�������ݵķ���
	  *���ã������ݽ���������ͨ�����ڷ��ͳ�ȥ
	  * **/
	 public void SendData(byte data[])
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
	 /**��ȡ�˿�����**/
	 public String ReadComm()
	 {
		 
		 byte[] readBuffer = new byte[256];
         String readStr="";
         int numBytes=0;
         try {
        	 while (inputstream.available() > 0) {
                 numBytes= inputstream.read(readBuffer);
            }
//           for(int iii=0;iii<numBytes;iii++){   
//             readStr=readStr + Byte.toString(readBuffer[iii]);                  
//           }
         readStr = new String(readBuffer);
		} catch (Exception e) {
			// TODO: handle exception
		}
         try {
        	 //�ر���Դ
				inputstream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         return readStr;
             
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
		        	MyWindow my = new MyWindow();
		        	 my.setReadStr(new CommControl().ReadComm());
		            break;            
		        }
		    }
	
	
	
}
