package album.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
	public List<AlbumBean> getAlbumList(){
		
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList(namespace + ".GetAlbumList"); // select ���� ArrayList �� �������� �޼���  
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
}
