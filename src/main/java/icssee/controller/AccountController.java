package icssee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import icssee.domain.Account;
import icssee.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/admin")
	public String index(Model model) {
		model.addAttribute("accounts", accountService.findAll());
		return "admin";
	}

	@GetMapping("/admin/create")
	public String create(Model model) {
		model.addAttribute("account", new Account());
		return "form";
	}

	@PostMapping("/admin/save")
	public String save(@Valid Account account, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		accountService.save(account);
		redirect.addFlashAttribute("success", "Saved account successfully!");
		return "redirect:/admin";
	}

	@GetMapping("/account/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("account", accountService.findOne(id));
		return "form";
	}

	@GetMapping("/account/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		accountService.delete(id);
		redirect.addFlashAttribute("success", "Deleted account successfully!");
		return "redirect:/admin";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}
}
