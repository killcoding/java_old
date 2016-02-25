/*
 * 两个线程同事进行
 * 最好用接口实现
 */
package com.bingfa;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bird bird = new Bird(10);
		Pig pig = new Pig(10);
		Thread t1 = new Thread(bird);
		Thread t2 = new Thread(pig);
		t1.start();
		t2.start();
	}

}
//输出字符
class Pig implements Runnable
{
	int n=0;
	int time=0;
	
	public Pig(int n)
	{
		this.n = n;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			time++;
			System.out.println("输出第"+time+"个hello");
			if(time==n)
			{
				break;
			}
		}
		
	}
	
}
//做算术题
class Bird implements Runnable
{
	int n=0;
	int res=0;
	int time=0;
	
	public Bird(int n)
	{
		this.n = n;
	}
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			res+=(++time);
			System.out.println("当前结果是"+res);
			if(time == n)
			{
				System.out.println("最后结果是"+res);
				break;
			}
		}
	}
}
