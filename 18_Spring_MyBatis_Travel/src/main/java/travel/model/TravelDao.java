package travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myTravelDao")
public class TravelDao {
	
	private String namespace = "travel.TravelBean"; // mapper

	@Autowired
	SqlSessionTemplate sqlSessionTemplate; // 계정접속정보 주입(root-context.xml)
	
	public TravelDao() {
		System.out.println("TravelDao()");
	}

	public List<TravelBean> getAllTravel(Paging pageInfo, Map<String, String> map) {
		
		// 몇개를 건너뛰고 몇개를 가져와야하는지 레코드 번호에 관한
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		// 내가 선택한게 17이라면 한페이지에 3개씩 ,
		System.out.println(pageInfo.getOffset()); // 건너뛸거 : 48개
		System.out.println(pageInfo.getLimit()); // 가져올거 : 3 (49, 50, 51)
		// 만약에 총 97개면 48개 건너뛰고 49번째부터 3개 가져온다!
		
		List<TravelBean> lists = new ArrayList<TravelBean>();
		lists = sqlSessionTemplate.selectList(namespace + ".GetTravelList", map , rowBounds);
		return lists;
	}

	public int insertTravel(TravelBean travelBean) {
		int cnt = -1;
		
		try {
			cnt = sqlSessionTemplate.insert(namespace + ".InsertTravel", travelBean);
		}catch (DataAccessException e) { // 예외처리. 에러메세지가 생각이 안나면 Exception 
			System.out.println("Dao insertTravel cnt : " + cnt);
		}
		return cnt;
	}

	public int getTotalCount(Map<String, String> map) {
		return sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
	}

	public TravelBean getTravelByNum(int num) {
		TravelBean travel = sqlSessionTemplate.selectOne(namespace + ".GetDetailTrave", num);
		return travel;
	}
	
}

