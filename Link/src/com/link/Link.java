/**
 * ���ã� ����Ľ���
 * ��Լɪ������
 */
package com.link;

public class Link {

	/**
	 * @param args
	 * ��Ҫѧϰ����Ĵ�����Ӧ��
	 * �ѵ㣺  Child firstChild  ����ʲô��˼
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CycLink cyclink = new CycLink();
		cyclink.SetLen(9);
		cyclink.creatLink();
		cyclink.setK(2);		//�ӵڶ����˿�ʼ
		cyclink.setM(2);		//����������
		cyclink.show();
	}

}

class Child
{
	int num;
	Child nextChild = null;
	public Child(int num)    //��Ĺ��췽��
	{
		this.num = num;
	}
}

//��������
class CycLink
{
	//�ȶ���ָ�������һ��С��������
	//ָ���һ��С�������ã��൱�ڳ�ʼ�����ܶ�
	Child firstChild = null;
	Child temp;		//������ʱ�������洢��ʱֵ����֤ԭʼֵ����
	int len = 0;		//��ʾ���м���С��
	int k=0;
	int m=0;
	
	//���û�������Ĵ�С
	public void SetLen(int len)
	{
		this.len = len;
	}
	
	//���ôӵڼ����˿�ʼ����
	public void setK(int k)
	{
		this.k = k;
	}
	//����M
	public void setM(int m)
	{
		this.m = m;
	}
	//��ʼ��Ϸ
	public void play()
	{
		Child temp = this.firstChild;
		//�ҵ���K ����
		for(int i=1;i<k;i++)
		{
			temp = temp.nextChild;
		}
		//����ΪM��
		for(int j=1;j<m;j++)
		{
			temp = temp.nextChild;
		}
		//������M�����˳�
	}
	//��ʼ����������
	public void creatLink()
	{
		for(int i=1;i<=len;i++)
		{
			if(i==1)
			{	
				//�ȴ�����һ��С��
				Child ch = new Child(i);
				this.firstChild = ch;
				this.temp = ch;
			}
			else
			{
				if(i==len)
				{
					Child ch = new Child(i);
					temp.nextChild = ch;
					temp = ch;
					temp.nextChild = this.firstChild;
				}
				else{
					//��������С��
					Child ch = new Child(i);
					temp.nextChild = ch;
					temp = ch;		//ָ���µ��࣬������һ��ָ��
				}
				
			}
			
		}
	}

	//��ӡ�Ļ�������
	public void show()
	{
		//����һ����ʱ����
		Child temp = this.firstChild;
		do{
			System.out.println(temp.num);
			temp = temp.nextChild;
		}while(temp != this.firstChild);
	}


}