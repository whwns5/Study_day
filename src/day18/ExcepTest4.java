package day18;

public class ExcepTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str1 = args[0];
			String str2 = args[1];
			
			System.out.println("num1 = " + str1);
			System.out.println("num2 = " + str2);
			
			int num1 = Integer.parseInt(str1);
			int num2 = Integer.parseInt(str2);
			
			System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("���� �� ���� �Է� �ϼž� �մϴ�.");
		} catch (NumberFormatException e) {
			System.out.println("���ڸ��� �Է� �ϼž� �մϴ�.");
		} catch (ArithmeticException e) {
			System.out.println("0���δ� ���� �� �����.");
		} catch (Exception e){
			System.out.println("�����Ϳ� ���� �ٶ�~");
		}
		
//		try {
//			String str1 = args[0];
//			String str2 = args[1];
//			
//			System.out.println("num1 = " + str1);
//			System.out.println("num2 = " + str2);
//			
//			int num1 = Integer.parseInt(str1);
//			int num2 = Integer.parseInt(str2);
//			
//			System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
//		} catch (Exception e) {
//			if ( e instanceof ArrayIndexOutOfBoundsException){
//				System.out.println("���� �� ���� �Է� �ϼž� �մϴ�.");
//			} else if ( e instanceof ArrayIndexOutOfBoundsException ) {
//				System.out.println("���ڸ��� �Է� �ϼž� �մϴ�.");
//			} else if( e instanceof ArithmeticException ) {
//				System.out.println("0���δ� ���� �� �����.");
//			}
//			
//		} 
		
		
	}

}
