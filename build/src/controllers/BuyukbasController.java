package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.BuyukbasService;
import service.HissedarlarService;
import service.TahsilatService;
import forms.Buyukbas;
import forms.Hissedarlar;

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

	@RequestMapping("/buyukbasEkleme")
	public String buyukbas(@ModelAttribute("buyukbas") Buyukbas buyukbas,
			ModelMap model) {
	 model.put("list", buyukBasService.buyukbasList());
		model.put("error", hata);

		hata = "0";

		return "buyukbasekleme";
	}

	@RequestMapping(value = "/ekleBuyuk", method = RequestMethod.POST)
	public String ekleBuyukbas(@ModelAttribute("buyukbas") Buyukbas buyukbas,
			@RequestParam(value = "hayvanNo") Long hayvanNo,
			Hissedarlar hissedar) {
		buyukbas.setId(0);

		if (!buyukBasService.yediHisseyeUlastimi(hayvanNo)) {

			buyukbas.setHisseFiyati(0);
			buyukBasService.ekle(buyukbas);

			hissedar.setHayvanNo(buyukbas.getHayvanNo());
			hissedar.setSatisFiyati(buyukbas.getSatisFiyati());
			hissedarService.ekle(hissedar);

		} else {

			hata = "1";
			return "buyukbasekleme";
		}

		return "redirect:/buyukbasEkleme";
	}

	@RequestMapping(value = "/hayvanGetir/{hayvanNo}")
	public String hayvanGetir(@PathVariable("hayvanNo") Long hayvanNo) {

		buyukbas1 = buyukBasService.hayvanGetir(hayvanNo);

		System.out.println(buyukbas1.getHayvanNo() + " "
				+ buyukbas1.getAgirlik() + " " + buyukbas1.getSatisFiyati()
				+ " " + buyukbas1.getKesimUcreti());

		return ("redirect:/satis");
	}

	@RequestMapping(value = "/hayvanGetir")
	public String hayvanGetir2(@RequestParam("hayvanNo") Long hayvanNo) {

		buyukbas1 = buyukBasService.hayvanGetir(hayvanNo);

		System.out.println(buyukbas1.getHayvanNo() + " "
				+ buyukbas1.getAgirlik() + " " + buyukbas1.getSatisFiyati()
				+ " " + buyukbas1.getKesimUcreti());

		return ("redirect:/satis");
	}

	@RequestMapping("/buyukbasSatis")
	public String buyukbasSatis(
			@ModelAttribute("buyukbas") Hissedarlar buyukbas, ModelMap model) {

		if (buyukbas2 != null) {

			model.put("list", buyukbas2);

		} else

			model.put("list", buyukBasService.buyukbasList());

		return "buyukbassatis";
	}

	@RequestMapping(value = "/fiyataGoreBuyukbasGetirme", method = RequestMethod.POST)
	public String kiloyaBuyukbasGetirme(
			@RequestParam(value = "satisFiyati") Long fiyat) {

		if (fiyat == null) {
			buyukbas2 = buyukBasService.buyukbasList();

		} else
			buyukbas2 = buyukBasService.fiyataGoreHayvanGetir(fiyat);

		return "redirect:/buyukbasSatis";
	}

}
