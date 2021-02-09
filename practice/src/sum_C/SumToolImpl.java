package sum_C;


import java.util.Scanner;

import menu_B.MenuTool;

public class SumToolImpl implements SumTool{

	
	@Override
	public int sum() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		boolean flag = false;
		while(!flag) {
			String input = sc.next();
			if(MenuTool.menu.containsKey(input)) {
				sum = sum + Integer.parseInt(MenuTool.menu.get(input));
			}else if(input.equals("소계")) {
				flag = true;
			}else if(input.equals("취소")) {
				sum = 0;
				flag = true;
			}else {
				System.out.println("해당 메뉴가 없습니다.");
			}
			
		}
		
		
	return sum;
	}
	

}
