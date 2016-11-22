package day14;

public class LeapYear {
	private int currentlyYear;
	
	public LeapYear(){
		this.currentlyYear = 0;
	}
	
	public LeapYear(int currentlyYear){
		this.currentlyYear = currentlyYear;
	}

	public int getCurrentlyYear() {
		return currentlyYear;
	}

	public void setCurrentlyYear(int currentlyYear) {
		this.currentlyYear = currentlyYear;
	}
	
	public void getInfo(){
		if( this.currentlyYear % 400 == 0 || ( this.currentlyYear % 4 == 0 && this.currentlyYear % 100 != 0) ){
			System.out.println(this.currentlyYear + "���� ���� �Դϴ�.");
		}else{
			System.out.println(this.currentlyYear +"������ �ƴմϴ�");
		}
		
	
	}
	
	public void getInfo(int currentlyYear){
		setCurrentlyYear(currentlyYear);
		getInfo();
	}
	
}
