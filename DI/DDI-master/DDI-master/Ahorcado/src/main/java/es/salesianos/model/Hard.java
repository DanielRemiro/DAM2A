package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@Profile("hard")
public class Hard extends Dificulty{
public Hard() {
	setTries(5);
}
}
