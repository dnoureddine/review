package com.org.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/")
public class ProductController {
	
	@RequestMapping(value = "products", method = RequestMethod.GET)
	public String searchProducts(Model model) {
		
		return "product/products";
	}

}
