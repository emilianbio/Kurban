package dao;

import java.util.List;

import forms.Giderler;

public interface GiderlerDAO {
	public void ekle(Giderler giderler);

	public List<Giderler> giderList();
}
