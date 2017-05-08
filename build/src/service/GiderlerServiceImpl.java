package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GiderlerDAO;
import forms.Giderler;

@Service
public class GiderlerServiceImpl implements GiderlerService {
	@Autowired
	GiderlerDAO giderlerDAO;

	@Override
	public void ekle(Giderler giderler) {
		giderlerDAO.ekle(giderler);

	}

	@Override
	public List<Giderler> giderList() {

		return giderlerDAO.giderList();

	}

}
