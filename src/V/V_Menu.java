package V;

import java.util.Scanner;
import C.C_Menu1;
import C.C_Menu2_login;

public class V_Menu implements Menu{
	public static Scanner sc = new Scanner(System.in);
	private static V_Menu menu = new V_Menu();
	public static C_Menu1 member_c = new C_Menu1();
	public V_Menu(){}

	public static V_Menu getMenu() {
		if(menu == null) {
			menu = new V_Menu();
		}
		return menu;
	}

	@Override
	public void v_init() {
		C_Menu2_login.Menu2.init();
		v_Menu1();
	}

	@Override
	public void v_Menu1() {
		while(true) {
			System.out.println("[1]회원가입 [2]로그인 [3]전체회원목록 [0]종료");
			String sel = sc.next();
			if(sel.equals("0")) {
				System.out.println("종료");
				break;
			}else if(sel.equals("1")) {
				member_c.join();
			}else if(sel.equals("2")) {
				member_c.login();
			}else if(sel.equals("3")) {
				member_c.UserList();
			}else {
				System.out.println("오류");
			}
		}
	}
	@Override
	public void v_Menu2_login() {
		while(true) {
			System.out.println("[1]쇼핑하기 [2]장바구니 [0]로그아웃");
			String sel = sc.next();
			if(sel.equals("0")) {
				System.out.println("종료");
				break;
			}else if(sel.equals("1")) {
				C_Menu2_login.Menu2.shopping();
			}else if(sel.equals("2")) {
				C_Menu2_login.Menu2.cart();
			}else {
				System.out.println("오류");
				break;

			}
		}
	}

}
