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

import pe.edu.upc.entity.Store;
import pe.edu.upc.serviceinterface.ILocationService;
import pe.edu.upc.serviceinterface.IStoreService;
import pe.edu.upc.serviceinterface.IUserService;

@Controller
@RequestMapping("/stores")
public class StoreController {

	@Autowired
	private IStoreService sS;

	@Autowired
	private ILocationService lS;

	@Autowired
	private IUserService uS;

	@GetMapping("/new")
	public String newStore(Model model) {
		model.addAttribute("store", new Store());
		model.addAttribute("listaLocaciones", lS.list());
		model.addAttribute("listaUsuarios", uS.list());
		return "store/store";
	}

	@PostMapping("/save")
	public String saveStore(@Valid Store store, BindingResult result, Model model,Model model2, SessionStatus status)
			throws Exception {

		if (result.hasErrors()) {

			return "store/store";
		} else {
			sS.insert(store);
		}
		model.addAttribute("listaTiendas", sS.list());
		return "redirect:/stores/list";
	}

	@GetMapping("/list")
	public String listStores(Model model) {

		try {

			model.addAttribute("store", new Store());
			model.addAttribute("listaLocaciones", lS.list());
			model.addAttribute("listaUsuarios", uS.list());
			model.addAttribute("listaTiendas", sS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar tiendas en el controller");
		}
		return "store/listStore";
	}
	
	@RequestMapping("/find")
	public String findBynProduct(Model model, @Validated Store store) throws ParseException{
		
		List<Store> listaTiendas;
		listaTiendas = sS.findByStore(store.getNameBusiness());
		if (listaTiendas.isEmpty()) {
			model.addAttribute("mensaje", "No se encontro");
		}
		model.addAttribute("listaTiendas", listaTiendas);
		return "store/listStore";
	}

}
