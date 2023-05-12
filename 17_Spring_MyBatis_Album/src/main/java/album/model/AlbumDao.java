package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;


// AlbumDao myAlbumDao = new AlbumDao();
@Component("myAlbumDao")
public class AlbumDao {
	
	// mapperȭ��, �� album.xml; �� �ִ� namespace �Ӽ��� �� album.AlbumBean �Ȱ��� �ۼ�
	private String namespace = "album.AlbumBean";
	
	// root-context.xml�� �� �������� ���� SqlSessionTemplate ��ü�� �����߾���.
	// ���� ���⼭ ���� �����ϴ� ���� �ƴ�, �Ʊ� ���� ��ü�� ���⿡ �����ؾ��Ѵ�. - @Autowired ������̼� �����
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; // � ������ �����ؾ��ϴ����� ���� ����
	
	public AlbumDao() {
		System.out.println("AlbumDao()");
	}
	
	
	// 
	public List<AlbumBean> getAlbumList(Paging pageInfo , Map<String, String> map){
		
		
		// ����¡ ����
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		// new RowBounds(�ǳʶ� ���ڵ� ��, ������ ���ڵ� ��);
		
		System.out.println("offset : " + pageInfo.getOffset());
		System.out.println("limit : " + pageInfo.getLimit()); // pageSize � ��������
		
		
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList(namespace + ".GetAlbumList", map, rowBounds); // select ���� ArrayList �� �������� �޼���  
		// album.AlbumBean.GetAlbumList -> namespace + id �������� �ִ°Ÿ� ���̵�. �� ���̵�� GetAlbumList
		// ���ӽ����̽��� album.AlbumBean �� ���� ȭ���� ã�ư���. (album.xml)
		
		
		System.out.println("lists.size() : " + lists.size());
		return lists;
	}
	
	public int insertAlbum(AlbumBean album) {
		int cnt = -1;
		// �Է��� ���� �Ѱܾ� �ϱ� ������ album
		cnt = sqlSessionTemplate.insert(namespace + ".InsertAlbum", album); // namespace : album.AlbumBean
		return cnt;
		// ��Ʈ�ѷ��� �Ѿ.
	}
	
	public int deleteAlbum(String num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".DeleteAlbum", num);
		return cnt;
	}
	
	public AlbumBean getAlbumByNum(int num) {
		// �ϳ��� �����´�!
		AlbumBean album = sqlSessionTemplate.selectOne(namespace + ".GetAlbumByNum", num);
		return album;
	}

	
	public int updateAlbum(AlbumBean album) {
		System.out.println("update �޼���");
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace + ".UpdateAlbum", album);
			System.out.println("update cnt : " + cnt);
		}catch (DataAccessException e) {
			System.out.println("���ܹ߻�");
		}
		return cnt;
	}

	// ��ü ���ڵ� ��
	public int getTotalCount(Map<String, String> map) {
		int totalcount = sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
		return totalcount;
	}
	
}
