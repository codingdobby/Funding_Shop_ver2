package uc.ac.service;

import java.util.List;

import uc.ac.vo.RewardVO;
import uc.ac.vo.UploadVO;

public interface UploadService {
	public List<UploadVO> projectALL();
	public List<UploadVO> getAll(String id);
	public void insertProject(UploadVO vo);
	
	//상품 정보 넣기
	public void insertReward(RewardVO vo);
	public int getProject_num_fk(String ptitle);
}
