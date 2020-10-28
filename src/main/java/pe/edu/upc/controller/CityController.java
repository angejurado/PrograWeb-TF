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
import pe.edu.upc.entity.City;
import pe.edu.upc.serviceinterface.ICityService;

@Controller
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private ICityService cS;
	
	
	@GetMapping("/new")
	public String newLCity(Model model) {
		model.addAttribute("city", new City());
		return "city/city";

	}
	
	@PostMapping("/save")
	public String saveCity(@Valid City city, BindingResult result, Model model, SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "city/city";
		}else {
			cS.insert(city);
		}
		model.addAttribute("listaCity", cS.list());
		
		return "redirect:/cities/list";
		
	}
	
	@GetMapping("/list")
	public String listCity(Model model) {
		
		try {
			model.addAttribute("listaCities", cS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "city/listCity";
	}
}

