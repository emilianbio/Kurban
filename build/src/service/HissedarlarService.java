package service;

import java.util.List;

import forms.Hissedarlar;

public interface HissedarlarService {
	public void ekle(Hissedarlar hissedarlar);

	public void guncelle(Hissedarlar hissedarlar);

	public List<Hissedarlar> hissedarList();

	public Long yediHisseyeUlastimi(Long hayvanNo);

	public List<Hissedarlar> hissedarGetir(String isim);

	public Long hisseToplami(Long hayvanNo);

	public Hissedarlar hissedarGetir(Long id);

	public Hissedarlar hayvanNoyaGöreHissedatGetir(Long hayvanNo);

	public Boolean telefonnoVarMi(String telno);
}
