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

import pe.edu.upc.entity.Reserve;
import pe.edu.upc.serviceinterface.IReserveService;

@Controller
@RequestMapping("/reserves")
public class ReserveController {

	@Autowired
	private IReserveService rS;
	
	@GetMapping("/new")
	public String newLReserve(Model model) {
		model.addAttribute("reserve", new Reserve());
		return "reserve/reserve";

	}
	
	@PostMapping("/save")
	public String saveBrand(@Valid Reserve reserve, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "reserve/reserve";
		}else {
			rS.insert(reserve);
		}
		model.addAttribute("listaReserve", rS.list());
		
		return "redirect:/reserve/list";
		
	}
	
	@GetMapping("/list")
	public String listReserve(Model model) {
		
		try {
			model.addAttribute("listaReserves", rS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "reserve/listReserve";
	}
}