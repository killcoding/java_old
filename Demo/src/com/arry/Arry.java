/*
 * ���ܣ���������Ӧ����������
 * ����֪ʶ��1��IO����ʹ�ã��Ӽ��̽�������
 * 			2.ʹ�ü��̽������ݺ���ʱ�쳣�Ĵ���
 */
package com.arry;
import java.io.*;
public class Arry {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//����һ�����Դ���ĸ����������
		Dog dogs[] = new Dog[4]; 
		
		//���������ֵ��ֵ
		/*dogs[0] = new Dog();  //���������٣�ע�⣡����
		dogs[0].setName("huahaua");
		dogs[0].setWeight(1);*/
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		for(int i=0;i<dogs.length;i++)
		{
			dogs[i] = new Dog();
			System.out.println("����������");
			String name = br.readLine();//�˴��쳣
			//���ָ�������
			dogs[i].setName(name);
			//���빷������
			System.out.println("����������");
			String t_weight = br.readLine();
			float weight = Float.parseFloat(t_weight);//�ַ���ת��Ϊ������
			//��������������
			dogs[i].setWeight(weight);
		}
		//����ƽ������
		float all = 0;
		for(int i=0;i<dogs.length;i++)
		{
			all += dogs[i].getWeight();
		}
		float ave_weight;
		ave_weight = all/dogs.length;
		System.out.println("������"+all+"ƽ������"+ave_weight);
	}

}

//����һ����
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