/*
 *功能：接口讲解 
 */
package com.jiekou;

public class jiekou {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个电脑
		Computer computer = new Computer();
		Camera  camera  = new Camera();
		Phone   phone  = new Phone();
		computer.UseUsb(camera);
		computer.UseUsb(phone);
		System.out.println(Usb.a);//接口中定义的变量都是静态的
	}

}

interface Usb			//接口
{
	int a=1;
	public void start();
	public void stop();
}
interface ks extends Usb	//接口不能继承类，但能继承其他的接口
{
	
}

//创建手机类，并实现USB接口
class Phone	implements Usb,ks 	//实现接口 ,,,一个类可以实现多个接口
{
	public void start()		//需要把接口定义的所有类都实现
	{
		System.out.println("手机接口打开");
	}
	public void stop()
	{
		System.out.println("手机接口关闭");
	}
	
}

class Camera implements Usb
{
	public void start()		//需要把接口定义的所有类都实现
	{
		System.out.println("相机接口打开");
	}
	public void stop()		//需要把接口定义的所有类都实现
	{
		System.out.println("相机接口关闭");
	}
}

class Computer
{
	//开始使用USB接口
	public void UseUsb(Usb usb)
	{
		usb.start();
		usb.stop();
	}
}