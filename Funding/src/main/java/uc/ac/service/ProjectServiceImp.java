package uc.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.ac.db.ProjectDAO;
import uc.ac.vo.ProdVO;
import uc.ac.vo.ProjectVO;

@Service
public class ProjectServiceImp implements ProjectService {

	@Autowired
	ProjectDAO dao;
	
	
	@Override
	public List<ProjectVO> getAll() {
		
		return dao.getAll();
	}

	@Override
	public List<ProjectVO> getContent(int pnum) {
		
		return dao.getContent(pnum);
	}

	@Override
	public List<ProdVO> getProd(int pnum) {
		
		return dao.getProd(pnum);
		}

	@Override
	public void phitUpdate(int pnum) {
		dao.phitUpdate(pnum);

	}

	@Override
	public List<ProjectVO> getHitItem() {
		
		return dao.getHitItem();
	}

	@Override
	public List<ProjectVO> getNewItem() {
		
		return dao.getNewItem();
	}

	@Override
	public void addCart(int id_fk, int project_num_fk, int prodNum_fk) {
		dao.addCart(id_fk, project_num_fk, prodNum_fk);

	}

	@Override
	public void minusProduct(int prodNum) {
		dao.minusProduct(prodNum);
	}

	@Override
	public void plusMoney(int projectNum) {
		dao.plusMoney(projectNum);

	}

	@Override
	public List<ProjectVO> search(String ptitle) {
		
		return dao.search(ptitle);
	}

	@Override
	public List<ProjectVO> getNewProject() {
		
		return dao.getNewProject();
	}

	@Override
	public List<ProjectVO> getPopularProject() {
		return dao.getPopularProject();
	}

}
