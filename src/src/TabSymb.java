/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TabSymb {
    List<SymbolHoc> ListaSymb;
    
    public TabSymb(){
        ListaSymb = new LinkedList<>();
        this.init();
    }
    public SymbolHoc lookup(String Nam){
        SymbolHoc s;
        Iterator it = ListaSymb.iterator();
        while(it.hasNext()){
            s=(SymbolHoc)it.next();
            if(s.Nom.equals(Nam))
                 return s;  
        }
        return null;
    }
    public SymbolHoc install(String Nam, EnumTipSim Tipo, float Val){
        SymbolHoc s = new SymbolHoc();
        s.InserSymbol(Nam, Tipo, Val);
        ListaSymb.add(s);
        return s;
    }
    public SymbolHoc install(String Nam, EnumTipSim Tipo, BLTIN FuncPred){
        SymbolHoc s = new SymbolHoc();
        s.InserSymbol(Nam, Tipo, FuncPred);
        ListaSymb.add(s);
        return s;
    }
    //registrar funciones y procedimientos
    public SymbolHoc installFuncion(String Nam, EnumTipSim Tipo, int dirInicio) {
        SymbolHoc s = lookup(Nam);
        
        if (s == null) {
            s = new SymbolHoc();
            s.Nom = Nam;
            ListaSymb.add(s);
        }

        s.TipoSim = Tipo;
        s.dirInicio = dirInicio;
        s.numParams = 0;

        return s;
    }
    public void init(){
        ListaSymb.clear();
        InitConstPredef();
        InitFuncPredef();
    }
    private void InitConstPredef(){
        SymbolHoc s= new SymbolHoc();
        float val;
        
        val =(float) 3.141592653589;
        s.InserSymbol("PI", EnumTipSim.CONST_PRED, val);
        ListaSymb.add(s);
        
        s= new SymbolHoc();
        val =(float) 2.718281828459;
        s.InserSymbol("E", EnumTipSim.CONST_PRED, val);
        ListaSymb.add(s);
        
         s= new SymbolHoc();
        val =(float) 0.577215664901;
        s.InserSymbol("GAMMA", EnumTipSim.CONST_PRED, val);
        ListaSymb.add(s);
        
        
        s= new SymbolHoc();
        val =(float) 57.2957795130;
        s.InserSymbol("DEG", EnumTipSim.CONST_PRED, val);
        ListaSymb.add(s);
        
        s= new SymbolHoc();
        val =(float) 1.6180334989;
        s.InserSymbol("PHI", EnumTipSim.CONST_PRED, val);
        ListaSymb.add(s);
    }
    
    private void InitFuncPredef(){
        SymbolHoc s= new SymbolHoc();
        float val;
        
        s.InserSymbol("sin", EnumTipSim.BLTIN, BLTIN.SIN);
        ListaSymb.add(s);
        
        s= new SymbolHoc();
       s.InserSymbol("cos", EnumTipSim.BLTIN, BLTIN.COS);
        ListaSymb.add(s);
        
         s= new SymbolHoc();
        s.InserSymbol("atan", EnumTipSim.BLTIN, BLTIN.ATAN);
        ListaSymb.add(s);
        
        s= new SymbolHoc();
        s.InserSymbol("log", EnumTipSim.BLTIN, BLTIN.LOG);
        ListaSymb.add(s);
        
        s= new SymbolHoc();
        s.InserSymbol("log10", EnumTipSim.BLTIN, BLTIN.LOG10);
        ListaSymb.add(s);
        
        s= new SymbolHoc();
        s.InserSymbol("exp", EnumTipSim.BLTIN, BLTIN.EXP);
        ListaSymb.add(s);
        
        s= new SymbolHoc();
        s.InserSymbol("sqrt", EnumTipSim.BLTIN, BLTIN.SQRT);
        ListaSymb.add(s);
        
        s= new SymbolHoc();
        s.InserSymbol("int", EnumTipSim.BLTIN, BLTIN.INT);
        ListaSymb.add(s);
        
        s= new SymbolHoc();
        s.InserSymbol("ABS", EnumTipSim.BLTIN, BLTIN.ABS);
        ListaSymb.add(s);
    }
}
