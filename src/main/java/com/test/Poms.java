package com.test;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;


import freemarker.template.Configuration;
import freemarker.template.Template;

public class Poms {
	private String getBcXml(Map<String, Object> tmpMap, Long prdContId) {
		Map<String, Object> metaMap = new HashMap<String, Object>();
		metaMap.put("poms", tmpMap);
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("utf-8");
		cfg.setEncoding(Locale.getDefault(), "utf-8");
		cfg.setStrictSyntaxMode(true);
		cfg.setNumberFormat("0");
		cfg.setClassForTemplateLoading(Poms.class, "/");
		
		String dateStr = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());
		String tmpPath = "d:" + File.separator+ dateStr+ "_" + prdContId + ".xml";
		File localFile = new File(tmpPath);
		FileWriter out = null;
		try {
			Template template = cfg.getTemplate("/template/pomsInterface.ftl");
			if (!localFile.getParentFile().exists()) {
				localFile.getParentFile().mkdirs();
			}
			out = new FileWriter(localFile);
			template.process(metaMap, out);
			SAXReader reader = new SAXReader();
			Document document = reader.read(localFile);
			String bcXml = document.asXML();
			if (localFile.exists() && localFile.isFile()) {
				localFile.delete();
			}
			return bcXml;
		} catch (Exception e) {
			if (localFile.exists() && localFile.isFile()) {
				localFile.delete();
			}
			e.printStackTrace();

			return "";
		}
	}

}
