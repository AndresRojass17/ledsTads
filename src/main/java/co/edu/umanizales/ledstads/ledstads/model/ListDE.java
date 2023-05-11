package co.edu.umanizales.ledstads.ledstads.model;

import co.edu.umanizales.ledstads.ledstads.exception.ListDEException;
import lombok.Data;

@Data
public class ListDE {
    private NodeDE head;
    int size;

    public void add(Led led) throws ListDEException {
        if (head != null) {
            NodeDE temp = head;
            while (temp.getNext() != null) {
                if (temp.getData().getId() == (led.getId())) {
                    throw new ListDEException("Ya existe un led");

                }
                temp = temp.getNext();
            }
            if (temp.getData().getId() == (led.getId())) {
                throw new ListDEException("Ya existe un led");
            }
            NodeDE newNode = new NodeDE(led);
            temp.setNext(newNode);
            newNode.setPrevious(temp);
        } else {
            head = new NodeDE(led);
        }
        size++;
    }

    public void addToStartLed(Led led) {
        NodeDE temp = null;
        if (head != null) {
            head = new NodeDE(led);

        } else {
            temp = new NodeDE(led);
            temp.setNext(head);
        }
        head.setPrevious(temp);
        head = temp;
    }

    public void rebootLeds() {
        if(head != null){
            NodeDE temp = null;
            while(temp != null){
                temp.getData().setState(false);
                temp = temp.getNext();
            }

        }
    }
}