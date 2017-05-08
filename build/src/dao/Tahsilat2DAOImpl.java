package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import forms.Tahsilat;
import forms.Tahsilat2;

@Repository
public class Tahsilat2DAOImpl implements Tahsilat2DAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void ekle(Tahsilat2 tahsilat2) {
		sessionFactory.getCurrentSession().saveOrUpdate(tahsilat2);
	}

	@Override
	@Transactional
	public Tahsilat2 tahsilat2Getir(Long id) {
		@SuppressWarnings("unused")
		Session session = sessionFactory.openSession();
		Tahsilat2 tahsialtt = (Tahsilat2) sessionFactory.getCurrentSession()
				.get(Tahsilat2.class, id);

		tahsialtt.getId();
		return tahsialtt;
	}

	@Override
	@Transactional
	public Boolean telefonNoVarMi(String telno) {
		Criteria criteriatelefonnoVarMi = sessionFactory.getCurrentSession()
				.createCriteria(Tahsilat2.class);
		criteriatelefonnoVarMi.add(Restrictions.eq("telNo", telno));
		@SuppressWarnings("rawtypes")
		List sonucList = criteriatelefonnoVarMi.list();
		return (sonucList != null && sonucList.size() > 0);
	}

	@Override
	@Transactional
	public List<Tahsilat2> tahsilat2List() {
		Criteria criteriaDemirbas = sessionFactory.getCurrentSession()
				.createCriteria(Tahsilat2.class);
		// criteriaDemirbas.setProjection(Projections.property("hayvanNo"));
		criteriaDemirbas.addOrder(Order.desc("odemezamani"));
		// criteriaDemirbas.addOrder(Order.asc("isim"));
		@SuppressWarnings("unchecked")
		List<Tahsilat2> sonuc = criteriaDemirbas.list();

		// sessionFactory.close();
		return sonuc;

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Tahsilat2> hissedar2Getir(String isim) {
		Session session = sessionFactory.getCurrentSession();
		Query sorgu = session
				.createQuery("from Tahsilat2 where isim like :x order by odemezamani desc");
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
	public void guncelle2(String telNo, int satisFiyati) {
		// Criteria crit = sessionFactory.getCurrentSession().createCriteria(
		// Buyukbas.class);
		// crit.setProjection(Projections.rowCount()).uniqueResult();
		//
		// crit.add(Restrictions.isNotNull("hayvanNo"));
		// crit.add(Restrictions.eq("hayvanNo", true));
		// List<Buyukbas> hayvanNo = crit.list();
		// Integer count = hayvanNo.size();
		// return count>0;

		Session session = sessionFactory.getCurrentSession();
		Query sorgu = session.createQuery("update Tahsilat set satisFiyati ="
				+ satisFiyati + "  where telNo =" + "'" + telNo + "'");
		// sorgu.setParameter("x", satisFiyati);
		// sorgu.setParameter("y", hayvanNo); // sorgu.setParameter("x", "%" +
		// id
		// // + "%");
		sorgu.executeUpdate();
	}

	@Override
	@Transactional
	public void guncelle(Tahsilat2 tahsilat) {
		sessionFactory.getCurrentSession().update(tahsilat);
	}

}