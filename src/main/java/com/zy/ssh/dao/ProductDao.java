package com.zy.ssh.dao;

import java.util.List;

import com.zy.ssh.model.Product;
import com.zy.ssh.vo.ProductVo;

/**
 * 商品操作-持久层接口
 *
 */
public interface ProductDao {
	void saveProduct(Product product);

	List<Product> getList();

	List<ProductVo> getListOne();

	List<Product> getListTwo();
}