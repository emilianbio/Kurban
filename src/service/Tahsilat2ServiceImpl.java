package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Tahsilat2DAO;
import forms.Tahsilat2;

@Service
public class Tahsilat2ServiceImpl implements Tahsilat2Service {
	@Autowired
	Tahsilat2DAO tahsilat2DAO;

	@Override
	public void ekle(Tahsilat2 tahsilat2) {
		tahsilat2DAO.ekle(tahsilat2);
	}

	@Override
	public Boolean telefonNoVarMi(String telno) {
		return tahsilat2DAO.telefonNoVarMi(telno);
	}

	@Override
	public Tahsilat2 tahsilat2Getir(Long id) {
		// TODO Auto-generated method stub
		return tahsilat2DAO.tahsilat2Getir(id);
	}

	@Override
	public List<Tahsilat2> tahsilat2List() {
		// TODO Auto-generated method stub
		return tahsilat2DAO.tahsilat2List();
	}

	@Override
	public List<Tahsilat2> hissedar2Getir(String isim) {
		// TODO Auto-generated method stub
		return tahsilat2DAO.hissedar2Getir(isim);
	}

	@Override
	public void guncelle(Tahsilat2 tahsilat) {
		tahsilat2DAO.guncelle(tahsilat);
	}

}
