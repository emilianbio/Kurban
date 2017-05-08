package dao;

import java.util.List;

import forms.Hissedarlar2;

public interface Hissedarlar2DAO {

	public void ekle(Hissedarlar2 hissedarlar2);

	Hissedarlar2 hissedarGetir(Long id);

	List<Hissedarlar2> hissedarList();

	// public void guncelle(Hissedarlar hissedarlar);
	//
	// public List<Hissedarlar> hissedarList();
	//
	// public Long yediHisseyeUlastimi(Long hayvanNo);
	//
	// public List<Hissedarlar> hissedarGetir(String isim);
	//
	// public Long hisseToplami(Long hayvanNo);
	//
	// public Hissedarlar hissedarGetir(Long id);
	//
	// public Hissedarlar hayvanNoyaGöreHissedatGetir(Long hayvanNo);
	//
	// public Boolean telefonnoVarMi(String telno);
}
