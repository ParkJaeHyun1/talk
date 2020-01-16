package com.phonefo.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phonefo.admin.domain.SearchCriteria;
import com.phonefo.board.domain.BoardVO;
import com.phonefo.board.persistence.BoardDAO;
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession sqlSession;	
	
	@Override
	public List<BoardVO> selectlist(SearchCriteria cri, int tno) throws Exception {
		return sqlSession.selectList("board.selectlist",tno,
		        new RowBounds(cri.getPageStart(), cri.getPerPageNum()) );
	}
	@Override
	public int listCount(int tno) throws Exception {		
		return sqlSession.selectOne("board.listcount",tno);
	}
	@Override
	public void insert(BoardVO board) throws Exception {		
		sqlSession.selectOne("board.insert",board);
	}
	@Override
	public String selecttitle(int tno) throws Exception {
		return sqlSession.selectOne("board.selecttitle",tno);
	}
	@Override
	public BoardVO selectpage(int bno) {
		return sqlSession.selectOne("board.selectpage", bno);
	}
}
