/*
 * ���ܣ���ʾ��̬
 */
public class duotai {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��̬
		/*Cat cat = new Cat();
		cat.cry();
		Dog dog = new Dog();
		dog.cry();*/
		//���������Ǻ������ĺ�����ֱ�ӵ��ø��ඨ��
		/*Animal an = new Cat();
		an.cry();*/
		//
		Master master = new Master();
		master.feed(new Dog(),new Bone());
		}

}

//������
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
	//������
	public void cry()
	{
		System.out.println("��֪����ô��");
	}
	//�����Զ���
	public void eat()		//���ຯ���ɱ��ֿ�
	{
		
	}
	
}

class Food		//ʳ��ĸ���
{
	String name;
	public void showName()
	{
		
	}
}
//������
class Master
{
	//������ιʳ�ʹ�ö�̬������ι��ͬ�Ķ���ʹ��ͬһ������
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
		System.out.println("��ͷ");
	}
}
//��������
class Cat extends Animal		//�̳�
{
	//�������ǣ���ʾè�Լ��Ľ�
	public void cry()		//��������
	{
		System.out.println("��");
	}
	//è�Զ���
	public void eat()
	{
		System.out.println("è����");
	}
}

class Dog extends Animal
{
	//��������
	public void cry()		//������಻���Ǹ��෽�����ø����̬���ã�����ͨ����ִ�в���
	{
		System.out.println("��");
	}
	
	//���Զ���
	public void  eat()
	{
		System.out.println("���Թ�ͷ");
	}
}