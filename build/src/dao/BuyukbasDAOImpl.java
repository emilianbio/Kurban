package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import forms.Buyukbas;

@Repository
public class BuyukbasDAOImpl implements BuyukbasDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void ekle(Buyukbas buyukbas) {
		sessionFactory.getCurrentSession().saveOrUpdate(buyukbas);
	}

	@Override
	@Transactional
	public List<Buyukbas> buyukbasList() {
		Criteria criteriaDemirbas = sessionFactory.getCurrentSession()
				.createCriteria(Buyukbas.class);
		criteriaDemirbas.addOrder(Order.desc("hayvanNo"));
		@SuppressWarnings("unchecked")
		List<Buyukbas> sonuc = criteriaDemirbas.list();
		return sonuc;

	}

	@Transactional
	public Boolean yediHisseyeUlastimi(Long hayvanNo) {
		// Criteria crit = sessionFactory.getCurrentSession().createCriteria(
		// Buyukbas.class);
		// crit.setProjection(Projections.rowCount()).uniqueResult();
		//
		// // crit.add(Restrictions.isNotNull("hayvanNo"));
		// // crit.add(Restrictions.eq("hayvanNo", true));
		// List<Buyukbas> hayvanNo = crit.list();
		// // Integer count = students.size();
		// return hayvanNo;

		Session session = sessionFactory.getCurrentSession();
		Query sorgu = session
				.createQuery("SELECT hayvanNo, COUNT(hayvanNo) FROM Buyukbas where hayvanNo =:x GROUP BY hayvanNo Having Count (hayvanNo)=7 ");
		sorgu.setParameter("x", hayvanNo); // sorgu.setParameter("x", "%" + id
											// // + "%");

		return sorgu.list().size() > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Buyukbas> hissedarGetir(String isim) {
		Session session = sessionFactory.getCurrentSession();
		Query sorgu = session.createQuery("from Buyukbas where isim like :x ");
		sorgu.setParameter("x", "%" + isim + "%"); // sorgu.setParameter("x",
													// "%" + id +// "%"); SELECT
													// hayvan_no,
													// COUNT(hayvan_no) FROM
													// buyukbas Group By
													// hayvan_no Having Count
													// (hayvan_no)=7
		return sorgu.list();
	}

	@Override
	@Transactional
	public Buyukbas hayvanGetir(Long id) {
		@SuppressWarnings("unused")
		Session session = sessionFactory.openSession();
		Buyukbas buyukbass = (Buyukbas) sessionFactory.getCurrentSession().get(
				Buyukbas.class, id);

		buyukbass.getId();
		return buyukbass;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Buyukbas> fiyataGoreHayvanGetir(Long fiyat) {
		Session session = sessionFactory.getCurrentSession();
		Query sorgu = session.createQuery("from Buyukbas where satisFiyati = "
				+ fiyat);
		// sorgu.setParameter(x, kilo);
		return sorgu.list();
	}

}