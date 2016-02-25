import gnu.io.CommPortIdentifier;
 
import gnu.io.PortInUseException;
  
import gnu.io.SerialPort;
  
import gnu.io.UnsupportedCommOperationException; 
 
import java.io.IOException;
 
import java.io.InputStream;
  
import java.io.OutputStream;
  
import java.util.Enumeration;
  
import java.util.TooManyListenersException; 
 
public class ComTest { 
 
    /**
     * @param args
  
     * @throws Exception
  
     */
  
    @SuppressWarnings("unchecked")
  
    public static void main(String[] args) throws Exception {
  
        String port = "COM3"; 
 
        for (Enumeration<CommPortIdentifier> e = CommPortIdentifier
                .getPortIdentifiers(); e.hasMoreElements();) {
  
            CommPortIdentifier portId = e.nextElement();
  
            //if (portId.getName().equals(port)) {
  
             //   System.out.println("\r");
  
                System.out.println("�ҵ��˿ڣ� " + port);
  
                //sendAtTest(portId);
  
          //  }
  
        }
  
    } 
 
    private static void sendAtTest(CommPortIdentifier portId)
 
            throws PortInUseException, UnsupportedCommOperationException,
  
            TooManyListenersException, IOException, InterruptedException {
  
        System.out.println("�򿪶˿� ��");
  
        final SerialPort serialPort = (SerialPort) portId.open("wavecom", 100);
  
        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);
  
        serialPort.setSerialPortParams(9600,// ������
  
                SerialPort.DATABITS_8,// ����λ��
  
                SerialPort.STOPBITS_1, // ֹͣλ
  
                SerialPort.PARITY_NONE);// ��żλ
  
        System.out.println("�˿��Ѵ򿪡�\n����ATָ�� ��");
  
        InputStream inputStream=serialPort.getInputStream();
  
        OutputStream outputStream=serialPort.getOutputStream();
  
        outputStream.write("AT\r".getBytes());
  
        Thread.sleep(1000);
       
        byte[] data=new byte[1024];
  
        for(int i=inputStream.read(data);;i=inputStream.read(data)){
        	
            if(i==0){
            	
                System.out.println(new String(data,0,i));
  
                System.out.println("�ɹ��յ�ָ���ֵ��");
  
                break;
  
            }
  
        } 
        serialPort.close();
        System.out.println("�رն˿ڡ�");
  
    } 
 
}
