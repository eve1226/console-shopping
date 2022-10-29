package M;

import java.util.ArrayList;

public class Product {
	public static ArrayList<Product> productList = new ArrayList<Product>();
	private int productNo;
	private String productName;
	private int price;

	public Product() {}
	public Product(int productNo, String productName, int price) {
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
	}

	public int productNo() {
		return productNo;
	}


	public void productNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return productName + " : " + price + "원";
	}

	public void toCart(){
		System.out.println(productName + " 를 장바구니에 담았습니다");
	}
}
