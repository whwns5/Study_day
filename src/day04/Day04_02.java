package day04;
import java.util.concurrent.SynchronousQueue;

/*
 * 2016_11_08
 * 
 * 연산자 우선순위
 *  1. 최우선연산자  .(접근 연산자) , [] , ()
 *  2. 단항연산자     !(논리 NOT연산자) , ~(비트 NOT연산자) , +/- , ++/--(전위형) , (cast)
 *  3. 산술연산자     + , - , * , /(몫) , %(나머지)
 *  4. 시프트연산자  << , >> , >>>
 *  5. 관계연산자     > , < , >= , <= , == , !=(같지 않다)
 *  6. 비트연산자     & , ^ , |
 *  7. 논리연산자     && , ||
 *  8. 삼항연산자     조건항 ? 참 : 거짓
 *  9. 대입연산자     = , += , -= , *= , /= , %=
 *  10.증감연산자     ++/--(후위형)
 *  
 *  Ctrl + Alt + 방향키 (위,아래) -> 복사
 *  범위지정 드레그 + Ctrl + / -> 여러줄 한줄 주석
 *  범위지정 드레그 + Ctrl + Shift + / -> 여러줄 여러줄 주석
 *  
 */
public class Day04_02 {

public static void main(String[] args){
		
		System.out.println("1. 산술연산자와 대입연산자");
		
		int i = 10; // 대입연산자
		System.out.println("i = " + i);
		
		i = i + 1; // 계산된 결과가 임시 보관함에 들어가기 때문
		System.out.println("i = " + i);
		
		i += 1;
		System.out.println("i = " + i);
		
		i ++;
		System.out.println("i = " + i);
		
		i = i - 1;
		System.out.println("i = " + i);
		
		i -= 1;
		System.out.println("i = " + i);
		
		i --;
		System.out.println("i = " + i);

		//i = i * 2;
		i *= 2;
		System.out.println("i = " + i);
		
		//i = i / 3; //나눗샘은 몫만 나온다.
		//i /= 3;
		//i = i % 3; //나머지를 구한다.
		i %= 3;
		System.out.println("i = " + i); 
		
		System.out.println("2. 단항연산자");
		System.out.println("2_1. ~ 비트 not 연산자");
		
		int m = 34;
		System.out.println("m = " + m);
		System.out.println("~m = " + ~m);
		
		int m2 = 257;
		System.out.println("m2 = " + m2);
		System.out.println("~m2 = " + ~m2);
		
		System.out.println("2_2. ! 논리 not 연산자");
		boolean bool = true;
		System.out.println("bool = " + bool);
		System.out.println("!bool = " + !bool);
		//System.out.println("!m = " + !m); //에러 -> !는 논리에 대해서 부정. ~는 비트에 대해서 부정
	
		/* 3. 시프트 연산자 */
		System.out.println("3. 시프트 연산자");
		/*
		 *  << 
		 *   값을 왼쪽으로 비트수만큼 이동 나머지는 0 으로 채움
		 *  >>
		 *   값을 오른쪽으로 비트수만큼 이동 나머지는 부호화비트로 채움
		 *  >>>
		 *   값을 오른쪽으로 비트수만큼 이동 나머지는 0으로 채움
		 */
		
		int n = 6;
		System.out.println("n = " + n);
		
		//System.out.println("n<<2 =" + n<<2 ); // 에러 -> 시프트연산자 보다 산술연산자가 우선순위가 높기때문
		System.out.println("n<<2 = " + (n<<2) );
		/*
		 * 6	0000 0110
		 * <<2	0001 1000 -> 24 (나머지 0으로 채움)
		 */
		System.out.println("n>>2 = " + (n>>2) );
		/*
		 * 6	0000 0110
		 * >>2	0000 0001 -> 1  (나머지 부호화 비트로 채움)
		 */
		System.out.println("n>>>2 = " + (n>>>2) );
		/*
		 * 6	0000 0110
		 * >>>2	0000 0001 -> 1	(나머지 0으로 채움)
		 */
		
		int n2 = -6;
		System.out.println("n2 = " + n2);
		
		//System.out.println("n<<2 =" + n<<2 ); // 에러 -> 시프트연산자 보다 산술연산자가 우선순위가 높기때문
		System.out.println("n2<<2 = " + (n2<<2) );
		/*
		 * 6			0000 0110
		 * ~(비트 NOT)	1111 1001
		 * 1의 보수		1111 1010 -> -6
		 * <<2			1110 1000 -> -24 (나머지 0으로 채움)
		 */
		System.out.println("n2>>2 = " + (n2>>2) );
		/*
		 * 6			0000 0110
		 * ~(비트 NOT)	1111 1001
		 * 1의 보수		1111 1010 -> -6
		 * >>2			1111 1111 1111 1111 ... 1111 1110 -> -2 (나머지 부호화 비트로 채움)
		 */
		System.out.println("n2>>>2 = " + (n2>>>2) );
		/*
		 * 6			0000 0110
		 * ~(비트 NOT)	1111 1001
		 * 1의 보수		1111 1010 -> -6
		 * >>>2			0011 1111 1111 1111 ... 1111 1110 -> 1073741822 (나머지 0으로 채움)
		 */
		
		
		/* 4. 비트연산자 */
		System.out.println("4. 비트 연산자");
		/*
		 * ~(비트 NOT 연산자) 또한 비트연산자에 속한다
		 * &(and)
		 *  대조되는 비트가 모두 1일 경우에 1을 , 하나라도 0일 경우에 0을 번환 (둘다 1일 경우 true)
		 * |(or)	
		 *  대조되는 피트가 하나라도 1일 경우에 1을 , 모두 0일 경우에 0을 반환 (하나라도 1일 경우 true)
		 * ^(xor)
		 *  대조되는 비트가 서로 다르면 1을 같으면 0을 반환
		 */
		
		int a = 14;
		int b = 10;
		System.out.println("a & b = " + (a&b) );
		/*
		 *  14		0000 1110
		 *  10		0000 1010
		 *  
		 *  &		0000 1010 -> 10
		 */
		System.out.println("a | b = " + (a|b) ); 
		/*
		 *  14		0000 1110
		 *  10		0000 1010
		 *  
		 *  |		0000 1110 -> 14
		 */
		System.out.println("a ^ b = " + (a^b) );
		/*
		 *  14		0000 1110
		 *  10		0000 1010
		 *  
		 *  ^		0000 0100 -> 4
		 */
		
		int am = -14;
		int bm = -10;
		System.out.println("a & b = " + (a&b) );
		/*
		 *  14			0000 1110
		 *  ~(비트 not)	1111 0001
		 *  1의 보수		
		 *  -14			1111 0010
		 *  
		 *  10			0000 1010
		 *  ~(비트 not)	1111 0101
		 *  1의 보수		
		 *  -10			1111 0110
		 *  	
		 *  &			1111 0010 -> -14
		 */
		System.out.println("a | b = " + (a|b) ); 
		/*
		 *  -14		1111 0010
		 *  -10		1111 0110
		 *  
		 *  |		1111 0110 -> -10
		 */
		System.out.println("a ^ b = " + (a^b) );
		/*
		 *  -14		1111 0010
		 *  -10		1111 0110
		 *  
		 *  ^		0000 0100 -> 4
		 */
		
		
		/* 관계연산자와 논리연산자 */
		System.out.println("5. 관계연산자와 논리연산자");
		
		System.out.println("7 > 5 = " + (7>5) );
		System.out.println("7 < 5 = " + (7<5) );
		//System.out.println("7 = 5 = " + (7=5) ); // 프로그램은 진행 되지만 원하는 결과 x
		System.out.println("7 == 5 = " + (7==5) );
		
		
		System.out.println("7 > 5 && 3 < 5 = " + ((7 > 5)&&(3 < 5)) );
		System.out.println("7 > 5 && 3 > 5 = " + ((7 > 5)&&(3 > 5)) );
		
		System.out.println("true && true = " + (true&&true) );
		System.out.println("true && false = " + (true&&false) );
		System.out.println("false && true = " + (false&&true) );
		System.out.println("false && false = " + (false&&false) );
		
		System.out.println("true || true = " + (true||true) );
		System.out.println("true || false = " + (true||false) );
		System.out.println("false || true = " + (false||true) );
		System.out.println("false || false = " + (false||false) );
		
		
		
		
	}

}
