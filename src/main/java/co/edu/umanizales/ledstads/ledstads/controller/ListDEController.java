package co.edu.umanizales.ledstads.ledstads.controller;

import co.edu.umanizales.ledstads.ledstads.DTO.ResponseDTO;
import co.edu.umanizales.ledstads.ledstads.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/listde")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;


    @GetMapping
    public ResponseEntity<ResponseDTO>
}
