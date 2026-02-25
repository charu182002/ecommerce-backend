package com.ecommerce.ecart.service;

import com.ecommerce.ecart.dto.ProductImageDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ecommerce.ecart.dto.ProductDto;
import com.ecommerce.ecart.dto.ProductReviewDto;
import com.ecommerce.ecart.entity.Product;
import com.ecommerce.ecart.entity.ProductReview;
import com.ecommerce.ecart.repository.ProductRepository;
import com.ecommerce.ecart.repository.ProductReviewRepository;
import com.ecommerce.ecart.spec.ProductSpecification;

@Service
public class ProductService {
	
	   @Autowired
       private ProductRepository productRepository;
	   
	   @Autowired
       private ProductReviewRepository productReviewRepository;
	   
	   public Map<String, Object> getAllProducts(int page, int size)
	   {
		   Pageable pageable = PageRequest.of(page, size);
		   Page<Product> products = productRepository.findAll(pageable);
		   List<ProductDto> productDtos = products.stream().map(this::convertToDto).collect(Collectors.toList());
		   Map <String, Object> response = new HashMap();
		   response.put("products", productDtos);
		   response.put("totalProducts", products.getTotalElements());
		   
		   
		   return response;
	   }
	   
	   public ProductDto convertToDto(Product product)
	   {
		   ProductDto dto = new ProductDto();
		   dto.setId(product.getId());
		   dto.setName(product.getName());
		   dto.setPrice(product.getPrice());
		   dto.setDescription(product.getDescription());
		   dto.setRatings(product.getRatings());
		   dto.setCategory(product.getCategory());
		   dto.setSeller(product.getSeller());
		   dto.setStock(product.getStock());
		   dto.setNumOfReviews(product.getNumOfReviews());
		   
//		   dto.setReviews(product.getReviews());
		   List<ProductReviewDto> reviewDtos = product.getReviews().stream().map(review -> {
			   ProductReviewDto reviewDto = new ProductReviewDto();
			   reviewDto.setProductId(review.getId());
			   reviewDto.setComment(review.getComment());
			   reviewDto.setRating(review.getRating());
			   return reviewDto;
		   }).collect(Collectors.toList());
		   
		   dto.setReviews(reviewDtos);
		
		   List<ProductImageDto> imageDtos = product.getImages().stream().map(image -> {
			   ProductImageDto imageDto = new ProductImageDto(image.getPublicId());
			   return imageDto;
		   }).collect(Collectors.toList());
		   
		   dto.setImages(imageDtos); 
		   
		   return dto;
	   }
	   
	   public Product getProductById(Long id)
	   {
		   return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with the id" +id));
	   }
	   
	   public List<Product> searchProducts(String category, Double minPrice, Double maxPrice, String keyword, Double ratings)
	   {
		   Specification<Product> spec = Specification.where(ProductSpecification.hasCategory(category))
				   .and(ProductSpecification.priceBetween(minPrice, maxPrice))
		           .and(ProductSpecification.hasNameOrDescriptionLike(keyword))
		           .and(ProductSpecification.ratingGreaterThan(ratings));
		   return productRepository.findAll(spec);
	   }
	   
	   public void addReview(ProductReviewDto reviewDto)
	   {
		  Product product = productRepository.findById(reviewDto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
		  
		  ProductReview review = new ProductReview();
		  review.setComment(reviewDto.getComment());
		  review.setRating(reviewDto.getRating());
		  review.setProduct(product);
		  productReviewRepository.save(review);
	   }
}
