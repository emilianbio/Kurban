package controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.Hissedarlar2Service;
import service.KucukbasService;
import service.Tahsilat2Service;
import forms.Hissedarlar2;
import forms.Kucukbas;
import forms.Tahsilat2;

@Controller
public class KucukbasController {
	@Autowired
	private KucukbasService kucukBasService;
	@Autowired
	private Hissedarlar2Service hissedarlar2Service;
	@Autowired
	private Tahsilat2Service tahsilat2Service;
	public Hissedarlar2 hissedarlar;
	public String hata = "0";

	@RequestMapping("/kucukbasEkleme")
	public String kucukbas(@ModelAttribute("kucukbas") Kucukbas kucukbas,
			ModelMap modelMap) {

		modelMap.put("kucukbasList", kucukBasService.kucukbasList());

		return "kucukbasekleme";
	}

	@RequestMapping(value = "/ekleKucuk", method = RequestMethod.POST)
	public String ekleKucukbas(@ModelAttribute("kucukbas") Kucukbas kucukbas,
			Hissedarlar2 hissedarlar2) {
		kucukbas.setId(0);
		kucukBasService.ekle(kucukbas);

		hissedarlar2.setIslamzamani(new Date());
		hissedarlar2.setHayvanNo(kucukbas.getHayvanNo());
		hissedarlar2.setSatisFiyati(kucukbas.getSatisFiyati());
		hissedarlar2Service.ekle(hissedarlar2);

		return "redirect:/kucukbasEkleme";
	}

	@RequestMapping("/satis2")
	public String kucukbasSatis(
			@ModelAttribute("hissedar2") Hissedarlar2 hissedarlar2,
			ModelMap model) {

		model.put("sayi", SayfaController.getGiristekiToplam());
		model.put("error", hata);

		if (hissedarlar == null) {

			hissedarlar = new Hissedarlar2();
		}
		model.put("hissedar2", hissedarlar);

		model.put("list", hissedarlar2Service.hissedarList());
		hissedarlar = null;
		hata = "0";

		return "satis2";
	}

	@RequestMapping(value = "/ekleKucukSatis", method = RequestMethod.POST)
	public String ekleSatis(
			@ModelAttribute("hissedar2") Hissedarlar2 hissedarlar2,
			Tahsilat2 tahsilat2, ModelMap model, HttpServletResponse response,
			HttpServletRequest request) {

		if (hissedarlar2.getTelNo() != "" && !hissedarlar2.getTelNo().isEmpty()
				&& !tahsilat2Service.telefonNoVarMi(hissedarlar2.getTelNo())) {

			System.out.println("telno YOKKKKKK");
			tahsilat2.setId(0);
			tahsilat2.setTelNo(hissedarlar2.getTelNo());
			tahsilat2.setIsim(hissedarlar2.getIsim());
			tahsilat2.setSatisFiyati(hissedarlar2.getSatisFiyati());
			tahsilat2Service.ekle(tahsilat2);
			hissedarlar2.setIslamzamani(new Date());
			hissedarlar2Service.ekle(hissedarlar2);
		} else {
			System.out.println("tel no VARRRRR");
			hata = "1";

		}

		return ("redirect:/satis2");
	}

	@RequestMapping(value = "/hissedar2Getir/{id}")
	public String hissedar2Getir(@PathVariable("id") Long id) {

		hissedarlar = hissedarlar2Service.hissedarGetir(id);

		return ("redirect:/satis2");
	}
}
