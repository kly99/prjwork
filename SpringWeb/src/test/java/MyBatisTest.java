import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import pbean.Board;


public class MyBatisTest {

	@Test // 아래 메소드를 테스트 하겠다.
	public void testList() throws IOException {
		String resource = "mybatis/Configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlMapper.openSession();
		List<Board> list = session.selectList("dao.BoardDAO.getBoardList");
		
		// for이취문 board 가 list일때 (참) 실행문
		for(Board board : list){
			System.out.println(board.getNum()+ " " + board.getTitle());
		}
		session.close();
	}
}
