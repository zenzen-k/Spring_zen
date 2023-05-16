package movie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	
}
