package edu.java.variable03;

public class VariableMain03 {

	public static void main(String[] args) {
		// 문자(character): 문자1개 . 작은따옴표('')를 사용.
		// - 컴퓨터는 문자를 저장할 때, 문자에 해당하는 코드값(정수)을 저장.
		//문자열(string): 문자들의 배열. 큰따옴표("")를 사용.
		
		char ch1 ='a'; //문자  a 의 코드값을 정수로 저장.
		System.out.println(ch1); //char 타입 변수 ch1에 저장된 값을 문자로 출력.
		System.out.println((int)ch1); //변수 ch1에 저장된 값을 int 타입으로 출력.
		// casting : 강제 타입 변환.
		
		char ch2 =98;
		System.out.println(ch2);
		
		char ch3 = '한';
		System.out.println(ch3);
		System.out.println((int) ch3);
	
	}

}
