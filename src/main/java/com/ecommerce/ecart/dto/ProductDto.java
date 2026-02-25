package com.ecommerce.ecart.dto;

import java.util.List;

import com.ecommerce.ecart.entity.ProductImage;
import com.ecommerce.ecart.entity.ProductReview;

public class ProductDto {

     private Long id;
	
     private String name;

     private Double price;

     private String description;
	
	 private String category;

     public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	private Double ratings = 0.0;
	
     private String seller;
 	
 	private Integer stock = 0;
	
     private Integer numOfReviews;
     
   
     private List<ProductImageDto> images;
     
     public List<ProductImageDto> getImages() {
		return images;
	}

	public void setImages(List<ProductImageDto> images) {
		this.images = images;
	}

	private List<ProductReviewDto> reviews;
     
     
	public ProductDto()
	{
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getNumOfReviews() {
		return numOfReviews;
	}

	public void setNumOfReviews(Integer numOfReviews) {
		this.numOfReviews = numOfReviews;
	}

//	public List<ProductImage> getImages() {
//		return images;
//	}
//
//	public void setImages(List<ProductImage> images) {
//		this.images = images;
//	}

	public List<ProductReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(List<ProductReviewDto> reviews) {
		this.reviews = reviews;
	}

	public ProductDto(Long id, String name, Double price, String description, String category, Double ratings, String seller, Integer stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.ratings = ratings;
		this.seller = seller;
		this.stock = stock;
	}
}
