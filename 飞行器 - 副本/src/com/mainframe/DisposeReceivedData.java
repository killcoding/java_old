/*这个类负责处理下位机上传的数据并进行处理整合，
 * 之后发送给用于显示的类进行界面显示
 * */
package com.mainframe;


public class DisposeReceivedData {
	
	String one,two,three,four,five,six,seven,eight,nine,ten;//用于存放串口接收数据的处理结果
	DisplayReceivedData drd = new DisplayReceivedData();
	
	/*处理串口接收到的数据*/
	public void disposeResiveData(String read,int num){
		
		/*校验帧头确保数据正确传输*/
		if(read.substring(0, 2).equals("AA")){
			System.out.println("num为"+num+"接受内容为"+read);
			switch(read.charAt(3)){//根据功能好判断接收的数据格式
			case '1':
				if(num==15){//利用数据总数保证数据正确接收后再进行转换
					
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
