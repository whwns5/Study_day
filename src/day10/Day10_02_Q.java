package day10;

import java.io.IOException;

/*
 * 2016_11_16
 * 
 * ���� �߱� ����
 * 
 * 1. ���ڿ� �ڸ����� ������ -> ��Ʈ����ũ
 * 2. ���ڴ� O �ڸ��� x -> ��
 * 
 * ���ӽ��� ��ư ���
 * ��ǻ�� ���� ���� ���
 * ����� �Է� ���
 * ���� �� ���
 */
public class Day10_02_Q {
	public static void main(String[] args) throws IOException{
		
		int inputNum[] = new int[3]; // ����� �Է� ��ȣ
		int comNum[] = new int[3]; // ��ǻ�� ���� ��ȣ
		
		
		
		int ballCount; // �� ī��Ʈ
		int strikeCount; // ��Ʈ����ũ ī��Ʈ
		//int outCount; // �ƿ� ī��Ʈ
		int count = 0; // ȸ�� ��
		
		// ��ǻ�� ���� ���� ���
		for(int i = 0 ; i < comNum.length ; i++){
			comNum[i] = (int)(Math.random()*10);
			if(i > 0){		// �ι�° ��ȣ ���� �ߺ� üũ ����
				while(true){	// ���� �ߺ� üũ
					int randCount = 0;
					for(int j = 0 ; j < i ; j++){	// ���� �Էµ� �����Ϳ� ��ü ��
						if( comNum[i] == comNum[j] ){ // ���� �Էµ� �����Ϳ� ������ �Էµ� �����Ͱ� ���� ��� ( i -> ���� �Է� index , j -> ���� �Է� index)
							comNum[i] = (int)(Math.random()*10); // ���� �Է� �����͸� �ٽ� �����Ѵ�.
							randCount = 1;
						} 
					}
					if(randCount == 0){ // randCount �� �������� ���� ���. �ߺ� �� ���� ���� �����̹Ƿ� �������´�.
						break;
					}
				}
			}
			
		}
		
		// ��ǻ�� ���� ���� ��� �׽�Ʈ
		System.out.print("��ǻ�� ���� ���� ��ȣ : ");
		for(int i = 0 ; i < comNum.length ; i++){
			System.out.print(comNum[i] + " ");
		}
		System.out.println();
		
		while(true){	// ������ �������� ���� �ݺ��Ѵ�.
			
			ballCount = 0;	// ���ο� ȸ�� ���� ���� �Ǳ��� �� ī��Ʈ �ʱ�ȭ
			strikeCount = 0; // ���ο� ȸ�� ���� ���� �Ǳ��� ��Ʈ����ũ ī��Ʈ �ʱ�ȭ
			//outCount = 0; // ���ο� ȸ�� ���� ���� �Ǳ��� �ƿ� ī��Ʈ �ʱ�ȭ
			
			count++;	 // ���� ���� ȸ�� �� ����
			
			// ȸ�� �� ��� ���� ���
			if(count == 11){
				System.out.println("10ȸ�� ���� ��� ���� �Ͽ����ϴ�.");
				System.exit(0);
			}
			
			// ����� �Է� ���
			System.out.println("0~9 ���� �� 3������ �Է��ϼ���. (�ߺ� �Ұ�)");
			for(int i = 0 ; i < inputNum.length ; i++){
				System.out.print((i + 1) + "��° ���� �Է��ϼ��� : ");
				inputNum[i]= System.in.read() - '0';
				System.in.skip(2);
			
				
				if(i > 0){		// �ι�° ��ȣ ���� �ߺ� üũ ����
					while(true){	// ����� �Է� �� �ߺ�üũ
						int inputCount = 0;
						for(int j = 0 ; j < i ; j++){	// ���� �Էµ� �����Ϳ� ��ü ��
							if( inputNum[i] == inputNum[j] ){ // ���� �Էµ� �����Ϳ� ������ �Էµ� �����Ͱ� ���� ��� ( i -> ���� �Է� index , j -> ���� �Է� index)
								System.out.println("�ߺ� �� ���� �Է��� �� �����ϴ�. �ٽ� �Է��� �ּ���.");
								System.out.print((i + 1) + "��° ���� �Է��ϼ��� : ");
								inputNum[i]= System.in.read() - '0'; // ���� �Է� �����͸� �ٽ� �Է� �޵��� �Ѵ�.
								System.in.skip(2); 
								inputCount = 1;
							} 
						}
						
						if(inputCount == 0){ // inputCount �� �������� ���� ���. �ߺ� �� ���� ���� �����̹Ƿ� �������´�.
							break;
						}
					}
				}
			}

			// ��ǻ�� ���� ���� ��� �׽�Ʈ
//			System.out.print("��ǻ�� ���� ���� ��ȣ : \t");
//			for(int i = 0 ; i < comNum.length ; i++){
//				System.out.print(comNum[i] + " ");
//			}
//			System.out.println();
			
			// ����� �Է� ��� �׽�Ʈ
//			System.out.print("����� �Է� ��ȣ : \t");
//			for(int i = 0 ; i < inputNum.length ; i++){
//				System.out.print(inputNum[i] + " ");
//			}
			
			
			// ���� �� ���
			for(int i = 0 ; i < comNum.length ; i++){		//��ǻ�� ���� �迭�� ����� �Է� �迭�� ���� ���Ѵ�.
				for(int j = 0 ; j < inputNum.length ; j++){
					if(comNum[i] == inputNum[j] && i == j){	// ��ǻ�� ���� ����� ���� ����, ���� �ڸ��� �ִٸ� -> ��Ʈ����ũ
						strikeCount += 1;
						break;
					} else if(comNum[i] == inputNum[j] && i != j) { // ��ǻ�� ���� ����� ���� ����, �ٸ� �ڸ��� �ִٸ� -> ��
						ballCount += 1;
						break;
					}  												// ��ǻ�� ���� ����� ���� �ٸ��ٸ� -> �ƿ�
					
				}
			}
			
			
			
			// ���� �� ��� �׽�Ʈ
//			System.out.println();
//			System.out.println("strikeCount = " + strikeCount);
//			System.out.println("ballCount = " + ballCount);
			
			// ��� ��� ���
			System.out.println();
			System.out.println("-----------------------------------------------------------------");
			if(strikeCount == 3){
				System.out.print(count + "ȸ�� -> ����\n");
				System.exit(0);
			} else if(strikeCount != 0 || ballCount != 0){
				
				System.out.print(count + "ȸ�� -> ");
				for(int i = 0 ; i < inputNum.length ; i++){
					System.out.print(inputNum[i] + " ");
				}
				System.out.println("��Ʈ����ũ : " + strikeCount + " �� : " + ballCount);
				
			} else if(strikeCount == 0 && ballCount == 0){
				
				System.out.print(count + "ȸ�� -> ");
				for(int i = 0 ; i < inputNum.length ; i++){
					System.out.print(inputNum[i] + " ");
				}
				System.out.println("out");
				
			}
		}
		
		
		
	}
}
