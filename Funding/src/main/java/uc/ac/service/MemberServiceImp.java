package uc.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.ac.db.MemberDAO;
import uc.ac.vo.CartVO;
import uc.ac.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO dao;

	@Override
	public void join(MemberVO vo) {
		dao.join(vo);

	}

	@Override
	public MemberVO checkMember(String id, String pwd) {

		return dao.checkMember(id, pwd);
	}

	@Override
	public boolean loginCheck(String id, String pwd) {
		return dao.loginCheck(id, pwd);
	}

	@Override
	public List<MemberVO> getAll() {
		return dao.getAll();
		
	}

	@Override
	public List<MemberVO> getVerify() {
		return dao.getVerify();
	}

	@Override
	public void delete(String id) {
	dao.delete(id);

	}

	@Override
	public String checkID(String checkid) {
		return dao.checkID(checkid);
	
	}

	@Override
	public void updateInfo(String nickname, String pwd, String phone, String address, String id) {
		dao.updateInfo(nickname, pwd, phone, address, id);

	}

	@Override
	public void updatePwd(String pwd, String checkid) {
		dao.updatePwd(pwd, checkid);

	}

	@Override
	public List<CartVO> getCart(String id_fk) {
		
		return dao.getCart(id_fk);
	}

}
