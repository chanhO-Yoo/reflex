package board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class BoardWithCommentCnt extends Board 
								 implements Serializable{
	private int commentCnt;

	public BoardWithCommentCnt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public BoardWithCommentCnt(int review_no, int order_details_no, String review_writer, Date review_date,
			int review_star, String review_content, String review_image, int review_readCount) {
		super(review_no, order_details_no, review_writer, review_date, review_star, review_content, review_image,
				review_readCount);
		// TODO Auto-generated constructor stub
	}


	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}


	@Override
	public String toString() {
		return "BoardWithCommentCnt [commentCnt=" + commentCnt + ", getReview_no()=" + getReview_no()
				+ ", getOrder_details_no()=" + getOrder_details_no() + ", getReview_writer()=" + getReview_writer()
				+ ", getReview_date()=" + getReview_date() + ", getReview_star()=" + getReview_star()
				+ ", getReview_content()=" + getReview_content() + ", getReview_image()=" + getReview_image()
				+ ", getReview_readCount()=" + getReview_readCount() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


	
	
	
}
