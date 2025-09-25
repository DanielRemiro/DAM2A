package es.salesianos.model;

import java.util.Arrays;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@Profile("informatica")
public class InformaticaWordList extends WordList{
public InformaticaWordList() {
	setWordList(Arrays.asList("sup1", "sup2", "sup3"));
	
}
}
