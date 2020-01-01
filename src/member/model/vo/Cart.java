package member.model.vo;

public class Cart {

	private static final long serialVersionUID = 1L;

	private int cart_No;
	private String member_Id;
	private int item_no;
	private String cartProdBrand;
	private String cartProdName;
	// 나중에 초기값 지우고 로직에서 set 할 것
	private int cartProdRentalPrice = 15000;
	private int cartProdStock;
	// 나중에 초기값 지우고 로직에서 set 할 것
	private int cartProdRentalTerm = 7;
	// 기본값 설정
	private int cartProdDeliveryFee = 4000;
	private int cartProdPrice;

	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cart(int cart_No, String member_Id, int item_no, String cartProdBrand, String cartProdName,
			int cartProdRentalPrice, int cartProdStock, int cartProdRentalTerm, int cartProdDeliveryFee,
			int cartProdPrice) {
		super();
		this.cart_No = cart_No;
		this.member_Id = member_Id;
		this.item_no = item_no;
		this.cartProdBrand = cartProdBrand;
		this.cartProdName = cartProdName;
		this.cartProdRentalPrice = cartProdRentalPrice;
		this.cartProdStock = cartProdStock;
		this.cartProdRentalTerm = cartProdRentalTerm;
		this.cartProdDeliveryFee = cartProdDeliveryFee;
		this.cartProdPrice = cartProdPrice;
	}

	public int getCartProdPrice() {
		return cartProdPrice;
	}

	public void setCartProdPrice(int cartProdPrice) {
		this.cartProdPrice = cartProdPrice;
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

	public int getCartProdRentalPrice() {
		return cartProdRentalPrice;
	}

	public void setCartProdRentalPrice(int cartProdRentalPrice) {
		this.cartProdRentalPrice = cartProdRentalPrice;
	}

	public int getCartProdStock() {
		return cartProdStock;
	}

	public void setCartProdStock(int cartProdStock) {
		this.cartProdStock = cartProdStock;
	}

	public int getCartProdRentalTerm() {
		return cartProdRentalTerm;
	}

	public void setCartProdRentalTerm(int cartProdRentalTerm) {
		this.cartProdRentalTerm = cartProdRentalTerm;
	}

	public int getCartProdDeliveryFee() {
		return cartProdDeliveryFee;
	}

	public void setCartProdDeliveryFee(int cartProdDeliveryFee) {
		this.cartProdDeliveryFee = cartProdDeliveryFee;
	}

	public int getCart_No() {
		return cart_No;
	}

	public void setCart_No(int cart_No) {
		this.cart_No = cart_No;
	}

	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

}