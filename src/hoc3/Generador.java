/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoc3;

import java.io.File;
import jflex.Main;
/**
 *
 * @author Montse
 */

public class Generador {
    public static void main(String[] args) {
        try {
            String ruta = "src\\flexcup\\";

            File archivoFlex = new File(ruta + "Hoc3.flex");

            Main.main(new String[]{archivoFlex.getPath()});

            String[] opcionesCup = {
                "-parser", "AnalizadorSintac",
                "-symbols", "AnalizadorSintacSym",
                "-destdir", ruta,
                ruta + "Hoc3.cup"
            };

            java_cup.Main.main(opcionesCup);

            System.out.println("Archivos generados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}