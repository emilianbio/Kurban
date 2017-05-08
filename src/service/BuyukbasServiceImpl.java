package service;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BuyukbasDAO;
import forms.Buyukbas;

@Service
public class BuyukbasServiceImpl implements BuyukbasService {
	@Autowired
	BuyukbasDAO buyukBasDAO;

	@Override
	public void ekle(Buyukbas buyukbas) {
		buyukBasDAO.ekle(buyukbas);

	}

	@Override
	public List<Buyukbas> buyukbasList() {

		return buyukBasDAO.buyukbasList();
	}

	public Boolean yediHisseyeUlastimi(Long hayvanNo) {

		return buyukBasDAO.yediHisseyeUlastimi(hayvanNo);
	}

	@Override
	public List<Buyukbas> hissedarGetir(String isim) {
		// TODO Auto-generated method stub
		return buyukBasDAO.hissedarGetir(isim);
	}

	@Override
	public Buyukbas hayvanGetir(Long id) {
		// TODO Auto-generated method stub
		return buyukBasDAO.hayvanGetir(id);
	}

	@Override
	public List<Buyukbas> fiyataGoreHayvanGetir(Long fiyat) {

		return buyukBasDAO.fiyataGoreHayvanGetir(fiyat);
	}

	@Override
	public JSONArray büyükbasListesi() {

		return buyukBasDAO.büyükbasListesi();
	}

}
