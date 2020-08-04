package com.project.portfolio;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	
	/*
	 * 1. 모든 주소는 'container.jsp'를 호출하도록 지정
	 * 2. container.jsp 내부에는 <%@ include file="${actualLocation }" %> 태그로 변동되는 페이지를 지정된 div 내부에 출력하도록 설정되어 있음
	 * 3. model에 addAttribute() 메소드를 사용해서 actualLocation 주소를 @RequestMapping에 해당하는 실제 페이지로 설정해서 반환
	 * 
	 * actualLocation 페이지가 고장나더라도 container.jsp 자체는 실행되지 않을까 싶은데 그건 모르겠네용ㅎ
	 * 
	 * 아래 예시 - /community/main.do 요청이 왔을 때
	 * return String은 'container' (실질적으로는 /경로/container.jsp가 되겠죠)
	 * 내부에 actualLocation = '../community/main.jsp'라는 jsp파일 경로를 작성해 모델에 저장 
	 * (경로 기준은 container가 될 것이므로 ../ 를 사용하든 절대경로를 적든 해야 함)
	 * 
	 * 이런식으로 하면 될거같은데 실험은 안해봄
	 * @민석
	 */
	@RequestMapping(value = "/community/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		String actualLocation = "../community/main.jsp";
		model.addAttribute(actualLocation);
		
		return "container";
	}
	
}
