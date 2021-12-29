package sec07;

import java.util.Date;

public class BookVO {
	private String no;
	private String name;
	private String author;
	private int price;
	private String date;
	private String pubNo;
	
	public BookVO() {}

	public BookVO(String no, String name, String author, int price, String date, String pubNo) {
		super();
		this.no = no;
		this.name = name;
		this.author = author;
		this.price = price;
		this.date = date;
		this.pubNo = pubNo;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPubNo() {
		return pubNo;
	}

	public void setPubNo(String pubNo) {
		this.pubNo = pubNo;
	}
	

}