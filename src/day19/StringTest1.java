package day19;
/*
 * 2016_11_29
 */
public class StringTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "java";
		String str2 = "java"; // str2�� ���ÿ����� �����Ǳ� ���� �� ������ ��ĵ�� ���� ������Ǿ� 
							  // "java"��� ��ü�� �������� �����Ǿ� ������ ���� �ּҷ� ���.
						
		String str3 = new String("java"); // new Ű���带 �̿��Ͽ� �����ϴ� ����. ��ĵ�� ���ʿ䰡 �����Ƿ� ���ο� "java"��ä�� ����� �ȴ�.
		
		System.out.println("str = " + str);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);

		
		if(str == str2){	
			System.out.println("str == str2 : ����");
		} else {
			System.out.println("str == str2 : ���� �ʴ�.");
		}
		
		String res = str==str3 ? "����" : "�����ʴ�";
		System.out.println("str == str3 :" + res);
		
		String res2 = str.equals(str2) ? "����" : "�����ʴ�";
		String res3 = str.equals(str3) ? "����" : "�����ʴ�";
		
		System.out.println("str==str2 : " + res2);
		System.out.println("str==str3 : " + res2);
	
		Object o = new Object();
		Object o2 = new Object();
		Object o3 = o;
		
		String res4 = o.equals(o2) ? "����" : "�����ʴ�";
		String res5 = o.equals(o3) ? "����" : "�����ʴ�";
		
		System.out.println("o == o2 : " + res4);
		System.out.println("o == o3 : " + res5 );
	}

}
