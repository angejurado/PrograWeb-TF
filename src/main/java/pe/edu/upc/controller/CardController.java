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


import pe.edu.upc.entity.Card;
import pe.edu.upc.serviceinterface.ICardService;
import pe.edu.upc.serviceinterface.IUserService;

@Controller
@RequestMapping("/cards")
public class CardController {

	@Autowired
	private ICardService cS;
	@Autowired
    private IUserService uS;
	
	@GetMapping("/new")
    public String newLBrand(Model model) {
        model.addAttribute("card", new Card());
        model.addAttribute("listUser", uS.list());
        return "card/card";
    }
      	
	@PostMapping("/save")
	public String saveCard(@Valid Card card, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("listUser", uS.list());
			return "card/card";
		}else {
			int rpta=cS.insert(card); 
				if(rpta>0)
				{
					model.addAttribute("mensaje","La tarjeta ya existe. ");
			        model.addAttribute("listUser", uS.list());
					return "card/card";
				
		}else {
			model.addAttribute("listUser", uS.list());
			model.addAttribute("listaCard", cS.list());
			return "redirect:/cards/list";}
		}
	}
	
	@GetMapping("/list")
	public String listCard(Model model) {
		
		try {
			model.addAttribute("listaTarjetas", cS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "card/listCard";
	}
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Card> objCar = cS.searchId(id);
		if (objCar == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/cards/list";
		} else {
			model.addAttribute("listUser",uS.list());
			model.addAttribute("card", objCar.get());
			return "card/ucard";

		}

	}

	
	@PostMapping("/update")
	public String updateCard(@Valid Card card, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "card/card";
		}else {
			cS.insert(card);
			model.addAttribute("mensaje", "Registro actualizado correctamente");
	        model.addAttribute("listUser", uS.list());
		}
		model.addAttribute("listaCard", cS.list());
		
		return "redirect:/cards/list";
	}
	
	
	@RequestMapping("/find")
	public String findByCard(Model model, @Validated Card card) throws ParseException{
		
		List<Card> listaTarjetas;
		listaTarjetas = cS.findByCard(card.getNumCard());
		if (listaTarjetas.isEmpty()) {
			model.addAttribute("mensaje", "No se encontro");
		}
		model.addAttribute("listaMarcas", listaTarjetas);
		return "brand/listBrand";
	}
	

}