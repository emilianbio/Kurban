package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.KucukbasDAO;
import forms.Kucukbas;

@Service
public class KucukbasServiceImpl implements KucukbasService {
	@Autowired
	KucukbasDAO kucukBasDAO;

	@Override
	public void ekle(Kucukbas kucukbas) {
		kucukBasDAO.ekle(kucukbas);

	}

	@Override
	public List<Kucukbas> kucukbasList() {
		return kucukBasDAO.kucukbasList();
	}

}
