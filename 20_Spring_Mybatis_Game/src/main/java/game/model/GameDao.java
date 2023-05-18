package game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class GameDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	private String namespace = "game.GameBean";
	public List<GameBean> getGameList(Map<String, String> map, Paging pageInfo) {
		List<GameBean> lists = new ArrayList<GameBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		
		lists = sqlSessionTemplate.selectList(namespace + ".GetGameList", map, rowBounds);
		return lists;
	}
	
	public int getTotalCount(Map<String, String> map) {
		int count = sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
		return count;
	}
	
	public int insertGame(GameBean game) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace + ".InsertGame", game);
		}catch (DataAccessException e) {
			System.out.println("등록 실패 : " + cnt);
		}
		return cnt;
	}

	public GameBean getOneGame(int num) {
		GameBean game = sqlSessionTemplate.selectOne(namespace + ".GetOneGame", num);
		return game;
	}

	public int deleteGame(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".DeleteGame", num);
		return 0;
	}

	public boolean gameTitleCheck(String inputTitle) {
		int count = sqlSessionTemplate.selectOne(namespace + ".GameTitleCheck", inputTitle);
		boolean result;
		if(count == 0) { // 등록가능함
			result = false;
		}else {
			result = true;
		}
		return result;
	}

	public int updateGame(GameBean game) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace + ".UpdateGame", game);
		}catch (DataAccessException e) {
			System.out.println("수정실패" + cnt);
		}
		return cnt;
	}
}
