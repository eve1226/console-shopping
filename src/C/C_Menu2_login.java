package C;

import java.util.ArrayList;

import M.Product;
import V.V_Menu;
import C.C_Menu1;

public class C_Menu2_login implements Menu2{
	public static C_Menu2_login Menu2 = new C_Menu2_login();
	V_Menu menu = V_Menu.getMenu();
	public int productNum = 1000;
	public String[] product = {"냉장고", "세탁기", "TV", "공기청정기", "청소기"};
	public int[] price = {100,200,300,400,500};

	public void init() {
		for(int i = 0; i< Menu2.product.length; i++) {
			Product p = new Product(
					Menu2.productNum,
					Menu2.product[i],
					Menu2.price[i]
			);
			Menu2.productNum++;
			Product.productList.add(p);
		}
	}

	public void shopping() {
		System.out.println(C_Menu1.member_con.logId);
		while(true) {
			int size = Product.productList.size();
			System.out.println("============제품리스트=============");
			for(int i = 0; i < size; i++) {
				System.out.println(Product.productList.get(i).toString());
			}
			System.out.println("================================");
			System.out.println("[1]장바구니에담기 [2]장바구니이동 [0]뒤로가기");
			String sel = menu.sc.next();
			if(sel.equals("2")) {C_Menu2_login.Menu2.cart(); return;}
			if(sel.equals("0")) {return;}
			if(sel.equals("1")) {
				System.out.println("구매하실 제품명을 입력해 주세요 : ");
				String sel1 = menu.sc.next();
				int ch = -1;
				for(int i = 0; i < size; i++) {
					String ProductName = Product.productList.get(i).getProductName();
					if(sel1.equals(ProductName)) {
						ch = i;
						break;
					}
				}

				if(ch == -1) {
					System.out.println("입력하신 제품이 존재하지 않습니다");
					continue;
				}else {
					C_Menu1.member_con.log.myCart.add(Product.productList.get(ch));
					Product.productList.get(ch).toCart();
				}
			}
		}
	}


	public void cart() {
		int total = 0;
		int productListSize = Product.productList.size();
		int myCartsize = C_Menu1.member_con.log.myCart.size();

		if(myCartsize == 0) {
			System.out.println("장바구니가 비어있습니다.");
			return;
		}

		System.out.println("======= " + C_Menu1.member_con.logId + "님의 장바구니 목록 =======");
		for(int i = 0; i < productListSize; i++) {
			int count = 0;
			int price = Product.productList.get(i).getPrice();
			String getI = Product.productList.get(i).getProductName();
			for(int j = 0; j < myCartsize; j++) {
				String getJ = C_Menu1.member_con.log.myCart.get(j).getProductName();
				if(getI.equals(getJ)) {
					count++;
					total += C_Menu1.member_con.log.myCart.get(j).getPrice();
				}
			}
			if(count > 0) {
				System.out.println(getI + " : " + price + "원 x " + count +" 개");
			}
			count = 0;
		}
		System.out.println("총 결재하실 금액 : " + total + "원");
		System.out.println("================================");

		System.out.println("[1]결재하기 [2]취소");
		int sel = menu.sc.nextInt();
		int myMoney = C_Menu1.member_con.log.getMoney();
		if(sel == 1) {
			if(myMoney < total) {
				System.out.println("보유금액이 부족합니다.");
				return;
			}
			System.out.println(total + "원을 결재하시겠습니까? [1]네 [2]취소");
			String sel1 = menu.sc.next();
			if(sel1.equals("2")) {return;}
			myMoney -= total;
			C_Menu1.member_con.log.setMoney(myMoney);
			System.out.println("결재완료 남은금액 : " + C_Menu1.member_con.log.getMoney());
			C_Menu1.member_con.log.myCart.clear();
		}else if(sel == 2) {
			return;
		}
	}


}










