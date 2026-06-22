/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.Stack;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.util.Stack;//Frames

/**
 *
 * @author Admin
 */
public class MaquinaHoc4 {
   public TabSymb Tabs;
    public InstruProg Prog[];
    public int progp = 0, pc;
    Stack<Datum> Callstack;
    Stack<Frame> FrameStack;
    Stack<Datum> ParamStack;
    public String nombreFuncionActual = "";
    public String nombreParametroActual = "";
    
    public MaquinaHoc4(){
       Tabs = new TabSymb();
       Tabs.init();
       
       Prog = new InstruProg[2048];
       progp=0;pc=0;
       
       Callstack = new Stack();
       Callstack.clear();
       
       FrameStack = new Stack();
       FrameStack.clear();

       ParamStack = new Stack();
       ParamStack.clear();
    }
    
    public void initcode(){
       progp=0;
       
       Callstack.clear();
       
       FrameStack.clear();
       ParamStack.clear();
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
    private Frame frameActual() {
        if (FrameStack.empty()) {
            return null;
        }
        return FrameStack.peek();
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
                   
                   boolean encontradoLocal = false;

                   Frame frActual = frameActual();
                   //EVAL primero busca si la variable es parámetro local de la función
                    if (frActual != null && frActual.sp != null) {
                        int idx = frActual.sp.listaParams.indexOf(p1.symb.Nom);

                    if (idx >= 0 && idx < frActual.parametros.size()) {
                        System.out.println("Usando parametro local: " + p1.symb.Nom);
                        p2.val = frActual.parametros.get(idx).val;
                        encontradoLocal = true;
                        }
                    }
                    if (!encontradoLocal) {
                        p2.val = p1.symb.val;
                    }
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
                //Ciclos
                case JUMP: 
                    Instruc = Prog[pc++];
                    pc = Instruc.direccion;
                    break;
                case JUMP_TRUE:
                    p1 = Callstack.pop();
                    Instruc = Prog[pc++];
                    if (p1.val != 0)
                        pc = Instruc.direccion;
                    break;
                case JUMP_FALSE:
                    p1 = Callstack.pop();
                    Instruc = Prog[pc++];
                    if (p1.val == 0)
                        pc = Instruc.direccion;
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
                //Comparadores
                case GT:
                    p2 = Callstack.pop();
                    p1 = Callstack.pop();
                    p1.val = (p1.val > p2.val) ? 1 : 0;
                    Callstack.push(p1);
                    break;

                case GE:
                    p2 = Callstack.pop();
                    p1 = Callstack.pop();
                    p1.val = (p1.val >= p2.val) ? 1 : 0;
                    Callstack.push(p1);
                    break;

                case LT:
                    p2 = Callstack.pop();
                    p1 = Callstack.pop();
                    p1.val = (p1.val < p2.val) ? 1 : 0;
                    Callstack.push(p1);
                    break;

                case LE:
                    p2 = Callstack.pop();
                    p1 = Callstack.pop();
                    p1.val = (p1.val <= p2.val) ? 1 : 0;
                    Callstack.push(p1);
                    break;

                case EQ:
                    p2 = Callstack.pop();
                    p1 = Callstack.pop();
                    p1.val = (p1.val == p2.val) ? 1 : 0;
                    Callstack.push(p1);
                    break;

                case NE:
                    p2 = Callstack.pop();
                    p1 = Callstack.pop();
                    p1.val = (p1.val != p2.val) ? 1 : 0;
                    Callstack.push(p1);
                    break;
                case CALL:
                    System.out.println("Entrando a CALL");
                    System.out.println("Funcion: " + (Instruc.SymHoc == null ? "NULL" : Instruc.SymHoc.Nom));
                    System.out.println("Dir inicio: " + (Instruc.SymHoc == null ? -1 : Instruc.SymHoc.dirInicio));
                    // Obtener la función que se va a llamar
                    SymbolHoc f = Instruc.SymHoc;
                    // Crear un nuevo frame
                    Frame fr = new Frame();
                    // Guardar la función y la dirección de retorno
                    fr.sp = f;
                    fr.retpc = pc;
                    for (int i = 0; i < Instruc.numArgs; i++) {
                        Datum arg = Callstack.pop();
                        fr.parametros.add(0, arg);
                    }
                    System.out.println("Args recibidos: " + fr.parametros.size());
                    System.out.println("Params funcion: " + f.listaParams);
                    if (!fr.parametros.isEmpty()) {
                        System.out.println("Valor arg 0: " + fr.parametros.get(0).val);
                    }
                    // Meter el frame a la pila de llamadas
                    FrameStack.push(fr);
                    // Saltar al inicio de la función
                    pc = f.dirInicio;
                    break;
                case RET:
                    if (!FrameStack.empty()) {
                        Frame frRet = FrameStack.pop();
                        pc = frRet.retpc;
                    } else {
                        System.out.println("RET sin frame");
                    }
                    break;
           }
       }
    }
    
}
