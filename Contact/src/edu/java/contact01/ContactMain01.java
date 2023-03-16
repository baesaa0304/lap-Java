package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	 // 상수(constant)
	private static final int MAX_LENGTH = 5; // 연락처 배열의 최대 길이(원소 개수)
	
	// field
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장할 배열.
	private int count = 0; // 연락처 배열에 현재까지 저장된 연락처의 개수. 배열에 저장될 때마다 값 증가.
	private Scanner scanner = new Scanner(System.in); // 입력 도구. 
	
	
	public static void main(String[] args) {
		System.out.println("****연락처 프로그램 V0.1****");
		
		ContactMain01 app = new ContactMain01();
		// -> static이 아닌 메서들을 사용하기 위해서 참조 변수를 생성.
		boolean run =true;
		while(run) {
			// 메인 메뉴 보여주기
			// 메인 메뉴에서 선택된 값
			int menu = app.showMainMenu();
			switch (menu) {
			case 0 : // 프로그램 종료.
				run = false;
				break;
			case 1 : // 새 연락처 저장.
				app.insertNewContact();
				break;
			case 2 : // 연락처 전체 목록 보여주기.
				app.selectAllContact();
				break;
			case 3 : // 배열의 인덱스로 연락처 검색하기.
				break;
			case 4 : // 연락처 이름 / 전화번호 /이메일 정보 수정하기.
				break;
			case 5 : // 배열의 인덱스로 연락처 삭제하기.
				break;
			default:
				System.out.println("메인 메뉴 번호를 확인하세요...");
			}
		}
		
		System.out.println("****** 프로그램 종료 ******");

	}
	// (1) 새 연락처
	public void insertNewContact() {
		System.out.println();
		System.out.println("----- 새 연락처 저장 -----");
		System.out.print("이름 입력 > ");
		String name = scanner.nextLine(); // 공백을 포함해서 엔터가 입력될 때까지 모든 문자열을 읽음.
		System.out.print("전화번호 입력 > ");		
		String phone = scanner.nextLine();
		System.out.print("이메일 입력 > ");
		String email = scanner.nextLine();					
		// 입력받은 정보들로 Contact 타입의 객체를 생성.
		Contact c = new Contact(0, name, phone, email);
		// 생성된 contact 타입의 객체를 배열에 저장
		contacts[count] = c;
		
		// 배열에 저장된 원소(연락처) 개수를 1 증가.
		count++;
		System.out.println("새 연락처 저장 성공");
		}
	
	// (2) 전체 목록 
	public void selectAllContact() {
		System.out.println();
		System.out.println(count+"개");
		if (count == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			System.out.println("연락처를 등록해주세요. ");			
		}else {
			System.out.println("------전체 연락처--------");
			for(int i= 0; i < count; i++) {
				System.out.println("연락처 : " + i +"개");				
				System.out.println("이름" + contacts[i].getName());
				System.out.println("연락처" + contacts[i].getPhone());
				System.out.println("이메일" + contacts[i].getEmail());
			}
		}		
	}
	// (3) 검색
	public void selectContact() {
		int search = scanner.nextInt();
		scanner.nextLine();
		System.out.println("검색 > ");		
		if(search >=0 && search<count) {
			System.out.println();
			System.out.println(contacts[search].getName());			
			System.out.println(contacts[search].getPhone());
			System.out.println(contacts[search].getEmail());
		} else {
			System.out.println("없는 연락처 입니다. 다시 확인해주세요.");
		}			
	}
	
	// (4) 수정
	public void updateContact() {
	System.out.println("수정 내역> ");
	
	}
	
	// (5) 삭제
	public void deleteContact() {
		System.out.println("삭제> ");
		int delete = scanner.nextInt();
		scanner.nextInt();
		if(delete >=0 && delete < count) {
			System.out.print("수정 할 이름 입력>");
			String name = scanner.nextLine();
			
		}
		
	}
	public int showMainMenu() {
		System.out.println();
		System.out.println("---------------------------------------------------------");
		System.out.println("[0]종료 [1]새 연락처 [2]전체 목록 [3]검색 [4]수정 [5]삭제");
		System.out.println("---------------------------------------------------------");
		System.out.println("선택> ");
		
		// 콘솔 창에서 입력된 문자열 1개 라인은 정수(int)로 변환.		
		int result = Integer.parseInt(scanner.nextLine());
		
		return result;
	}

}