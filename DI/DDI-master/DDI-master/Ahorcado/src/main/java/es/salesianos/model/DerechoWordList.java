package es.salesianos.model;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@Profile("derecho")
public class DerechoWordList extends WordList{

	public DerechoWordList() {
	setWordList(Arrays.asList("sup1", "sup2", "sup3"));
	}
}
