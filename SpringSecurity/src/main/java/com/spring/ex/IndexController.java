package com.spring.ex;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.login.model.UsersBean;
import com.spring.ex.login.model.UsersDAO;

/*
security-context.xml에서 default-target-url="/main.do" 
	-> default-target-url : 로그인 후 보여질 페이지(성공적으로 로그인 이후 이동한 URL)

*/
@Controller
public class IndexController {
	
	private final String command = "/main.lg";
	private String gotoPage = "index";
	
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	UsersDAO usersDAO;
	
	@RequestMapping(value = "/main.lg", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Principal principal) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		String getUserId = principal.getName();			// Principal은 자바의 표준 시큐리티 기술로, 로그인이 된 상태라면 계정 정보를 담고있다.
		
		UsersBean userInfo = usersDAO.getInfo(getUserId);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		model.addAttribute("userInfo", userInfo);
		
		return gotoPage; // index
	}
	
}//IndexController
