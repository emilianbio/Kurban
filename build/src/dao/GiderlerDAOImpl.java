package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import forms.Giderler;

@Repository
public class GiderlerDAOImpl implements GiderlerDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void ekle(Giderler giderler) {
		sessionFactory.getCurrentSession().saveOrUpdate(giderler);
	}

	@Override
	@Transactional
	public List<Giderler> giderList() {

		Criteria criteriaGider = sessionFactory.getCurrentSession()
				.createCriteria(Giderler.class);
		@SuppressWarnings("unchecked")
		List<Giderler> sonuc = criteriaGider.list();

		return sonuc;
	}

}
