package day19;

import java.util.*;

/*
 * 2016_11_29
 * 
 * StringTokenizer 
 *  - ������ Ŭ����
 *  
 *  - Ŀ����� ��ҷ� �����Ͽ� ���.
 *  
 *   * while -> ������ Ŭ������ ����ϴµ� ���
 */
public class StringTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "���,��,Ű��,����,����";
		String str2 = "������ ȭ���� ���� �԰� ���� �� ������~?";
		
		StringTokenizer st = new StringTokenizer(str, ",");
		StringTokenizer st2 = new StringTokenizer(str2); // �����ڸ� �ȳ����� �������� ����
		
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		
		while(st2.hasMoreTokens()){
			System.out.println(st2.nextToken());
		}
		
		
	}

}
