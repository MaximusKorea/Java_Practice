package menu_B;

import java.util.HashMap;
import java.util.Map;

public interface MenuTool {

	Map<String, String> menu = new HashMap<>();
	//메뉴 등록
	public boolean register(String menu, String price);
	
	//메뉴 전체보기
	public void showmenu();
	
	//메뉴 수정
	public void updatemunu();
}
