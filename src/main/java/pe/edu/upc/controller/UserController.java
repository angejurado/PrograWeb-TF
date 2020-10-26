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


import pe.edu.upc.entity.User;
import pe.edu.upc.serviceinterface.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService uS;
	
	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "user/user";
	}
	
	@PostMapping("/save")
	public String saveBrand(@Valid User user, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "user/user";
		}else {
			uS.insert(user);
		}
		model.addAttribute("listaBrand", uS.list());
		
		return "redirect:/users/list";
		
	}
	
	@GetMapping("/list")
	public String listBrand(Model model) {
		
		try {
			model.addAttribute("listaUsuarios", uS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "user/listUser";
	}

}
