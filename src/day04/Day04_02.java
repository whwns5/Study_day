package day04;
import java.util.concurrent.SynchronousQueue;

/*
 * 2016_11_08
 * 
 * ������ �켱����
 *  1. �ֿ켱������  .(���� ������) , [] , ()
 *  2. ���׿�����     !(�� NOT������) , ~(��Ʈ NOT������) , +/- , ++/--(������) , (cast)
 *  3. ���������     + , - , * , /(��) , %(������)
 *  4. ����Ʈ������  << , >> , >>>
 *  5. ���迬����     > , < , >= , <= , == , !=(���� �ʴ�)
 *  6. ��Ʈ������     & , ^ , |
 *  7. ��������     && , ||
 *  8. ���׿�����     ������ ? �� : ����
 *  9. ���Կ�����     = , += , -= , *= , /= , %=
 *  10.����������     ++/--(������)
 *  
 *  Ctrl + Alt + ����Ű (��,�Ʒ�) -> ����
 *  �������� �巹�� + Ctrl + / -> ������ ���� �ּ�
 *  �������� �巹�� + Ctrl + Shift + / -> ������ ������ �ּ�
 *  
 */
public class Day04_02 {

public static void main(String[] args){
		
		System.out.println("1. ��������ڿ� ���Կ�����");
		
		int i = 10; // ���Կ�����
		System.out.println("i = " + i);
		
		i = i + 1; // ���� ����� �ӽ� �����Կ� ���� ����
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
		
		//i = i / 3; //�������� �� ���´�.
		//i /= 3;
		//i = i % 3; //�������� ���Ѵ�.
		i %= 3;
		System.out.println("i = " + i); 
		
		System.out.println("2. ���׿�����");
		System.out.println("2_1. ~ ��Ʈ not ������");
		
		int m = 34;
		System.out.println("m = " + m);
		System.out.println("~m = " + ~m);
		
		int m2 = 257;
		System.out.println("m2 = " + m2);
		System.out.println("~m2 = " + ~m2);
		
		System.out.println("2_2. ! �� not ������");
		boolean bool = true;
		System.out.println("bool = " + bool);
		System.out.println("!bool = " + !bool);
		//System.out.println("!m = " + !m); //���� -> !�� ���� ���ؼ� ����. ~�� ��Ʈ�� ���ؼ� ����
	
		/* 3. ����Ʈ ������ */
		System.out.println("3. ����Ʈ ������");
		/*
		 *  << 
		 *   ���� �������� ��Ʈ����ŭ �̵� �������� 0 ���� ä��
		 *  >>
		 *   ���� ���������� ��Ʈ����ŭ �̵� �������� ��ȣȭ��Ʈ�� ä��
		 *  >>>
		 *   ���� ���������� ��Ʈ����ŭ �̵� �������� 0���� ä��
		 */
		
		int n = 6;
		System.out.println("n = " + n);
		
		//System.out.println("n<<2 =" + n<<2 ); // ���� -> ����Ʈ������ ���� ��������ڰ� �켱������ ���⶧��
		System.out.println("n<<2 = " + (n<<2) );
		/*
		 * 6	0000 0110
		 * <<2	0001 1000 -> 24 (������ 0���� ä��)
		 */
		System.out.println("n>>2 = " + (n>>2) );
		/*
		 * 6	0000 0110
		 * >>2	0000 0001 -> 1  (������ ��ȣȭ ��Ʈ�� ä��)
		 */
		System.out.println("n>>>2 = " + (n>>>2) );
		/*
		 * 6	0000 0110
		 * >>>2	0000 0001 -> 1	(������ 0���� ä��)
		 */
		
		int n2 = -6;
		System.out.println("n2 = " + n2);
		
		//System.out.println("n<<2 =" + n<<2 ); // ���� -> ����Ʈ������ ���� ��������ڰ� �켱������ ���⶧��
		System.out.println("n2<<2 = " + (n2<<2) );
		/*
		 * 6			0000 0110
		 * ~(��Ʈ NOT)	1111 1001
		 * 1�� ����		1111 1010 -> -6
		 * <<2			1110 1000 -> -24 (������ 0���� ä��)
		 */
		System.out.println("n2>>2 = " + (n2>>2) );
		/*
		 * 6			0000 0110
		 * ~(��Ʈ NOT)	1111 1001
		 * 1�� ����		1111 1010 -> -6
		 * >>2			1111 1111 1111 1111 ... 1111 1110 -> -2 (������ ��ȣȭ ��Ʈ�� ä��)
		 */
		System.out.println("n2>>>2 = " + (n2>>>2) );
		/*
		 * 6			0000 0110
		 * ~(��Ʈ NOT)	1111 1001
		 * 1�� ����		1111 1010 -> -6
		 * >>>2			0011 1111 1111 1111 ... 1111 1110 -> 1073741822 (������ 0���� ä��)
		 */
		
		
		/* 4. ��Ʈ������ */
		System.out.println("4. ��Ʈ ������");
		/*
		 * ~(��Ʈ NOT ������) ���� ��Ʈ�����ڿ� ���Ѵ�
		 * &(and)
		 *  �����Ǵ� ��Ʈ�� ��� 1�� ��쿡 1�� , �ϳ��� 0�� ��쿡 0�� ��ȯ (�Ѵ� 1�� ��� true)
		 * |(or)	
		 *  �����Ǵ� ��Ʈ�� �ϳ��� 1�� ��쿡 1�� , ��� 0�� ��쿡 0�� ��ȯ (�ϳ��� 1�� ��� true)
		 * ^(xor)
		 *  �����Ǵ� ��Ʈ�� ���� �ٸ��� 1�� ������ 0�� ��ȯ
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
		 *  ~(��Ʈ not)	1111 0001
		 *  1�� ����		
		 *  -14			1111 0010
		 *  
		 *  10			0000 1010
		 *  ~(��Ʈ not)	1111 0101
		 *  1�� ����		
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
		
		
		/* ���迬���ڿ� �������� */
		System.out.println("5. ���迬���ڿ� ��������");
		
		System.out.println("7 > 5 = " + (7>5) );
		System.out.println("7 < 5 = " + (7<5) );
		//System.out.println("7 = 5 = " + (7=5) ); // ���α׷��� ���� ������ ���ϴ� ��� x
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
