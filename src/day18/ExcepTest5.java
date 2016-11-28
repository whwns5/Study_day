package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcepTest5 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.print("��� �����͸� �Է��Ͻ� �̴ϱ� ? ");
			int user = Integer.parseInt(br.readLine());
			
			int arr[] = new int[user];
			
			for(int i = 0 ; i < arr.length ; i ++){
				System.out.print((i+1) + " ��° ������ : ");
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			System.out.print("�� ��° �����͸� Ȯ�� �Ͻǰ̴ϱ� ? ");
			int num = Integer.parseInt(br.readLine());
			
			System.out.println(num + " ��ġ�� ������ �� : " + arr[num-1] );
			
		}catch(IOException e){
			System.out.println("����� ���� ���� �߻�!");
		}catch(NumberFormatException e){
			System.out.println("���ڸ��� �Է� �ϼž� �մϴ�.");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("����� �����Ͱ� ���� �����Դϴ�.");
		}catch(NegativeArraySizeException e ){
			System.out.println("���� ������ �׻� ������� �մϴ�.");
		}catch(Exception e){
			System.out.println("������ ���� �ٶ�.");
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
