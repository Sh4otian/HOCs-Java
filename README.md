# HOCs-Java
HOC 3 - Compiladores en Java con JFlex y Java CUP

## Descripción

Este proyecto implementa **HOC 3 (High Order Calculator 3)** para la materia de **Compiladores**, utilizando **Java**, **JFlex** y **Java CUP** para la generación automática del analizador léxico y sintáctico.

El sistema permite:

- Operaciones aritméticas básicas (`+`, `-`, `*`, `/`, `^`).
- Manejo de variables.
- Identificadores con nombres arbitrarios.
- Detección y reporte de errores léxicos y sintácticos.
- Uso de funciones matemáticas predefinidas.
- Evaluación de expresiones mediante una calculadora tipo intérprete.

## Tecnologías utilizadas

- Java
- JFlex 1.9.1
- Java CUP 11b

## Estructura del proyecto
## Estructura del Proyecto

```text
HOC3/
│
├── Dep/
│   ├── java-cup-11b.jar
│   ├── java-cup-runtime-11b.jar
│   └── jflex-full-1.9.1.jar
│
├── src/
│   ├── flexcup/
│   │   ├── AnalizadorLexico.java
│   │   ├── AnalizadorSintac.java
│   │   ├── AnalizadorSintacSym.java
│   │   ├── Hoc3.flex
│   │   └── Hoc3.cup
│   │
│   ├── hoc3/
│   │   └── HOC3.java
│   │
│   └── src/
│       ├── BLTIN.java
│       ├── EnumTipSim.java
│       ├── Principal.java
│       ├── Principal.form
│       ├── SymbolHoc.java
│       └── TabSymb.java
│
└── README.md
```

## Generación de código

Cada vez que se realicen cambios en los archivos del analizador léxico (`Hoc3.flex`) o del analizador sintáctico (`Hoc3.cup`), es necesario regenerar los archivos correspondientes ejecutando los siguientes comandos desde el directorio del proyecto.

### 1. Generar el analizador léxico

```bash
java -jar ../../Lib/jflex-full-1.9.1.jar Hoc3.flex
```

### 2. Generar el analizador sintáctico

```bash
java -cp "../../Lib/java-cup-11b.jar;../../Lib/java-cup-runtime-11b.jar" java_cup.Main Hoc3.cup
```

> **Nota para Linux/macOS:** sustituir `;` por `:` en el classpath.

```bash
java -cp "../../Lib/java-cup-11b.jar:../../Lib/java-cup-runtime-11b.jar" java_cup.Main Hoc3.cup
```


## Funcionalidades implementadas en HOC 3

- Declaración y uso de variables.
- Variables con nombres arbitrarios.
- Asignación de valores.
- Evaluación de expresiones aritméticas.
- Manejo de precedencia y asociatividad de operadores.
- Funciones matemáticas predefinidas.
- Manejo de errores léxicos.
- Manejo de errores sintácticos.
- Interpretación de instrucciones ingresadas por el usuario.
