package es.salesianos.controller;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Dificulty;
import es.salesianos.model.WordList;

@Controller
public class HangleController {

	private static Logger log = LogManager.getLogger(HangleController.class);
	@Autowired
	WordList wordlist;

	@Autowired
	Dificulty dificulty;

	String correctAnswer;
	Integer tries;
	String userInput;
	String feedback;
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/yieldRandomSolutionWord")
	public String generateAnswer() {

		int rnd = new Random().nextInt(wordlist.getWordList().size());
		correctAnswer = wordlist.getWordList().get(rnd);
		tries = dificulty.getTries();
		log.debug("la respuesta a encotnrar es:" + correctAnswer);
		return "index";
	}

	@PostMapping("/checkAnswer")
	public ModelAndView checkAnswer(@RequestParam String userInput) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		if (userInput.equalsIgnoreCase(correctAnswer)) {
			log.info("Has ganado");
			feedback = "Los has logrado has acertado la palabra";

		} else {
			int rnd = new Random().nextInt(correctAnswer.length());
			log.info("pista:" + correctAnswer.charAt(rnd));
			feedback = "pista:" +String.valueOf(correctAnswer.charAt(rnd));
		
		}
		modelAndView.addObject("feedback", feedback);
		return modelAndView;
	}

}
