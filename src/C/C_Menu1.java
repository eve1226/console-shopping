package C;
import V.V_Menu;

import java.util.Map;

import M.Member;

public class C_Menu1 implements Menu1{
	public static C_Menu1 member_con = new C_Menu1();
	V_Menu menu = V_Menu.getMenu();
	public static Member log;
	public static String logId;

	@Override
	public void join() {
		System.out.println("[회원가입] 아이디 : ");
		String id = V_Menu.sc.next();
		if(Member.userMap.containsKey(id)) {
			System.out.println("중복된 아이디 입니다");
			return;
		}
		System.out.println("[회원가입] 비밀번호 입력 : ");
		String pw = V_Menu.sc.next();
		System.out.println("[회원가입] 이름 입력 : ");
		String name = V_Menu.sc.next();
		int money = 3000;
		Member member = new Member(id,pw,name,money);
		Member.userMap.put(id, member);
		System.out.println("회원가입을 축하드립니다.");
		System.out.println("쇼핑지원금 3000원이 지급되었습니다.");
	}

	@Override
	public void login() {
		System.out.println("[로그인] 아이디 : ");
		String id = menu.sc.next();
		if(Member.userMap.containsKey(id)) {
			System.out.println("[로그인] 비밀번호 : ");
			String pw = menu.sc.next();
			if(Member.userMap.get(id).getPw().equals(pw)) {
				log = Member.userMap.get(id);
				logId = id;
				System.out.println(id + "님 로그인성공");
				menu.v_Menu2_login();
			}else {
				System.out.println("비밀번호 맞지않음");
			}
		}else {
			System.out.println("없는 아이디");
		}
	}

	@Override
	public void UserList() {
		for(Map.Entry<String, Member> e : Member.userMap.entrySet()) {
			System.out.println(e.getValue());
		}
	}
}





