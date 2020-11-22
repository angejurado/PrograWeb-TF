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
		model.addAttribute("listaUsuarios", uS.listOwners());
		return "store/store";
	}

	@PostMapping("/save")
	public String saveStore(@Valid Store store, BindingResult result, Model model,Model model2, SessionStatus status)
			throws Exception {

		if (result.hasErrors()) {

			return "store/store";
		} else {
			int rpta = sS.insert(store);
			if (rpta > 0) {
				model.addAttribute("mensaje", "La tienda ya existe!!");
				model.addAttribute("listaLocaciones", lS.list());
				model.addAttribute("listaUsuarios", uS.listOwners());
				return "store/store";
			} else {
				model.addAttribute("listaTiendas", sS.list());
				return "redirect:/stores/list";

			}
			
		}
		
	}

	@GetMapping("/list")
	public String listStores(Model model) {

		try {

			model.addAttribute("store", new Store());
			model.addAttribute("listaLocaciones", lS.list());
			model.addAttribute("listaUsuarios", uS.listOwners());
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
	
	@RequestMapping("/delete/{id}")
	public String deleteStore(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				sS.delete(id);
			}
			model.addAttribute("store", new Store());
			model.addAttribute("mensaje", "Se eliminó correctamente!");
			model.addAttribute("listTiendas", sS.list());
		} catch (Exception e) {
			model.addAttribute("store", new Store());
			model.addAttribute("mensaje", "No se puede eliminar!!");
			model.addAttribute("listTiendas", sS.list());

		}

		return "store/listStore";

	}
	@RequestMapping("/irUpdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Store> objSto=sS.searchId(id);
		if(objSto==null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un error");
			return "redirect/store/listStores";
		}
		else {
			model.addAttribute("listaLocaciones", lS.list());
			model.addAttribute("listaUsuarios", uS.listOwners());
			model.addAttribute("store",objSto.get());
			return "store/uStore";
		}
		
	}
	
	@PostMapping("/update")
	public String updateStore(@Valid Store store, BindingResult result, Model model, SessionStatus status)
	   throws Exception{
	    if(result.hasErrors()) {
	    	return "store/store";
	    }else {
	    	int rpta = sS.insert(store);
			if (rpta > 0) {
				model.addAttribute("mensaje", "La tienda ya existe!!");
				model.addAttribute("listaLocaciones", lS.list());
				model.addAttribute("listaUsuarios", uS.listOwners());
				return "store/uStore";
			} else {
				model.addAttribute("listaTiendas", sS.list());
				return "redirect:/stores/list";

			}
	    }
		
	  
		
	}
		
	
	

}
