package day17;

public class Person {
	private String name; // 이름
	private int age; // 나이
	
	public Person(){
		
	}
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void getInfo(){
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
	}
	
	
}
