package dao;

import java.util.List;

import forms.Tahsilat;
import forms.Tahsilat2;

public interface Tahsilat2DAO {
	public void ekle(Tahsilat2 tahsilat2);

	public Tahsilat2 tahsilat2Getir(Long id);

	public Boolean telefonNoVarMi(String telno);

	List<Tahsilat2> tahsilat2List();

	List<Tahsilat2> hissedar2Getir(String isim);

	public void guncelle2(String telNo, int satisFiyati);

	public void guncelle(Tahsilat2 tahsilat);
}
