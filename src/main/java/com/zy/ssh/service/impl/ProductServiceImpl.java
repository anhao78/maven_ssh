package com.zy.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.ssh.dao.ProductDao;
import com.zy.ssh.model.Product;
import com.zy.ssh.service.ProductService;
import com.zy.ssh.vo.ProductVo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

	@Override
	public List<Product> getList() {
		return productDao.getList();
	}

	@Override
	public List<ProductVo> getListOne() {
		return productDao.getListOne();
	}

	@Override
	public List<Product> getListTwo() {
		return productDao.getListTwo();
	}

}