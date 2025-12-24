package lab.ch01;

public class NPEtest {

	/*
	파라미터 자리를 통해서 초기화가 호출될 때 일어남
	이 때 null이리도 있다는 생각을 고려
	 * */
	void methodA(String temp) {
		System.out.println("methodA호출 성공");
		// 만일 파라미터 temp에 null인 상태이더라도 사용하지 않으면 예외발생하지  않음
		try {
			//예외가 발생할 가능성이 있는 코드를 쓴다
			System.out.println(temp.length());
			//예외가 발생했을때 프로그램이 멈추지 않도록 하려면 예외처리를 따로 하면
			//중지되지 않고 다음으로 진행이 됨
		} catch (NullPointerException e) {
			System.out.println("{");
			System.out.println("\tNullPointerException "+e.toString());
			System.out.println("}");
		} finally {		//예외가 발생하더라도 무조건 실행기회를 갖는다
			System.out.println("\n여기는 finally구역");
		}
		
		System.out.println("여기까지 잘 찍힘");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("");
		
		String msg = "Hello";
		System.out.println(msg.length());
		//length() 동사형은 문자열의 길이를 반환하고
		//length명사형은  배열의 크기를 반환함
		System.out.println("Hello".length());
		
		//String name = null;
		//System.out.println(name.length());
		
		NPEtest epe = new NPEtest();
		epe.methodA(null);
	}
}
