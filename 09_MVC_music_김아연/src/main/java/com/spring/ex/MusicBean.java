package com.spring.ex;

public class MusicBean {
	private String title;
	private String singer;
	private int price;

	public MusicBean() {
		super();
		System.out.println("MusicBean()");
	}

	public MusicBean(String title, String singer, int price) {
		super();
		this.title = title;
		this.singer = singer;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		System.out.println("setTitle()");
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
		System.out.println("setSinger()");
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		System.out.println("setPrice()");
	}

}
