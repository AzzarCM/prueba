package com.uca.capas.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class MainController {
	
	private ArrayList<Product> components = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraComponents() {
		
		ModelAndView mav = new ModelAndView();
		
		components.add(new Product(0, "MOTHERBOARD ASUS 170-K", 10));
		components.add(new Product(2, "RAM HYPERX 2X 8GB RGB", 20));
		components.add(new Product(3, "THERMALTAKE 600V BRONCE", 20));
		components.add(new Product(4, "SSD 860 EVO 480GB + HDD 500GB", 20));		
		components.add(new Product(5, "EVGA GEFORCE GTX 760", 2)); //PROXIMO UPDATE:(
		components.add(new Product(6, "INTEL I7 6700K", 5));
		components.add(new Product(7, "KEYBOARD HYPERX ALLOY FPS", 5));
		components.add(new Product(8, "MONITOR HP 25X 144HZ", 5));
		
		mav.setViewName("componentes");
		mav.addObject("product", new Product());
		mav.addObject("producto", components);
		
		
		return mav;
		
	}
	
	@PostMapping("/validar")
	@ResponseBody
	public ModelAndView validarDato(Product componente) {
		ModelAndView mav = new ModelAndView();
		
		if(components.get(componente.getId()).getCantidad() < componente.getCantidad()) {
			mav.setViewName("/error");
		}else {mav.setViewName("/compra");}
		
		mav.addObject("item", components.get(componente.getId()).getNombre());
		
		return mav;
	}
	
	

}
