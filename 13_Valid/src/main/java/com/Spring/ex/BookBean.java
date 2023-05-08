package com.Spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {
	//@NotEmpty(message = "���� �Է� ����") // ����ó�� X(�����̽�)
	//@NotNull(message = "���� �Է� ����") // ����ó�� X(�����̽�)
	@NotBlank(message = "���� �Է� ����") // ����ó�� O(�����̽�)
	private String title;

	@NotEmpty(message = "���� �Է� ����")
	// @Size(min = 5, message = "5���� �̻� �Է�")
	@Length(min = 5, message = "5���� �̻� �Է�")
	private String author;

	@NotEmpty(message = "���� �Է� ����")
	@Pattern(regexp = "^[0-9]+$", message = "���ڸ� �Է� ����")
	@Length(max = 5, message = "5�ڸ� ���Ϸθ� �Է�")
	private String price;

	@NotEmpty(message = "���ǻ� �Է� ����")
	private String publisher;
	
	//@NotEmpty(message = "���� �Ѱ��̻� ����2")
	@NotNull(message = "���� �Ѱ��̻� ����1")
	//@NotBlank(message = "���� �Ѱ��̻� ����3")
	private String bookstore;
	
	//@NotEmpty(message = "��ۺ� ����1")
	//@NotNull(message = "��ۺ� ����2")
	@NotBlank(message = "��ۺ� ����3")
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
