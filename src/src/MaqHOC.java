/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.Stack;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class MaqHOC {
   public TabSymb Tabs;
    InstruProg Prog[];
    int progp = 0, pc;
    Stack<Datum> Callstack;
    
    public MaqHOC(){
       Tabs = new TabSymb();
       Tabs.init();
       
       Prog = new InstruProg[2048];
       progp=0;pc=0;
       
       Callstack = new Stack();
       Callstack.clear();
    }
    
    public void initcode(){
       progp=0;
       
       Callstack.clear();
    }
    
    public Integer code(InstruProg ins){
        Integer oprogp = progp;
        Prog[progp++] =ins;
        return oprogp;
    }
    
    public Integer code2(InstruProg ins1,InstruProg ins2){
        Integer oprogp = progp;
        Prog[progp++] =ins1;
        Prog[progp++] =ins2;
        return oprogp;
    }
    
    public Integer code3(InstruProg ins1,InstruProg ins2,InstruProg ins3){
        Integer oprogp = progp;
        Prog[progp++] =ins1;
        Prog[progp++] =ins2;
        Prog[progp++] =ins3;
        return oprogp;
    }
    public void exec(int ind, JTextArea ArRes, JTable Pila){
           System.out.println("Inicio exec");

for(int i = 0; i < progp; i++){
    System.out.println(
        i + " -> " +
        (Prog[i] == null ?
         "NULL" :
         Prog[i].Instruccion)
    );
}
        InstruProg Instruc;
        Datum p1,p2;
        String Result = new String();
        
        Object os[] = new Object[5];
        String TipDatum, Val, NombSymbol, TypeSymbol,ValSymb = new String();
        
        DefaultTableModel ModelTab = (DefaultTableModel) Pila.getModel();
        
        pc=ind;
       while(Prog[pc].Instruccion != EnumMaq.STOP){
           TipDatum="";Val="";NombSymbol="";TypeSymbol="";ValSymb="";
           Instruc = Prog[pc++];
           switch(Instruc.Instruccion){
               case ADD:
                   p2 = Callstack.pop();
                   p1 = Callstack.pop();
                   p1.val+=p2.val;
                   Callstack.push(p1);
                   
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                    os[0]=(Object)"Val";
                    os[1]=(Object)p1.val;
                    os[2]="";
                    os[3]="";
                    os[4]="";
                    ModelTab.addRow(os);
                   break;
                   case ASIGN:
                   p2 = Callstack.pop();
                   p1 = Callstack.pop();
                   
                   p2.symb.val=p1.val;
                   p2.symb.TipoSim = EnumTipSim.VAR;
                   Callstack.push(p1);
                   
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                    os[0]=(Object)"Val";
                    os[1]=(Object)p1.val;
                    os[2]="";
                    os[3]="";
                    os[4]="";
                    ModelTab.addRow(os);
                   break;
                   case BLTIN:
                       Instruc = Prog[pc++];
                       switch(Instruc.Func_BLTIN){
                           case SIN:
                                p1 = Callstack.pop();
                                p1.val=(float)Math.sin((double)p1.val);
                                Callstack.push(p1);
                   
                                ModelTab.removeRow(ModelTab.getRowCount()-1);
                               os[0]=(Object)"Val";
                               os[1]=(Object)p1.val;
                               os[2]="";
                               os[3]="";
                               os[4]="";
                               ModelTab.addRow(os);
                               break;
                           case COS:
                                p1 = Callstack.pop();
                                p1.val=(float)Math.cos((double)p1.val);
                                Callstack.push(p1);
                   
                                ModelTab.removeRow(ModelTab.getRowCount()-1);
                               os[0]=(Object)"Val";
                               os[1]=(Object)p1.val;
                               os[2]="";
                               os[3]="";
                               os[4]="";
                               ModelTab.addRow(os);
                               break;
                           case ATAN:
                                p1 = Callstack.pop();
                                p1.val=(float)Math.atan((double)p1.val);
                                Callstack.push(p1);
                   
                                ModelTab.removeRow(ModelTab.getRowCount()-1);
                               os[0]=(Object)"Val";
                               os[1]=(Object)p1.val;
                               os[2]="";
                               os[3]="";
                               os[4]="";
                               ModelTab.addRow(os);
                               break;
                           case LOG: 
                                p1 = Callstack.pop();
                                p1.val=(float)Math.log((double)p1.val);
                                Callstack.push(p1);
                   
                                ModelTab.removeRow(ModelTab.getRowCount()-1);
                               os[0]=(Object)"Val";
                               os[1]=(Object)p1.val;
                               os[2]="";
                               os[3]="";
                               os[4]="";
                               ModelTab.addRow(os);
                               break;
                           case LOG10:
                                p1 = Callstack.pop();
                                p1.val=(float)Math.log10((double)p1.val);
                                Callstack.push(p1);
                   
                                ModelTab.removeRow(ModelTab.getRowCount()-1);
                               os[0]=(Object)"Val";
                               os[1]=(Object)p1.val;
                               os[2]="";
                               os[3]="";
                               os[4]="";
                               ModelTab.addRow(os);
                               break;
                           case EXP:
                                p1 = Callstack.pop();
                                p1.val=(float)Math.exp((double)p1.val);
                                Callstack.push(p1);
                   
                                ModelTab.removeRow(ModelTab.getRowCount()-1);
                               os[0]=(Object)"Val";
                               os[1]=(Object)p1.val;
                               os[2]="";
                               os[3]="";
                               os[4]="";
                               ModelTab.addRow(os);
                               break;
                           case SQRT:
                                p1 = Callstack.pop();
                                p1.val=(float)Math.sqrt((double)p1.val);
                                Callstack.push(p1);
                   
                                ModelTab.removeRow(ModelTab.getRowCount()-1);
                               os[0]=(Object)"Val";
                               os[1]=(Object)p1.val;
                               os[2]="";
                               os[3]="";
                               os[4]="";
                               ModelTab.addRow(os);
                               break; 
                           case INT: 
                                p1 = Callstack.pop();
                                p1.val=(float)Math.floor((double)p1.val);
                                Callstack.push(p1);
                   
                                ModelTab.removeRow(ModelTab.getRowCount()-1);
                               os[0]=(Object)"Val";
                               os[1]=(Object)p1.val;
                               os[2]="";
                               os[3]="";
                               os[4]="";
                               ModelTab.addRow(os);
                               break;
                           case ABS:
                                p1 = Callstack.pop();
                                p1.val=Math.abs(p1.val);
                                Callstack.push(p1);
                   
                                ModelTab.removeRow(ModelTab.getRowCount()-1);
                                ModelTab.removeRow(ModelTab.getRowCount()-1);
                               os[0]=(Object)"Val";
                               os[1]=(Object)p1.val;
                               os[2]="";
                               os[3]="";
                               os[4]="";
                               ModelTab.addRow(os);
                               break;
                       }
                   break;
                case CONSTPUSH:
                   p1 = new Datum();
                   p1.val=Prog[pc++].SymHoc.val;
                   Callstack.push(p1);
                   
                    os[0]=(Object)"Val";
                    os[1]=(Object)p1.val;
                    os[2]="";
                    os[3]="";
                    os[4]="";
                    ModelTab.addRow(os);
                    Pila.repaint();
                   break;
                   
                case DIV:
                   p2 = Callstack.pop();
                   p1 = Callstack.pop();
                   p1.val/=p2.val;
                   Callstack.push(p1);
                   
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                   
                    os[0]=(Object)"Val";
                    os[1]=(Object)p1.val;
                    os[2]="";
                    os[3]="";
                    os[4]="";
                    ModelTab.addRow(os);
                    Pila.repaint();
                   break;
                 case EVAL:
                   p2 = new Datum();
                   p1=Callstack.pop();
                   
                   p2.val = p1.symb.val;
                   Callstack.push(p2);
                   
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                    os[0]=(Object)"Val";
                    os[1]=(Object)p2.val;
                    os[2]="";
                    os[3]="";
                    os[4]="";
                    ModelTab.addRow(os);
                   break;
                case MUL:
                   p2 = Callstack.pop();
                   p1 = Callstack.pop();
                   p1.val*=p2.val;
                   Callstack.push(p1);
                   
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                   
                    os[0]=(Object)"Val";
                    os[1]=(Object)p1.val;
                    os[2]="";
                    os[3]="";
                    os[4]="";
                    ModelTab.addRow(os);
                   break;       
                case NEGATE:
                   p1 = Callstack.pop();
                   p1.val= -p1.val;
                   Callstack.push(p1);
                   
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                   
                    os[0]=(Object)"Val";
                    os[1]=(Object)p1.val;
                    os[2]="";
                    os[3]="";
                    os[4]="";
                    ModelTab.addRow(os);
                   break;  
                case POWER:
                   p2 = Callstack.pop();
                   p1 = Callstack.pop();
                   p1.val = (float) Math.pow((double)p1.val,(double)p2.val);
                   Callstack.push(p1);
                   
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                   
                    os[0]=(Object)"Val";
                    os[1]=(Object)p1.val;
                    os[2]="";
                    os[3]="";
                    os[4]="";
                    ModelTab.addRow(os);
                   break;  
                case PRINT:
                   p1 = Callstack.pop();
                   Result = Float.toString(p1.val)+"\n";
                   ArRes.append(Result);
                   
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                   break;  
                case STOP:
                   return;
                case SUB:
                   p2 = Callstack.pop();
                   p1 = Callstack.pop();
                   p1.val -= p2.val;
                   Callstack.push(p1);
                   
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                    ModelTab.removeRow(ModelTab.getRowCount()-1);
                   
                    os[0]=(Object)"Val";
                    os[1]=(Object)p1.val;
                    os[2]="";
                    os[3]="";
                    os[4]="";
                    ModelTab.addRow(os);
                   break;     
                case VARPUSH:
                   p1 = new Datum();
                   p1.symb=Prog[pc++].SymHoc;
                   Callstack.push(p1);
                   
                    os[0]=(Object)"Symbol";
                    os[1]=(Object)p1.val;
                    os[2]=p1.symb.Nom;
                    os[3]=p1.symb.TipoSim;
                    os[4]=p1.symb.val;
                    ModelTab.addRow(os);
                   break;                   
           }
       }
    }
    
}
