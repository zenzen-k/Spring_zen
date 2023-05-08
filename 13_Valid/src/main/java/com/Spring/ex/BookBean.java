package com.Spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {
	//@NotEmpty(message = "제목 입력 누락") // 공백처리 X(스페이스)
	//@NotNull(message = "제목 입력 누락") // 공백처리 X(스페이스)
	@NotBlank(message = "제목 입력 누락") // 공백처리 O(스페이스)
	private String title;

	@NotEmpty(message = "저자 입력 누락")
	// @Size(min = 5, message = "5글자 이상 입력")
	@Length(min = 5, message = "5글자 이상 입력")
	private String author;

	@NotEmpty(message = "가격 입력 누락")
	@Pattern(regexp = "^[0-9]+$", message = "숫자만 입력 가능")
	@Length(max = 5, message = "5자리 이하로만 입력")
	private String price;

	@NotEmpty(message = "출판사 입력 누락")
	private String publisher;
	
	//@NotEmpty(message = "서점 한개이상 선택2")
	@NotNull(message = "서점 한개이상 선택1")
	//@NotBlank(message = "서점 한개이상 선택3")
	private String bookstore;
	
	//@NotEmpty(message = "배송비 선택1")
	//@NotNull(message = "배송비 선택2")
	@NotBlank(message = "배송비 선택3")
	private String kind;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookstore() {
		return bookstore;
	}

	public void setBookstore(String bookstore) {
		this.bookstore = bookstore;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

}
