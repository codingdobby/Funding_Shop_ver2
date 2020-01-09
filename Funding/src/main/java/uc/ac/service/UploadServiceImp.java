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
	UploadDAO dao;

	@Override
	public List<UploadVO> projectALL() {

		return dao.projectALL();
	}

	@Override
	public List<UploadVO> getAll(String id) {
		return dao.getAll(id);

	}

	
	
	@Override
	public void insertProj(UploadVO vo) {
		dao.insertproj(vo);
	}

	@Override
	public void insertRew(RewardVO vo) {
		dao.insertRew(vo);
		
	}

	@Override
	public int getProject_num_fk(String ptitle) {
		
		return dao.getProject_num_fk(ptitle);
	}

}
