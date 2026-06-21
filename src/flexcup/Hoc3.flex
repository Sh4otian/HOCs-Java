package flexcup;
import src.*;
import java_cup.runtime.*;
import java.io.Reader;
%%
%public
%class AnalizadorLexico
%line
%column
%char
%cup

%{
    public SymbolHoc s;
    public int TipSimb;
    public MaqHOC Maquina;

    TabSymb ListSimb = new TabSymb();

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object Value){
        return new Symbol(type, yyline, yycolumn, Value);
    }
%}

Letra=[a-zA-Z]
Digito=[0-9]
%%
[ \t\n]+            { ;}
";"                 { return symbol(AnalizadorSintacSym.SEMIC); }
{Digito}+(\.{Digito}+)?                 { s=new SymbolHoc("",EnumTipSim.CONST_NUM, new Float(yytext()));
                        return symbol(AnalizadorSintacSym.NUM,s);
                        }
"="                 { return symbol(AnalizadorSintacSym.OpAsig); }
"/"                 { return symbol(AnalizadorSintacSym.OpDiv); }
"*"                 { return symbol(AnalizadorSintacSym.OpProd); }
"+"                 { return symbol(AnalizadorSintacSym.OpSum); }
"-"                 { return symbol(AnalizadorSintacSym.OpRes); }
")"                 { return symbol(AnalizadorSintacSym.ParDer); }
"("                 { return symbol(AnalizadorSintacSym.ParIzq); }
\^                 { return symbol(AnalizadorSintacSym.OpPot); }
{Letra}({Letra}|{Digito})*      {

        s = Maquina.Tabs.lookup(yytext());
        if(s ==null)
            s=Maquina.Tabs.install(yytext(), EnumTipSim.UNDEF, (float)0.0);
        switch(s.TipoSim){
            case VAR: 
                TipSimb = AnalizadorSintacSym.VAR;
                break;
            case UNDEF:
                TipSimb = AnalizadorSintacSym.VAR;
                break;
            case BLTIN:
                TipSimb = AnalizadorSintacSym.BLTIN;
                break;
            case CONST_PRED:
                TipSimb = AnalizadorSintacSym.CONST_PRED;
                break;
        }
        return symbol(TipSimb, s);
   }
.           { return symbol(AnalizadorSintacSym.error);}
