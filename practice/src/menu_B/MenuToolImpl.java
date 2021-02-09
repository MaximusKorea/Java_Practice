package menu_B;

import java.util.Iterator;
import java.util.Scanner;

public class MenuToolImpl implements MenuTool {

	
	
	@Override
	public boolean register(String input_menu, String price) {
		
		if(menu.containsKey(input_menu)) {
			return false;
		}else {
			menu.put(input_menu, price);
			return true;
		}
	}

	@Override
	public void showmenu() {
		
		Iterator<String> itr = menu.keySet().iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			System.out.println("=============================");
			System.out.println("메뉴 이름 : "+key);
			System.out.println("가 격 : "+menu.get(key)+"원");
		}
	}

	@Override
	public void updatemunu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			System.out.print("1.메뉴 수정 2.메뉴 삭제  3.종 료");
			int num = sc.nextInt();
			switch(num) {
				case 1:
					System.out.print("수정할 메뉴 입력 :");
					String name = sc.next();
					if(menu.containsKey(name)) {	//value값의 존재 여부에 따라 다른 결과를 나타낼 수 있으려면 get을해서 해당 참조변수가 null값이냐 아니냐에 따라서 다른 결과를 
						System.out.println("가 격");  //보여주게 할 수도 있다.
						String price = sc.next();	//arrayList를 통해서 어떤 것의 유무에 대해 구현할 때는 미리 confirm 메서드를 통해서 만들어 놓으면 된다.
						menu.put(name, price);
						System.out.println("메뉴 수정 완료");
					}else {
						System.out.println("해당 메뉴가 존재하지 않습니다.");
					}
					break;
				case 2:
					System.out.println("삭제할 메뉴 입력 :");
					String name1 = sc.next();
					if(menu.containsKey(name1)) {
						menu.remove(name1);
						System.out.println("메뉴 삭제 완료");
					}else {
						System.out.println("해당 메뉴가 존재하지 않습니다.");
					}
					break;
				case 3:
					return;
					
			}
		}
		
	}

}
