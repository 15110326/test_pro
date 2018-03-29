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
import icssee.domain.News;
import icssee.service.AccountService;
import icssee.service.NewsService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private NewsService newsService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin")
	public String index(Model model) {
		model.addAttribute("accounts", accountService.findAll());
		return "admin";
	}
	
	@GetMapping("/addNews")
	public String index1(Model model) {
		model.addAttribute("news",newsService.findAll());
		return "addNews";
	}

	@GetMapping("/admin/create")
	public String create(Model model) {
		model.addAttribute("account", new Account());
		return "form";
	}
	
	@GetMapping("/addNews/createNews")
	public String createNews(Model model) {
		model.addAttribute("news", new News());
		return "formAddNews";
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
	
	@PostMapping("/news/save")
	public String saveNews(@Valid News news, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "formAddNews";
		}
		newsService.save(news);
		redirect.addFlashAttribute("success", "Saved news successfully!");
		return "redirect:/addNews";
	}
	
	@PostMapping("/login")
	public String login(@Valid Account account, BindingResult result, RedirectAttributes redirect) {
		redirect.addFlashAttribute("success", "Login successfully!");
		return "redirect:/admin";
	}

	@GetMapping("/account/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("account", accountService.findOne(id));
		return "form";
	}
	
	@GetMapping("/news/{id}/edit")
	public String editNews(@PathVariable int id, Model model) {
		model.addAttribute("news", newsService.findOne(id));
		return "formAddNews";
	}

	@GetMapping("/account/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		accountService.delete(id);
		redirect.addFlashAttribute("success", "Deleted account successfully!");
		return "redirect:/admin";
	}
	
	@GetMapping("/news/{id}/delete")
	public String deleteNews(@PathVariable int id, RedirectAttributes redirect) {
		newsService.delete(id);
		redirect.addFlashAttribute("success", "Deleted news successfully!");
		return "redirect:/addNews";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}
}
