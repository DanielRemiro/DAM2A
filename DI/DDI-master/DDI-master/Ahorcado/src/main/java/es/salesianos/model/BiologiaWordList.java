package es.salesianos.model;

import java.util.Arrays;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@Profile("biologia")
public class BiologiaWordList extends WordList{
public BiologiaWordList() {
	setWordList(Arrays.asList("sup1", "sup2", "sup3"));
	
}
}
