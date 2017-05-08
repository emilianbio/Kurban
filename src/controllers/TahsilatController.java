package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.HissedarlarService;
import service.OdemeGecmisi2Service;
import service.OdemeGecmisiService;
import service.Tahsilat2Service;
import service.TahsilatService;

import com.google.gson.Gson;

import forms.Hissedarlar;
import forms.Hissedarlar2;
import forms.OdemeGecmisi;
import forms.OdemeGecmisi2;
import forms.Tahsilat;
import forms.Tahsilat2;

@Controller
public class TahsilatController {
	@SuppressWarnings("unused")
	private Hissedarlar hissedar;
	public List<Hissedarlar> hissedar1;
	public List<Hissedarlar2> hissedar2;
	private Tahsilat tahsilat1;
	private Tahsilat2 tahsilat2;
	public List<Tahsilat> tahsilatList;
	public List<Tahsilat2> tahsilat2List;
	@Autowired
	private TahsilatService tahsilatService;
	@Autowired
	private Tahsilat2Service tahsilat2Service;
	@Autowired
	private OdemeGecmisiService odemeGecmisiService;
	@Autowired
	private OdemeGecmisi2Service odemeGecmisi2Service;
	@Autowired
	private HissedarlarService hissedarService;
	public int a = 0;

	public String isim = null;

	@SuppressWarnings({ "unchecked" })
	private JSONArray büyükbasHissedarİsimleri(String isim) {
		JSONArray donecek = new JSONArray();
		List<Tahsilat> isimListesi = new ArrayList<Tahsilat>();
		isimListesi = tahsilatService.hissedarGetir(isim);
		Iterator<Tahsilat> iterator = isimListesi.iterator();
		while (iterator.hasNext()) {
			// JSONObject jsonObject = new JSONObject();
			Tahsilat tip = iterator.next();
			// jsonObject.put("isim2", tip.getTelNo());
			// donecek.add(jsonObject);
			donecek.add(tip.getIsim());
		}
		return donecek;
	}

	@SuppressWarnings({ "unchecked" })
	private JSONArray büyükbasHayvanNo(String isim) {
		JSONArray donecek = new JSONArray();
		List<Tahsilat> isimListesi = new ArrayList<Tahsilat>();
		isimListesi = tahsilatService.hissedarGetir(isim);
		Iterator<Tahsilat> iterator = isimListesi.iterator();
		while (iterator.hasNext()) {
			// JSONObject jsonObject = new JSONObject();
			Tahsilat tip = iterator.next();
			// jsonObject.put("isim2", tip.getTelNo());
			// donecek.add(jsonObject);
			donecek.add(tip.getHayvanNo().toString());
		}
		return donecek;
	}

	@RequestMapping(value = "/tahsilat")
	public String tahsilat(@ModelAttribute("tahsilat") Tahsilat tahsilat,
			@RequestParam(value = "id", required = false) Long id,
			ModelMap model) {

		// model.put("tahsilat", tahsilat);
	
			model.put("tahsilat", tahsilatService.tahsilatGetir(id));
	
		tahsilat1 = null;

		if (tahsilatList != null) {

			model.put("list", tahsilatList);
		} else {
			model.put("list", tahsilatService.tahsilatList());
		}

		tahsilatList = null;
		return "tahsilat";
	}

	@RequestMapping(value = "/tahsilatGiris", method = RequestMethod.POST)
	public String tahsilatGiris(Tahsilat tahsilat, Hissedarlar hissedarlar,
			OdemeGecmisi odemeGecmisi) {

		// tahsilat.setId(0);
		// tahsilat.setSatisFiyati(hissedarlar.getHisseFiyati());
		Date date = new Date();

		tahsilat.setOdemezamani(date);
		tahsilatService.guncelle(tahsilat);
		odemeGecmisi.setOdemezamani(date);
		odemeGecmisi.setId(0);
		odemeGecmisiService.ekle(odemeGecmisi);
		System.out.println(date.toString());

		hissedar1 = null;
		// hissedarService.guncelle(hissedarlar);
		return "redirect:/tahsilat";
	}

	@ResponseBody
	@RequestMapping(value = "/tahsilaticinHissedarGetir", method = RequestMethod.GET)
	public String tahsilaticinHissedarGetir(@RequestParam("id") Long id) {

		tahsilat1 = tahsilatService.tahsilatGetir(id);

		System.out.println("tahsilaticinhissedargetir fonsiyonu çalışıyor");

		return ("tahsilat");
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/hissedarOtomatikTamamlama", method = RequestMethod.GET)
	public String hissedarOtomatikTamamlama(
			@RequestParam(value = "term") String term, ModelMap model) {
		tahsilat1 = null;

		tahsilatList = büyükbasHissedarİsimleri(term);
		// tahsilatList = tahsilatService.hissedarGetir(isim);

		Gson gson = new Gson();

		System.out.println(gson.toJson(büyükbasHissedarİsimleri(term))
				.toUpperCase());

		return gson.toJson(büyükbasHissedarİsimleri(term).toArray());

	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/hayvanNoOtomatikTamamlama", method = RequestMethod.GET)
	public String hayvanNoOtomatikTamamlama(
			@RequestParam(value = "term") String term, ModelMap model) {
		tahsilat1 = null;
		long a = new Date().getTime();

		System.out.println(a);
		tahsilatList = büyükbasHayvanNo(term);
		// tahsilatList = tahsilatService.hissedarGetir(isim);
		long b = new Date().getTime();
		System.out.print(b + "     ");
		System.out.println(b - a);

		Gson gson = new Gson();

		System.out.println(gson.toJson(büyükbasHayvanNo(term).toArray()));

		return gson.toJson(büyükbasHayvanNo(term).toArray());

	}

	@RequestMapping(value = "/hissedarArama", method = RequestMethod.POST)
	public String hissedarArama(@RequestParam(value = "isim") String isim,
			ModelMap model) {
		tahsilat1 = null;
		long a = new Date().getTime();

		System.out.println(a);
		tahsilatList = tahsilatService.hissedarGetir(isim);
		// tahsilatList = tahsilatService.hissedarGetir(isim);
		long b = new Date().getTime();
		System.out.print(b + "     ");
		System.out.println(b - a);

		return "redirect:/tahsilat";

	}

	@RequestMapping(value = "/hayvanNoArama", method = RequestMethod.POST)
	public String hayvanNoArama(
			@RequestParam(value = "hayvanNo") Long hayvanNo, ModelMap model) {
		tahsilat1 = null;
		long a = new Date().getTime();

		System.out.println(a);
		tahsilatList = tahsilatService.hayvanNoyaGöreHissedargetir(hayvanNo);
		long b = new Date().getTime();
		System.out.print(b + "     ");
		System.out.println(b - a);
		return "redirect:/tahsilat";
	}

	@RequestMapping(value = "/tahsilatmakbuzyazdir")
	public String makbuzYaz(@ModelAttribute("tahsilat") Tahsilat tahsilat,
			ModelMap model) {

		a++;

		if (tahsilat1 == null) {

			tahsilat1 = new Tahsilat();
		}
		model.put("odemeSayisi",
				odemeGecmisiService.odemeSayisi(tahsilat1.getIsim()));

		System.out.println(tahsilat1.getIsim());
		model.put("makbuzyazdirma", tahsilat1);

		tahsilat1 = null;
		return "makbuzyazdir";
	}

	@RequestMapping(value = "/makbuzicinHissedarGetir/{id}")
	public String makbuziçinHissedarGetir(@PathVariable("id") Long id) {

		tahsilat1 = tahsilatService.tahsilatGetir(id);

		System.out.println(tahsilat1.getId() + " " + tahsilat1.getTelNo() + " "
				+ tahsilat1.getSatisFiyati() + " ");

		return ("redirect:/tahsilatmakbuzyazdir");
	}

	@RequestMapping(value = "/tahsilat2")
	public String tahsilat2(@ModelAttribute("tahsilat2") Tahsilat2 tahsilat,
			ModelMap model) {

		// model.put("tahsilat", tahsilat);
		model.put("tahsilat2", tahsilat2);

		tahsilat2 = null;

		if (tahsilat2List != null) {

			model.put("list", tahsilat2List);
		} else {
			model.put("list", tahsilat2Service.tahsilat2List());
		}

		tahsilat2List = null;
		return "tahsilat2";
	}

	@RequestMapping(value = "/tahsilat2icinHissedarGetir/{id}")
	public String tahsilat2icinHissedarGetir(@PathVariable("id") Long id) {

		tahsilat2 = tahsilat2Service.tahsilat2Getir(id);

		System.out.println(tahsilat2.getId() + " " + tahsilat2.getTelNo() + " "
				+ tahsilat2.getSatisFiyati() + " ");

		return ("redirect:/tahsilat2");
	}

	@RequestMapping(value = "/hissedar2Arama", method = RequestMethod.POST)
	public String hissedar2Arama(@RequestParam(value = "isim") String isim,
			ModelMap model) {
		tahsilat2 = null;
		long a = new Date().getTime();

		System.out.println(a);
		tahsilat2List = tahsilat2Service.hissedar2Getir(isim);
		long b = new Date().getTime();
		System.out.print(b + "     ");
		System.out.println(b - a);
		return "redirect:/tahsilat2";
	}

	@RequestMapping(value = "/tahsilat2makbuzyazdir")
	public String makbuz2Yaz(@ModelAttribute("tahsilat2") Tahsilat2 tahsilat,
			ModelMap model) {

		a++;

		if (tahsilat2 == null) {

			tahsilat2 = new Tahsilat2();
		}
		model.put("odemeSayisi",
				odemeGecmisi2Service.odemeSayisi(tahsilat2.getIsim()));

		model.put("makbuzyazdirma", tahsilat2);

		tahsilat2 = null;
		return "makbuzyazdir2";
	}

	@RequestMapping(value = "/makbuz2icinHissedarGetir/{id}")
	public String makbuz2içinHissedarGetir(@PathVariable("id") Long id) {

		tahsilat2 = tahsilat2Service.tahsilat2Getir(id);

		System.out.println(tahsilat2.getId() + " " + tahsilat2.getTelNo() + " "
				+ tahsilat2.getSatisFiyati() + " ");

		return ("redirect:/tahsilat2makbuzyazdir");
	}

	@RequestMapping(value = "/tahsilat2Giris", method = RequestMethod.POST)
	public String tahsilat2Giris(Tahsilat2 tahsilat, Hissedarlar2 hissedarlar,
			OdemeGecmisi2 odemeGecmisi) {

		// tahsilat.setId(0);
		// tahsilat.setSatisFiyati(hissedarlar.getHisseFiyati());
		Date date = new Date();

		tahsilat.setOdemezamani(date);
		tahsilat2Service.guncelle(tahsilat);
		odemeGecmisi.setOdemezamani(date);
		odemeGecmisi.setId(0);
		odemeGecmisi2Service.ekle(odemeGecmisi);
		System.out.println(date.toString());

		hissedar2 = null;
		// hissedarService.guncelle(hissedarlar);
		return "redirect:/tahsilat2";
	}
}
