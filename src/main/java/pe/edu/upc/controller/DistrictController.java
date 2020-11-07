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

import pe.edu.upc.entity.District;
import pe.edu.upc.serviceinterface.ICityService;
import pe.edu.upc.serviceinterface.IDistrictService;

@Controller
@RequestMapping("/districts")
public class DistrictController {

	@Autowired
	private IDistrictService dS;
	
	@Autowired
	private ICityService cS;
	
	@GetMapping("/new")
	public String newLDistrict(Model model) {
		model.addAttribute("district", new District());
		model.addAttribute("listCity",cS.list());
		return "district/district";

	}
	     
	@PostMapping("/save")
	public String saveBrand(@Valid District district, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "district/district";
		}else {
			dS.insert(district);
		}
		model.addAttribute("listaDistrict", dS.list());
		
		return "redirect:/districts/list";
		
	}
	
	@GetMapping("/list")
	public String listDistrict(Model model) {
		
		try {
			model.addAttribute("listaDistritos", dS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "district/listDistrict";
	}
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<District> objVac = dS.searchId(id);
		if (objVac == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/districts/list";
		} else {
			model.addAttribute("listCity",cS.list());
			model.addAttribute("district", objVac.get());
			return "district/udistrict";

		}

	}

	
	@PostMapping("/update")
	public String updateDistrict(@Valid District district, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "district/district";
		}else {
			dS.insert(district);
			model.addAttribute("mensaje", "Registro actualizado correctamente");
		}
		model.addAttribute("listaDistrict", dS.list());
		
		return "redirect:/districts/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteDistrict(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				dS.delete(id);
			}
			model.addAttribute("district", new District());
			model.addAttribute("mensaje", "Se eliminó correctamente!");
			model.addAttribute("listaDistritos", dS.list());
		} catch (Exception e) {
			model.addAttribute("district", new District());
			model.addAttribute("mensaje", "No se puede eliminar!!");
			model.addAttribute("listaDistritos", dS.list());

		}

		return "district/listDistrict";

	}
}