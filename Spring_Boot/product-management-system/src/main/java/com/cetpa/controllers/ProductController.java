package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cetpa.models.Product;
import com.cetpa.services.ProductService;

@Controller
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@GetMapping("/insert")
	public String getInsertForm()
	{
		return "insert-form";
	}
	@PostMapping("/save-record")
	public ModelAndView saveProductRecord(Product product)
	{
		productService.saveProduct(product);
		ModelAndView modelAndView=new ModelAndView("save-success");
		return modelAndView;
	}
	@GetMapping("/search")
	public String getSearchForm()
	{
		return "search-form";
	}
	@GetMapping("/search-record")
	public ModelAndView searchProductRecord(int pid)
	{
		Product product=productService.getProduct(pid);
		ModelAndView modelAndView=new ModelAndView();
		if(product==null)
		{
			modelAndView.setViewName("search-form");
			modelAndView.addObject("msg","Product record not found");
			modelAndView.addObject("pid",pid);
		}
		else
		{
			modelAndView.setViewName("show-record");
			modelAndView.addObject("product",product);
		}
		return modelAndView;
	}
	@GetMapping("/delete")
	public String getDeleteForm()
	{
		return "delete-form";
	}
	@GetMapping("/confirm-delete")
	public String shoeProductRecordForFelete(int pid,Model model)
	{
		Product product=productService.getProduct(pid);
		if(product==null)
		{
			model.addAttribute("pid",pid);
			model.addAttribute("msg","Product record does not exist");
			return "delete-form";
		}
		model.addAttribute("product",product);
		return "confirm-delete";
	}
	@GetMapping("/delete-record")
	public ModelAndView deleteProductRecord(int pid)
	{
		productService.deleteProduct(pid);
		ModelAndView modelAndView=new ModelAndView("delete-success");
		modelAndView.addObject("pid",pid);
		return modelAndView;
	}
	@GetMapping("/edit-record")
	public String shoeProductRecordForEdit(int pid,Model model)
	{
		Product product=productService.getProduct(pid);
		if(product==null)
		{
			model.addAttribute("pid",pid);
			model.addAttribute("msg","Product record does not exist");
			return "edit-form";
		}
		model.addAttribute("product",product);
		return "show-edit-record";
	}
	@GetMapping("/edit")
	public String getEditForm()
	{
		return "edit-form";
	}
	@PostMapping("/update-record")
	public ModelAndView updateProductRecord(Product product)
	{
		productService.updateProduct(product);
		ModelAndView modelAndView=new ModelAndView("update-success");
		modelAndView.addObject("pid",product.getPid());
		return modelAndView;
	}
	@GetMapping("/products")
	public ModelAndView getProductRecords()
	{
		List<Product> productList=productService.getProducts();
		ModelAndView modelAndView=new ModelAndView("product-list");
		modelAndView.addObject("plist",productList);
		return modelAndView;
	}
}
