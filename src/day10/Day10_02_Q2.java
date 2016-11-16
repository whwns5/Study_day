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
 * 
 * v0.2
 *  ������ �迭�� �̿��Ͽ� ����
 */
public class Day10_02_Q2 {
	public static void main(String[] args) throws IOException{

		int count = 0; // ȸ�� ��
		
		int gameData[][][] = new int[10][3][3]; // ���� �����͸� ������ �ִ� �迭
												// 0�� �迭 -> ����� �Է� ��ȣ �迭 (int inputNum[])
												// 1�� �迭 -> ��ǻ�� ���� ��ȣ �迭 (int comNum[])
												// 2�� �迭 -> ȸ�� ��, ��Ʈ����ũ ī��Ʈ (int strikeCount), �� ī��Ʈ (int ballCount)
		
		// ��ǻ�� ���� ���� ���
		for(int i = 0 ; i < gameData[0][1].length ; i++){   		// gameData[0][1] -> ��ǻ�� ���� ��ȣ �迭 (int comNum[])
			gameData[0][1][i] = (int)(Math.random()*10);
			
			// 1. ��ǻ�� ���� �ߺ� üũ ���
			for(int j = 0 ; j < i ; j++){	// ���� �Էµ� �����Ϳ� ��ü ��
				if( gameData[0][1][i] == gameData[0][1][j] ){ // ���� �Էµ� �����Ϳ� ������ �Էµ� �����Ͱ� ���� ��� ( i -> ���� �Է� index , j -> ���� �Է� index)
					i--;
					break;
				}
			}
			
			// 2. ��ǻ�� ���� �ߺ� üũ ��� 
			/*if(i > 0){		// �ι�° ��ȣ ���� �ߺ� üũ ����
				while(true){	// ���� �ߺ� üũ
					int randCount = 0;
					for(int j = 0 ; j < i ; j++){	// ���� �Էµ� �����Ϳ� ��ü ��
						if( gameData[0][1][i] == gameData[0][1][j] ){ // ���� �Էµ� �����Ϳ� ������ �Էµ� �����Ͱ� ���� ��� ( i -> ���� �Է� index , j -> ���� �Է� index)
							gameData[0][1][i] = (int)(Math.random()*10); // ���� �Է� �����͸� �ٽ� �����Ѵ�.
							randCount = 1;
						} 
					}
					if(randCount == 0){ // randCount �� �������� ���� ���. �ߺ� �� ���� ���� �����̹Ƿ� �������´�.
						break;
					}
				}
				
			}*/
			for(int k = 1; k < gameData.length; k++){
				gameData[k][1] = gameData[0][1]; // ��� ȸ�� ���� ������ ��ǻ�� ���� ��ȣ �迭�� ���� �Ѵ�.
			}
		}
		
		
		while(true){	// ������ �������� ���� �ݺ��Ѵ�.
	
			// ȸ�� �� ��� ���� ���
			if(count == 10){
				System.out.println("10ȸ�� ���� ��� ���� �Ͽ����ϴ�.");
				System.exit(0);
			}
			
			// ����� �Է� ���
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("0~9 ���� �� 3������ �Է��ϼ���. (�ߺ� �Ұ�)");
			for(int i = 0 ; i < gameData[count][0].length ; i++){	// gameData[0][1] -> ����� �Է� ��ȣ �迭 (int inputNum[])
				System.out.print((i + 1) + "��° ���� �Է��ϼ��� : ");	
				gameData[count][0][i]= System.in.read() - '0';
				System.in.skip(2);
				
				// 1. ����� �Է� �ߺ� üũ ���
				for(int j = 0 ; j < i ; j++){
					if( gameData[count][0][i] == gameData[count][0][j] ){
						System.out.println("�ߺ� �� ���� �Է��� �� �����ϴ�. �ٽ� �Է��� �ּ���.");
						i--;
						break;
					}
				}
				
				// 2. ����� �Է� �ߺ� üũ ��� 
				/*if(i > 0){		// �ι�° ��ȣ ���� �ߺ� üũ ����
					while(true){	// ����� �Է� �� �ߺ�üũ
						int inputCount = 0;
						for(int j = 0 ; j < i ; j++){	// ���� �Էµ� �����Ϳ� ��ü ��
							if( gameData[count][0][i] == gameData[count][0][j] ){ // ���� �Էµ� �����Ϳ� ������ �Էµ� �����Ͱ� ���� ��� ( i -> ���� �Է� index , j -> ���� �Է� index)
								System.out.println("�ߺ� �� ���� �Է��� �� �����ϴ�. �ٽ� �Է��� �ּ���.");
								System.out.print((i + 1) + "��° ���� �Է��ϼ��� : ");
								gameData[count][0][i]= System.in.read() - '0'; // ���� �Է� �����͸� �ٽ� �Է� �޵��� �Ѵ�.
								System.in.skip(2); 
								inputCount = 1;
							} 
						}
						if(inputCount == 0){ // inputCount �� �������� ���� ���. �ߺ� �� ���� ���� �����̹Ƿ� �������´�.
							break;
						}
					}
				}*/
			}
			
			// ��� ó�� ��� ( �� )
			for(int i = 0 ; i < gameData[count][1].length ; i++){		//��ǻ�� ���� �迭�� ����� �Է� �迭�� ���� ���Ѵ�.
				for(int j = 0 ; j < gameData[count][0].length ; j++){
					if(gameData[count][1][i] == gameData[count][0][j] && i == j){	// ��ǻ�� ���� ����� ���� ����, ���� �ڸ��� �ִٸ� -> ��Ʈ����ũ
						gameData[count][2][1] += 1;	// ��Ʈ����ũ ī��Ʈ (int strikeCount) 
						break;
					} else if(gameData[count][1][i] == gameData[count][0][j] && i != j) { // ��ǻ�� ���� ����� ���� ����, �ٸ� �ڸ��� �ִٸ� -> ��
						gameData[count][2][2] += 1; // �� ī��Ʈ (int ballCount) 
						break;
					}  											
				}
			}
			
			// ��� ó�� ��� ( ȸ���� �Է� )
			gameData[count][2][0] = ++count; // ȸ�� ���� �����Ϳ� �����ϰ� ī���͸� ����

			// ��� ��� ���
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nn\n\n\n\n\nn\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("------------------------------------------------------------------------------------------");
			for(int i = 0 ; i < count ; i++){ // ī���� ��ŭ ���
					System.out.print(gameData[i][2][0] + " ȸ�� >>>>>\t\t");
					
					if(gameData[i][2][1] == 3){				// ��Ʈ����ũ ī��Ʈ (int strikeCount)�� 3�� ���
						System.out.println(" ����");
						System.exit(0);
					} else if ( gameData[i][2][1] != 0 || gameData[i][2][2] != 0) { // ��Ʈ����ũ ī��Ʈ (int strikeCount) �Ǵ� �� ī��Ʈ (int ballCount)�� 0�� �ƴѰ��
						for(int j = 0 ; j < gameData[i][0].length; j++){
							System.out.print(gameData[i][0][j] + "\t");
						}
						System.out.println("\t��Ʈ����ũ :\t" + gameData[i][2][1] + "\t�� :\t" + gameData[i][2][2]);
					} else if ( gameData[i][2][1] == 0 && gameData[i][2][2] == 0 ) { // ��Ʈ����ũ ī��Ʈ (int strikeCount)�� �� ī��Ʈ (int ballCount)�� 0�� ���
						for(int j = 0 ; j < gameData[i][0].length; j++){
							System.out.print(gameData[i][0][j] + "\t");
						}
						System.out.println("\tout");
					}
			}
		}
	}
}
