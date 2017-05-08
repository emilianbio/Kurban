package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OdemeGecmisiDAO;
import forms.OdemeGecmisi;

@Service
public class OdemeGecmisiServiceImpl implements OdemeGecmisiService {
	@Autowired
	OdemeGecmisiDAO odemeGecmisiDAO;

	@Override
	public void ekle(OdemeGecmisi odemeGecmisi) {
		odemeGecmisiDAO.ekle(odemeGecmisi);
	}

	@Override
	public Long odemeSayisi(String isim) {
		// TODO Auto-generated method stub
		return odemeGecmisiDAO.odemeSayisi(isim);
	}

}
