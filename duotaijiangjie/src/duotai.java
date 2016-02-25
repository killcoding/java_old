/*
 * 功能：演示多态
 */
public class duotai {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//多态
		/*Cat cat = new Cat();
		cat.cry();
		Dog dog = new Dog();
		dog.cry();*/
		//被方法覆盖后的子类的函数可直接调用父类定义
		/*Animal an = new Cat();
		an.cry();*/
		//
		Master master = new Master();
		master.feed(new Dog(),new Bone());
		}

}

//动物类
class Animal
{
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//动物会叫
	public void cry()
	{
		System.out.println("不知道怎么叫");
	}
	//动物会吃东西
	public void eat()		//父类函数可保持空
	{
		
	}
	
}

class Food		//食物的父类
{
	String name;
	public void showName()
	{
		
	}
}
//主人类
class Master
{
	//给动物喂食物，使用多态可以是喂不同的动物使用同一个方法
	public void feed(Animal an,Food f)
	{
		an.eat();
		f.showName();
	}
}
class Fish extends Food
{
	public void showName()
	{
		System.out.println("yu");
	}
}
class Bone extends Food
{
	public void showName()
	{
		System.out.println("骨头");
	}
}
//建立子类
class Cat extends Animal		//继承
{
	//方法覆盖，显示猫自己的叫
	public void cry()		//方法覆盖
	{
		System.out.println("喵");
	}
	//猫吃东西
	public void eat()
	{
		System.out.println("猫吃鱼");
	}
}

class Dog extends Animal
{
	//方法覆盖
	public void cry()		//如果子类不覆盖父类方法，用父类多态调用，编译通过但执行不行
	{
		System.out.println("汪");
	}
	
	//狗吃东西
	public void  eat()
	{
		System.out.println("狗吃骨头");
	}
}