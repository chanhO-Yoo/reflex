package order.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class OrderSheet implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String orderNo;
	private String impUid; //아임포트에서 발급하는 거래건당 고유번호
	private String memberId;
	private Date orderDate;
	private String orderPayMethod;
	private String orderPayStatus;
	private int orderTotalCount;
	private int orderTotalPrice;
	
	public OrderSheet() {
		super();
	}

	public OrderSheet(String orderNo, String impUid, String memberId, Date orderDate, String orderPayMethod,
			String orderPayStatus, int orderTotalCount, int orderTotalPrice) {
		super();
		this.orderNo = orderNo;
		this.impUid = impUid;
		this.memberId = memberId;
		this.orderDate = orderDate;
		this.orderPayMethod = orderPayMethod;
		this.orderPayStatus = orderPayStatus;
		this.orderTotalCount = orderTotalCount;
		this.orderTotalPrice = orderTotalPrice;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getImpUid() {
		return impUid;
	}

	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderPayMethod() {
		return orderPayMethod;
	}

	public void setOrderPayMethod(String orderPayMethod) {
		this.orderPayMethod = orderPayMethod;
	}

	public String getOrderPayStatus() {
		return orderPayStatus;
	}

	public void setOrderPayStatus(String orderPayStatus) {
		this.orderPayStatus = orderPayStatus;
	}

	public int getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(int orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getOrderTotalCount() {
		return orderTotalCount;
	}

	public void setOrderTotalCount(int orderTotalCount) {
		this.orderTotalCount = orderTotalCount;
	}

	@Override
	public String toString() {
		return "OrderSheet [orderNo=" + orderNo + ", impUid=" + impUid + ", memberId=" + memberId + ", orderDate="
				+ orderDate + ", orderPayMethod=" + orderPayMethod + ", orderPayStatus=" + orderPayStatus
				+ ", orderTotalCount=" + orderTotalCount + ", orderTotalPrice=" + orderTotalPrice + "]";
	}
	
}
