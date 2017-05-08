package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Hissedarlar2DAO;
import forms.Hissedarlar2;

@Service
public class Hissedarlar2ServiceImpl implements Hissedarlar2Service {
	@Autowired
	Hissedarlar2DAO hissedar2DAO;

	@Override
	public void ekle(Hissedarlar2 hissedarlar2) {
		hissedar2DAO.ekle(hissedarlar2);

	}

	@Override
	public Hissedarlar2 hissedarGetir(Long id) {
		// TODO Auto-generated method stub
		return hissedar2DAO.hissedarGetir(id);
	}

	@Override
	public List<Hissedarlar2> hissedarList() {
		// TODO Auto-generated method stub
		return hissedar2DAO.hissedarList();
	}

	// @Override
	// public List<Hissedarlar> hissedarList() {
	//
	// return hissedarDAO.hissedarList();
	// }
	//
	// public Long yediHisseyeUlastimi(Long hayvanNo) {
	//
	// return hissedarDAO.yediHisseyeUlastimi(hayvanNo);
	// }
	//
	// @Override
	// public List<Hissedarlar> hissedarGetir(String isim) {
	// // TODO Auto-generated method stub
	// return hissedarDAO.hissedarGetir(isim);
	// }
	//
	// @Override
	// public Long hisseToplami(Long hayvanNo) {
	// // TODO Auto-generated method stub
	// return hissedarDAO.hisseToplami(hayvanNo);
	// }
	//
	// @Override
	// public void guncelle(Hissedarlar hissedarlar) {
	// hissedarDAO.guncelle(hissedarlar);
	//
	// }
	//
	// @Override
	// public Hissedarlar hissedarGetir(Long id) {
	// // TODO Auto-generated method stub
	// return hissedarDAO.hissedarGetir(id);
	// }
	//
	// @Override
	// public Hissedarlar hayvanNoyaGöreHissedatGetir(Long hayvanNo) {
	// // TODO Auto-generated method stub
	// return hissedarDAO.hayvanNoyaGöreHissedatGetir(hayvanNo);
	// }
	//
	// @Override
	// public Boolean telefonnoVarMi(String telno) {
	// // TODO Auto-generated method stub
	// return hissedarDAO.telefonnoVarMi(telno);
	// }

}
