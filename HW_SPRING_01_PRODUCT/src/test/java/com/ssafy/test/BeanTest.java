package com.ssafy.test;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;

public class BeanTest {

	public static void main(String[] args) {
		BeanFactory con = new ClassPathXmlApplicationContext("com/ssafy/config/beans.xml");
		
		ProductService productService = con.getBean(ProductService.class);
		
		
		List<Product> products = productService.selectAll();
		for(Product p : products) {
			System.out.println(p);
		}
		System.out.println("================================");
		Product pd = productService.select("1");
		System.out.println(pd);
		System.out.println("================================");
		Product p1 = new Product("햄버거",9900,"버1거1킹");
		productService.insert(p1);
		System.out.println("================================");
//		productService.update(p1);
		System.out.println("================================");
//		productService.delete("16");
	}

}
