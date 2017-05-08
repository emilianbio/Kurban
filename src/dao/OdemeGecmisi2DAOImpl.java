package dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import forms.OdemeGecmisi2;

@Repository
public class OdemeGecmisi2DAOImpl implements OdemeGecmisi2DAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void ekle(OdemeGecmisi2 odemeGecmisi) {
		sessionFactory.getCurrentSession().saveOrUpdate(odemeGecmisi);
	}

	@Override
	@Transactional
	public Long odemeSayisi(String isim) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				OdemeGecmisi2.class);
		crit.setProjection(Projections.rowCount());
		// crit.add(Restrictions.isNotNull(isim));
		crit.add(Restrictions.eq("isim", isim));
		return (Long) crit.uniqueResult();
	}
}