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

@Repository
public class TahsilatDAOImpl implements TahsilatDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void ekle(Tahsilat tahsilat) {
		sessionFactory.getCurrentSession().save(tahsilat);
	}

	@Override
	@Transactional
	public void guncelle(Tahsilat tahsilat) {
		sessionFactory.getCurrentSession().update(tahsilat);
	}

	@Override
	@Transactional
	public Tahsilat tahsilatGetir(Long id) {
		@SuppressWarnings("unused")
		Session session = sessionFactory.openSession();
		Tahsilat tahsialtt = (Tahsilat) sessionFactory.getCurrentSession().get(
				Tahsilat.class, id);

		tahsialtt.getId();
		return tahsialtt;
	}

	@Override
	@Transactional
	public Boolean telefonNoVarMi(String telno) {
		Criteria criteriatelefonnoVarMi = sessionFactory.getCurrentSession()
				.createCriteria(Tahsilat.class);
		criteriatelefonnoVarMi.add(Restrictions.eq("telNo", telno));
		@SuppressWarnings("rawtypes")
		List sonucList = criteriatelefonnoVarMi.list();
		return (sonucList != null && sonucList.size() > 0);
	}

	@Override
	@Transactional
	public List<Tahsilat> tahsilatList() {
		Criteria criteriaDemirbas = sessionFactory.getCurrentSession()
				.createCriteria(Tahsilat.class);
		// criteriaDemirbas.setProjection(Projections.property("hayvanNo"));
		criteriaDemirbas.addOrder(Order.desc("odemezamani"));
		//criteriaDemirbas.addOrder(Order.asc("isim"));
		@SuppressWarnings("unchecked")
		List<Tahsilat> sonuc = criteriaDemirbas.list();

		// sessionFactory.close();
		return sonuc;

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Tahsilat> hissedarGetir(String isim) {
		Session session = sessionFactory.getCurrentSession();
		Query sorgu = session
				.createQuery("from Tahsilat where isim like :x order by odemezamani desc");
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
}