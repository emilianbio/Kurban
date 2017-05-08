package service;

import java.util.List;

import forms.Tahsilat2;

public interface Tahsilat2Service {

	public void ekle(Tahsilat2 tahsilat2);

	public Boolean telefonNoVarMi(String telno);

	public Tahsilat2 tahsilat2Getir(Long id);

	List<Tahsilat2> tahsilat2List();

	public List<Tahsilat2> hissedar2Getir(String isim);

	public void guncelle(Tahsilat2 tahsilat);
}
