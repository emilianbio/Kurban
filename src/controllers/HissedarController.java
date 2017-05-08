package controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.BuyukbasService;
import service.HissedarlarService;
import service.TahsilatService;
import forms.Hissedarlar;
import forms.Tahsilat;

@Controller
public class HissedarController {
	@Autowired
	private HissedarlarService hissedarService;
	@Autowired
	private TahsilatService tahsilatService;
	@Autowired
	private BuyukbasService buyukBasService;
	public List<Hissedarlar> hissedar1;
	private Hissedarlar hissedar;
	public String hata = "0";

	@RequestMapping(value = "/satis")
	public String satis(@ModelAttribute("hissedar") Hissedarlar hissedar1, ModelMap model) {

		if (hissedar == null) {
			hissedar = new Hissedarlar();
		}
		hissedar1.setId(0);
		model.put("hissedar", hissedar);
		System.out.println(new Date().getTime());
		model.put("list", hissedarService.hissedarList());
		System.out.println(new Date().getTime());
		model.put("error", hata);
		hissedar = null;
		hata = "0";
		return "satis";
	}

	@RequestMapping(value = "/hissedarGetir/{id}")
	public String hissedarGetir(@PathVariable("id") Long id) {

		hissedar = hissedarService.hissedarGetir(id);
		System.out.println("ID: " + hissedar.getId() + "\n" + hissedar.getHayvanNo() + " " + hissedar.getIsim() + " "
				+ hissedar.getSatisFiyati() + " " + hissedar.getIsim7());

		if (hissedar == null || !hissedar.equals(hissedarService.hissedarGetir(id))) {
			return "redirect:/satis";
		}
		return ("redirect:/satis");
	}

	@ResponseBody
	@RequestMapping(value = "/ekleSatis", method = RequestMethod.POST)
	public String ekleSatis(@ModelAttribute("hissedar") Hissedarlar hissedar1, Tahsilat tahsilat, ModelMap model,
			HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "hayvanNo", required = true) int hayvanNo,
			@RequestParam(value = "telNo", required = false) String telNo,
			@RequestParam(value = "telNo2", required = false) String telNo2,
			@RequestParam(value = "telNo3", required = false) String telNo3,
			@RequestParam(value = "telNo4", required = false) String telNo4,
			@RequestParam(value = "telNo5", required = false) String telNo5,
			@RequestParam(value = "telNo6", required = false) String telNo6,
			@RequestParam(value = "telNo7", required = false) String telNo7) {

		hissedar1.setIslamzamani(new Date());
		hissedarService.ekle(hissedar1);

		System.out.println(hissedar1.getIsim());
		System.out.println(hissedar1.getIsim2());
		System.out.println(hissedar1.getIsim3());

		System.out.println(hissedar1.getHisseFiyati());
		System.out.println(hissedar1.getHisseFiyati2());
		System.out.println(hissedar1.getHisseFiyati3());

		System.out.println(hissedar1.getHissesi());
		System.out.println(hissedar1.getHissesi2());
		System.out.println(hissedar1.getHissesi3());

		System.out.println(hissedar1.getReferans());
		System.out.println(hissedar1.getReferans2());
		System.out.println(hissedar1.getReferans3());

		System.out.println(hissedar1.getTelNo());
		System.out.println(hissedar1.getTelNo2());
		System.out.println(hissedar1.getTelNo3());

		System.out.println("0\n***************" + hayvanNo);

		// if (hissedar1.getTelNo() != "" && !hissedar1.getTelNo().isEmpty()
		// && !tahsilatService.telefonNoVarMi(hissedar1.getTelNo())) {
		// tahsilat.setTelNo(hissedar1.getTelNo());
		// tahsilat.setSatisFiyati(hissedar1.getHisseFiyati());
		// tahsilat.setIsim(hissedar1.getIsim());
		// tahsilatService.ekle(tahsilat);
		// } else if (telNo != "") {
		// tahsilatService.guncelle2(telNo, hissedar1.getHisseFiyati());
		// }
		//
		// if (hissedar1.getTelNo2() != "" && !hissedar1.getTelNo2().isEmpty()
		// && !tahsilatService.telefonNoVarMi(hissedar1.getTelNo2())) {
		// tahsilat.setTelNo(hissedar1.getTelNo2());
		// tahsilat.setSatisFiyati(hissedar1.getHisseFiyati2());
		// tahsilat.setIsim(hissedar1.getIsim2());
		// tahsilatService.ekle(tahsilat);
		// } else if (telNo2 != "") {
		// tahsilatService.guncelle2(telNo2, hissedar1.getHisseFiyati2());
		// }
		//
		// if (telNo3 != null) {
		// if (hissedar1.getTelNo3() != "" && !hissedar1.getTelNo3().isEmpty()
		// && !tahsilatService.telefonNoVarMi(hissedar1.getTelNo3())) {
		// tahsilat.setTelNo(hissedar1.getTelNo3());
		// tahsilat.setSatisFiyati(hissedar1.getHisseFiyati3());
		// tahsilat.setIsim(hissedar1.getIsim3());
		// tahsilatService.ekle(tahsilat);
		// } else if (telNo3 != "") {
		// tahsilatService.guncelle2(telNo3, hissedar1.getHisseFiyati3());
		// }
		// }
		// if (hissedar1.getTelNo4() != "" && !hissedar1.getTelNo4().isEmpty()
		// && !tahsilatService.telefonNoVarMi(hissedar1.getTelNo4())) {
		// tahsilat.setTelNo(hissedar1.getTelNo4());
		// tahsilat.setSatisFiyati(hissedar1.getHisseFiyati4());
		// tahsilat.setIsim(hissedar1.getIsim4());
		// tahsilatService.ekle(tahsilat);
		// } else if (telNo4 != "") {
		// tahsilatService.guncelle2(telNo4, hissedar1.getHisseFiyati4());
		// }
		// if (hissedar1.getTelNo5() != "" && !hissedar1.getTelNo5().isEmpty()
		// && !tahsilatService.telefonNoVarMi(hissedar1.getTelNo5())) {
		// tahsilat.setTelNo(hissedar1.getTelNo5());
		// tahsilat.setSatisFiyati(hissedar1.getHisseFiyati5());
		// tahsilat.setIsim(hissedar1.getIsim5());
		// tahsilatService.ekle(tahsilat);
		// } else if (telNo5 != "") {
		// tahsilatService.guncelle2(telNo5, hissedar1.getHisseFiyati5());
		// }
		// if (hissedar1.getTelNo6() != "" && !hissedar1.getTelNo6().isEmpty()
		// && !tahsilatService.telefonNoVarMi(hissedar1.getTelNo6())) {
		// tahsilat.setTelNo(hissedar1.getTelNo6());
		// tahsilat.setSatisFiyati(hissedar1.getHisseFiyati6());
		// tahsilat.setIsim(hissedar1.getIsim6());
		// tahsilatService.ekle(tahsilat);
		// } else if (telNo6 != "") {
		// tahsilatService.guncelle2(telNo6, hissedar1.getHisseFiyati6());
		// }
		// if (hissedar1.getTelNo7() != "" && !hissedar1.getTelNo7().isEmpty()
		// && !tahsilatService.telefonNoVarMi(hissedar1.getTelNo7())) {
		// tahsilat.setTelNo(hissedar1.getTelNo7());
		// tahsilat.setSatisFiyati(hissedar1.getHisseFiyati7());
		// tahsilat.setIsim(hissedar1.getIsim7());
		// tahsilatService.ekle(tahsilat);
		// } else if (telNo7 != "") {
		// tahsilatService.guncelle2(telNo7, hissedar1.getHisseFiyati7());
		// }

		hissedar1.setId(0);

		System.out.println("ekleSatis Çalıştı...");
		return "{}";
	}

	@RequestMapping(value = "/hissedarVazgec")
	public String vazgec(@ModelAttribute("hissedar") Hissedarlar hissedar1, ModelMap model) {

		hissedar = null;
		hata = "0";
		return "redirect:/satis";
	}
}
