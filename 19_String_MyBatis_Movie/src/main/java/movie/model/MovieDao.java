package movie.model;

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
public class MovieDao {
	
	private String namespace = "movie.MovieBean";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private MovieDao() {
		System.out.println("MovieDao()");
	}

	public List<MovieBean> getMovieList(Paging pageInfo, Map<String, String> map) {
		List<MovieBean> list = new ArrayList<MovieBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		list = sqlSessionTemplate.selectList(namespace + ".GetMovieList", map, rowBounds);
		return list;
	}

	public int getTotalCount(Map<String, String> map) {
		int count = sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
		System.out.println("count : " + count);
		return count;
	}

	public int insertMovie(MovieBean movie) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace + ".InsertMovie", movie);
		} catch (DataAccessException e) {
			System.out.println("DataAccessException");
		}
		System.out.println("Dao insertMovie cnt : " + cnt);
		
		return cnt;
	}
	
	public boolean searchTitle(String title) {
		int count = sqlSessionTemplate.selectOne(namespace + ".SearchTitle", title);
		if(count == 0)
			return false; // 존재안함
		else
			return true; // 이미 존재
	}
	
	public MovieBean getOneMovie(int num) {
		MovieBean movie = sqlSessionTemplate.selectOne(namespace + ".GetOneMovie", num);
		return movie;
	}

	public int deleteMovie(int num) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.delete(namespace + ".DeleteMovie", num);
		}catch (DataAccessException e) {
			System.out.println("삭제실패 : " + cnt);
		}
		return cnt;
	}
	
}
