package guru.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
	
private final AuthorRepository authorRepository;
	
	@GetMapping("/getall")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "authors/list";
	}

}
