package com.zy.ssh.service;

import java.util.List;

import com.zy.ssh.model.Product;
import com.zy.ssh.vo.ProductVo;

/**
 * 商品操作-服务层接口
 *
 */
public interface ProductService {
	void saveProduct(Product product);

	List<Product> getList();

	List<ProductVo> getListOne();

	List<Product> getListTwo();
}