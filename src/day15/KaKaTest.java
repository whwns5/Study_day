package day15;

// ±î±î
class KaKa{
	String kakaName;
	
	public void getInfo(){
		System.out.println("±î±î¸¦ ¶â¾î¼­ ¸Ô½À´Ï´Ù.");
	}
}

// ¹Ù³ª³ªÅ±
class Banana extends KaKa{
	
	public Banana(){
		this.kakaName = "¹Ù³ª³ªÅ±";
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		//super.getInfo();
		System.out.println(this.kakaName + "ÀÇ ºÀÁö¸¦ ¶â¾î¼­ ¸Ô½À´Ï´Ù.");
	}
	
	
}
// ÇÁ¸µ±Û½º
class Prin extends KaKa{
	
	public Prin(){
		this.kakaName = "ÇÁ¸µ±Û½º";
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		//super.getInfo();
		System.out.println(this.kakaName + "ÀÇ ¶Ñ²±À» ¿­¾î¼­ ¸Ô½À´Ï´Ù.");
	}
	
	
}

// °í·¡¹ä
class Sea extends KaKa{
	
	public Sea(){
		this.kakaName = "°í·¡¹ä";
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		//super.getInfo();
		System.out.println(this.kakaName + "ÀÇ »óÀÚ¸¦ ¶â¾î¼­ ¸Ô½À´Ï´Ù.");
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
