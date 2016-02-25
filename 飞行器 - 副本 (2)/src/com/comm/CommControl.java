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

    /*********************端口的变量******************************/
	String potrName;
	static CommPortIdentifier portId;
	InputStream inputstream;
	OutputStream outputstream;
    SerialPort serialPort = null;
	static StringBuffer buffer;//串口读入数据
	Boolean recieve;//有新数据读入标志
	static Enumeration<CommPortIdentifier> portList;
	/**打开串口的方法**/
	 public void OpenComm()
	 {
		 portList = CommPortIdentifier.getPortIdentifiers(); //得到当前连接上的端口
			while (portList.hasMoreElements()) 
			{  
				portId = (CommPortIdentifier) portList.nextElement();
				if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
				{//判断如果端口类型是串口
					System.out.println(portId.getName());
					
					if (portId.getName().equals("COM3")) {
					//打开串口
                 try {
                 		serialPort = (SerialPort)portId.open("OOPSD", 2000);
						} catch (PortInUseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                 try {
                     //获得输入流
                     inputstream = serialPort.getInputStream();
                 } catch (IOException e1) {}
               //设置串口监听
                 try {
                     serialPort.addEventListener((SerialPortEventListener) this);
                 } catch (TooManyListenersException e1) {}
                 
                 serialPort.notifyOnDataAvailable(true);
                 
                 /* 设置串口通讯参数 */
                 try {
                     serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
                             SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                 } catch (UnsupportedCommOperationException e1) {}
                
					}
				}
		    }
	 }
	 /**发送数据的方法
	  *作用：将传递进来的数据通过串口发送出去
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
	 /**读取端口数据**/
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
        	 //关闭资源
				inputstream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         return readStr;
             
	 }
	 /**关闭串口**/
	 public void close()
	 {
		 serialPort.close(); // 关闭串口
	 }
	 @Override
		public void serialEvent(SerialPortEvent arg0) {
			// TODO Auto-generated method stub
			 switch(arg0.getEventType()) {
		        case SerialPortEvent.BI:/*Break interrupt,通讯中断*/
		        case SerialPortEvent.OE:/*Overrun error，溢位错误*/
		        case SerialPortEvent.FE:/*Framing error，传帧错误*/
		        case SerialPortEvent.PE:/*Parity error，校验错误*/
		        case SerialPortEvent.CD:/*Carrier detect，载波检测*/
		        case SerialPortEvent.CTS:/*Clear to send，清除发送*/
		        case SerialPortEvent.DSR:/*Data set ready，数据设备就绪*/
		        case SerialPortEvent.RI:/*Ring indicator，响铃指示*/
		        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:/*Output buffer is empty，输出缓冲区清空*/
		            break;
		        case SerialPortEvent.DATA_AVAILABLE:/*Data available at the serial port，端口有可用数据。读到缓冲数组，输出到终端*/
		        	MyWindow my = new MyWindow();
		        	 my.setReadStr(new CommControl().ReadComm());
		            break;            
		        }
		    }
	
	
	
}
