package com.zy.ssh.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.ssh.model.PrdCont;
import com.zy.ssh.service.PrdContService;

@Controller
@Scope("prototype")
public class PrdContAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(PrdContAction.class);

	private int id;
	private String cid;
	@Autowired
	private PrdContService prdContService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@ResponseBody
	public String savePrdCont1() {
		System.out.println("save 2018===");
		/*PrdCont prdCont = new PrdCont();
		prdCont.setId(id);
		prdCont.setContentId(cid);
		prdContService.savePrdCont(prdCont);*/
		String str=this.getText("invalid.fieldvalue.price");
		System.out.println(str);
		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("root",  "txtname");
		return SUCCESS;
	}

	public String getProduct() {
		List<PrdCont> list = prdContService.getList();
		for (PrdCont prdCont : list) {
			System.out.println(prdCont.toString());
		}
		return SUCCESS;
	}

}