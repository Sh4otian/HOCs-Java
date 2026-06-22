/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.ArrayList;


/**
 *
 * @author Montse
 */
public class Frame {

    public SymbolHoc sp;      // símbolo de la función
    public int retpc;         // dirección de retorno
    public ArrayList<Datum> parametros;

    public Frame() {
        parametros = new ArrayList<>();
    }

}
