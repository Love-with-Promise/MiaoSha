package com.controller.newpagehome;

import com.bean.Msproductdetail;
import com.bean.Msproductinfo;
import com.redis.MsproductdetailRedisService;
import com.redis.MsproductinfoRedisService;
import com.service.MsorderService;
import com.service.MsproductdetailService;
import com.service.MsproductinfoService;
import com.vo.ConstomProduct;
import com.vo.MsProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("newpagehomeAction")
public class NewPagehomeAction {
	
	@Autowired(required=false)
	private MsproductinfoService msproductinfoService;
	
	@Autowired(required=false)
	private MsorderService msorderService;
	
	@Autowired(required=false)
	private MsproductdetailService msproductdetailService;
	
	@Autowired(required=false)
	private MsproductinfoRedisService msproductinfoRedisService;
	
	@Autowired(required=false)
	private MsproductdetailRedisService msproductdetailRedisService;
	
	@RequestMapping("index")
	public String index(HttpServletRequest req){
		MsProductVo msProductVo = new MsProductVo();
		ConstomProduct constomProduct = new ConstomProduct();
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowstring = dateFormat.format(now);
		constomProduct.setStartendtime(nowstring);
		constomProduct.setAuditstate(2);
		msProductVo.setConstomProduct(constomProduct);
//		private Date startstarttime;//秒杀开始时间查询范围开始时间
//		private Date endstarttime;//秒杀开始时间查询范围结束时间
		msProductVo.setConstomProduct(constomProduct);
		List<Msproductinfo> list = msproductinfoService.listmsproduct(msProductVo);
		req.setAttribute("list", list);
		return "newhomepage/index";
}
	
	@RequestMapping("viewproductdetail")
	public String viewproductdetail(HttpServletRequest req, int id){
		Msproductinfo msproduct = msproductinfoRedisService.selectByPrimaryKey(id);
		Msproductdetail msproductdetail = msproductdetailRedisService.queryMsproductdetailByid(id);
		req.setAttribute("msproduct", msproduct);
		req.setAttribute("msproductdetail", msproductdetail);
		return "newhomepage/seckill-item";
	}
	
}
