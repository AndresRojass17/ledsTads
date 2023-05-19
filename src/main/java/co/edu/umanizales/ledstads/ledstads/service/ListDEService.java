package co.edu.umanizales.ledstads.ledstads.service;

import co.edu.umanizales.ledstads.ledstads.exception.ListDEException;
import co.edu.umanizales.ledstads.ledstads.model.Led;
import co.edu.umanizales.ledstads.ledstads.model.ListDE;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDEService {
    private ListDE leds;

public ListDEService() {
leds = new ListDE();
}
}
