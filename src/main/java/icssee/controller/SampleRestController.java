package icssee.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import icssee.domain.Account;
import icssee.domain.News;
import icssee.service.AccountService;
import icssee.service.NewsService;

@RestController
public class SampleRestController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/all-accounts")
	public String index(Model model) {
		return model.addAttribute("users", accountService.findAll()).toString();
	}
	
	@GetMapping("/all-news")
	public String news(Model model) {
		return model.addAttribute("news", newsService.findAll()).toString();
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello !!";
	}
	
	@GetMapping("/save-account")
	public String saveAccount(@RequestParam String username, @RequestParam String password
			, @RequestParam String role) {
		Account acc = new Account(username, password, role);
		accountService.save(acc);
		return "Account saved!";
	}
	
	@GetMapping("/save-news")
	public String saveNews(@RequestParam String title, @RequestParam String content
			, @RequestParam String creater, @RequestParam String date_created) {
		News ne = new News(title, content, creater,date_created);
		newsService.save(ne);
		return "News saved!";
	}
	
	@GetMapping("/delete-account")
	public String deleteAccount(@RequestParam int id) {
		accountService.delete(id);
		return "Account deleted!";
	}
	
	@GetMapping("/delete-news")
	public String deleteNews(@RequestParam int id) {
		newsService.delete(id);
		return "News deleted!";
	}
}
