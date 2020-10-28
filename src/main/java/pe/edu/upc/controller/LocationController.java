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

import pe.edu.upc.entity.Location;
import pe.edu.upc.serviceinterface.ILocationService;
import pe.edu.upc.serviceinterface.ICityService;
import pe.edu.upc.serviceinterface.IDistrictService;

@Controller
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private ILocationService lS;
	
	@Autowired
	private ICityService ciS;
	
	@Autowired
	private IDistrictService diS;
	
	@GetMapping("/new")
	public String newLLocation(Model model) {
		model.addAttribute("location", new Location());
		model.addAttribute("listCity",ciS.list());
		model.addAttribute("listDistrict",diS.list());		
		return "location/location";

	}
	
	@PostMapping("/save")
	public String saveLocation(@Valid Location location, BindingResult result, Model model, SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "location/location";
		}else {
			lS.insert(location);
		}
		
		model.addAttribute("listaLocation", lS.list());
		
		return "redirect:/locations/list";
		
	}
	
	@GetMapping("/list")
	public String listLocation(Model model) {
		
		try {
			model.addAttribute("listaLocations", lS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "location/listLocation";
	}
}
