
public class Book implements Comparable {
	private String bookName, authorName, publishDate;
	private int pageCount;
	
	public Book(String bookName, String authorName, String publishDate, int pageCount) {
		
		this.bookName = bookName;
		this.authorName = authorName;
		this.publishDate = publishDate;
		this.pageCount = pageCount;
	}
	
	@Override
	public int compareTo(Object arg0) {
		Book b = (Book)arg0;
		return this.bookName.compareTo(b.bookName);
	}
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	
	

}
