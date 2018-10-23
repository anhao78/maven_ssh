package com.properties;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

//读取模版，生成响应文件
public class NewTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		File localFile = new File("f:/test/1022.xml");
		Map<String, Object> metaMap = new HashMap<String, Object>();
		Map<String, Object> root = new HashMap<String, Object>();

		List<Map<String, String>> kwList = new LinkedList<Map<String, String>>();
		String[] kws = "11,22,33".split(",");
		if (kws.length > 0) {
			for (String kw : kws) {
				Map<String, String> kwm = new HashMap<String, String>();

				kwm.put("KeywordName", kw);
				kwm.put("PrimaryKey", "0");

				kwList.add(kwm);
			}
		}

		root.put("Version", "1.0.0");
		root.put("AssetID", "AssetID");
		root.put("ContentID", "ContentID");
		root.put("Name", "Name");
		root.put("ShortName", "ShortName");
		root.put("Keywords", kwList);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("Area", "china");
		root.put("CopyRight", result);

		metaMap.put("CONTENT", root);
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("utf-8");
		cfg.setEncoding(Locale.getDefault(), "utf-8");
		cfg.setStrictSyntaxMode(true);
		cfg.setNumberFormat("0");
		cfg.setClassForTemplateLoading(NewTest.class, "/");
		try {
			Template template = cfg.getTemplate("/template/albumMetadata.ftl");
			FileWriter out = new FileWriter(localFile);
			template.process(metaMap, out);
			System.out.println("======");
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}

}
