package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HissedarlarDAO;
import forms.Hissedarlar;

@Service
public class HissedarlarServiceImpl implements HissedarlarService {
	@Autowired
	HissedarlarDAO hissedarDAO;

	@Override
	public void ekle(Hissedarlar hissedarlar) {
		hissedarDAO.ekle(hissedarlar);

	}

	@Override
	public List<Hissedarlar> hissedarList() {

		return hissedarDAO.hissedarList();
	}

	public Long yediHisseyeUlastimi(Long hayvanNo) {

		return hissedarDAO.yediHisseyeUlastimi(hayvanNo);
	}

	@Override
	public List<Hissedarlar> hissedarGetir(String isim) {
		// TODO Auto-generated method stub
		return hissedarDAO.hissedarGetir(isim);
	}

	@Override
	public Long hisseToplami(Long hayvanNo) {
		// TODO Auto-generated method stub
		return hissedarDAO.hisseToplami(hayvanNo);
	}

	@Override
	public void guncelle(Hissedarlar hissedarlar) {
		hissedarDAO.guncelle(hissedarlar);

	}

	@Override
	public Hissedarlar hissedarGetir(Long id) {
		// TODO Auto-generated method stub
		return hissedarDAO.hissedarGetir(id);
	}

	@Override
	public Hissedarlar hayvanNoyaGöreHissedatGetir(Long hayvanNo) {
		// TODO Auto-generated method stub
		return hissedarDAO.hayvanNoyaGöreHissedatGetir(hayvanNo);
	}

	@Override
	public Boolean telefonnoVarMi(String telno) {
		// TODO Auto-generated method stub
		return hissedarDAO.telefonnoVarMi(telno);
	}

}
