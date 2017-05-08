package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import forms.Buyukbas;
import service.BuyukbasService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Controller
public class SayfaController {

	@Autowired
	private BuyukbasService buyukbasService;

	@SuppressWarnings("unused")
	private double sonuc1;
	public static long giristekiToplam = 0;

	public static long getGiristekiToplam() {
		return giristekiToplam;
	}

	private Long girilenSayi = 0l;

	@RequestMapping(value = "/girisedon")
	public String giriseDonus() {

		return "redirect:/giris";
	}

	@RequestMapping(value = "/buyukbasadon")
	public String buyukbasaDonus() {

		return "redirect:/buyukbasEkleme";
	}

	@RequestMapping(value = "/kucukbasadon")
	public String kucukbasaDonus() {

		return "redirect:/kucukbasEkleme";
	}

	@RequestMapping(value = "/tahsilatyonlendirme")
	public String tahsilatyonlendirme() {

		return "tahsilatYonlendirme";
	}

	public static long toplam(Long sayi) {
		long sum = 0L;
		if (sayi == 0)
			return 0;
		else if (sayi == 1)
			return 1;
		else

			for (int i = 0; i <= sayi; i++) {
				sum += i;
				// System.out.printf("%d'e kadar toplam: %d %n", i, sum);
			}
		if (sum < 0) {
			return 0;
		}
		System.out.printf("%d'e kadar toplam: %d %n", sayi, sum);
		return sum;
	}

	@RequestMapping(value = "/hesapla", method = RequestMethod.GET)
	@ResponseBody
	public Long toplam2(@RequestParam(value = "sayi", required = false) Long sayi, ModelMap model) {
		if (sayi == null)
			sayi = (long) 0;
		System.out.println(toplam(sayi));
		giristekiToplam = toplam(sayi);
		girilenSayi = sayi;
		model.put("sayi", sayi);

		return toplam(sayi);
	}

	@RequestMapping("/giris")
	public String giris(ModelMap model) {

		model.put("list", buyukbasService.büyükbasListesi());
		

		System.out.println(buyukbasService.büyükbasListesi() + "******");
		girilenSayi = 0l;
		giristekiToplam = 0;
		return "giris";
	}

	@RequestMapping("/open")
	public String openLayer() {
		return "openlayer";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/json1", method = RequestMethod.GET)
	public @ResponseBody JSONArray openLayerAjax0() {
		JSONObject jsonSonuc = new JSONObject();
		JSONArray donecek = new JSONArray();
		List<Buyukbas> list = new ArrayList<Buyukbas>();

		jsonSonuc.put("liste", list);
		donecek.add(list);
		System.out.println(donecek.toJSONString());

		return donecek;
	}

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public @ResponseBody String openLayerAjax() {

		SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy", new Locale("tr"));
		SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE", new Locale("tr"));
		SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss", new Locale("tr"));

		String date = sdf.format(new Date());
		String date2 = sdf2.format(new Date());
		String date3 = sdf3.format(new Date());
		String sonuc = "Tarih :" + date + "<br>" + date2 + "<br>Saat &nbsp; :" + date3;

		// System.out.println(sonuc);
		return sonuc;
	}

}
