/*����ฺ������λ���ϴ������ݲ����д������ϣ�
 * ֮���͸�������ʾ������н�����ʾ
 * */
package com.mainframe;


public class DisposeReceivedData {
	
	String one,two,three,four,five,six,seven,eight,nine,ten;//���ڴ�Ŵ��ڽ������ݵĴ�����
	DisplayReceivedData drd = new DisplayReceivedData();
	
	/*�����ڽ��յ�������*/
	public void disposeResiveData(String read,int num){
		
		/*У��֡ͷȷ��������ȷ����*/
		if(read.substring(0, 2).equals("AA")){
			System.out.println("numΪ"+num+"��������Ϊ"+read);
			switch(read.charAt(3)){//���ݹ��ܺ��жϽ��յ����ݸ�ʽ
			case '1':
				if(num==15){//��������������֤������ȷ���պ��ٽ���ת��
					
					one = read.substring(5, 9);
					two = read.substring(10,14);
					drd.display_angel(one,two);
				}
				break;
			case '2':
				break;
				
			}
		}
											
	}
}
