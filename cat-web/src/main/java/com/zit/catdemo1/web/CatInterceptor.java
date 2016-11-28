package com.zit.catdemo1.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Message;
import com.dianping.cat.message.Transaction;

public class CatInterceptor implements HandlerInterceptor {
	
	private static final Logger _LOG = LoggerFactory.getLogger(CatInterceptor.class);
	
	private ThreadLocal<Transaction> tranLocal = new ThreadLocal<Transaction>();
//    private ThreadLocal<Transaction> pageLocal = new ThreadLocal<Transaction>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		_LOG.info("### uri={}", uri);
        Transaction t = Cat.newTransaction("URL", uri);
        Cat.logEvent("URL.Method", request.getMethod(),Message.SUCCESS,request.getRequestURL().toString());
        Cat.logEvent("URL.Host", request.getMethod(),Message.SUCCESS,request.getRemoteHost());
        tranLocal.set(t);
        
        _LOG.info("### preHandle 方法进入...");
        return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		String viewName = modelAndView != null?modelAndView.getViewName():"无";
//        Transaction t = Cat.newTransaction("View", viewName);
        tranLocal.get().addData("test-key", "test-key-value");
        _LOG.info("### POSTHandle 方法进入...");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		 //请求-页面渲染前
//        Transaction pt = pageLocal.get();
//        pt.setStatus(Transaction.SUCCESS);
//        pt.complete();
//        
        //总计
        Transaction t = tranLocal.get();
        t.setStatus(Transaction.SUCCESS);
        _LOG.info("### afterCompletion 方法进入...");
        t.complete();

	}

}
