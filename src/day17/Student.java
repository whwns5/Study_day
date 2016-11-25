package day17;

public class Student extends Person{
	
	private String major; // 전공
	
	public Student(){
		
	}
	
	public Student(String name, int age, String major){
		super(name, age);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		System.out.println("----------------------");
		super.getInfo();
		System.out.println("전공 : " + major);
		System.out.println("----------------------");
	}
	
}
