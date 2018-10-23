package com.properties.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.zy.ssh.model.PrdCont;

public class HashSetDemo {
	public static void main(String[] args) {
		// hsahSet去重
		List<PrdCont> prdContLists = new ArrayList<PrdCont>();
		PrdCont prdCont1 = new PrdCont();
		prdCont1.setId(1);
		prdCont1.setContentId("1001");
		PrdCont prdCont2 = new PrdCont();
		prdCont2.setId(2);
		prdCont2.setContentId("2002");
		PrdCont prdCont3 = new PrdCont();
		prdCont3.setId(1);
		prdCont3.setContentId("1001");
		prdContLists.add(prdCont1);
		prdContLists.add(prdCont2);
		prdContLists.add(prdCont1);
		HashSet<PrdCont> hashSet = new HashSet<PrdCont>(prdContLists);
		prdContLists.clear();
		prdContLists.addAll(hashSet);
		System.out.println(prdContLists.size());

		/*
		 * Set<Bean> set = new HashSet<>(); Bean b1 = new Bean(1, "123"); Bean
		 * b2 = new Bean(2, "456"); set.add(b1); set.add(b2); Bean b3 = new
		 * Bean(1, "789"); Bean b4 = new Bean(2, "012"); set.add(b3);
		 * set.add(b4); System.out.println(set.size());
		 * 
		 * List<Bean> prdContLists = new ArrayList<Bean>();
		 * prdContLists.add(b1); prdContLists.add(b2); prdContLists.add(b3);
		 * prdContLists.add(b4); HashSet<Bean> hashSet = new
		 * HashSet<Bean>(prdContLists); prdContLists.clear();
		 * prdContLists.addAll(hashSet);
		 * System.out.println(prdContLists.size());
		 */
	}

}
