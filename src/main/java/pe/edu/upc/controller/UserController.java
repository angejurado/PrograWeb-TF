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
			this.listUser(model);
		}
		model.addAttribute("listaBrand", uS.list());
		
		return "redirect:/users/list";
		
	}
	
	@GetMapping("/list")
	public String listUser(Model model) {
		
		try {
			model.addAttribute("user", new User());
			model.addAttribute("listaUsuarios", uS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller");
		}
		return "user/listUser";
	}
	
	@RequestMapping("/find")
	public String findVaccine(Model model, @Validated User user) throws ParseException{
		try {
			
			/*model.addAttribute("listLaboratorios",lS.findBynameLaboratory(laboratory.getNameLaboratory()));*/
			List<User> listUser;
			listUser=uS.findBynameUser(user.getNameUser());
			model.addAttribute("listUser", listUser);
			if(listUser.isEmpty())
			{
				model.addAttribute("mensaje", "No se encontro");
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en el metodo del controller");
		}
		
		
		return "/user/listUser";
		
	}

}
