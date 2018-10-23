package com.zy.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.ssh.dao.PrdContDao;
import com.zy.ssh.model.PrdCont;
import com.zy.ssh.service.PrdContService;

@Service
public class PrdContServiceImpl implements PrdContService {
	@Autowired
	private PrdContDao prdContDao;

	@Override
	public void savePrdCont(PrdCont prdCont) {
		prdContDao.savePrdCont(prdCont);
	}

	@Override
	public List<PrdCont> getList() {
		return prdContDao.getList();
	}

}