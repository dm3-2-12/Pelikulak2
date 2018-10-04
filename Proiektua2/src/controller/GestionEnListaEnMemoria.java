/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Pelikula;

/**
 *
 * @author DM3-2-12
 */
public class GestionEnListaEnMemoria {
    
    
     static FileReader frMangas = null;
    static FileReader frGeneros = null;
    static BufferedReader br = null;
    
    public static ArrayList<Pelikula> cargaPelikula()
    {

        try {
            //Strima irekitzen dugu.
            frMangas = new FileReader("PelikulaK.txt");
            br = new BufferedReader(frMangas);
            String aux;
            String[] arraString;
            ArrayList<Pelikula> arrPel= new ArrayList();
            while ((aux = br.readLine()) != null) {
                if (!"".equals(aux)) {
                    arraString = aux.split(",");
                    //Izenburu-Idazle-Marrazki-Genero
                    arrPel.add(new Pelikula(arraString[0], arraString[1], arraString[2], Integer.parseInt(arraString[3]), Integer.parseInt(arraString[4])));
                }
            }
            br.close();
            return arrPel;
        } catch (FileNotFoundException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Artxiboa ez da aurkitu.");
            error.showAndWait();
            return null;
        } catch (IOException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Errorea egon da irakurketan.");
            error.showAndWait();
            return null;
        }
  /* public static ObservableList<Pelikula> datuak(){
       
       
        return FXCollections.observableArrayList(
            new Pelikula("Advengers: Infinity War", "Anthony Russo & Joe Russo", "2h 40m",12,2018),
            new Pelikula("Black Panther","Ryan Coogler", "2h 15m",12,2018),
            new Pelikula("Los Increíbles 2", "Brad Bird", "2h 5m",3,2018),
            new Pelikula("Jurassic World: El reino caído", "Juan Antonio Bayona", "2h 10m",16,2018)
        );
   }*/
}
}
