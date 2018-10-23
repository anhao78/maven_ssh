package com.zy.ssh.service;

import java.util.List;

import com.zy.ssh.model.PrdCont;

public interface PrdContService {
	void savePrdCont(PrdCont prdCont);

	List<PrdCont> getList();
}