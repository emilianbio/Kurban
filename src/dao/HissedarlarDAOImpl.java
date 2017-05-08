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

import forms.Hissedarlar;

@Repository
public class HissedarlarDAOImpl implements HissedarlarDAO {
	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("unused")
	private Hissedarlar hissedarlar;

	@Override
	@Transactional
	public void ekle(Hissedarlar hissedarlar) {
		sessionFactory.getCurrentSession().saveOrUpdate(hissedarlar);
	}

	@Override
	@Transactional
	public List<Hissedarlar> hissedarList() {
		Criteria criteriaDemirbas = sessionFactory.getCurrentSession()
				.createCriteria(Hissedarlar.class);
		// criteriaDemirbas.setProjection(Projections.property("hayvanNo"));
		criteriaDemirbas.addOrder(Order.asc("hayvanNo"));
		@SuppressWarnings("unchecked")
		List<Hissedarlar> sonuc = criteriaDemirbas.list();

		// sessionFactory.close();
		return sonuc;

	}

	@Override
	@Transactional
	public Long yediHisseyeUlastimi(Long hayvanNo) {
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
		Query sorgu = session
				.createQuery("SELECT SUM(hissesi)FROM Hissedarlar where hayvanNo =:x ");
		sorgu.setParameter("x", hayvanNo); // sorgu.setParameter("x", "%" + id
											// // + "%");
		return (Long) sorgu.uniqueResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Hissedarlar> hissedarGetir(String isim) {
		Session session = sessionFactory.getCurrentSession();
		Query sorgu = session
				.createQuery("from Hissedarlar where isim like :x order by hayvanNo asc");
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
	public Long hisseToplami(Long hayvanNo) {
		Session session = sessionFactory.getCurrentSession();
		Query sorgu = session
				.createQuery("select sum (hissesi)from Hissedarlar where hayvanNo = :x ");
		sorgu.setParameter("x", hayvanNo);

		return (Long) sorgu.uniqueResult();
	}

	@Override
	@Transactional
	public void guncelle(Hissedarlar hissedarlar) {

		sessionFactory.getCurrentSession().update(hissedarlar);
		// Session session = sessionFactory.getCurrentSession();
		// Query sorgu =
		// session.createQuery("from Hissedarlar Where hayvanNo=:x");
		// sorgu.setParameter("x", hayvanNo);
		//
		// if (!sorgu.list().isEmpty()) {
		// Hissedarlar hissedar = (Hissedarlar) sorgu.list().get(0);
		// hissedar.setHisseFiyati(hisseyeDusenMiktar);
		// session.update(hissedar);
		// }
	}

	@Override
	@Transactional
	public Hissedarlar hissedarGetir(Long id) {
		@SuppressWarnings("unused")
		Session session = sessionFactory.openSession();
		Hissedarlar hissedarr = (Hissedarlar) sessionFactory
				.getCurrentSession().get(Hissedarlar.class, id);

		hissedarr.getId();
		return hissedarr;
	}

	@Override
	@Transactional
	public Hissedarlar hayvanNoyaGöreHissedatGetir(Long hayvanNo) {
		@SuppressWarnings("unused")
		Session session = sessionFactory.openSession();
		Hissedarlar hissedarr = (Hissedarlar) sessionFactory
				.getCurrentSession().get(Hissedarlar.class, hayvanNo);

		hissedarr.getHayvanNo();
		return hissedarr;
	}

	@Override
	@Transactional
	public Boolean telefonnoVarMi(String telno) {
		Criteria criteriatelefonnoVarMi = sessionFactory.getCurrentSession()
				.createCriteria(Hissedarlar.class);
		criteriatelefonnoVarMi.add(Restrictions.eq("telNo", telno));
		criteriatelefonnoVarMi.add(Restrictions.eq("telNo2", telno));
		criteriatelefonnoVarMi.add(Restrictions.eq("telNo3", telno));
		criteriatelefonnoVarMi.add(Restrictions.eq("telNo4", telno));
		criteriatelefonnoVarMi.add(Restrictions.eq("telNo5", telno));
		criteriatelefonnoVarMi.add(Restrictions.eq("telNo6", telno));
		criteriatelefonnoVarMi.add(Restrictions.eq("telNo7", telno));
		@SuppressWarnings("rawtypes")
		List sonucList = criteriatelefonnoVarMi.list();
		return (sonucList != null && sonucList.size() > 0);
	}

}
