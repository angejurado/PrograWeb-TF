package pe.edu.upc.controller;

import java.util.Optional;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

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
	public String saveCity(@Valid City city, BindingResult result, Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			return "city/city";
		} else {
			int rpta = cS.insert(city);
			if (rpta > 0) {
				model.addAttribute("mensaje", "la ciudad ya existe");
				return "city/city";
			} else {
				model.addAttribute("listaCities", cS.list());
				return "redirect:/cities/list";
			}
		}

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

	
	@RequestMapping("/delete/{id}")
	public String deleteCity(Model model, @PathVariable (value="id") int id) throws ParseException{
		
		try {

			if (id > 0) {
				cS.delete(id);
			}
			model.addAttribute("city", new City());
			model.addAttribute("mensaje", "Se elimino correctamente");
			model.addAttribute("listaCities",cS.list());
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("city", new City());
			model.addAttribute("mensaje","No se puede eliminar");
			model.addAttribute("listaCities",cS.list());
		}
		return "city/listCity";
	}
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<City> objVac = cS.searchId(id);
		if (objVac == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/cities/list";
		} else {
			model.addAttribute("city", objVac.get());
			return "city/ucity";

		}

	}

	@PostMapping("/update")
	public String updateCity(@Valid City city, BindingResult result, Model model, SessionStatus status)
			throws Exception {

		if (result.hasErrors()) {

			return "city/city";
		} else {
			int rpta = cS.insert(city);
			if (rpta > 0) {
				model.addAttribute("mensaje", "la ciudad ya existe");
				return "city/ucity";
			} else {
				model.addAttribute("listaCity", cS.list());
				return "redirect:/cities/list";
			}
		}

	}
}