package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OdemeGecmisi2DAO;
import forms.OdemeGecmisi2;

@Service
public class OdemeGecmisi2ServiceImpl implements OdemeGecmisi2Service {
	@Autowired
	OdemeGecmisi2DAO odemeGecmisiDAO;

	@Override
	public void ekle(OdemeGecmisi2 odemeGecmisi) {
		odemeGecmisiDAO.ekle(odemeGecmisi);
	}

	@Override
	public Long odemeSayisi(String isim) {
		// TODO Auto-generated method stub
		return odemeGecmisiDAO.odemeSayisi(isim);
	}

}
