package pe.edu.upc.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
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

import pe.edu.upc.entity.DetailsReserve;
import pe.edu.upc.entity.Reserve;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.ICardService;
import pe.edu.upc.serviceinterface.IDetailsReserveService;
import pe.edu.upc.serviceinterface.IReserveService;
import pe.edu.upc.serviceinterface.IStoreService;
import pe.edu.upc.serviceinterface.IUserService;


@Controller
@RequestMapping("/reserves")
public class ReserveController {

	@Autowired
	private IReserveService rS;
	
	@Autowired
	private IUserService uS;
	
	@Autowired
	private IProductService pS;
	
	@Autowired
    private ICardService cS;
	
	@Autowired
	private IDetailsReserveService dS;
	
	@Autowired
	private IStoreService sS;
	
	@RequestMapping("/reports")
	public String Report()
	{
		return "reports/reports";
	}
	
	@RequestMapping("/new")
	public String irRegistrar(Model model) {
		model.addAttribute("reserve", new Reserve());
		model.addAttribute("listUser", uS.list());
		model.addAttribute("listCard", cS.list());
		model.addAttribute("listStores", sS.list());
		return "reserve/reserve";
	}

	
	@RequestMapping("/newproduct/{id}")
	public String irNewProduct(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		model.put("detail", new DetailsReserve());
		model.put("listProducts", pS.list());

		Reserve objimp = rS.listarId(id);
		model.put("reserve", objimp);

		return "reserve/details/detailForm";
	}
	
	@RequestMapping("/list")
	public String listar(Map<String, Object> model) {
		model.put("listaReservas", rS.list());
		return "reserve/listReserve";
	}
	
	@GetMapping("/listVoucher")
	public String listarVoucher(Map<String, Object> model) {
		model.put("listaReservas", rS.list());
		return "voucher/listVoucher";
	}
	
	@GetMapping("/detail/{id}")
	public String detailImportation(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash) {
		Reserve res = rS.listarId(id);

		if (res == null) {
			flash.addFlashAttribute("error", "El Detalle no existe en la base de datos");
			return "reserve/listReserve"; 
		}
		model.put("reserve", res);
		model.put("titulo", "Detalle de Reserva #" + res.getIdReserve());

		return "reserve/details/listDetail"; 
	}
	
	@GetMapping("/voucher/{id}")
	public String detailVoucher(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash) {
		Reserve res = rS.listarId(id);

		if (res == null) {
			flash.addFlashAttribute("error", "El Voucher no existe en la base de datos");
			return "reserve/listReserve"; 
		}
		model.put("reserve", res);
		model.put("titulo", "Detalle del Voucher #" + res.getIdReserve());

		return "voucher/listVoucherDetails"; 
	}
	
	@PostMapping("/save")
	public String saveOrder(@Valid Reserve res, Model model, SessionStatus status, BindingResult binRes) {
		Date requestday = new Date();
		try {
			res.setdDate(requestday);
			rS.insert(res);
			status.setComplete();
			model.addAttribute("success", "Reserva Generada");
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect: /reserves/new";
		}

		return "redirect:/reserves/list";
	}
	
	@PostMapping("/saveproduct{id}")
	public String newProductXReserve(@PathVariable(value = "id") Long id, @Valid DetailsReserve reservadet,
			RedirectAttributes flash, BindingResult result, Model model, SessionStatus status) {
		Reserve res = rS.listarId(id);
		if (result.hasErrors()) {
			flash.addFlashAttribute("error", "El valor debe ser positivo");
			String cadena1 = "redirect:/reserves/newproduct/" + id;
			return cadena1;
		}
		try {
			res.addDetailImportation(reservadet);
			rS.insert(res);
			status.isComplete();
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		String cadena = "redirect:/reserves/detail/" + id;
		return cadena;
	}
	
	@RequestMapping("{idimp}/eliminardetail/{id}")
	public String eliminarDetalle(Map<String, Object> model, @PathVariable(value = "id") Long idet,
			@PathVariable(value = "idimp") int idimp, RedirectAttributes flash) {
		try {
			if (idet!=0 && idet > 0) {
				dS.delete(idet);
				flash.addAttribute("mensaje", "Se eliminó correctamente");
				flash.addAttribute("mensaje1", "Se eliminó correctamente el id" + idet);
			} else
				return "redirect:/home";
		} catch (Exception e) {
			model.put("mensaje", "No se puede eliminar");
			model.put("error", e.getMessage());
		}
		String cadena = "redirect:/reserves/detail/" + idimp;
		return cadena;
	}
	
	@RequestMapping("/findString")
	public String findByString(Model model, @Validated String busqueda) throws ParseException{
		
		List<Reserve> listaReserva;
		listaReserva = rS.findByString(busqueda);
		if (listaReserva.isEmpty()) {
			model.addAttribute("mensaje", "No se encontro");
		}
		model.addAttribute("listaReserva", listaReserva);
		return "reserve/listReserve";
	}
	
	@RequestMapping("/findNumber")
	public String findByNumber(Model model, @Validated Long busqueda) throws ParseException{
		
		List<Reserve> listaReserva;
		listaReserva = rS.findByNumber(busqueda);
		if (listaReserva.isEmpty()) {
			model.addAttribute("mensaje", "No se encontro");
		}
		model.addAttribute("listaReserva", listaReserva);
		return "reserve/listReserve";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteReserve(Model model, @PathVariable (value="id") Long id) throws ParseException{
		
		try {

			if (id > 0) {
				rS.delete(id);;
			}
			model.addAttribute("reserva", new Reserve ());
			model.addAttribute("success", "Se elimino correctamente");
			model.addAttribute("listaReserva",rS.list());
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("reserva", new Reserve ());
			model.addAttribute("success","No se puede eliminar");
			model.addAttribute("listaReserva",rS.list());
		}
		return  "redirect:/reserves/list";
	}
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable Long id, Model model, RedirectAttributes objRedir){
		
		Optional<Reserve> objPro = rS.searchId(id);
		if (objPro == null) {
			objRedir.addFlashAttribute("mensaje", "ocurrio un error");
			return "redirect:reserves/list";
		}else {
			model.addAttribute("listUser", uS.list());
			model.addAttribute("listCard", cS.list());
			model.addAttribute("listStores", sS.list());
			model.addAttribute("reserve", objPro.get());
			return "reserve/uReserve";

		}
		
	}
	
	@PostMapping("/update")
	public String UpdateReserve(@Valid Reserve product, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			model.addAttribute("listUser", uS.list());
			model.addAttribute("listCard", cS.list());
			model.addAttribute("listStores", sS.list());
			return "reserve/uReserve";
		}else {
			rS.insert(product);
		}
		model.addAttribute("listaReserve", rS.list());
		
		return "redirect:/reserves/list";
	}
	
	
	
}