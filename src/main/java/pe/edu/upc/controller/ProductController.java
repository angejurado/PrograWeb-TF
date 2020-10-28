package pe.edu.upc.controller;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Product;
import pe.edu.upc.serviceinterface.IBrandService;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.IStoreService;
import pe.edu.upc.serviceinterface.ICategoryService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService pS;
	
	@Autowired
	private IBrandService bS;

	@Autowired
	private ICategoryService cS;
	

	@GetMapping("/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listBrand", bS.list());
		model.addAttribute("listCategory", cS.list());
				return "product/product";
	}
	
	
	@PostMapping("/save")
	public String saveProduct(@Valid Product product, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "product/product";
		}else {
			pS.insert(product);
		}
		model.addAttribute("listaProductos", pS.list());
		
		return "redirect:/products/list";
	}
	
	@GetMapping("/list")
	public String listProducts(Model model) {
		
		try {
			
			model.addAttribute("listaProductos", pS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar Productos en el controller");
		}
		return "product/listProduct";
	}
	
}
