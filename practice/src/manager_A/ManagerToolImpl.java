package manager_A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerToolImpl implements ManagerTool {

	
	//관리자 등록
	@Override
	public boolean resister(String id, String pw) {
		int count = 0;
		if(managerlist.size() == 0) {
			count = 0;
		}else {
			for(ManagerVO v : managerlist) {
				if(v.getManagerId().equals(id)) {
					count++;
				}
			}
		}
		if(count == 0) {
			ManagerVO vo = new ManagerVO(id,pw);
			managerlist.add(vo);
			return true;
		}else {
			return false;
		}
	}
	//관리자 로그인
	@Override
	public int login(String id, String pw) {
		int result = 0;
		int count = 0;
		int index = 0;
		for(int i=0; i<managerlist.size(); i++) {
			if(managerlist.get(i).getManagerId().equals(id)) {
				index = i;
				count++;
			}
				
			
		}
		if(count == 1) {
			if(managerlist.get(index).getManagerPw().equals(pw)) {
				result = 1; // 로그인 인증됨
			}else{
				result = -1; // 비밀번호 틀림
			}
		}else {
			result = 0; // 아이디가 없음
		}
		
		return result;
		
	}
	//관리자 정보 수정(비밀번호 수정)
	@Override
	public int update(String id, String pw_old) {
		int index = 0;
		int count = 0;
		int result = 0;
		for(int i=0;i<managerlist.size();i++) {
			if(managerlist.get(i).getManagerId().equals(id)) {
				index = i;
				count++;
			}
		}
		
		if(count == 1) {
			if(managerlist.get(index).getManagerPw().equals(pw_old)) {
				Scanner sc = new Scanner(System.in);
				System.out.print("변경 후 비밀번호 입력 : ");
				String pw = sc.next();
				managerlist.set(index,new ManagerVO(id,pw));
				result = 1;
			}else {
				result = -1;
			}
		}else {
			result = 0;
		}
		return result;
	}
	//관리자 삭제
	@Override
	public int delete(String id, String pw) {
		int index = 0;
		int count = 0;
		int result = 0;
		for(int i=0;i<managerlist.size();i++) {
			if(managerlist.get(i).getManagerId().equals(id)) {
				index = i;
				count++;
			}
		}
		
		if(count == 1) {
			if(managerlist.get(index).getManagerPw().equals(pw)) {
				Scanner sc = new Scanner(System.in);
				managerlist.remove(index);
				result = 1;
			}else {
				result = -1;
			}
		}else {
			result = 0;
		}
		return result;
		
	}

}
