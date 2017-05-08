package dao;

import java.util.List;

import forms.Buyukbas;

public interface BuyukbasDAO {
	public void ekle(Buyukbas buyukbas);

	public List<Buyukbas> buyukbasList();

	public Boolean yediHisseyeUlastimi(Long hayvanNo);

	public List<Buyukbas> hissedarGetir(String isim);

	public Buyukbas hayvanGetir(Long id);

	public List<Buyukbas> fiyataGoreHayvanGetir(Long fiyat);
}
