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

import pe.edu.upc.serviceinterface.ICardService;
import pe.edu.upc.serviceinterface.IReserveService;
import pe.edu.upc.serviceinterface.IUserService;


@Controller
@RequestMapping("/reserves")
public class ReserveController {

	@Autowired
	private IReserveService rS;
	
	@Autowired
	private IUserService uS;
	
	@Autowired
    private ICardService cS;
	
	@GetMapping("/new")
	public String newLReserve(Model model) {
		model.addAttribute("reserve", new Reserve());
		model.addAttribute("user",uS.list());
		model.addAttribute("cards",cS.list());
		return "reserve/reserve";
	}
	
	@PostMapping("/save")
	public String saveReserve(@Valid Reserve reserve, BindingResult result, Model model, Model model2,Model model3, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "reserve/reserve";
		}else {
			rS.insert(reserve);
		}
		model.addAttribute("listaReservas", rS.list());
		
		return "redirect:/reserves/list";
		
	}
	
	@GetMapping("/list")
	public String listReserve(Model model) {
		
		try {
			model.addAttribute("listaReservas", rS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "reserve/listReserve";
	}
}