package com.zy.ssh.dao;

import java.util.List;

import com.zy.ssh.model.PrdCont;


public interface PrdContDao {
	void savePrdCont(PrdCont prdCont);

	List<PrdCont> getList();

}