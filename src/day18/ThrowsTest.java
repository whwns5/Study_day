package day18;

import java.io.IOException;

class AAA{
	public void aaa(){
		throw new NullPointerException();
	}
}

class BBB{
	public void bbb(){  // thorws�� ���� ȣ���� �༮���� ������Ű�� ��
		AAA a = new AAA();
		a.aaa();
	}
}

public class ThrowsTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		BBB b = new BBB();
		b.bbb();
	}

}
