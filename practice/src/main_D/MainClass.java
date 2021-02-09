package main_D;

import java.util.Scanner;

import manager_A.ManagerTool;
import manager_A.ManagerToolImpl;
import menu_B.MenuTool;
import menu_B.MenuToolImpl;
import sum_C.SumTool;
import sum_C.SumToolImpl;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ManagerTool manager = new ManagerToolImpl();
		MenuTool menutool = new MenuToolImpl(); 
		SumTool sumtool = new SumToolImpl();
		int login_identifier = 0;
		System.out.println("========= 음식 계산 프로그램 ==========");
		while(true) {
			System.out.println("기능을 선택하세요!");
			System.out.println("1.계산  2.메뉴 전체보기  3.메뉴 등록 4.메뉴 수정(삭제) 5.관리자 로그인 6. 관리자 로그아웃  7.관리자 등록(수정,삭제) 8.시스템 종료");
			int choice = sc.nextInt();
			switch(choice) {
			
			case 1:
				if(menutool.menu.size()==0) {
					System.out.println("등록된 메뉴가 없습니다. 메뉴 등록을 해주세요");
					System.out.println();
				}else {
				System.out.println("계산할 음식을 입력 (계산합계시 \"소계\"라고 입력해주세요. 취소를 원하시면 \"취소\"라고 입력해주세요) "); //합계버튼을 눌러주면 지금까지 입력한 모든음식의 값이 나옴
				int money=0;
				money = sumtool.sum();
				if(money == 0) {
					System.out.println("계산이 취소되었습니다.");
					System.out.println();
				}else {
				System.out.println("합계 : " + money+"원");
				System.out.print("지불하실 금액(숫자만 입력) : ");
				int pay = sc.nextInt();
				System.out.println("거스름돈 : "+(pay-money));
				System.out.println("계산완료 ");
				System.out.println();
				}
				}
				break;
			case 2:
				if(MenuTool.menu.size() == 0) {
					System.out.println("등록된 메뉴가 없습니다.");
				}else {
					System.out.println("========= 전체 메뉴 =========");
					menutool.showmenu();
					System.out.println();
				}
				break;
			case 3:
				if(login_identifier == 0) {
					System.out.println("관리자 로그인을 해주세요 ");
					System.out.println();
				}else {
					System.out.println("========= 메뉴 등록 =========");
					System.out.print("등록하실 메뉴 입력 : ");
					String menu = sc.next();
					System.out.print("등록하실 메뉴 가격 입력(숫자만 입력) : ");
					String price = sc.next();
					if(menutool.register(menu,price)) {
						System.out.println("메뉴 등록 완료!!");
						System.out.println();
					}else {
						System.out.println("같은 메뉴가 존재합니다.");
						System.out.println();
					}
				}
				break;
			case 4:
				if(login_identifier == 0) {
					System.out.println("관리자 로그인을 해주세요");
					System.out.println();
				}else {
				System.out.println("========= 메뉴 수정 =========");
				menutool.updatemunu();
				System.out.println();
				}
				break;
			case 5:
				System.out.println("========= 관리자 로그인 =========");
				if(login_identifier == 1) {
					System.out.println("이미 로그인 되어있습니다.");
				}else {
				
				if(ManagerTool.managerlist.size() == 0) {
					System.out.println("관리자 등록이 되어있지 않습니다. 먼저 등록부터 해주세요!");
					System.out.println();
				}else {
					System.out.print("관리자 아이디 입력 :");
					String id = sc.next();
					System.out.print("관리자 비밀번호 입력 :");
					String pw = sc.next();
					if(id == null) {
						System.out.println("다시 입력해주세요");
					}else {
					if(manager.login(id,pw)==1) {
						System.out.println("로그인이 인증되었습니다.");
						System.out.println();
						login_identifier = 1;
					}else if(manager.login(id, pw) == -1) {
						System.out.println("비밀번호가 틀렸습니다.");
						System.out.println();
						login_identifier = 0;
					}else {
						System.out.println("아이디가 없습니다.");
						login_identifier = 0;
						System.out.println();
					}
					}
				}
				}
				break;
			case 6:
				if(login_identifier == 1) {
					System.out.println("로그아웃 되었습니다.");
					login_identifier = 0;
				}else {
					System.out.println("로그인 상태가 아닙니다.");
					System.out.println();
				}
			
				break;
			case 7:
				System.out.println("========= 관리자 모드 =========");
				boolean flag = true;
				while(flag) {
				System.out.println("1.관리자 등록 2.관리자 정보 수정 3. 관리자 삭제 4.종료");
				System.out.print("입력>>> ");
				int num = sc.nextInt();
				switch(num) {
				case 1:
					System.out.print("아이디를 입력해주세요 : ");
					String id = sc.next();
					System.out.print("비밀번호를 입력해주세요 : ");
					String pw = sc.next();
					if(manager.resister(id,pw)) {
						System.out.println("관리자 등록 완료!");
						System.out.println();
					}else {
						System.out.println("동일한 관리자 아이디가 존재합니다!!!");
						System.out.println();
					}
					flag=true;
					break;
				case 2:
					
					System.out.print("수정하실 관리자 아이디를 입력해주세요 :");
					String id_new = sc.next();
					System.out.print("현재 비밀번호 입력 :");
					String pw_old = sc.next();
					int m = manager.update(id_new, pw_old);
					if(m == 1) {
						System.out.println("관리자 정보가 변경되었습니다.");
					}else if(m == 0) {
						System.out.println("해당 관리자 정보가 존재하지 않습니다.");
					}else {
						System.out.println("비밀번호가 틀렸습니다.");
					}
					flag=true;
					break;
				case 3:
					System.out.print("삭제하실 관리자 아이디를 입력해주세요 :");
					String id_del = sc.next();
					System.out.print("삭제하실 관리자 비밀번호를 입력해주세요 :");
					String pw_del = sc.next();
					int re = manager.delete(id_del, pw_del);
					if(re == 1) {
						System.out.println("삭제 완료");
						login_identifier = 0;
					}else if(re == 0) {
						System.out.println("해당 관리자 정보가 존재하지 않습니다.");
					}else {
						System.out.println("비밀번호가 틀렸습니다.");
					}
					flag=true;
					break;
				case 4:
					flag=false;
				
				}
				}
				break;
			case 8:System.exit(0);break;
			
			}
			
			
		}
		
	}

}
