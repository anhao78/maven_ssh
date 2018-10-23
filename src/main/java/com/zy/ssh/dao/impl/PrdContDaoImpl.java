package com.zy.ssh.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zy.ssh.dao.PrdContDao;
import com.zy.ssh.model.PrdCont;

@Repository
public class PrdContDaoImpl implements PrdContDao {

	private HibernateTemplate template;

	public PrdContDaoImpl(SessionFactory sessionFactory) {
		this.template = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void savePrdCont(PrdCont prdCont) {
		template.save(prdCont);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PrdCont> getList() {
		List<PrdCont> list = (List<PrdCont>) template.find("from Product");
		return list;
	}

}