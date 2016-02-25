/**
 * 作用： 链表的建立
 * 、约瑟夫问题
 */
package com.link;

public class Link {

	/**
	 * @param args
	 * 主要学习链表的创建和应用
	 * 难点：  Child firstChild  不懂什么意思
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CycLink cyclink = new CycLink();
		cyclink.SetLen(9);
		cyclink.creatLink();
		cyclink.setK(2);		//从第二个人开始
		cyclink.setM(2);		//设置数几下
		cyclink.show();
	}

}

class Child
{
	int num;
	Child nextChild = null;
	public Child(int num)    //类的构造方法
	{
		this.num = num;
	}
}

//环形链表
class CycLink
{
	//先定义指向链表第一个小孩的引用
	//指向第一个小孩的引用，相当于初始，不能动
	Child firstChild = null;
	Child temp;		//创建临时变量，存储临时值，保证原始值不变
	int len = 0;		//表示共有几个小孩
	int k=0;
	int m=0;
	
	//设置环形链表的大小
	public void SetLen(int len)
	{
		this.len = len;
	}
	
	//设置从第几个人开始数数
	public void setK(int k)
	{
		this.k = k;
	}
	//设置M
	public void setM(int m)
	{
		this.m = m;
	}
	//开始游戏
	public void play()
	{
		Child temp = this.firstChild;
		//找到第K 个人
		for(int i=1;i<k;i++)
		{
			temp = temp.nextChild;
		}
		//数数为M下
		for(int j=1;j<m;j++)
		{
			temp = temp.nextChild;
		}
		//将数到M的人退出
	}
	//初始化环形链表
	public void creatLink()
	{
		for(int i=1;i<=len;i++)
		{
			if(i==1)
			{	
				//先创建第一个小孩
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
					//继续创建小孩
					Child ch = new Child(i);
					temp.nextChild = ch;
					temp = ch;		//指向新的类，便于下一个指向
				}
				
			}
			
		}
	}

	//打印改环形链表
	public void show()
	{
		//定义一个临时变量
		Child temp = this.firstChild;
		do{
			System.out.println(temp.num);
			temp = temp.nextChild;
		}while(temp != this.firstChild);
	}


}