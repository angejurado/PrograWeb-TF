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

import pe.edu.upc.entity.Category;
import pe.edu.upc.serviceinterface.ICategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private ICategoryService dS;
	
	@GetMapping("/new")
	public String newLCategory(Model model) {
		model.addAttribute("category", new Category());
		return "category/category";
	}
	
	@PostMapping("/save")
	public String saveBrand(@Valid Category category, BindingResult result, Model model, SessionStatus status) throws Exception{
		if(result.hasErrors()) {
			return "category/category";
		}else {
			dS.insert(category);
		}
		model.addAttribute("listaCategory", dS.list());
		return "redirect:/categories/list";
		}
	
	@GetMapping("/list")
	public String listCategory(Model model) {
		try {
			model.addAttribute("listaCategorias",dS.list());
		}catch (Exception e) {
			//TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "district/listDistrict";
	}

}
