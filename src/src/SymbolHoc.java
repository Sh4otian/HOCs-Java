/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class SymbolHoc {
    public String Nom;
    public EnumTipSim TipoSim;
    public float val;
    public BLTIN FuncPred;
    
    public int dirInicio;
    public int numParams;
    public java.util.ArrayList<String> listaParams;
    
    public SymbolHoc(){
        Nom="";val=0; dirInicio = -1; numParams = 0; listaParams = new java.util.ArrayList<>(); //cada función/procedimiento podrá guardar dónde empieza su código y cuáles son sus parámetros
    }
    
    public SymbolHoc(String nombre, EnumTipSim TipSim, float valor){
        Nom=nombre; TipoSim = TipSim; val=valor;
    }
    
    public SymbolHoc(String nombre, EnumTipSim TipSim, BLTIN func){
        Nom=nombre; TipoSim = TipSim; FuncPred=func;
    }
    
    public void InserSymbol(String nombre, EnumTipSim TipSim, float valor){
        Nom=nombre; TipoSim = TipSim; val=valor;
    }
    
    public void InserSymbol(String nombre, EnumTipSim TipSim, BLTIN func){
        Nom=nombre; TipoSim = TipSim; FuncPred=func;
    }
}
