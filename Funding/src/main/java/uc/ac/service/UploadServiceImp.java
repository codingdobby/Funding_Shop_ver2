package uc.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.ac.db.UploadDAO;
import uc.ac.vo.RewardVO;
import uc.ac.vo.UploadVO;

@Service
public class UploadServiceImp implements UploadService {

	@Autowired
	UploadDAO uploadDAO;

	@Override
	public List<UploadVO> projectALL() {

		return uploadDAO.projectALL();
	}

	@Override
	public List<UploadVO> getAll(String id) {
		return uploadDAO.getAll(id);

	}

	@Override
	public void insertProject(UploadVO vo) {
		uploadDAO.insertProject(vo);
	}

	@Override
	public void insertReward(RewardVO vo) {
		uploadDAO.insertReward(vo);

	}

	@Override
	public int getProject_num_fk(String ptitle) {

		return uploadDAO.getProject_num_fk(ptitle);
	}

}
