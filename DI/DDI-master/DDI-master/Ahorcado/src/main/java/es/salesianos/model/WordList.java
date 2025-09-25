package es.salesianos.model;

import java.util.List;

import org.springframework.stereotype.Component;
public abstract class WordList {
 private List<String> wordList;

public List<String> getWordList() {
	return wordList;
}

public void setWordList(List<String> wordList) {
	this.wordList = wordList;
}
}
