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

import pe.edu.upc.serviceinterface.ICardService;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.IReserveService;
import pe.edu.upc.serviceinterface.IStoreService;
import pe.edu.upc.serviceinterface.IVoucherService;

import pe.edu.upc.entity.Voucher;


@Controller
@RequestMapping("/vouchers")
public class VoucherController {
	
	@Autowired
	private IVoucherService vS;
	
	@Autowired
	private ICardService cS;
	
	@Autowired
	private IStoreService sS;
	
	@Autowired
	private IReserveService rS;
	
	@Autowired
	private IProductService pS;
	
	@GetMapping("/new")
	public String newVoucher(Model model) {
		model.addAttribute("Voucher", new Voucher());
		model.addAttribute("listaTarjetas", cS.list());
		model.addAttribute("listaTiendas", sS.list());
		model.addAttribute("listaReservas", rS.list());
		model.addAttribute("listaProductos", pS.list());
		
		return "voucher/voucher";
	}
	
	
	@PostMapping("/save")
	public String saveVoucher(@Valid Voucher voucher, BindingResult result, Model model,Model model2, SessionStatus status)
            throws Exception {

        if (result.hasErrors()) {

            return "voucher/voucher";
        } else {
            vS.insert(voucher);
        }
        model.addAttribute("listaVouchers", vS.list());
        return "redirect:/vouchers/list";
    }
	
	@GetMapping("/list")
    public String listVouchers(Model model) {

        try {
            model.addAttribute("listaVoucherss", vS.list());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al listar vouchers en el controller");
        }
        return "voucher/listVoucher";
    }

	

}
