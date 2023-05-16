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
	SqlSessionTemplate sqlSessionTemplate; // ������������ ����(root-context.xml)
	
	public TravelDao() {
		System.out.println("TravelDao()");
	}

	public List<TravelBean> getAllTravel(Paging pageInfo, Map<String, String> map) {
		
		// ��� �ǳʶٰ� ��� �����;��ϴ��� ���ڵ� ��ȣ�� ����
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		// ���� �����Ѱ� 17�̶�� ���������� 3���� ,
		System.out.println(pageInfo.getOffset()); // �ǳʶ۰� : 48��
		System.out.println(pageInfo.getLimit()); // �����ð� : 3 (49, 50, 51)
		// ���࿡ �� 97���� 48�� �ǳʶٰ� 49��°���� 3�� �����´�!
		
		List<TravelBean> lists = new ArrayList<TravelBean>();
		lists = sqlSessionTemplate.selectList(namespace + ".GetTravelList", map , rowBounds);
		return lists;
	}

	public int insertTravel(TravelBean travelBean) {
		int cnt = -1;
		
		try {
			cnt = sqlSessionTemplate.insert(namespace + ".InsertTravel", travelBean);
		}catch (DataAccessException e) { // ����ó��. �����޼����� ������ �ȳ��� Exception 
			System.out.println("Dao insertTravel cnt : " + cnt);
		}
		return cnt;
	}

	public int getTotalCount(Map<String, String> map) {
		return sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
	}

	public TravelBean getTravelByNum(int num) {
		System.out.println("dao num : " + num);
		TravelBean travel = sqlSessionTemplate.selectOne(namespace + ".GetDetailTrave", num);
		return travel;
	}

	public int updateTravel(TravelBean travelBean) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace + ".UpdateTravel", travelBean);
		}catch (DataAccessException e) { 
			System.out.println("Dao updateTravel cnt : " + cnt);
		}
		return cnt;
	}

	public int deleteTravel(int num) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.delete(namespace + ".DeleteTravel", num);
		}catch (DataAccessException e) { 
			System.out.println("Dao deleteTravel cnt : " + cnt);
		}
		return cnt;
	}
	
}

