package service;

import java.util.List;

import forms.Giderler;

public interface GiderlerService {

	public void ekle(Giderler giderler);

	public List<Giderler> giderList();
}
