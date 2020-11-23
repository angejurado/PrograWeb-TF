package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Category;
import pe.edu.upc.serviceinterface.ICategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private ICategoryService cS;
	
	@GetMapping("/new")
	public String newLCategory(Model model) {
		model.addAttribute("category", new Category());
		return "category/category";
	}
	
	@PostMapping("/save")
	public String saveBrand(@Valid Category cate, BindingResult result, Model model, SessionStatus status) throws Exception{
		
		if (result.hasErrors()) {
			return "category/category";
		}else {
			int rpta=cS.insert(cate);
			if (rpta > 0) {
				model.addAttribute("mensaje", "la categoria ya existe");
				return "category/category";
			}else {
				model.addAttribute("listaCategorias", cS.list());
				return "redirect:/categories/list";
			}
		}
		
	}
	
	@GetMapping("/list")
	public String listCategory(Model model) {
		try {
			model.addAttribute("listaCategorias",cS.list());
		}catch (Exception e) {
			//TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "category/listCategory";
	}

	@RequestMapping("/delete/{id}")
	public String deleteCategory(Model model, @PathVariable(value="id") int id )
	{
		try {
			if(id>0) {
				cS.delete(id);
			}
			model.addAttribute("category", new Category());
			model.addAttribute("mensaje", "se elimino correctamente");
			model.addAttribute("listaCategorias",cS.list());
 		} catch (Exception e) {
 			model.addAttribute("Category", new Category());
			model.addAttribute("mensaje", "no se puede eliminar");
			model.addAttribute("listaCategorias",cS.list());
		}
		return "category/listCategory";
	}
	
	@RequestMapping("/reporte1")
	public String catMasSolicitadas(Map<String, Object> model) {
		model.put("listCatMasSoli", cS.catMasPedida());
		return "reports/categoriasMasPedidas";
	}
}

