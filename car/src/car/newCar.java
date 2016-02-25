package car;

class Car1
{
	//描述颜色
	String color = "蓝色";
	//描述车的车轮
	int num = 4;
	//运行时显示
	void run()
	{
		System.out.println(color+"  "+num);
	}
}
public class newCar {
	//建立主函数入口，切记！！！！！！！！
	public static void main(String[] args){
		//新建一个类类型的变量，变量指向一个类，即以下的C
		Car1 c = new Car1();
		//将已有的车的颜色改变颜色，在Java中指挥方式是   指挥。对象成员
		c.color = "红色";
		c.run();
	}

}
