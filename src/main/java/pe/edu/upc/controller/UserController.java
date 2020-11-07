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
	public String saveUser(@Valid User user, BindingResult result, Model model, 
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
	public String findUser(Model model, @Validated User user) throws ParseException{
		
		List<User> listaUsuarios;
		listaUsuarios = uS.findBynameUser(user.getNameUser());
		if (listaUsuarios.isEmpty()) {
			model.addAttribute("mensaje", "No se encontro");
		}
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "user/listUser";
	}



	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<User> objVac = uS.searchId(id);
		if (objVac == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/users/list";
		} else {
			model.addAttribute("user", objVac.get());
			return "user/uuser";

		}

	}

	
	@PostMapping("/update")
	public String updateUser(@Valid User user, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			
			return "user/user";
		}else {
			uS.insert(user);
			this.listUser(model);
		}
		model.addAttribute("listaUsuarios", uS.list());
		
		return "redirect:/users/list";
		
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				uS.delete(id);
			}
			model.addAttribute("user", new User());
			model.addAttribute("mensaje", "Se eliminó correctamente!");
			model.addAttribute("listaUsuarios", uS.list());
		} catch (Exception e) {
			model.addAttribute("user", new User());
			model.addAttribute("mensaje", "No se puede eliminar!!");
			model.addAttribute("listaUsuarios", uS.list());
		}
		return "user/listUser";
	}
}

