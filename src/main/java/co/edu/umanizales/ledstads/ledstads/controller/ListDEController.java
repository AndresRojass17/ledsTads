package co.edu.umanizales.ledstads.ledstads.controller;

import co.edu.umanizales.ledstads.ledstads.DTO.LedDTO;
import co.edu.umanizales.ledstads.ledstads.DTO.ResponseDTO;
import co.edu.umanizales.ledstads.ledstads.exception.ListDEException;
import co.edu.umanizales.ledstads.ledstads.model.Led;
import co.edu.umanizales.ledstads.ledstads.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/listde")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getLeds() {
        return new ResponseEntity<>(new ResponseDTO(
                200, listDEService.getLeds().listLeds(), null), HttpStatus.OK);
    }

    @PostMapping(path = "/add/{id}")
    public ResponseEntity<ResponseDTO> addPet(@RequestBody LedDTO ledDTO) throws ListDEException {
        listDEService.getLeds().add(new Led(ledDTO.getId(),false,null,null));
        return new ResponseEntity<>(new ResponseDTO(200,"Se ha adicionado el led",null),HttpStatus.OK
        );
    }


    @GetMapping(path = "/reboot")
    public ResponseEntity<ResponseDTO> rebootLeds(){
        listDEService.getLeds().rebootLeds();
        return new ResponseEntity<>(new ResponseDTO(200, "las leds reiniciaron su estado", null), HttpStatus.OK);

    }
    @PostMapping(path = "/addtostart")
    public ResponseEntity<ResponseDTO> addToStart(@RequestBody LedDTO ledDTO){
        listDEService.getLeds().addToStartLed(new Led(ledDTO.getId(),false,null,null));
        return new ResponseEntity<>(new ResponseDTO(200, "la bombilla fue añadida al inicio", null), HttpStatus.OK);

    }


    @GetMapping(path = "/turnonlight")
    public ResponseEntity<ResponseDTO> turnOnLight() {

        listDEService.getLeds().turnOnLight();

        return new ResponseEntity<>(new ResponseDTO(
                200, "se encendieron las luces", null), HttpStatus.OK);
    }

}
