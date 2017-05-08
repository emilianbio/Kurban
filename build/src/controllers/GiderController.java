package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import service.GiderlerService;
import forms.Giderler;

@Controller
public class GiderController {
	@Autowired
	private GiderlerService giderlerService;

	@RequestMapping("/giderler")
	public String giderler(@ModelAttribute("gider") Giderler giderler,
			ModelMap model) {
		model.put("giderList", giderlerService.giderList());

		return "giderler";
	}

	@RequestMapping(value = "/giderKaydet")
	public String giderKaydet(@ModelAttribute("gider") Giderler giderler) {
		giderlerService.ekle(giderler);
		return "redirect:/giderler";
	}
}
