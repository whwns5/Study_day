package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * ȸ�� �˰���
 *  - ���ڿ��� ����� ���� ���ڿ��� �Ǵ��� �Ǻ��ϴ� �˰���
 *  
 */
public class Palindrome {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputStr = "";
		String tempStr = "";
		
		
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		inputStr = br.readLine();
		
		//String ��ü�� ���ڿ��� �������� �ٽ� �����ϴ� �˰���
//		for(int i = inputStr.length()-1 ; i >= 0 ; i--){		// ���ڿ��� �������� ���鼭
//			tempStr += inputStr.charAt(i);
//		
//		}
		
//		System.out.println("�������� ���ڿ�      : " + tempStr);
//		
//		if( inputStr.equals(tempStr) ){				// �������� ���ڿ��� �� ���ڿ��� ���Ͽ� ������ ȸ��
//			System.out.println("ȸ�� �Դϴ�.");
//		}else{
//			System.out.println("ȸ���� �ƴմϴ�.");
//		}
		
		StringBuffer tempStr2 = new StringBuffer(inputStr);
		
		tempStr2.reverse();
	
		
		
		System.out.println("�������� ���ڿ�      : " + tempStr2);
		
		if( inputStr.equals(tempStr2) ){				// �������� ���ڿ��� �� ���ڿ��� ���Ͽ� ������ ȸ��
			System.out.println("ȸ�� �Դϴ�.");
		}else{
			System.out.println("ȸ���� �ƴմϴ�.");
		}
		
		
		
		
		
	}

}
