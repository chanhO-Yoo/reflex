package member.model.vo;

public class Cart {

	private static final long serialVersionUID = 1L;

	private int cartNo;
	private String memberId;
	private int itemNo;
	private String categoryNo;
	private String rentOptNo;
	private int itemQuantity;
	private String cartProdBrand;
	private String cartProdName;
	private int cartProdPrice;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartNo, String memberId, int itemNo, String categoryNo, String rentOptNo, int itemQuantity,
			String cartProdBrand, String cartProdName, int cartProdPrice) {
		super();
		this.cartNo = cartNo;
		this.memberId = memberId;
		this.itemNo = itemNo;
		this.categoryNo = categoryNo;
		this.rentOptNo = rentOptNo;
		this.itemQuantity = itemQuantity;
		this.cartProdBrand = cartProdBrand;
		this.cartProdName = cartProdName;
		this.cartProdPrice = cartProdPrice;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getRentOptNo() {
		return rentOptNo;
	}

	public void setRentOptNo(String rentOptNo) {
		this.rentOptNo = rentOptNo;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getCartProdBrand() {
		return cartProdBrand;
	}

	public void setCartProdBrand(String cartProdBrand) {
		this.cartProdBrand = cartProdBrand;
	}

	public String getCartProdName() {
		return cartProdName;
	}

	public void setCartProdName(String cartProdName) {
		this.cartProdName = cartProdName;
	}

	public int getCartProdPrice() {
		return cartProdPrice;
	}

	public void setCartProdPrice(int cartProdPrice) {
		this.cartProdPrice = cartProdPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", memberId=" + memberId + ", itemNo=" + itemNo + ", categoryNo=" + categoryNo
				+ ", rentOptNo=" + rentOptNo + ", itemQuantity=" + itemQuantity + ", cartProdBrand=" + cartProdBrand
				+ ", cartProdName=" + cartProdName + ", cartProdPrice=" + cartProdPrice + "]";
	}


}