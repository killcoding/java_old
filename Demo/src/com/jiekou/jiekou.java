/*
 *���ܣ��ӿڽ��� 
 */
package com.jiekou;

public class jiekou {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ������
		Computer computer = new Computer();
		Camera  camera  = new Camera();
		Phone   phone  = new Phone();
		computer.UseUsb(camera);
		computer.UseUsb(phone);
		System.out.println(Usb.a);//�ӿ��ж���ı������Ǿ�̬��
	}

}

interface Usb			//�ӿ�
{
	int a=1;
	public void start();
	public void stop();
}
interface ks extends Usb	//�ӿڲ��ܼ̳��࣬���ܼ̳������Ľӿ�
{
	
}

//�����ֻ��࣬��ʵ��USB�ӿ�
class Phone	implements Usb,ks 	//ʵ�ֽӿ� ,,,һ�������ʵ�ֶ���ӿ�
{
	public void start()		//��Ҫ�ѽӿڶ���������඼ʵ��
	{
		System.out.println("�ֻ��ӿڴ�");
	}
	public void stop()
	{
		System.out.println("�ֻ��ӿڹر�");
	}
	
}

class Camera implements Usb
{
	public void start()		//��Ҫ�ѽӿڶ���������඼ʵ��
	{
		System.out.println("����ӿڴ�");
	}
	public void stop()		//��Ҫ�ѽӿڶ���������඼ʵ��
	{
		System.out.println("����ӿڹر�");
	}
}

class Computer
{
	//��ʼʹ��USB�ӿ�
	public void UseUsb(Usb usb)
	{
		usb.start();
		usb.stop();
	}
}