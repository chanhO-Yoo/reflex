package itemRentEach.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import itemRentEach.model.dao.ItemRentEachDAO;
import itemRentEach.model.vo.ItemRentEach;

public class ItemRentEachService {

	public ItemRentEach selectOne(String memberId) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ItemRentEach ItemRentEach = new ItemRentEachDAO().selectOne(conn, memberId);
		close(conn);
		
		return ItemRentEach;
		
	}

}
