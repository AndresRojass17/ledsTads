package co.edu.umanizales.ledstads.ledstads.model;

import co.edu.umanizales.ledstads.ledstads.exception.ListDEException;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ListDE {
    private NodeDE head;
    private NodeDE tail;
    int size;
    private List<Led>leds = new ArrayList<>();

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

    public ArrayList listLeds() {
        ArrayList listFinal = null;
        if (head != null) {
            NodeDE temp = head;
            listFinal = new ArrayList<>();
            while (temp != null) {
                listFinal.add(temp.getData());
                temp = temp.getNext();
            }
        }
        return listFinal;
    }
    public void addToStartLed(Led led) {

        if (head != null) {
            NodeDE newNode = new NodeDE(led);
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;

        } else {
        head = new NodeDE(led);
        }
        size++;
    }


    public void rebootLeds() {
        if(head != null){
            NodeDE temp = null;
            while(temp != null){
                temp.getData().setState(false);
                temp.getData().setDateOff(null);
                temp.getData().setDateOn(null);
                temp = temp.getNext();

            }

        }
    }
/*
primero verificamos si en la cabeza no hay nada
despues creamos un temporal el cual va a ser la cabeza
despues creamos un contador de pasos y lo inicializamos en 1
creamos una media
si el tamaño de la lista es impar
almacenamos el tamaño divido en 2 y se le suma 1
mientras temporal sea diferente de null
creamos un temporal siguiente el cual va a ser el temporal
comprobamos en hilos de espera con un thread.sleep y lo ponemos en 1000
despues imprimimos el seguimiento de la pila de impresion
despues con el temporal vamos al estado y debe estar en false
despues comprobamos si esta apagado con locatime
y miramos como esta el estado de comprobacion
tambien de cuando este prendido con localtime
y temporal siguiente nos mira si este quedo encendido
y temporal siguiente miramos si se prende en el momento
despues aumentamos los pasos
y el temporal pasa al siguiente
sino medimos la mitad divida en 2
mientras el temporal sea diferente de null
comprobamos que siga encendiendo el siguiente y el anterior
mientras el temporal siguiente del siguiente sea diferente de null
creamos un hilo y lo ponemos a esperar
y despues imprimimos el seguimiento de la pila de impresion
entonces con temporal miramos el estado en el que esta el led si es false esta apagado
despues miramos el tiempo actual y la hora actual
y con temporal siguiente miramos el siguiente
cuando este prendido y cuando este apagado
y aumentamos los pasos
y temporal pasa al siguiente
 */
    public  void turnOnLight(){
        if (head != null) {
            NodeDE temp = head;
            int steps = 1;
            int medium;
            if ((size%2)!=0){
                medium = (size / 2) + 1;
                while (temp!= null){

                    if (steps == medium){
                        NodeDE tempNext = temp;
                        temp.getData().setState(true);
                        temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));

                        while (tempNext.getNext() != null){

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            temp.getData().setState(false);
                            temp.getData().setDateOff(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(false);
                            tempNext.getData().setDateOff(LocalTime.from(LocalDateTime.now()));

                            temp = temp.getPrevious();
                            tempNext= tempNext.getNext();

                            temp.getData().setState(true);
                            temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(true);
                            tempNext.getData().setDateOn(LocalTime.from(LocalDateTime.now()));



                        }
                    }
                    steps++;
                    temp= temp.getNext();


                }




            } else{
                medium = size/2;

                while (temp!= null){
                    if (steps == medium){
                        NodeDE tempNext = temp.getNext();
                        temp.getData().setState(true);
                        temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));
                        tempNext.getData().setState(true);
                        tempNext.getData().setDateOn(LocalTime.from(LocalDateTime.now()));

                        while (tempNext.getNext() != null) {

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            temp.getData().setState(false);
                            temp.getData().setDateOff(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(false);
                            tempNext.getData().setDateOff(LocalTime.from(LocalDateTime.now()));

                            temp = temp.getPrevious();
                            tempNext = tempNext.getNext();

                            temp.getData().setState(true);
                            temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(true);
                            tempNext.getData().setDateOn(LocalTime.from(LocalDateTime.now()));


                        }
                    }
                    steps++;
                    temp= temp.getNext();

                }

            }

        }

    }
}