package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Users;
import pe.edu.upc.serviceinterface.IUsersService;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/userss")
public class UsersController {
	@Autowired
	private IUsersService uS;

	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("user", new Users());
		return "users/user";
	}

	@PostMapping("/save")
	public String saveUser(@Validated Users users, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "users/user";
		} else {
			String password = new BCryptPasswordEncoder().encode(users.getPassword());
			users.setPassword(password);
			uS.insert(users);
			model.addAttribute("listUsers", uS.list());
			return "users/listUsers";

		}
	}

	@GetMapping("/list")
	public String listUsers(Model model) {
		try {
			model.addAttribute("listUsers", uS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "users/listUsers";

	}

}
