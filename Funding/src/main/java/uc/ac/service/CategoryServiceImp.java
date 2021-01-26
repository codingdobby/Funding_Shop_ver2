package uc.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.ac.db.CatDAO;
import uc.ac.vo.CatVO;

@Service
public class CatServiceImp implements CatService {
	@Autowired
	CatDAO dao;

	@Override
	public List<CatVO> getCat() {

		return dao.getCat();
	}

}
