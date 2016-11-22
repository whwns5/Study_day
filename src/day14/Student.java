package day14;



public class Student {
	private String stName; // �̸�
	private int stAge; // ����
	private String stAddress; // �ּ�
	private String stPhone; // ��ȭ��ȣ
	private int stKorScore; // ����
	private int stEngScore; // ����
	private int stMatScore; // ����

	private int stTotalScore; // ����
	private double stAvgScore; // ���

	public Student(String stName, int stAge, String stAddress, String stPhone,
			int stKorScore, int stEngScore, int stMatScore){
		
		this.stName = stName;
		this.stAge = stAge;
		this.stAddress = stAddress;
		this.stPhone = stPhone;
		
		this.stKorScore = stKorScore;
		this.stEngScore = stEngScore;
		this.stMatScore = stMatScore;
		
		this.stTotalScore = stKorScore + stEngScore + stMatScore;
		this.stAvgScore =  this.stTotalScore / 3.0;
	}
	
	public String getStName() {
		return this.stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public int getStAge() {
		return this.stAge;
	}

	public void setStAge(int stAge) {
		this.stAge = stAge;
	}

	public String getStAddress() {
		return this.stAddress;
	}

	public void setStAddress(String stAddress) {
		this.stAddress = stAddress;
	}

	public String getStPhone() {
		return this.stPhone;
	}

	public void setStPhone(String stPhone) {
		this.stPhone = stPhone;
	}

	public int getStKorScore() {
		return this.stKorScore;
	}

	public void setStKorScore(int stKorScore) {
		this.stKorScore = stKorScore;
	}

	public int getStEngScore() {
		return this.stEngScore;
	}

	public void setStEngScore(int stEngScore) {
		this.stEngScore = stEngScore;
	}

	public int getStMatScore() {
		return this.stMatScore;
	}

	public void setStMatScore(int stMatScore) {
		this.stMatScore = stMatScore;
	}

	public int getStTotalScore() {
		return this.stTotalScore;
	}

	public void setStTotalScore(int stTotalScore) {
		this.stTotalScore = stTotalScore;
	}

	public double getStAvgScore() {
		return this.stAvgScore;
	}

	public void setStAvgScore(double stAvgScore) {
		this.stAvgScore = stAvgScore;
	}
	
	

}
