/*
 * ͨ���̳�thread���д�߳�
 */
package com.demo1;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//����һ��hello����
		Hello hel = new Hello();
		//�����߳�,�ᵼ��run����������
		hel.start();
	}

}

class Hello extends Thread
{
	int time;
	//��дRUN����
	public void run()
	{
		while(true)
		{
			//����һ��
			//sleep����ʹ���������Blocked״̬�����ͷ���Դ
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time++;
			System.out.println("hello,word"+time);
			if(time==10)
			{
				//�ر��߳�
				break;
			}
		}
		
	}
}