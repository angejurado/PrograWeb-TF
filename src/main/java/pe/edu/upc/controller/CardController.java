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
			
			return "card/card";
		}else {
			cS.insert(card);
		}
		model.addAttribute("listaCard", cS.list());
		
		return "redirect:/cards/list";
		
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
	
	
}