package dao;

import java.util.List;

import forms.Tahsilat;

public interface TahsilatDAO {
	public void ekle(Tahsilat tahsilat);

	public void guncelle(Tahsilat tahsilat);

	public Tahsilat tahsilatGetir(Long id);

	public Boolean telefonNoVarMi(String telno);

	List<Tahsilat> tahsilatList();

	List<Tahsilat> hissedarGetir(String isim);

	public void guncelle2(String telNo, int satisFiyati);

	List<Tahsilat> hayvanNoyaGöreHissedargetir(Long hayvanNo);

	// public List<Buyukbas> buyukbasList();
	//
	// public Boolean yediHisseyeUlastimi(Long hayvanNo);
	//
	// public List<Buyukbas> hissedarGetir(String isim);
	//
	// public Buyukbas hayvanGetir(Long id);
	//
	// public List<Buyukbas> kiloyaGoreHayvanGetir(Long kilo);
}
