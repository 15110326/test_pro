package icssee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import icssee.domain.Account;
import icssee.service.AccountService;

@RestController
public class SampleRestController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/all-accounts")
	public String index(Model model) {
		return model.addAttribute("users", accountService.findAll()).toString();
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
	
	@GetMapping("/delete-account")
	public String deleteAccount(@RequestParam int id) {
		accountService.delete(id);
		return "Account deleted!";
	}
}
