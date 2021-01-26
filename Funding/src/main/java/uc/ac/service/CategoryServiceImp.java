package uc.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.ac.db.CategoryDAO;
import uc.ac.vo.CategoryVO;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public List<CategoryVO> getCategory() {

		return categoryDAO.getCategory();
	}

}
