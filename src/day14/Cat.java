package day14;

public class Cat {

	private String catName;	// �̸�
	private int catAge;	// ����
	private String catKind; // ǰ��
	
	public Cat(){
		this.catName = "����";
		this.catAge = 1;
		this.catKind = "ũ������";
	}
	
	public Cat(String catName){
		this();
		this.catName = catName;
		
	}
	public Cat(String catName, int catAge){
		this(catName);
		this.catAge = catAge;
	}
	
	public Cat(String catName, int catAge, String catKind){
		this(catName, catAge);
		this.catKind = catKind;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getCatAge() {
		return catAge;
	}

	public void setCatAge(int catAge) {
		this.catAge = catAge;
	}

	public String getCatKind() {
		return catKind;
	}

	public void setCatKind(String catKind) {
		this.catKind = catKind;
	}
	
	public void getInfo(){
		System.out.println("catName :" + catName);
		System.out.println("catAge :" + catAge);
		System.out.println("catKind :" + catKind);
		
		
	}
}
