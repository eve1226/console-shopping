package M;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Member {
	public static Map<String, Member> userMap = new HashMap<String, Member>();
	public List<Product> myCart = new ArrayList<Product>();
	private String id;
	private String pw;
	private String name;
	private int money;

	public Member(){}
	public Member(String id,String pw,String name,int money){
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.money = money;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "ID:" + this.id + ", " + "이름:" + this.name + ", " + "보유금액" + this.money + "원";

	}

	public static void getUserList(Map<String, Member> userMap){
		Set<Map.Entry<String, Member>> entries = userMap.entrySet();
		for(Map.Entry<String, Member> entry : entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue().toString());
		}
	}

}
