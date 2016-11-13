package day05;
import java.io.*;
import java.text.DecimalFormat;
/*
 * 2016_11_09
 * 
 * 국어 영어 수학 점수를 사용자로부터
 * 입력받아 총점과 평균을 출력하시오.
 */
public class Day05_04_Q2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int kor; // 국어점수
		int eng; // 영어점수
		int mat; // 수학점수
		int sum; // 총점
		double avg; // 평균
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("국어 점수를 입력하세요 :"); 
		kor = Integer.parseInt(br.readLine());		// 국어 점수 입력
		
		System.out.print("수학 점수를 입력하세요 :"); 
		eng = Integer.parseInt(br.readLine());		// 영어 점수 입력
		
		System.out.print("영어 점수를 입력하세요 :");
		mat = Integer.parseInt(br.readLine());		// 수학 점수 입력
		
		sum = kor + eng + mat;	// 총점 계산
		avg = sum/(double)3;	// 평균 계산
		//avg = sum/3.0;	// 평균 계산
		
		DecimalFormat df = new DecimalFormat("#.##");

		System.out.println("총점 : " + sum + " 평균 : " + df.format(avg));
		
		
		
	}

}
