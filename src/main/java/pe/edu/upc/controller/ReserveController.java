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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.DetailsReserve;
import pe.edu.upc.entity.Reserve;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.ICardService;
import pe.edu.upc.serviceinterface.IDetailsReserveService;
import pe.edu.upc.serviceinterface.IReserveService;
import pe.edu.upc.serviceinterface.IStoreService;
import pe.edu.upc.serviceinterface.IUserService;


@Controller
@RequestMapping("/reserves")
public class ReserveController {

	@Autowired
	private IReserveService rS;
	
	@Autowired
	private IUserService uS;
	
	@Autowired
	private IProductService pS;
	
	@Autowired
    private ICardService cS;
	
	@Autowired
	private IDetailsReserveService dS;
	
	@Autowired
	private IStoreService sS;
	
	@RequestMapping("/reports")
	public String Report()
	{
		return "reports/reports";
	}
	
	@RequestMapping("/new")
	public String irRegistrar(Model model) {
		model.addAttribute("reserve", new Reserve());
		model.addAttribute("listUser", uS.list());
		model.addAttribute("listCard", cS.list());
		model.addAttribute("listStores", sS.list());
		return "reserve/reserve";
	}

	
	@RequestMapping("/newproduct/{id}")
	public String irNewProduct(@PathVariable(value = "id") int id, Map<String, Object> model) {

		model.put("detail", new DetailsReserve());
		model.put("listProducts", pS.list());

		Reserve objimp = rS.listarId(id);
		model.put("reserve", objimp);

		return "reserve/details/detailForm";
	}
	
	@RequestMapping("/list")
	public String listar(Map<String, Object> model) {
		model.put("listaReservas", rS.list());
		return "reserve/listReserve";
	}
	
	@GetMapping("/detail/{id}")
	public String detailImportation(@PathVariable(value = "id") int id, Map<String, Object> model,
			RedirectAttributes flash) {
		Reserve res = rS.listarId(id);

		if (res == null) {
			flash.addFlashAttribute("error", "El Detalle no existe en la base de datos");
			return "reserve/listReserve"; 
		}
		model.put("reserve", res);
		model.put("titulo", "Detalle de Reserva #" + res.getIdReserve());

		return "reserve/details/listDetail"; 
	}
	
	@PostMapping("/save")
	public String saveOrder(@Valid Reserve res, Model model, SessionStatus status, BindingResult binRes) {
	
		try {
			
			rS.insert(res);
			status.setComplete();
			model.addAttribute("success", "Reserva Generada");
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect: /reserves/new";
		}

		return "redirect:/reserves/list";
	}
	
	@PostMapping("/saveproduct{id}")
	public String newProductXImportation(@PathVariable(value = "id") int id, @Valid DetailsReserve reservadet,
			RedirectAttributes flash, BindingResult result, Model model, SessionStatus status) {
		Reserve res = rS.listarId(id);
		if (result.hasErrors()) {
			flash.addFlashAttribute("error", "El valor debe ser positivo");
			String cadena1 = "redirect:/reserves/newproduct/" + id;
			return cadena1;
		}
		try {
			res.addDetailImportation(reservadet);
			rS.insert(res);
			status.isComplete();
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		String cadena = "redirect:/reserves/detail/" + id;
		return cadena;
	}
	
	@RequestMapping("{idimp}/eliminardetail/{id}")
	public String eliminarDetalle(Map<String, Object> model, @PathVariable(value = "id") int idet,
			@PathVariable(value = "idimp") int idimp, RedirectAttributes flash) {
		try {
			if (idet > 0) {
				dS.delete(idet);
				flash.addAttribute("mensaje", "Se eliminó correctamente");
				flash.addAttribute("mensaje1", "Se eliminó correctamente el id" + idet);
			} else
				return "redirect:/home";
		} catch (Exception e) {
			model.put("mensaje", "No se puede eliminar");
			model.put("error", e.getMessage());
		}
		String cadena = "redirect:/reserves/detail/" + idimp;
		return cadena;
	}
	
}