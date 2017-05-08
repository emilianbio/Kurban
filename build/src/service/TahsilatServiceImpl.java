package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TahsilatDAO;
import forms.Tahsilat;

@Service
public class TahsilatServiceImpl implements TahsilatService {
	@Autowired
	TahsilatDAO tahsilatDAO;

	@Override
	public void ekle(Tahsilat tahsilat) {
		tahsilatDAO.ekle(tahsilat);
	}

	@Override
	public void guncelle(Tahsilat tahsilat) {
		tahsilatDAO.guncelle(tahsilat);
	}

	@Override
	public Tahsilat tahsilatGetir(Long id) {
		return tahsilatDAO.tahsilatGetir(id);
	}

	@Override
	public Boolean telefonNoVarMi(String telno) {
		// TODO Auto-generated method stub
		return tahsilatDAO.telefonNoVarMi(telno);
	}

	@Override
	public List<Tahsilat> tahsilatList() {
		// TODO Auto-generated method stub
		return tahsilatDAO.tahsilatList();
	}

	@Override
	public List<Tahsilat> hissedarGetir(String isim) {
		// TODO Auto-generated method stub
		return tahsilatDAO.hissedarGetir(isim);
	}

	@Override
	public void guncelle2(String telNo, int satisFiyati) {
		tahsilatDAO.guncelle2(telNo, satisFiyati);

	}

}
