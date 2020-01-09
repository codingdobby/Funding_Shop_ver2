package uc.ac.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uc.ac.vo.CatVO;


@Component
public class CatDAO {
	@Autowired
	private org.apache.ibatis.session.SqlSession SqlSession;

	String namespace = "mybatis.Category.xml";
	
	public List<CatVO> getCat() {
		
		return SqlSession.selectList(namespace + ".catList");
	}
}
