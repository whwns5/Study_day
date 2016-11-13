package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
/*
 * 2016_11_10
 */
public class Day06_05_Q {
public static void main(String[] args)throws IOException{
		
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			/*System.in 은 1바이트 값만 입력되므로 2바이트 입력이가능한 InputStreamReader 보조스트림으로 확장뒤 
	                    문자열 입력이 가능한 BufferedReader보조스트림 로 확장후 br변수를 선언후 초기화 */ 
	    DecimalFormat bo=new DecimalFormat();
	    bo.applyLocalizedPattern("#.#####");
	
	    /* DecimalFormat bo=new DecimalFormat(); ┐
	    bo.applyLocalizedPattern("#.#####");─┐   |
	                                         |   |─────같음 (int a;처럼 쓰기위해 new decimalFormat
	    int a;  ─────────────────────────────|───┘         을 불러와서 bo라는 이름으로 초기화)
	    a = 10; ─────────────────────────────┴─────────같음
	    
	    DecimalFormat bo=new DecimalFormat("#.#####");──┐──같음
	    int a = 10;     ────────────────────────────────┘   
	    */ 
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
			System.out.println("총점:"+sum+"\n평균:"+bo.format(avg)); //총점과 평균 구하기
			bo.applyLocalizedPattern("#.####");
			System.out.println("총점:"+sum+"\n평균:"+bo.format(avg)); //총점과 평균 구하기
			
			bo.applyLocalizedPattern("#.#####");
			System.out.println("총점:"+sum+"\n평균:"+bo.format(avg)); //총점과 평균 구하기
			
			int ca=(int)avg/10;   //실수는 스위치문에서 못씀 *95/10=9 나머지 5
			switch(ca){
			
			case 10: System.out.println("학점:A");   
			break;
			case 9: System.out.println("학점:A");   
			break;
			case 8:	System.out.println("학점:B");
			break;      
			case 7:	System.out.println("학점:C");
			break;      
			case 6:	System.out.println("학점:D");
			break;      
			default:System.out.println("학점:F");
			}
			
		}
}
