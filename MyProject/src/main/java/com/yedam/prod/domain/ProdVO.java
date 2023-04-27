package com.yedam.prod.domain;

import lombok.Data;

@Data
public class ProdVO {
	private int id;
	private String name;
	private String explain;
	private int price;
	private int discount;
	private int rating;
	private String image;
}
