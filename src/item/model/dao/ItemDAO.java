package item.model.dao;

import static common.JDBCTemplate.close;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import item.model.exception.ItemException;
import item.model.vo.Item;
import item.model.vo.ItemImage;

public class ItemDAO {
	private Properties prop = new Properties();
	
	public ItemDAO() {
		String fileName = ItemDAO.class.getResource("/sql/item/item-query.properties").getPath();
		try {
			prop.load(new FileReader(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Item> selectItemList(Connection conn, String categoryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectItemList");
		List<Item> list = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, categoryNo);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				Item item = new Item();
				item.setItemNo(rset.getInt("item_no"));
				item.setCategoryNo(categoryNo);
				item.setItemStock(rset.getInt("item_stock"));
				item.setItemBrand(rset.getString("item_brand"));
				item.setItemName(rset.getString("item_name"));
				item.setItemPrice(rset.getInt("item_price"));
				item.setItemDesc(rset.getString("item_desc"));
				item.setItemEnrollDate(rset.getDate("item_enroll_date"));
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("상품목록조회 에러!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public List<ItemImage> selectItemImageList(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectItemImageList");
		List<ItemImage> list = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				ItemImage img = new ItemImage();
				img.setItemImageNo(rset.getInt("item_image_no"));
				img.setItemNo(itemNo);
				img.setItemImageTypeNo(rset.getString("item_image_type_no"));
				img.setItemImageDefault(rset.getString("item_image_default"));
				img.setItemImageRenamed(rset.getString("item_image_renamed"));
				list.add(img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException("상품이미지조회 실패!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int enrollItem(Connection conn, Item item) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("enrollItem");
		try {
			//1. prepareStatment객체 생성
			pstmt = conn.prepareStatement(query);
			
			//2.쿼리 실행
			pstmt.setString(1, item.getCategoryNo());
			pstmt.setInt(2, item.getItemStock());
			pstmt.setString(3, item.getItemBrand());
			pstmt.setString(4, item.getItemName());
			pstmt.setInt(5, item.getItemPrice());
			pstmt.setString(6, item.getItemDesc());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectItemLastNo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int itemNo = 0;
		String query = prop.getProperty("itemLastNo");
		System.out.println(query);
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				itemNo = rset.getInt(1);
			}
			System.out.println("itemNo="+itemNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return itemNo;
	}

	public int enrollImage(Connection conn, ItemImage itemImg) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("enrollImage");
		try {
			//1. prepareStatment객체 생성
			pstmt = conn.prepareStatement(query);
			
			//2.쿼리 실행
			pstmt.setInt(1, itemImg.getItemNo());
			pstmt.setString(2, itemImg.getItemImageTypeNo());
			System.out.println("typeNo@dao="+itemImg.getItemImageTypeNo());
			pstmt.setString(3, itemImg.getItemImageDefault());
			pstmt.setString(4, itemImg.getItemImageRenamed());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Item selectOne(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Item item = null;
		String query = prop.getProperty("selectOne");
		System.out.println(query);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				item = new Item();
				item.setItemNo(rset.getInt("item_no"));
				item.setCategoryNo(rset.getString("category_no"));
				item.setItemStock(rset.getInt("item_stock"));
				item.setItemBrand(rset.getString("item_brand"));
				item.setItemName(rset.getString("item_name"));
				item.setItemPrice(rset.getInt("item_price"));
				item.setItemDesc(rset.getString("item_desc"));
				item.setItemEnrollDate(rset.getDate("item_enroll_date"));
			}
			System.out.println("item="+item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return item;
	}

	public int updateItem(Connection conn, Item item) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateItem");
		try {
			//1. prepareStatment객체 생성
			pstmt = conn.prepareStatement(query);
			
			//2.쿼리 실행
			pstmt.setString(1, item.getCategoryNo());
			pstmt.setInt(2, item.getItemStock());
			pstmt.setString(3, item.getItemBrand());
			pstmt.setString(4, item.getItemName());
			pstmt.setInt(5, item.getItemPrice());
			pstmt.setString(6, item.getItemDesc());
			pstmt.setInt(7, item.getItemNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ItemImage selectImageOne(Connection conn, int itemMainImageNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ItemImage itemImg = null;
		String query = prop.getProperty("selectImageOne");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemMainImageNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				itemImg = new ItemImage();
				itemImg.setItemImageNo(rset.getInt("item_image_no"));
				itemImg.setItemNo(rset.getInt("item_no"));
				itemImg.setItemImageTypeNo(rset.getString("item_image_type_no"));
				itemImg.setItemImageDefault(rset.getString("item_image_default"));
				itemImg.setItemImageRenamed(rset.getString("item_image_renamed"));
			}
			System.out.println("itemImg="+itemImg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return itemImg;
	}

	public int updateImage(Connection conn, ItemImage itemImg) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateImage");
		try {
			//1. prepareStatment객체 생성
			pstmt = conn.prepareStatement(query);
			
			//2.쿼리 실행
			pstmt.setString(1, itemImg.getItemImageDefault());
			pstmt.setString(2, itemImg.getItemImageRenamed());
			pstmt.setInt(3, itemImg.getItemImageNo());
			System.out.println(itemImg.getItemImageDefault());
			System.out.println(itemImg.getItemImageRenamed());
			System.out.println(itemImg.getItemImageNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
}
