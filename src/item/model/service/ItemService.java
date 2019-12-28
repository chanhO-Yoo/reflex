package item.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import item.model.dao.ItemDAO;
import item.model.vo.Item;
import item.model.vo.ItemImage;

public class ItemService {

	public List<Item> selectItemList(String categoryNo) {
		Connection conn = getConnection();
		List<Item> list = new ItemDAO().selectItemList(conn, categoryNo);
		close(conn);
		return list;
	}

	public List<ItemImage> selectItemImageList(int itemNo) {
		Connection conn = getConnection();
		List<ItemImage> list = new ItemDAO().selectItemImageList(conn, itemNo);
		close(conn);
		return list;
	}

	public int itemEnroll(Item item) {
		Connection conn = getConnection();
		int result = new ItemDAO().itemEnroll(conn, item);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
		return result;
	}

}
