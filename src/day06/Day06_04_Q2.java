package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
/*
 * 2016_11_10
 * 
 * 사용자로부터 수학, 영어, 국어 점수를 입력받아 총점
 * 과 평균을 계산하는 프로그램
 */
public class Day06_04_Q2 {
	public static void main(String[] args)throws IOException{
		
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			/*System.in 은 1바이트 값만 입력되므로 2바이트 입력이가능한 InputStreamReader 보조스트림으로 확장뒤 
	                    문자열 입력이 가능한 BufferedReader보조스트림 로 확장후 br변수를 선언후 초기화 */ 
	    
	    DecimalFormat bo=new DecimalFormat("avg");
	    bo.applyLocalizedPattern("#.00");
	    
			int met; //수학점수 
			int eng; //영어점수
			int kor; //국어점수
			
			int sum; //총점
			double avg; //평균
		
			System.out.print("수학점수:"); 
			met = Integer.parseInt(br.readLine()); //수학점수를 입력받은뒤 문자열을 숫자로 바꾼뒤 met변수안에 대입
			System.out.print("영어점수:");
			eng = Integer.parseInt(br.readLine()); // 위랑 동일
			System.out.print("국어점수:");
			kor = Integer.parseInt(br.readLine()); // 위랑 동일
			
			sum = met+eng+kor; //총점 구하기
			avg = sum/3.0;       //평균 구하기 , 자료형들은 계산할때 가장큰 자료형식으로 바뀌어서 계산된다.
			System.out.println("총점:"+sum+"\n평균:"+bo.format(avg)); //총점과 평균 구하기
			
			                                       //총점을 이용해 조건을걸어 해당점수대로 학점출력
			if(avg>=90){                           //총점이 90보다 크거나 같으면 "학점 A"출력
				System.out.println("학점:A");   
			}else if(avg>=80){                     //총점이 80보다 크거나 같으면 "학점 B"출력
				System.out.println("학점:B");
			}else if(avg>=70){
				System.out.println("학점:C");
			}else if(avg>=60){
				System.out.println("학점:D");
			}else {
				System.out.println("학점:F");
			}
			
		}
}
