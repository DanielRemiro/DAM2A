package es.salesianos.model;

import org.springframework.stereotype.Component;


public abstract class Dificulty {
private Integer tries;

public Integer getTries() {
	return tries;
}

public void setTries(Integer tries) {
	this.tries = tries;
}
}
