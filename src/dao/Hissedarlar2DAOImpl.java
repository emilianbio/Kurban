package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import forms.Hissedarlar;
import forms.Hissedarlar2;

@Repository
public class Hissedarlar2DAOImpl implements Hissedarlar2DAO {
	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("unused")
	private Hissedarlar hissedarlar;

	@Override
	@Transactional
	public void ekle(Hissedarlar2 hissedarlar2) {
		sessionFactory.getCurrentSession().saveOrUpdate(hissedarlar2);
	}

	@Override
	@Transactional
	public Hissedarlar2 hissedarGetir(Long id) {
		@SuppressWarnings("unused")
		Session session = sessionFactory.openSession();
		Hissedarlar2 hissedarr = (Hissedarlar2) sessionFactory
				.getCurrentSession().get(Hissedarlar2.class, id);

		hissedarr.getId();
		return hissedarr;
	}

	@Override
	@Transactional
	public List<Hissedarlar2> hissedarList() {
		Criteria criteriaDemirbas = sessionFactory.getCurrentSession()
				.createCriteria(Hissedarlar2.class);
		// criteriaDemirbas.setProjection(Projections.property("hayvanNo"));
		criteriaDemirbas.addOrder(Order.desc("hayvanNo"));
		@SuppressWarnings("unchecked")
		List<Hissedarlar2> sonuc = criteriaDemirbas.list();

		// sessionFactory.close();
		return sonuc;

	}

}
