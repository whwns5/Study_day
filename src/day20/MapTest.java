package day20;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("one", "�ϳ�");
		map.put("two", "��");
		map.put("apple", "���");
		map.put("plate", "����");
		
		System.out.println("oen�� ���� ���� ? " + map.get("one"));
		System.out.println("apple�� ���� ? " + map.get("apple"));
		
		map.put("apple", "������");
		
		System.out.println("apple�� ���� ? " + map.get("apple"));
	}

}
