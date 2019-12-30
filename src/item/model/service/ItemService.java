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
		System.out.println("ListImg@Service="+list);
		close(conn);
		return list;
	}

	public int enrollItem(Item item) {
		Connection conn = getConnection();
		int result = new ItemDAO().enrollItem(conn, item);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
		return result;
	}

	public int selectItemLastNo() {
		Connection conn = getConnection();
		int itemNo = new ItemDAO().selectItemLastNo(conn);
		
		return itemNo;
	}

	public int enrollImage(ItemImage itemImg) {
		Connection conn = getConnection();
		int result = new ItemDAO().enrollImage(conn,itemImg);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
		return result;
	}

	public Item selectOne(int itemNo) {
		Connection conn = getConnection();
		Item item = new ItemDAO().selectOne(conn,itemNo);
		
		return item;
	}

	public int updateItem(Item item) {
		Connection conn = getConnection();
		int result = new ItemDAO().updateItem(conn, item);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
		return result;
	}

	public ItemImage selectImageOne(int itemMainImageNo) {
		Connection conn = getConnection();
		ItemImage itemImg = new ItemDAO().selectImageOne(conn,itemMainImageNo);
		
		return itemImg;
	}

	public int updateImage(ItemImage itemImg) {
		Connection conn = getConnection();
		int result = new ItemDAO().updateImage(conn, itemImg);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
		return result;
	}

	public int deleteItem(int itemNo) {
		Connection conn = getConnection();
		int result = new ItemDAO().deleteItem(conn, itemNo);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
		return result;
	}

}
