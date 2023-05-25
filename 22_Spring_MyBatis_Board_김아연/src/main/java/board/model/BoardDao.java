package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	private String namespace="board.BoardBean";
	
	public int getTotalCount(Map<String, String> map) {
		int count = sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
		return count;
	}

	public List<BoardBean> getBoardList(Map<String, String> map, Paging pageInfo) {
		List<BoardBean> lists = new ArrayList<BoardBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace + ".GetBoardList", map, rowBounds);
		return lists;
	}

	public int insertBoard(BoardBean board) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".InsertBoard", board);
		return 0;
	}

	public BoardBean getOneBoard(int num) {
		BoardBean board = sqlSessionTemplate.selectOne(namespace + ".GetOneBoard", num);
		return board;
	}

	public void updateCount(int num) {
		sqlSessionTemplate.update(namespace + ".UpdateCount", num);
	}

	public int updateBoard(BoardBean board) {
		int cnt= -1;
		cnt = sqlSessionTemplate.update(namespace + ".UpdateBoard", board);
		return cnt;
	}

	public int deleteBoard(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".DeleteBoard", num);
		return cnt;
	}

	public int replyUpdateBoard(BoardBean board) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".ReplyUpdateBoard", board);
		return cnt;
	}

	public void replyInsertBoard(BoardBean board) {
		int cnt = sqlSessionTemplate.insert(namespace + ".ReplyInsertBoard", board);
		System.out.println("reply cnt : " + cnt);
	}
	
	
}
