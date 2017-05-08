package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SayfaController {

	@RequestMapping("/giris")
	public String giris() {

		return "giris";
	}

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

}
