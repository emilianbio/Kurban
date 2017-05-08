package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import forms.Kucukbas;

@Repository
public class KucukbasDAOImpl implements KucukbasDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void ekle(Kucukbas kucukbas) {
		sessionFactory.getCurrentSession().saveOrUpdate(kucukbas);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Kucukbas> kucukbasList() {
		Criteria criteriaKucukbas = sessionFactory.getCurrentSession()
				.createCriteria(Kucukbas.class);
		criteriaKucukbas.addOrder(Order.asc("hayvanNo"));
		return criteriaKucukbas.list();
	}
}
