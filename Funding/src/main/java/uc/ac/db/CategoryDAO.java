package uc.ac.db;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uc.ac.vo.CategoryVO;

@Component
public class CategoryDAO {
	@Autowired
	private org.apache.ibatis.session.SqlSession SqlSession;

	String namespace = "mybatis.Category.xml";

	public List<CategoryVO> getCategory() {

		return SqlSession.selectList(namespace + ".catList");
	}
}
