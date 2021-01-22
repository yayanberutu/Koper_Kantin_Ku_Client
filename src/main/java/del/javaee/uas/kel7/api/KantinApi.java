package del.javaee.uas.kel7.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import del.javaee.uas.kel7.model.Pemesanan;
import del.javaee.uas.kel7.model.Produk;

public class KantinApi {

String url = "http://localhost:8080/";
	
	@Autowired RestTemplate restTemplate;
	
	public List<Produk> getAllProduk(){
		List<Produk> listProduk= Arrays.stream(restTemplate.getForObject(url + "produk/get", Produk[].class)).collect(Collectors.toList());
		return listProduk;
	}
	
	public Produk getProdukById(int id) {
		Produk produk = restTemplate.getForObject(url + "/produk/get/{id}", Produk.class, id);
		return produk;
	}
	
	public void deleteProduk(Integer id) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", id);
		restTemplate.delete(url + "/produk/delete/{id}", parameter);
	}
	
	public void updateProduk(Produk produk) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", produk.getId_produk());
		restTemplate.put(url + "produk/edit/{id}", produk, parameter);
	}
	
	public void addProduk(Produk produk) {
		restTemplate.postForObject(url + "/produk/add", produk, Produk.class);
	}
	
	public void addPemesanan(Pemesanan pesanan) {
		restTemplate.postForObject(url + "/pemesanan/add", pesanan, Pemesanan.class);
	}
	
}
