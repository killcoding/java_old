/*
 * 通过继承thread类编写线程
 */
package com.demo1;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//创建一个hello对象
		Hello hel = new Hello();
		//启动线程,会导致run函数的运行
		hel.start();
	}

}

class Hello extends Thread
{
	int time;
	//重写RUN函数
	public void run()
	{
		while(true)
		{
			//休眠一秒
			//sleep会致使其进入阻塞Blocked状态，并释放资源
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
				//关闭线程
				break;
			}
		}
		
	}
}