package com.zit.catdemo1.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;

@Controller
public class CatDemoController {

	private static final Logger _LOG = LoggerFactory.getLogger(CatDemoController.class);
	
	@ResponseBody
	@RequestMapping(value = "test/demo2", method=RequestMethod.POST)
	public Object func2(HttpServletRequest request, HttpServletResponse response) {
		
		return "wowowowow";
	}
	
	@ResponseBody
	@RequestMapping(value = "test/demo", method=RequestMethod.POST)
	public Object func1(HttpServletRequest request, HttpServletResponse response) {
		Transaction t = Cat.newTransaction("URL", "name...");	// 创建一个 Transaction
		try {
			Cat.logEvent("URL.Server", "namehere", Event.SUCCESS, "第四个参数");
			Cat.logMetricForCount("payCount");
			Cat.logMetricForSum("PayAmount", 100);
			
			// yourbusiness
			_LOG.info("打出了日志，自己的业务逻辑");
			throw new RuntimeException("手动抛了一个异常！");
		} catch (Exception e) {
			t.setStatus(e);
			_LOG.error("异常捕获了。。。");
		} finally {
			t.complete();
		}
		return "hahah";
	}
}
