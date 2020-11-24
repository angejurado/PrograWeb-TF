 package pe.edu.upc.controller;
 
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

import pe.edu.upc.entity.Product;
import pe.edu.upc.serviceinterface.IBrandService;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.IStoreService;
import pe.edu.upc.serviceinterface.ICategoryService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService pS;
	
	@Autowired
	private IBrandService bS;

	@Autowired
	private ICategoryService cS;
	
	@Autowired
	private IStoreService sS; 
	

	@GetMapping("/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listBrand", bS.list());
		model.addAttribute("listCategory", cS.list());
		model.addAttribute("listStore", sS.list());
				return "product/product";
	}
	
	
	@PostMapping("/save")
	public String saveProduct(@Valid Product product, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			model.addAttribute("listBrand", bS.list());
			model.addAttribute("listCategory", cS.list());
			model.addAttribute("listStore", sS.list());
			return "product/product";
		}else {
			pS.insert(product);
		}
		model.addAttribute("listaProduct", pS.list());
		
		return "redirect:/products/list";
	}
	
	@GetMapping("/list")
	public String listProducts(Model model) {
		
		try {
			model.addAttribute("product", new Product());
			model.addAttribute("listBrand", bS.list());
			model.addAttribute("listCategory", cS.list());
			model.addAttribute("listStore", sS.list());
			model.addAttribute("listaProductos", pS.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar Productos en el controller");
		}
		return "product/listProduct";
	}
	
	@RequestMapping("/find")
	public String findBynProduct(Model model, @Validated Product product) throws ParseException{
		
		List<Product> listaProductos;
		listaProductos = pS.findBynProduct(product.getnProduct());
		if (listaProductos.isEmpty()) {
			model.addAttribute("mensaje", "No se encontro");
		}
		model.addAttribute("listaProductos", listaProductos);
		return "product/listProduct";
	}
	
	
	
	@RequestMapping("/findprice")
	public String findByPrice(Model model, @Validated Product product) throws ParseException{
		
		List<Product> listaProductos;
		listaProductos = pS.findByPrice(product.getMprice());
		if (listaProductos.isEmpty()) {
			model.addAttribute("mensaje", "No se encontro");
		}
		model.addAttribute("listaProductos", listaProductos);
		return "product/listProduct";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(Model model, @PathVariable (value="id") int id) throws ParseException{
		
		try {

			if (id > 0) {
				pS.delete(id);
			}
			model.addAttribute("product", new Product ());
			model.addAttribute("mensaje", "Se elimino correctamente");
			model.addAttribute("listaProductos",pS.list());
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("product", new Product());
			model.addAttribute("Mensaje","No se puede eliminar");
			model.addAttribute("listaProductos",pS.list());
		}
		return  "product/listProduct";
	}
		
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir){
		
		Optional<Product> objPro = pS.searchId(id);
		if (objPro == null) {
			objRedir.addFlashAttribute("mensaje", "ocurrio un error");
			return "redirect:products/list";
		}else {
			model.addAttribute("listBrand", bS.list());
			model.addAttribute("listCategory", cS.list());
			model.addAttribute("listStore", sS.list());
			model.addAttribute("product", objPro.get());
			return "product/uproduct";

		}
		
	}
	
	@PostMapping("/update")
	public String UpdateVaccine(@Valid Product product, BindingResult result, Model model, 
			SessionStatus status ) throws Exception {
		
		if (result.hasErrors()) {
			model.addAttribute("listBrand", bS.list());
			model.addAttribute("listCategory", cS.list());
			model.addAttribute("listStore", sS.list());
			return "product/uproduct";
		}else {
			pS.insert(product);
		}
		model.addAttribute("listaProduct", pS.list());
		
		return "redirect:/products/list";
	}
	
	
	@RequestMapping("/reporte2")
	public String top10Productos(Map<String, Object> model) {
		model.put("listTop10Productos", pS.top10Productos());
		return "reports/productosMasPedidos";
	}
	
}
