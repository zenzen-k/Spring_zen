package utility;

public class Paging {
	//����¡ ���� ����	
	private int totalCount = 0 ; //�� ���ڵ� �Ǽ�
	private int totalPage = 0 ; //��ü ������ ��
	private int pageNumber = 0 ; //������ ������ �ѹ�(ǥ�� ������ �������� 1���� totalPage�����̴�.)
	private int pageSize = 0 ; //�� �������� ������ �Ǽ�
	private int beginRow = 0 ; //���� �������� ���� ��
	private int endRow = 0 ; //���� �������� �� ��
	private int pageCount = 3 ; // �� ȭ�鿡 ������ ������ ��ũ �� (������ ����) [1][2][3] [����] �̷���
	private int beginPage = 0 ; //����¡ ó�� ���� ������ ��ȣ
	private int endPage = 0 ; //����¡ ó�� �� ������ ��ȣ
	private int offset = 0 ;
	private int limit = 0 ;
	private String url = "" ; //���� ==>  http://localhost:8989/MyServlet/list.do
	private String pagingHtml = "";//�ϴ��� ���� ������ ��ũ
	//private String pagingStatus = ""; //��� ������ ���� ������ ��ġ ǥ��
	//�˻��� ���� ���� �߰�
	private String whatColumn = "" ; //�˻� ���(�ۼ���, ������, ��ü �˻��� all) ���
	private String keyword = "" ; //�˻��� �ܾ� 

	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getBeginRow() {
		return beginRow;
	}


	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public int getBeginPage() {
		return beginPage;
	}


	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getPagingHtml() {
		System.out.println("pagingHtml:"+pagingHtml);
		
		return pagingHtml;
//		pagingHtml:
//			&nbsp;<font color='red'>1</font>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=2&pageSize=2&whatColumn=null&keyword=null'>2</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=3&pageSize=2&whatColumn=null&keyword=null'>3</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=4&pageSize=2&whatColumn=null&keyword=null'>4</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=5&pageSize=2&whatColumn=null&keyword=null'>5</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=6&pageSize=2&whatColumn=null&keyword=null'>6</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=7&pageSize=2&whatColumn=null&keyword=null'>7</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=8&pageSize=2&whatColumn=null&keyword=null'>8</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=9&pageSize=2&whatColumn=null&keyword=null'>9</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=10&pageSize=2&whatColumn=null&keyword=null'>10</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=11&pageSize=2&whatColumn=null&keyword=null'>����</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=22&pageSize=2&whatColumn=null&keyword=null'>�� ��</a>&nbsp;

	}


	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}


	public String getWhatColumn() {
		return whatColumn;
	}


	public void setWhatColumn(String whatColumn) {
		this.whatColumn = whatColumn;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	// ������
	public Paging(
			String _pageNumber, 
			String _pageSize,  
			int totalCount,
			String url, 
			String whatColumn, 
			String keyword,
			String whologin) {		

		if(  _pageNumber == null || _pageNumber.equals("null") || _pageNumber.equals("")  ){
			
			System.out.println("_pageNumber:"+_pageNumber); // null
			_pageNumber = "1" ;
		}
		this.pageNumber = Integer.parseInt( _pageNumber ) ; 

		if( _pageSize == null || _pageSize.equals("null") || _pageSize.equals("") ){
			_pageSize = "3" ; // �� �������� ������ ���ڵ� ���� -> ���⼭ �����ص� �ǰ� ��Ʈ�ѷ����� �����ںθ��� �ص� ����
		}		
		this.pageSize = Integer.parseInt( _pageSize ) ;
		
		this.limit = pageSize ; // �� �������� ������ ���ڵ� ����

		this.totalCount = totalCount ; 

		this.totalPage = (int)Math.ceil((double)this.totalCount / this.pageSize) ;
		// ceil ������ �ø� -> 10/3 = 3.333333 -> 4�� ���´�.
		
		
		/*
			pageNumber : 2
			pageSize : 3 // ���Ծ���
			beginRow : 4 -> ���۷��ڵ��ȣ�ε�
			endRow : 6 -> ��
			
			���� 1������ Ŭ���ϸ� 
			pageNumber : 1
			pageSize : 3 // ���Ծ���
			beginRow : 1
			endRow : 3
		*/
		this.beginRow = ( this.pageNumber - 1 )  * this.pageSize  + 1 ;
		this.endRow =  this.pageNumber * this.pageSize ;
		
		// ������ �������� 3�������� �ϳ��� ���ڵ尡 �ִٰ� ��������.
		// �׷��� ������ ���ڵ带 �����ϸ� �ٽ� 2�������� ������ . �װſ� ���� ���
		if( this.pageNumber > this.totalPage ){
			this.pageNumber = this.totalPage ;
		}
		
		// ���� ���� ������ ��������(pageNumber) : 3
		// (3-1)*3 = 6 (offset)
		// 1������ : 0 (offset)
		// 2������ : 3 (offset)
		// ��, offset�� �ǳʶ� ���ڵ���� ���Ѵ�
		// -> 1�������� �����ϸ� 0�̹Ƿ� �ǳʶ� ���� ���� 1��° ���ڵ���� �����´�.
		// -> 2�������� �����ϸ� �ǳʶ� ���ڵ尡 3�̹Ƿ� 3�� �ǳʶ� �� 4��° ���ڵ���� �����´�.
		// -> 3�������� �����ϸ� �ǳ� �� ���ڵ尡 6�̹Ƿ� 6�� �ǳʶ� �� 7��° ���ڵ���� �����´�.
		this.offset = ( pageNumber - 1 ) * pageSize ; 
		// �߿�!!!
		
		// ���� ��ü ���ڵ尡 5���� 2���������� 4�� 5�� �����ָ� ������ �������� ���°��� 6�̴�.
		// �׷��� �ٲٴ°�
		if( this.endRow > this.totalCount ){
			this.endRow = this.totalCount  ;
		}
		
		// ( 5 - 1 ) / 3 * 3 + 1 = 1 * 3 + 1 = 4(beginPage)
		// 4 + 3 - 1 = 6(endPage)
		this.beginPage = ( this.pageNumber - 1 ) / this.pageCount * this.pageCount + 1  ;
		this.endPage = this.beginPage + this.pageCount - 1 ;
		
		System.out.println("pageNumber:"+pageNumber+"/totalPage:"+totalPage);	
		
		// ���� ���� �������� ���ü��־ �׷��� �ٲٶ�� �ǹ� 
		if( this.endPage > this.totalPage ){
			this.endPage = this.totalPage ;
		}
		
		System.out.println("pageNumber2:"+pageNumber+"/totalPage2:"+totalPage);	
		this.url = url ; //  /ex/list.ab
		this.whatColumn = whatColumn ;
		this.keyword = keyword ;
		System.out.println("whatColumn:"+whatColumn+"/keyword:"+keyword);
		
		// url�� �ѱ��. ���� �Ѿ�� ���� �ʿ��� ���ڿ��� ��������°���!!!
		// 1 2 3 [����] �̷���!
		this.pagingHtml = getPagingHtml(url) ;
	
	}
	
	private String getPagingHtml( String url ){ //����¡ ���ڿ��� �����.
		System.out.println("getPagingHtml url:"+url); 
		// getPagingHtml url:/ex/list.ab
		
		String result = "" ;
		String added_param = "&whatColumn=" + whatColumn + "&keyword=" + keyword ; // &whatColumn=singer&keyword=��
		
		// ������������ 1�� �ƴϸ� �������� ���� �������� �ʿ��ϴ� ���� �ش�Ǵ� ��ũ�� ����
		if (this.beginPage != 1) { // ����, pageSize:�� ȭ�鿡 ���̴� ���ڵ� ��
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + ( 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>�� ó��</a>&nbsp;" ;
			result += "&nbsp;<a href='" + url 
					+ "?pageNumber=" + (this.beginPage - 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>����</a>&nbsp;" ;
		}
		
		//���
		// ���� ���� �̾� ���������� ������ ���������� �������� ������!!
		for (int i = this.beginPage; i <= this.endPage ; i++) {
			if ( i == this.pageNumber ) {
				result += "&nbsp;<font color='red'>" + i + "</font>&nbsp;"	;
						
			} else {
				
//				<a href='/ex/list/ab?pageNumber=3&pageSize=3&whatColumn=null&keyword=null'>
				// ��ó�� ��ũ������ ���ڿ��� ������ �Ǵ°��̴�
				result += "&nbsp;<a href='" + url   
						+ "?pageNumber=" + i + "&pageSize=" + this.pageSize 
						+ added_param + "'>" + i + "</a>&nbsp;" ;
				
			}
		}
		
		System.out.println("result:"+result); 
		System.out.println();
		
		if ( this.endPage != this.totalPage) { // ����
			
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + (this.endPage + 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>����</a>&nbsp;" ;
			
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + (this.totalPage ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>�� ��</a>&nbsp;" ;
		}		
		System.out.println("result2:"+result);
		// result2 : <a href='/ex/list.ab?pageNumber=1&pageSize=2'>�� ó��</a>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=3&pageSize=2&whatColumn=null&keyword=null'>����</a>&nbsp;&nbsp;<font color='red'>4</font>&nbsp;&nbsp;<a href='/ex/list.ab?pageNumber=5&pageSize=2&whatColumn=null&keyword=null'>5</a>&nbsp;
		// �� �����մ°� list.jsp �� �ؿ� ��������
		
		return result ;
	}	
	
}

