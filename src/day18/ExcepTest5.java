package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcepTest5 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.print("몇개의 데이터를 입력하실 겁니까 ? ");
			int user = Integer.parseInt(br.readLine());
			
			int arr[] = new int[user];
			
			for(int i = 0 ; i < arr.length ; i ++){
				System.out.print((i+1) + " 번째 데이터 : ");
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			System.out.print("몇 번째 데이터를 확인 하실겁니까 ? ");
			int num = Integer.parseInt(br.readLine());
			
			System.out.println(num + " 위치의 데이터 값 : " + arr[num-1] );
			
		}catch(IOException e){
			System.out.println("입출력 관련 예외 발생!");
		}catch(NumberFormatException e){
			System.out.println("숫자만을 입력 하셔야 합니다.");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("저장된 데이터가 없는 공간입니다.");
		}catch(NegativeArraySizeException e ){
			System.out.println("저장 공간은 항상 양수여야 합니다.");
		}catch(Exception e){
			System.out.println("고객센터 연락 바람.");
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

}
