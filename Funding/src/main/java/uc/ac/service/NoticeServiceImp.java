package uc.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.ac.db.NoticeDAO;
import uc.ac.vo.NoticeVO;

@Service
public class NoticeServiceImp implements NoticeService {

	@Autowired
	NoticeDAO dao;

	@Override
	public NoticeVO getContent(int no) {

		return dao.getContent(no);
	}

	@Override
	public void hitUpdate(int no) {
		dao.hitUpdate(no);

	}

	@Override
	public List<NoticeVO> getAll() {

		return dao.getAll();
	}

	@Override
	public void noticeInsert(String nTitle, String nContent, String nWriter) {
		dao.noticeInsert(nTitle, nContent, nWriter);

	}

	@Override
	public int cnt() {
		return dao.cnt();

	}

	@Override
	public List<NoticeVO> listPage(int displayPost, int postNum) throws Exception {
		return dao.listPage(displayPost, postNum);

	}

	@Override
	public void noticeDelete(int num) {
		dao.noticeDelete(num);
		
	}

}
