package day20;
import java.util.*;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Vector (int initialCapacity, int capacityIncrement) 
		
		/*
			배열						  콜렉션
		
		   고정된 크기				     가변적 크기
		
		  기본데이터 및			 레퍼런스만 저장가능
		레퍼런스의 데이터
		
	         공통 자료형					타종간데이터
		*/
		
		Vector v = new Vector(4,3); // 기본값 4 증가치 3
		
		System.out.println("v의 저장공간 : " + v.capacity());
		System.out.println("v의 저장된 데이터 수 : " + v.size());
		
		for(int i = 0 ; i <= 9 ; i++){
			v.add(new Integer(i)); // 기본적으로 Vector 는 기본 데이터를 삽입하지 못하고 , 레퍼런스 변수만 삽입이 가능하다.
			//v.add(1); // 기본 데이터를 삽입해도 실행되지만, 내부적으로 오토박싱(박싱)을 통해서 레퍼런스 자료형으로 변환되어 들어가진다.
		}
		
		//모든 레퍼런스 변수는 4바이트
		
		System.out.println("v의 저장공간 : " + v.capacity());
		System.out.println("v의 저장된 데이터 수 : " + v.size());
		
		v.add(new Double(1.23));
		v.add(new Double(2.34));
		
		v.add("Hello");
		
		System.out.println("v의 저장공간 : " + v.capacity());
		System.out.println("v의 저장된 데이터 수 : " + v.size());
		
		System.out.println("v의 세번째 요소의 값 : " + v.get(2));
		int a = (int)v.get(5);
		Object i = v.get(5);
		
		System.out.println("v의 여섯번째 요소의 값 : " + a);
		System.out.println("v의 여섯번째 요소의 값 : " + i);
		
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
