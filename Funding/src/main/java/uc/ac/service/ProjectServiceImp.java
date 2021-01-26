package uc.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.ac.db.ProjectDAO;
import uc.ac.vo.ProductVO;
import uc.ac.vo.ProjectVO;

@Service
public class ProjectServiceImp implements ProjectService {

	@Autowired
	ProjectDAO projectDAO;
	
	
	@Override
	public List<ProjectVO> getAll() {
		
		return projectDAO.getAll();
	}

	@Override
	public List<ProjectVO> getContent(int pnum) {
		
		return projectDAO.getContent(pnum);
	}

	@Override
	public List<ProductVO> getProd(int pnum) {
		
		return projectDAO.getProduct(pnum);
		}

	@Override
	public void phitUpdate(int pnum) {
		projectDAO.phitUpdate(pnum);

	}

	@Override
	public List<ProjectVO> getHitItem() {
		
		return projectDAO.getHitItem();
	}

	@Override
	public List<ProjectVO> getNewItem() {
		
		return projectDAO.getNewItem();
	}

	@Override
	public void addCart(int id_fk, int project_num_fk, int prodNum_fk) {
		projectDAO.addCart(id_fk, project_num_fk, prodNum_fk);

	}

	@Override
	public void minusProduct(int prodNum) {
		projectDAO.minusProduct(prodNum);
	}

	@Override
	public void plusMoney(int projectNum) {
		projectDAO.plusMoney(projectNum);

	}

	@Override
	public List<ProjectVO> search(String ptitle) {
		
		return projectDAO.search(ptitle);
	}

	@Override
	public List<ProjectVO> getNewProject() {
		
		return projectDAO.getNewProject();
	}

	@Override
	public List<ProjectVO> getPopularProject() {
		return projectDAO.getPopularProject();
	}

	@Override
	public void admit(String project_num) {
		 projectDAO.admit(project_num);
		
	}

}
