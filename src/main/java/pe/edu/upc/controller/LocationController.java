package pe.edu.upc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;
import pe.edu.upc.entity.Location;
import pe.edu.upc.serviceinterface.ICityService;
import pe.edu.upc.serviceinterface.IDistrictService;
import pe.edu.upc.serviceinterface.ILocationService;

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
		model.addAttribute("listCity", ciS.list());
		model.addAttribute("listDistrict", diS.list());
		return "location/location";

	}

	@PostMapping("/save")
	public String saveLocation(@Valid Location location, BindingResult result, Model model, SessionStatus status)
			throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("listCity", ciS.list());
			model.addAttribute("listDistrict", diS.list());
			
			return "location/location";
		} else {
			int rpta=lS.insert(location);
			
			if(rpta>0)
			{
				
				model.addAttribute("mensaje","La direccion ya existe. ");
				model.addAttribute("listCity", ciS.list());
				model.addAttribute("listDistrict", diS.list());
				return "location/location";
				} 
			else	{
				model.addAttribute("listCity", ciS.list());
				model.addAttribute("listDistrict", diS.list());
				model.addAttribute("listaLocations",lS.list());
				return "redirect:/locations/list";
				}
		
		}
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

	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Location> objVac = lS.searchId(id);
		if (objVac == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/locations/list";
		} else {
			model.addAttribute("listCity", ciS.list());
			model.addAttribute("listDistrict", diS.list());
			model.addAttribute("location", objVac.get());
			return "location/ulocation";

		}

	}

	@PostMapping("/update")
	public String updateLocation(@Valid Location location, BindingResult result, Model model, SessionStatus status)
			throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("listCity", ciS.list());
			model.addAttribute("listDistrict", diS.list());
			
			return "location/ulocation";
		} else {
			int rpta=lS.insert(location);
			
			if(rpta>0)
			{
				
				model.addAttribute("mensaje","La direccion ya existe. ");
				model.addAttribute("listCity", ciS.list());
				model.addAttribute("listDistrict", diS.list());
				return "location/ulocation";
				} 
			else	{
				model.addAttribute("listCity", ciS.list());
				model.addAttribute("listDistrict", diS.list());
				model.addAttribute("listaLocations",lS.list());
				return "redirect:/locations/list";
				}
		
		}	}

	@RequestMapping("/find")
	public String findBynLocation(Model model, @Validated Location location) throws ParseException {

		List<Location> listaDirecciones;
		listaDirecciones = lS.findByLocation(location.getNameDirection());
		if (listaDirecciones.isEmpty()) {
			model.addAttribute("mensaje", "No se encontro la ubicacion");
		}
		model.addAttribute("listaDirecciones", listaDirecciones);
		return "location/listLocation";
	}

	@RequestMapping("/delete/{id}")
	public String deleteDistrict(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				lS.delete(id);
			}
			model.addAttribute("location", new Location());
			model.addAttribute("mensaje", "Se eliminó correctamente la direccion!");
			model.addAttribute("listaDirecciones", lS.list());
		} catch (Exception e) {
			model.addAttribute("location", new Location());
			model.addAttribute("listaLocation", lS.list());
			
			model.addAttribute("mensaje", "No se puede eliminar la direccion!!");
			
		}
		return "redirect:/locations/list";
	

	}
	
	
}
