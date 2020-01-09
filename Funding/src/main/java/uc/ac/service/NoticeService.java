package uc.ac.service;

import java.util.List;

import uc.ac.vo.NoticeVO;

public interface NoticeService {


		/**************************************************************************/

		public NoticeVO getContent(int no);

		/**************************************************************************/
		public void hitUpdate(int no);

		/**************************************************************************/
		public List<NoticeVO> getAll();

		/**************************************************************************/

		public void noticeInsert(String nTitle, String nContent, String nWriter);

		
		public int cnt();
		
		public List<NoticeVO> listPage(int displayPost, int postNum) throws Exception;
		
		public void noticeDelete(int num);
}
