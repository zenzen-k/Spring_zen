package member.model;

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
public class MemberDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	private String namespace = "member.model.Member";
	
	public int insertMember(MemberBean member) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".InsertMember", member);
		return cnt;
	}

	public int getTotalCount(Map<String, String> map) {
		int count = sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
		return count;
	}

	public List<MemberBean> getMemberList(Map<String, String> map, Paging pageInfo) {
		List<MemberBean> lists = new ArrayList<MemberBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace + ".GetMemberList", map, rowBounds);
		return lists;
	}

	public int deleteMember(String id) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".DeleteMember", id);
		return cnt;
	}

	public MemberBean getOneMember(String id) {
		MemberBean member = sqlSessionTemplate.selectOne(namespace + ".GetOneMember", id);
		return member;
	}

	public int updateMember(MemberBean member) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace + ".UpdateMember", member);
		}catch (DataAccessException e) {
			System.out.println("수정실패 : " + cnt);
		}
		return 0;
	}

}
