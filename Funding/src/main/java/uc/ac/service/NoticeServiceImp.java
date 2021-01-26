package uc.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.ac.db.NoticeDAO;
import uc.ac.vo.NoticeVO;

@Service
public class NoticeServiceImp implements NoticeService {

	@Autowired
	NoticeDAO noticeDAO;

	@Override
	public NoticeVO getContent(int no) {

		return noticeDAO.getContent(no);
	}

	@Override
	public void hitUpdate(int no) {
		noticeDAO.hitUpdate(no);

	}

	@Override
	public List<NoticeVO> getAll() {

		return noticeDAO.getAll();
	}

	@Override
	public void noticeInsert(String nTitle, String nContent, String nWriter) {
		noticeDAO.noticeInsert(nTitle, nContent, nWriter);

	}

	@Override
	public int cnt() {
		return noticeDAO.cnt();

	}

	@Override
	public List<NoticeVO> listPage(int displayPost, int postNum) throws Exception {
		return noticeDAO.listPage(displayPost, postNum);

	}

	@Override
	public void noticeDelete(int num) {
		noticeDAO.noticeDelete(num);

	}

}
