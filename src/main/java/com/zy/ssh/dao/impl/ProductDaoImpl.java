package com.zy.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zy.ssh.dao.ProductDao;
import com.zy.ssh.model.Product;
import com.zy.ssh.vo.ProductVo;

/**
 * 商品信息-服务层实现
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao {

	private HibernateTemplate template;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.template = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveProduct(Product product) {
		template.save(product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getList() {
		List<Product> list=(List<Product>) template.find("from Product");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductVo> getListOne() {
		List<Object[]> list=(List<Object[]>) template.find("select name,price from Product");
		List<ProductVo> result=new ArrayList<ProductVo>();
		for (Object[] objects : list) {
			ProductVo pv=new ProductVo();
			pv.setName((String)objects[0]);
			pv.setPrice(Double.parseDouble(objects[1].toString()));
			result.add(pv);
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getListTwo() {
		List<Product> list=(List<Product>) template.find("select new Product(name,price) from Product");
		return list;
	}

}