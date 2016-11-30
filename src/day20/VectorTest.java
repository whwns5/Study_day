package day20;
import java.util.*;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Vector (int initialCapacity, int capacityIncrement) 
		
		/*
			�迭						  �ݷ���
		
		   ������ ũ��				     ������ ũ��
		
		  �⺻������ ��			 ���۷����� ���尡��
		���۷����� ������
		
	         ���� �ڷ���					Ÿ����������
		*/
		
		Vector v = new Vector(4,3); // �⺻�� 4 ����ġ 3
		
		System.out.println("v�� ������� : " + v.capacity());
		System.out.println("v�� ����� ������ �� : " + v.size());
		
		for(int i = 0 ; i <= 9 ; i++){
			v.add(new Integer(i)); // �⺻������ Vector �� �⺻ �����͸� �������� ���ϰ� , ���۷��� ������ ������ �����ϴ�.
			//v.add(1); // �⺻ �����͸� �����ص� ���������, ���������� ����ڽ�(�ڽ�)�� ���ؼ� ���۷��� �ڷ������� ��ȯ�Ǿ� ������.
		}
		
		//��� ���۷��� ������ 4����Ʈ
		
		System.out.println("v�� ������� : " + v.capacity());
		System.out.println("v�� ����� ������ �� : " + v.size());
		
		v.add(new Double(1.23));
		v.add(new Double(2.34));
		
		v.add("Hello");
		
		System.out.println("v�� ������� : " + v.capacity());
		System.out.println("v�� ����� ������ �� : " + v.size());
		
		System.out.println("v�� ����° ����� �� : " + v.get(2));
		int a = (int)v.get(5);
		Object i = v.get(5);
		
		System.out.println("v�� ������° ����� �� : " + a);
		System.out.println("v�� ������° ����� �� : " + i);
		
		for(int j = 0 ; j < v.size() ; j ++){
			System.out.println(v.get(j));
		}
		
		Vector<String> v2 = new Vector<String>();
		
		v2.add("java");
		v2.add("jsp");
		v2.add("html");
		v2.add("css");
		
		for(int j = 0 ; j < v2.size() ; j++){
		//	String temp = (String) v2.get(j);
			System.out.println(v2.get(j));
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
	    
		
		for(int j = 0 ; j < arr.size() ; j++){
			int temp = arr.get(j);
			System.out.println(temp);
		}
	}

}
