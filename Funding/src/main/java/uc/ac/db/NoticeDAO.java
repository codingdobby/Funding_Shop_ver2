package uc.ac.db;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uc.ac.vo.NoticeVO;

@Component
public class NoticeDAO {
	@Autowired
	private org.apache.ibatis.session.SqlSession SqlSession;

	String namespace = "mybatis.Notice.xml";

	/**************************************************************************/

	public NoticeVO getContent(int no) {
		return SqlSession.selectOne(namespace + ".getContent", no);
	}

	/**************************************************************************/
	public void hitUpdate(int no) {// 회원1명 DB에 등록
		SqlSession.update(namespace + ".hitUpdate", no);
	}

	/**************************************************************************/
	public List<NoticeVO> getAll() {// namecard table에 있는 모든 레코드를 넘겨줌
		return SqlSession.selectList(namespace + ".getAll");
	}

	/**************************************************************************/

	public void noticeInsert(String ntitle, String nContent, String nWriter) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("nTitle", ntitle);
		data.put("nContent", nContent);
		data.put("nWriter", nWriter);
		SqlSession.insert(namespace + ".noticeInsert", data);
	}

	/**************************************************************************/

	public int cnt() {
		return SqlSession.selectOne(namespace+".cnt");
		
	}
	
	
	// 페이징 + 목록
		public List<NoticeVO> listPage(int displayPost, int postNum) {

			HashMap<String, Integer> data = new HashMap<String, Integer>();
			data.put("displayPost", displayPost);
			data.put("postNum", postNum);

			return SqlSession.selectList(namespace+".listPage", data);

		}
		
		
	public void noticeDelete(int num) {
		 SqlSession.delete(namespace+".noticeDelete",num);
		
	}
	
	
	
	/*
	 * public void projectInsert(String ptitle, int pcategory, String pcontent, int
	 * pmoney, String pwriter, String pdate, String ppic) {// 회원1명 DB에 등록
	 * 
	 * connectDB();//
	 * 
	 * String SQL = "insert into project(ptitle,pcategory,pcontent,pmoney,\r\n" +
	 * "			pwriter,pdate, ppic1) values(?,?,?,?,?,?,?)";
	 * 
	 * try { pstm = conn.prepareStatement(SQL); pstm.setString(1, ptitle);
	 * pstm.setInt(2, pcategory);// tel); pstm.setString(3, pcontent);// company);
	 * pstm.setInt(4, pmoney); pstm.setString(5, pwriter);// tel); pstm.setString(6,
	 * pdate);// company); pstm.setString(7, ppic);
	 * 
	 * pstm.executeUpdate(); // insert, update, delete 문에 사용 } catch (SQLException
	 * e) { e.printStackTrace(); } closeDB(); }
	 */

}
