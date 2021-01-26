package uc.ac.service;

import java.util.List;

import uc.ac.vo.NoticeVO;

public interface NoticeService {

	// 공지 내용 가져오기
	public NoticeVO getContent(int no);

	// 조회수 +1
	public void hitUpdate(int no);

	// 공지 전부 조회
	public List<NoticeVO> getAll();

	// 공지 작성
	public void noticeInsert(String nTitle, String nContent, String nWriter);

	public int cnt();

	public List<NoticeVO> listPage(int displayPost, int postNum) throws Exception;

	// 공지 삭제
	public void noticeDelete(int num);
}
