package day16;
/*
 * 
 * 2016_11_24
 * 
 * Final ������ (modifier)
 *  Final ������ ��?
 *   abstract �� �ݴ�� ����� �����ϴ� ��.
 *   
 *   			  abstract					    final
 *   
 *   Ŭ����		��ӹް��� ����			����� ���ް� �ϴ°� ����
 *   
 *   �޼ҵ�		���� �������̵���			      �������̵� ����
 *   				����
 *   
 *   ����		    ������				         ��� ����
 *   								   	final public static
 *   
 * 
 * �������̽�
 *  �������̽� �� ?
 *   �ڹ��� ���ϻ���� ������ �����ϱ� ���� ���Ӱ� ������ ���߻�� ����
 *  
 *  ����
 *   ���������� interface �������̽��� extends �������̽� {
 *   	�߻�޼ҵ��;
 *   }
 *   
 *    *��� ����
 *     Interface �������̽��� extends Interface
 *     Class Ŭ������ extends Class
 *     Interface �������̽��� implements Class
 *     Class Ŭ������ implements Interface
 *     
 *   
 *  Ȱ�� �뵵
 *   1. �޴���
 *   2. ��� Ȯ��
 *   3. �θ��������� �ڽ��� ������ ����
 */
class cls1{
	int a = 10;
	
	public cls1(){
		
	}
	
	public void cls1Test(){
		System.out.println("cls1Test");
	}
}

interface Inter1{
	public void inter1Test();
}

interface Inter2 extends Inter1{
	public void inter2Test();
}

abstract class abs1{
	abstract public void abs1Test();
}


public class Day16_01 {

}
