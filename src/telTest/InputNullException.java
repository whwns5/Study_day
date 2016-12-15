package telTest;

public class InputNullException extends Exception{
	
	String nullComponent;
	
	public InputNullException() {
		// TODO Auto-generated constructor stub
		super("사용자로부터 공란이 입력됨.");
	}
	
	public InputNullException(String nullComponent) {
		super("사용자로부터 " + nullComponent + " 가 공란으로 입력됨.");
		this.nullComponent = nullComponent;
	}
	
	public String getExceptionString(){
		return this.nullComponent + " 을(를) 입력하여 주세요.";
	}
}