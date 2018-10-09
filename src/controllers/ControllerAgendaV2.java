/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelAgendaV2;
import views.ViewAgendaV2;

/**
 *
 * @author Zeo
 */
public class ControllerAgendaV2 {

    ModelAgendaV2 modelAgenda;
    ViewAgendaV2 viewAgenda;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            }
            else if (e.getSource() == viewAgenda.jbtn_nuevo) {
                jbtn_nuevo_actionPerformed();
            }
            else if (e.getSource() == viewAgenda.jbtn_insertar) {
                jbtn_insertar_actionPerformed();
            }
            else if (e.getSource() == viewAgenda.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            }
           else if (e.getSource() == viewAgenda.jbtn_eliminar) {
                jbtn_eliminar_actionPerformed();
            }

        }

        
    };

    /**
     * Constructor de Controlador para unir el ModelAgendaV2 y ViewAgendaV2
     *
     * @param modelAgenda objeto de tipo ModelAgendaV2
     * @param viewAgenda objeto de tipo ViewAgendaV2
     */
    public ControllerAgendaV2(ModelAgendaV2 modelAgenda, ViewAgendaV2 viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
 email del primer registro en las cajas de texto de ViewAgendaV2.
     */
    public void initDB(){
        modelAgenda.conectarDB();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }
    /**
     * Metodo para inicializar la ViewAgendaV2
     */
    public void initComponents() {
        viewAgenda.setLocationRelativeTo(null);
        viewAgenda.setTitle("Agenda MVC");
        viewAgenda.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewAgenda.jbtn_primero.addActionListener(actionListener);
        viewAgenda.jbtn_anterior.addActionListener(actionListener);
        viewAgenda.jbtn_siguiente.addActionListener(actionListener);
        viewAgenda.jbtn_ultimo.addActionListener(actionListener);
        viewAgenda.jbtn_nuevo.addActionListener(actionListener);
        viewAgenda.jbtn_insertar.addActionListener(actionListener);
        viewAgenda.jbtn_modificar.addActionListener(actionListener);
        viewAgenda.jbtn_eliminar.addActionListener(actionListener);
        //conecta los botones de la vista
        //es indispensable para realizar el evento
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    
    private void jbtn_primero_actionPerformed() {
       viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
       viewAgenda.jtf_email.setText(modelAgenda.getEmail());
       modelAgenda.moverPrimerRegistro();
        //invocar al metodo moverPrimerRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() {
       viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
       viewAgenda.jtf_email.setText(modelAgenda.getEmail());
       modelAgenda.moverAnteriorRegistro();
        //invocar al metodo moverAnteriorRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() {
       modelAgenda.moverUltimoRegistro();
       viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
       viewAgenda.jtf_email.setText(modelAgenda.getEmail());
       
        //invocar al metodo moverUltimoRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }
    
    /**
     * Método para limpiar las cajas de texto
     */
    private void jbtn_nuevo_actionPerformed() {
       System.out.print("boton nuevo");
       viewAgenda.jtf_nombre.setText("");
       viewAgenda.jtf_email.setText("");
       
    //limpia las cajas para que el usuario pueda insert insertar un registro
    }
    
     /**
     * Método para limpiar las cajas de texto
     */
    private void jbtn_eliminar_actionPerformed() {
       System.out.println("Eliminar");
       modelAgenda.setNombre(viewAgenda.jtf_nombre.getText());
       modelAgenda.setEmail(viewAgenda.jtf_email.getText());
       modelAgenda.Eliminar();
        //invoca el metodo eliminar
        //elimina un registro seleccionado
    }

    private void jbtn_insertar_actionPerformed() {
       modelAgenda.setNombre(viewAgenda.jtf_nombre.getText());
       modelAgenda.setEmail(viewAgenda.jtf_email.getText());
       modelAgenda.insertar();
    }

    private void jbtn_modificar_actionPerformed() {
        System.out.println("modificar");
       modelAgenda.setNombre(viewAgenda.jtf_nombre.getText());
       modelAgenda.setEmail(viewAgenda.jtf_email.getText());
       modelAgenda.modificar();
    }



    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() {
      modelAgenda.moverSiguienteRegistro();
       viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
       viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        //invocar al metodo moverSiguienteRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }
}
