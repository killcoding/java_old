package car;

class Car1
{
	//������ɫ
	String color = "��ɫ";
	//�������ĳ���
	int num = 4;
	//����ʱ��ʾ
	void run()
	{
		System.out.println(color+"  "+num);
	}
}
public class newCar {
	//������������ڣ��мǣ���������������
	public static void main(String[] args){
		//�½�һ�������͵ı���������ָ��һ���࣬�����µ�C
		Car1 c = new Car1();
		//�����еĳ�����ɫ�ı���ɫ����Java��ָ�ӷ�ʽ��   ָ�ӡ������Ա
		c.color = "��ɫ";
		c.run();
	}

}
