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

    public void add(Led led) throws ListDEException {
        leds.add(led);
    }

    public void addToStartLed(Led led){
        leds.addToStartLed(led);
    }

    public void rebootLed() {
        leds.rebootLeds();
    }
}
