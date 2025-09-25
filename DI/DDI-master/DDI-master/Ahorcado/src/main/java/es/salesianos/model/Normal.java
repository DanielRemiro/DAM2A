package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@Profile("normal")
public class Normal extends Dificulty{
public Normal() {
	setTries(10);
}
}
