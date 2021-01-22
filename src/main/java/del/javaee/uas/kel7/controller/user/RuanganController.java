package del.javaee.uas.kel7.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user/ruangan")
public class RuanganController {
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("user/ruangan/index");
		return mv;
	}
}
