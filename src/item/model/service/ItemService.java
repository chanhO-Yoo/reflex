package item.model.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import item.model.dao.ItemDAO;
import item.model.vo.Item;
import item.model.vo.ItemImage;
import item.model.vo.ItemQna;
import item.model.vo.ItemQnaAns;

public class ItemService {

	public List<Item> selectItemAll(String categoryNo, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Item> list = new ItemDAO().selectItemAll(conn, categoryNo, cPage, numPerPage);
		close(conn);
		return list;
	}

	public List<ItemImage> selectItemImageList(int itemNo) {
		Connection conn = getConnection();
		List<ItemImage> list = new ItemDAO().selectItemImageList(conn, itemNo);
		close(conn);
		return list;
	}

	public int selectTotalContent(String categoryNo) {
		Connection conn = getConnection();
		int totalContent = new ItemDAO().selectTotalContent(conn, categoryNo);
		close(conn);
		return totalContent;
	}

	public List<Item> selectItemAllByLowPrice(String categoryNo, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Item> list = new ItemDAO().selectItemAllByLowPrice(conn, categoryNo, cPage, numPerPage);
		close(conn);
		return list;
	}

	public Item selectItemOne(int itemNo) {
		Connection conn = getConnection();
		Item item = new ItemDAO().selectItemOne(conn, itemNo);
		close(conn);
		return item;
	}

	public int insertItemQna(Map<String, Object> paramMap) {
		Connection conn = getConnection();
		int result = new ItemDAO().insertItemQna(conn, paramMap);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<ItemQna> selectItemQnaAll() {
		Connection conn = getConnection();
		List<ItemQna> qnaList = new ItemDAO().selectItemQnaAll(conn);
		close(conn);
		return qnaList;
	}

	public ItemQnaAns selectIteQnaAnsOne(int itemQnaNo) {
		Connection conn = getConnection();
		ItemQnaAns qnaAns = new ItemDAO().selectIteQnaAnsOne(conn, itemQnaNo);
		close(conn);
		return qnaAns;
	}

	public int selectItemQnaCount() {
		Connection conn = getConnection();
		int totalContent = new ItemDAO().selectItemQnaCount(conn);
		close(conn);
		return totalContent;
	}


}
