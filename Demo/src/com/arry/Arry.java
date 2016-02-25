/*
 * 功能：对象数组应用样例代码
 * 额外知识：1、IO流的使用，从键盘接收数据
 * 			2.使用键盘接收数据函数时异常的处理
 */
package com.arry;
import java.io.*;
public class Arry {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//定义一个可以存放四个对象的数组
		Dog dogs[] = new Dog[4]; 
		
		//给数组各个值赋值
		/*dogs[0] = new Dog();  //本条不能少，注意！！！
		dogs[0].setName("huahaua");
		dogs[0].setWeight(1);*/
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		for(int i=0;i<dogs.length;i++)
		{
			dogs[i] = new Dog();
			System.out.println("请输入名字");
			String name = br.readLine();//此处异常
			//名字付给变量
			dogs[i].setName(name);
			//输入狗的体重
			System.out.println("请输入重量");
			String t_weight = br.readLine();
			float weight = Float.parseFloat(t_weight);//字符型转换为浮点型
			//将重量付给对象
			dogs[i].setWeight(weight);
		}
		//计算平均体重
		float all = 0;
		for(int i=0;i<dogs.length;i++)
		{
			all += dogs[i].getWeight();
		}
		float ave_weight;
		ave_weight = all/dogs.length;
		System.out.println("总体重"+all+"平均体重"+ave_weight);
	}

}

//定义一个类
class Dog
{
	private String name;
	private float weight;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}