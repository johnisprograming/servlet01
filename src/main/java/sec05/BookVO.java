package sec05;

import java.util.Date;

public class BookVO {
	private String bookNo;
	private String bookName;
	private String bookAuthor;
	private int bookPrice;
	private Date booDate;
	private String pubNo;
	
	
	public BookVO() {}


	public BookVO(String bookNo, String bookName, String bookAuthor, int bookPrice, Date booDate, String pubNo) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.booDate = booDate;
		this.pubNo = pubNo;
	}


	public String getBookNo() {
		return bookNo;
	}


	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public int getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}


	public Date getBooDate() {
		return booDate;
	}


	public void setBooDate(Date booDate) {
		this.booDate = booDate;
	}


	public String getPubNo() {
		return pubNo;
	}


	public void setPubNo(String pubNo) {
		this.pubNo = pubNo;
	}


}
