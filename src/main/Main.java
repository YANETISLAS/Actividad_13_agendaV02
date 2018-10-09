/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//version 2.0


package main;
import models.ModelAgendaV2;
import views.ViewAgendaV2;
import controllers.ControllerAgendaV2;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModelAgendaV2 modelAgenda = new ModelAgendaV2();
        ViewAgendaV2 viewAgenda = new ViewAgendaV2();
        ControllerAgendaV2 controllerAgenda = new ControllerAgendaV2(modelAgenda, viewAgenda);
    }
    
}
