package pe.edu.upc.controller;

import java.util.List;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import com.sun.el.parser.ParseException;
import pe.edu.upc.entity.Brand;
import pe.edu.upc.serviceinterface.IBrandService;

@Controller
@RequestMapping("/brands")
public class BrandController {

	@Autowired
	private IBrandService bS;
	
	@GetMapping("/new")
	public String newLBrand(Model model) {
		model.addAttribute("brand", new Brand());
		return "brand/brand";

	}
	
	@PostMapping("/save")
	public String saveBrand(@Valid Brand brand, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "brand/brand";
		}else {
			int rpta=bS.insert(brand); 
				if(rpta>0)
				{
					model.addAttribute("mensaje","La marca ya existe. ");
					return "brand/brand";
				
		}else {
			model.addAttribute("listaBrand", bS.list());
			return "redirect:/brands/list";}
		}
	}
	
	@GetMapping("/list")
	public String listBrand(Model model) {
		
		try {
			model.addAttribute("listaMarcas", bS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "brand/listBrand";
	}
	
	
	
	@RequestMapping("/find")
	public String findBynBrand(Model model, @Validated Brand brand) throws ParseException{
		
		List<Brand> listaMarcas;
		listaMarcas = bS.findByBrand(brand.getNameBrand());
		if (listaMarcas.isEmpty()) {
			model.addAttribute("mensaje", "No se encontro");
		}
		model.addAttribute("listaMarcas", listaMarcas);
		return "brand/listBrand";
	}
}