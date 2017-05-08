package dao;

import forms.OdemeGecmisi;

public interface OdemeGecmisiDAO {
	public void ekle(OdemeGecmisi odemeGecmisi);

	public Long odemeSayisi(String isim);
}
