package day18;

import java.io.IOException;

class AAA{
	public void aaa(){
		throw new NullPointerException();
	}
}

class BBB{
	public void bbb(){  // thorws는 나를 호출한 녀석에게 전가시키는 것
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
