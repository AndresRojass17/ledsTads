package co.edu.umanizales.ledstads.ledstads.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private int code;
    private Object data;
    private List<ErrorDTO> erros;
}
