package del.javaee.uas.kel7.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/*
 * 
 * Ini adalah controller untuk Login dan Registration User
 * 
 * 
 */

@RestController
public class LogResController {
	
	@GetMapping("/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView("user/registration");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("user/login");
		return mv;
	}
	
}
