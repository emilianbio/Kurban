package service;

import java.util.List;

import forms.Tahsilat;

public interface TahsilatService {

	public void ekle(Tahsilat tahsilat);

	public void guncelle2(String telNo, int satisFiyati);

	public void guncelle(Tahsilat tahsilat);

	public Tahsilat tahsilatGetir(Long id);

	public Boolean telefonNoVarMi(String telno);

	List<Tahsilat> tahsilatList();

	List<Tahsilat> hissedarGetir(String isim);

	List<Tahsilat> hayvanNoyaGöreHissedargetir(Long hayvanNo);
}
