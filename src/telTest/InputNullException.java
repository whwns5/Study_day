package telTest;

public class InputNullException extends Exception{
	
	String nullComponent;
	
	public InputNullException() {
		// TODO Auto-generated constructor stub
		super("����ڷκ��� ������ �Էµ�.");
	}
	
	public InputNullException(String nullComponent) {
		super("����ڷκ��� " + nullComponent + " �� �������� �Էµ�.");
		this.nullComponent = nullComponent;
	}
	
	public String getExceptionString(){
		return this.nullComponent + " ��(��) �Է��Ͽ� �ּ���.";
	}
}