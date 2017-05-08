package dao;

import java.util.List;

import forms.Kucukbas;

public interface KucukbasDAO {
	public void ekle(Kucukbas kucukbas);

	List<Kucukbas> kucukbasList();
}
