package day17;

public class Professor extends Person{

	private String Subject; // ����
	
	public Professor(){
		
	}
	
	public Professor(String name, int age, String Subject){
		super(name, age);
		this.Subject = Subject;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}
	
	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		System.out.println("----------------------");
		super.getInfo();
		System.out.println("���� : " + this.Subject);
		System.out.println("----------------------");
	}
}
