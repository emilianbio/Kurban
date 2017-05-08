package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import service.BuyukbasService;
import service.HissedarlarService;
import service.TahsilatService;
import forms.Buyukbas;
import forms.Hissedarlar;
import forms.Tahsilat;

@Controller
public class BuyukbasController {
	@Autowired
	private BuyukbasService buyukBasService;
	@Autowired
	private TahsilatService tahsilatService;
	public String hata = "0";
	private Buyukbas buyukbas1;
	@SuppressWarnings("unused")
	private Hissedarlar hissedar;
	public List<Buyukbas> buyukbas2;
	@Autowired
	private HissedarlarService hissedarService;

	@SuppressWarnings({ "unchecked" })
	@ResponseBody
	private JSONArray büyükbaslistesi() {
		JSONArray donecek = new JSONArray();
		List<Buyukbas> buyukbasListesi = new ArrayList<Buyukbas>();
		buyukbasListesi = buyukBasService.buyukbasList();
		Iterator<Buyukbas> iterator = buyukbasListesi.iterator();
		while (iterator.hasNext()) {
			JSONObject jsonObject = new JSONObject();
			Buyukbas tip = iterator.next();
			jsonObject.put("id", tip.getId());
			jsonObject.put("isim", tip.getIsim());
			jsonObject.put("hayvanNo", tip.getHayvanNo());
			jsonObject.put("agirlik", tip.getAgirlik());
			jsonObject.put("alisFiyati", tip.getAlisFiyati());
			jsonObject.put("satisFiyati", tip.getSatisFiyati());
			jsonObject.put("kesimUcreti", tip.getKesimUcreti());
			jsonObject.put("kupeNo", tip.getKupeNo());
			// donecek.add(tip.getAlisFiyati());
			// donecek.add(tip.getHisseFiyati());
			// donecek.add(tip.getSatisFiyati());
			// donecek.add(tip.getHayvanNo());
			donecek.add(jsonObject);
		}

		// for (int i = 0; i < donecek.size(); i++) {
		// System.out.println("for döngüsü" + donecek.get(i));
		// }
		Gson gson = new Gson();
		for (int i = 0; i < donecek.size(); i++) {
			// System.out.println("************ " +
			// donecek.listIterator(i).next());
		}
		return (donecek);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String list() {

		Gson gson = new Gson();
		System.out.println("/list" + " " + buyukBasService.büyükbasListesi().size() + "*****");

		return (gson.toJson(buyukBasService.büyükbasListesi()));
	}

	@RequestMapping("/jquery")
	public String jQuery(ModelMap modelMap) {

		modelMap.put("list", buyukBasService.büyükbasListesi());
		return "jquery_deneme";
	}

	@RequestMapping("/buyukbasEkleme")
	public String buyukbas(@ModelAttribute("buyukbas") Buyukbas buyukbas, ModelMap model) {
		// model.put("list", buyukBasService.buyukbasList());
		model.put("error", hata);
		model.put("list", buyukBasService.büyükbasListesi());

		System.out.println("buyukbasekleme :" + " " + büyükbaslistesi());

		System.out.println("buyukbasekleme 2:" + " " + buyukBasService.büyükbasListesi());
		hata = "0";

		
		

		return "buyukbasekleme";

	}

	@RequestMapping(value = "/ekleBuyuk", method = RequestMethod.POST)
	@ResponseBody
	public String ekleBuyukbas(Buyukbas buyukbas) {
		// @RequestParam(value = "hayvanNo") Long hayvanNo,
		// Hissedarlar hissedar
		buyukbas.setId(0);
		System.out.println("ekleBuyuk çalıştı");
		// if (!buyukBasService.yediHisseyeUlastimi(hayvanNo)) {
		//
		// buyukbas.setHisseFiyati(0);
		// buyukBasService.ekle(buyukbas);
		//
		// hissedar.setHayvanNo(buyukbas.getHayvanNo());
		// hissedar.setSatisFiyati(buyukbas.getSatisFiyati());
		// hissedarService.ekle(hissedar);
		//
		// } else {
		//
		// hata = "1";
		// return "buyukbasekleme";
		// }
		buyukBasService.ekle(buyukbas);
		return "";
	}

	@RequestMapping(value = "/hayvanGetir/{hayvanNo}")
	public String hayvanGetir(@PathVariable("hayvanNo") Long hayvanNo) {

		buyukbas1 = buyukBasService.hayvanGetir(hayvanNo);

		System.out.println(buyukbas1.getHayvanNo() + " " + buyukbas1.getAgirlik() + " " + buyukbas1.getSatisFiyati()
				+ " " + buyukbas1.getKesimUcreti());

		return ("redirect:/satis");
	}

	@RequestMapping(value = "/hayvanGetir")
	public String hayvanGetir2(@RequestParam("hayvanNo") Long hayvanNo) {

		buyukbas1 = buyukBasService.hayvanGetir(hayvanNo);

		System.out.println(buyukbas1.getHayvanNo() + " " + buyukbas1.getAgirlik() + " " + buyukbas1.getSatisFiyati()
				+ " " + buyukbas1.getKesimUcreti());

		return ("redirect:/satis");
	}

	@RequestMapping("/buyukbasSatis")
	public String buyukbasSatis(@ModelAttribute("buyukbas") Hissedarlar buyukbas, ModelMap model) {

		if (buyukbas2 != null) {

			model.put("list", buyukbas2);

		} else

			model.put("list", buyukBasService.buyukbasList());

		return "buyukbassatis";
	}

	@RequestMapping(value = "/fiyataGoreBuyukbasGetirme", method = RequestMethod.POST)
	public String kiloyaBuyukbasGetirme(@RequestParam(value = "satisFiyati") Long fiyat) {

		if (fiyat == null) {
			buyukbas2 = buyukBasService.buyukbasList();

		} else
			buyukbas2 = buyukBasService.fiyataGoreHayvanGetir(fiyat);

		return "redirect:/buyukbasSatis";
	}

}
