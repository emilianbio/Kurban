package service;

import java.util.List;

import forms.Kucukbas;

public interface KucukbasService {

	public void ekle(Kucukbas kucukbas);

	List<Kucukbas> kucukbasList();
}
