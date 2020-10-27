package pe.edu.upc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Store;
import pe.edu.upc.serviceinterface.IStoreService;

@Controller
@RequestMapping("/stores")
public class StoreController {
	

private IStoreService sS;
	
	@GetMapping("/new")
	public String newStore(Model model) {
		model.addAttribute("store", new Store());
		return "store/store";

     }
	@PostMapping("/save")
	public String saveStore(@Valid Store store, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "store/store";
		}else {
			sS.insert(store);
		}
		model.addAttribute("listaStore", sS.list());
		
		return "redirect:/stores/list";
		
	}
	
	@GetMapping("/list")
	public String listStore(Model model) {
		
		try {
			model.addAttribute("listTiendas", sS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "store/listStore";
	}
}
