package co.edu.umanizales.ledstads.ledstads.model;

import lombok.Data;

@Data
public class NodeDE {
    private Led Data;
    private NodeDE next;
    private NodeDE previous;

    public NodeDE(Led data) {
        this.Data = data;
    }
}
