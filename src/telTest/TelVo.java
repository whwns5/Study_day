package telTest;

public class TelVo {
	private String name; // 이름
	private int age; // 나이
	private String addr; // 주소
	private String tel; // 전번
	
	
	public TelVo() {
		super();
	}
	
	public TelVo(String name) {
		super();
		this.name = name;
	}

	public TelVo(String name, int age, String addr, String tel) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "TelVo [name=" + name + ", age=" + age + ", addr=" + addr + ", tel=" + tel + "]";
	}
	
	public String toViewString(){
		String str = "이름 : " + this.name + "\t\t나이 : " + this.age + "\t\t주소 : " + this.addr + "\t\t전번 :" + this.tel;
		return str;
	}
	
}
