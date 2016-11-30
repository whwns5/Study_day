package day20;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("apple", "사과");
		map.put("plate", "접시");
		
		System.out.println("oen의 뜻이 무야 ? " + map.get("one"));
		System.out.println("apple은 뭐야 ? " + map.get("apple"));
		
		map.put("apple", "아이폰");
		
		System.out.println("apple은 뭐야 ? " + map.get("apple"));
	}

}
