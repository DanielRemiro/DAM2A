package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@Profile("easy")
public class Easy extends Dificulty{
	public Easy() {
	setTries(20);
	}

}
