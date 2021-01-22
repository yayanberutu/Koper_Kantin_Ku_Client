package del.javaee.uas.kel7.controller.user;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import del.javaee.uas.kel7.api.KantinApi;
import del.javaee.uas.kel7.model.Pemesanan;
import del.javaee.uas.kel7.model.Produk;

@RestController
@RequestMapping("/user/kantin")
public class KantinController {
	@Autowired KantinApi kantinapi;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("user/kantin/index");
		return mv;
	}
	
	@GetMapping("/makanan")
	public ModelAndView makanan(){
		List<Produk> listProduk = kantinapi.getAllProduk();
		ModelAndView mv = new ModelAndView("user/kantin/makanan");
		mv.addObject("produk", listProduk);
		mv.addObject("pemesanan", new Pemesanan());
		return mv;
	}
	
	@GetMapping("/checkout")
	public ModelAndView checkoutProduk(@PathVariable("id") int id) {
		Produk produk = kantinapi.getProdukById(id);
		ModelAndView mv = new ModelAndView("user/kantin/checkout");
		mv.addObject("produk", produk);
		return mv;
	}
	
	@RequestMapping("/buatpembayaran")
	public ModelAndView menungguPembayaran() {
		Random random = new Random();
		String inv = "";
		int num = random.nextInt(99999 - 10000) + 10000;
		inv += String.valueOf(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("inv_num", inv);
		return mv;
	}
	
	@RequestMapping("/pesanmakanan")
	public ModelAndView pesanMakan(@ModelAttribute Produk produk, HttpSession session) {
		Pemesanan pesanan = new Pemesanan();
		pesanan.setId_produk(produk.getId_produk());
		pesanan.setId_user((int) session.getAttribute("id_user"));
		pesanan.setJumlah_harga(produk.getStock() * produk.getHarga());
		pesanan.setTanggal_pemesanan(new Date());
		pesanan.setStatus_bayar(0);
		pesanan.setStatus_produk(0);
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
}
