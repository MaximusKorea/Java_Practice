package manager_A;

import java.util.ArrayList;
import java.util.List;

public interface ManagerTool {
	
	List<ManagerVO> managerlist = new ArrayList<>();
	
	//Manager 등록
	public boolean resister(String id, String pw);
	//Manager 로그인
	public int login(String id, String pw);
	//Manager 정보 수정
	public int update(String id,String pw);
	//Manager 정보 삭제
	public int delete(String id,String pw);
	
}
