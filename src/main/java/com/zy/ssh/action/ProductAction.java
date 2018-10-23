package com.zy.ssh.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;

//import com.opensymphony.xwork2.ActionSupport;

import com.zy.ssh.model.Product;
import com.zy.ssh.publish.PublishThread;
import com.zy.ssh.publish.SyncThreadPool;
import com.zy.ssh.service.ProductService;
import com.zy.ssh.vo.ProductVo;

/**
 * 商品操作-控制层
 *
 */
@Controller
@Scope("prototype")
public class ProductAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(ProductAction.class);
	@Autowired
	private ProductService productService;
	private ThreadPoolTaskExecutor publishThreadPool;
	private String pname;
	private double price;

	/**
	 * 保存商品操作
	 * 
	 * @return
	 */
	public String saveProduct1() {
		Product product = new Product(pname, price);
		productService.saveProduct(product);
		this.addActionMessage("保存成功...");
		String str = getText("asdfghjkl");
		System.out.println("str:===:" + str);
		return SUCCESS;
	}

	public String listProduct() {
		log.info("===listProduct===begin");
		Product product = new Product(pname, price);
		System.out.println("pname:" + product.getName() + "=price:"
				+ product.getPrice());
		/*
		 * List<Product> list=this.productService.getListTwo(); for (Product
		 * product2 : list) {
		 * System.out.println(product2.getName()+"\t"+product2.getPrice()); }
		 */
		List<ProductVo> list = this.productService.getListOne();
		for (ProductVo productVo : list) {
			System.out.println(productVo.getName() + "\t"
					+ productVo.getPrice());
		}
		return SUCCESS;
	}

	public String saveProduct() {
		/*
		 * 定时任务方式一 System.out.println(publishThreadPool.getCorePoolSize());
		 * System.out.println(publishThreadPool.getMaxPoolSize());
		 * publishThreadPool.execute(new PublishThread(5));
		 */
		/*
		 * 定时任务方式二 SyncThreadPool.addTask(4);
		 */
		
		return SUCCESS;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;

	}

	public ThreadPoolTaskExecutor getPublishThreadPool() {
		return publishThreadPool;
	}

	public void setPublishThreadPool(ThreadPoolTaskExecutor publishThreadPool) {
		this.publishThreadPool = publishThreadPool;
	}

	@Override
	public void validate() {
		if (pname == null || "".equals(pname.trim())) {
			this.addFieldError("pname", "商品名称不能为空");
		}
	}

}