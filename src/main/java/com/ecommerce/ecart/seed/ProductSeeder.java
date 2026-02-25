package com.ecommerce.ecart.seed;

import com.ecommerce.ecart.entity.ProductImage;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecommerce.ecart.entity.Product;
import com.ecommerce.ecart.repository.ProductRepository;


@Component
public class ProductSeeder implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception
	{
		if(productRepository.count() == 0)
		{
			List<Product> demoProducts = List.of( 

				    new Product(null, "Apple iphone 15", 799.0, "SmartPhone A16 Chip", "Mobile", 4.8, "Amazon", 5, List.of("/products/1.jpg")),

				    new Product(null, "Samsung Galaxy S24", 699.0, "Flagship Android Smartphone", "Mobile", 4.7, "Flipkart", 8, List.of("/products/2.jpg")),

				    new Product(null, "OnePlus 12", 649.0, "Fast and Smooth Performance", "Mobile", 4.6, "Amazon", 10, List.of("/products/3.jpg")),

				    new Product(null, "Google Pixel 8", 599.0, "Best Camera Smartphone", "Mobile", 4.5, "Flipkart", 6, List.of("/products/4.jpg")),

				    new Product(null, "Sony WH-1000XM5", 349.0, "Noise Cancelling Headphones", "Audio", 4.7, "Amazon", 12, List.of("/products/5.jpg")),

				    new Product(null, "Dell XPS 13", 999.0, "Ultra Thin Laptop", "Laptop", 4.6, "Dell Store", 4, List.of("/products/6.jpg")),

				    new Product(null, "MacBook Air M2", 1099.0, "Apple Silicon Laptop", "Laptop", 4.9, "Apple Store", 7, List.of("/products/7.jpg")),

				    new Product(null, "iPad Air 5", 599.0, "Powerful Tablet with M1 Chip", "Tablet", 4.8, "Amazon", 9, List.of("/products/8.jpg")),

				    new Product(null, "Samsung 55 Inch QLED TV", 899.0, "4K Smart Television", "Electronics", 4.6, "Flipkart", 3, List.of("/products/9.jpg")),

				    new Product(null, "Logitech MX Master 3", 99.0, "Wireless Productivity Mouse", "Accessories", 4.7, "Amazon", 15, List.of("/products/10.jpg"))

				);
			
			
			productRepository.saveAll(demoProducts);
			System.out.println("Seeded Demo Products!!!");
		}
		else
		{
			System.out.println("Products Already Exists! Skipping Seed");
		}
	}

}
