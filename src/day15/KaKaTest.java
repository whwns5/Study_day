package day15;

// ���
class KaKa{
	String kakaName;
	
	public void getInfo(){
		System.out.println("�� �� �Խ��ϴ�.");
	}
}

// �ٳ���ű
class Banana extends KaKa{
	
	public Banana(){
		this.kakaName = "�ٳ���ű";
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		//super.getInfo();
		System.out.println(this.kakaName + "�� ������ �� �Խ��ϴ�.");
	}
	
	
}
// �����۽�
class Prin extends KaKa{
	
	public Prin(){
		this.kakaName = "�����۽�";
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		//super.getInfo();
		System.out.println(this.kakaName + "�� �Ѳ��� ��� �Խ��ϴ�.");
	}
	
	
}

// ����
class Sea extends KaKa{
	
	public Sea(){
		this.kakaName = "����";
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		//super.getInfo();
		System.out.println(this.kakaName + "�� ���ڸ� �� �Խ��ϴ�.");
	}
	
}


public class KaKaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Banana banana = new Banana();
//		banana.getInfo();
//		
//		Prin prin = new Prin();
//		prin.getInfo();
		
		KaKa arrKaKa[] = new KaKa[3];
		arrKaKa[0] = new Sea();
		arrKaKa[1] = new Prin();
		arrKaKa[2] = new Banana();

		for (int i = 0; i < arrKaKa.length; i++) {
			arrKaKa[i].getInfo();
		}
		
	}

}
