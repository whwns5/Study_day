package day14;

public class Tv {
	int rgb; // ����
	int mi; // ���
	int ri; // ���
	
	public Tv(){ // �⺻ ������
		rgb = 50;
		mi = 50;
		ri = 50;
	}
	
	public Tv(int rgb){ // ���� ������
		//this.Tv(); -> �����ڴ� �Ϲ� �޼ҵ�ó�� �̸����� ȣ�� �� �� ����.
		this(); // ���� �⺻ �����ڸ� ȣ��
		this.rgb = rgb;
	}
	
	public Tv(int r, int m){
		this(r);
		mi = m;
	}
	
	public Tv(int r, int m, int ri){
		this(r, m);
		this.ri = ri;
	}
	
	public void getInfo(){
		System.out.println("���� : " + rgb);
		System.out.println("��� : " + mi);
		System.out.println("��� : " + ri);
		
	}
	
	public void getInfo(String title){
		System.out.println(title);
		this.getInfo();
	}
}
