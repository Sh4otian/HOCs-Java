/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Admin
 */
public class SymbolHoc {
    public String Nom;
    public EnumTipSim TipoSim;
    public float val;
    public BLTIN FuncPred;
    
    public SymbolHoc(){
        Nom="";val=0;
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
