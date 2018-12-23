/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisAFD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Oscar Chaves Navarro <ochndev at github.com>
 */
public class LogicaDeLaAplicacion {
    
    Automata AUT;
    String cadena_caracteres;
    private String estadoActual;

    LogicaDeLaAplicacion() {
        AUT = new Automata();
        estadoActual = "";
    }
    
    public void CargarArchivo(String ruta) throws FileNotFoundException, IOException{

        FileReader FR = new FileReader(ruta);
        BufferedReader BR = new BufferedReader(FR);
        
        String estados[];
        String inicial = "";
        String finales [];
        ArrayList<String[]> transiciones = new ArrayList<>();
        
        String linea;
        
        do{
            linea = BR.readLine();
            System.out.println(linea);
            
            if(linea.contains("ESTADOS:")){
                estados = linea.replace("ESTADOS:","").split(" ");
                AUT.setEstados(estados);
            }else if(linea.contains("INICIAL:")){
                inicial = linea.replace("INICIAL: ", "");
                AUT.setEstadoInicial(inicial);
            }else if(linea.contains("FINALES:")){
                finales = linea.replace("FINALES:", "").split(" ");
                AUT.setEstadosFinales(finales);
            }else if(linea.charAt(0) == ' '){                
                linea = linea.replace("'", "");
                transiciones.add(linea.split(" "));
            }

        }while(!linea.equals("FIN"));
        
        for (int i = 0; i < transiciones.size(); i++) {
            System.out.println("estado inicial: "+transiciones.get(i)[1]+
                    "- caracter: "+transiciones.get(i)[2]+
                    " - estado_siguiente: "+transiciones.get(i)[3]);
            
        }
        
        AUT.setTransiciones(transiciones);       
        
        BR.close();
        FR.close();
        
    }
    
    public String simulacion(){
        
        String estado_actual;
        String salida = AUT.representarAutomata();
        estado_actual = AUT.getEstadoInicial();
        
        System.out.println("cadena de caracteres: " + cadena_caracteres);
        System.out.println(" -> estado inicial: "+estado_actual);
        salida += " -> estado inicial: "+estado_actual;
        
        int i = 0;
                
        while(!AUT.esFinal(estado_actual) && i < cadena_caracteres.length()){
            

            System.out.println(" -> estado actual: "+estado_actual);
            salida += "\n\n -> estado actual: "+estado_actual;
            
            System.out.println(" -> caracter actual: " + cadena_caracteres.charAt(i) + "(en indice "+i+")");
            salida += "\n -> caracter actual: " + cadena_caracteres.charAt(i) + "(en indice "+i+")";
            
            estado_actual = AUT.estadoSiguiente(estado_actual, cadena_caracteres.substring(i, i+1));
            
            System.out.println(" -> estado tras transicion: "+estado_actual);
            salida += "\n -> estado tras transicion: "+estado_actual;
            i++;
        }       
        
        
        if(AUT.esFinal(estado_actual)){
            System.out.println(" -> El estado actual: "+estado_actual+" es estado FINAL");
            salida += "\n\n -> El estado actual: "+estado_actual+" es estado FINAL";
        }
        else{
            System.out.println(" -> El estado actual: "+estado_actual+" es un estado MUERTO");
            salida += "\n\n -> El estado actual: "+estado_actual+" es un estado MUERTO";
        }
        
        return salida;
    }
    
    
    
    public String simulacionPasoAPaso(int caracter_actual){

        String salida = AUT.representarAutomata();        
        
        ////////////////////////////////////////////////////////////////////////
        if(caracter_actual == 0){            
            
            estadoActual = AUT.getEstadoInicial();
            System.out.println(" -> ESTADO INICIAL: "+estadoActual);
            salida += " -> ESTADO INICIAL: "+estadoActual;
            
        }else{
            
            System.out.println(" -> ESTADO ACTUAL: " + estadoActual);
            salida += " -> ESTADO ACTUAL: " + estadoActual;
            
        }        
        
        ////////////////////////////////////////////////////////////////////////
        
        System.out.println(" -> CARACTER: "+cadena_caracteres.charAt(caracter_actual)+"(en indice "+caracter_actual+")");
        salida += "\n -> CARACTER: "+cadena_caracteres.charAt(caracter_actual)+"(en indice "+caracter_actual+")";
                
        ////////////////////////////////////////////////////////////////////////
        if(!AUT.esFinal(estadoActual) && caracter_actual < cadena_caracteres.length()){
            estadoActual = AUT.estadoSiguiente(estadoActual, cadena_caracteres.substring(caracter_actual, caracter_actual+1));            
            System.out.println(" -> ESTADO ACTUAL tras transicion: "+estadoActual);
            salida += "\n -> ESTADO ACTUAL tras transicion: "+estadoActual;
        }
        
        if(!AUT.esFinal(estadoActual) && caracter_actual == cadena_caracteres.length()-1){
            System.out.println(" -> el estado "+estadoActual+" es un estado MUERTO\n");
            salida += "\n -> el estado "+estadoActual+" es un estado MUERTO\n";
        }
        
        if(AUT.esFinal(estadoActual) && caracter_actual == cadena_caracteres.length()-1){
            System.out.println(" -> el estado "+estadoActual+" es un estado FINAL\n");
            salida += "\n -> el estado "+estadoActual+" es un estado FINAL\n";
        }
        
        ////////////////////////////////////////////////////////////////////////        
        return salida;
    }
    
    
    
    
    public void setCadena(String cadena_caracteres){
        this.cadena_caracteres = cadena_caracteres;
    }
    
    public String getCadena(){
        return cadena_caracteres;
    }
    
}
