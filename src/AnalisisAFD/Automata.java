/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisAFD;

import java.util.ArrayList;

/**
 *
 * @author Oscar Chaves Navarro <ochndev at github.com>
 */
public class Automata {
    
    private String estado_inicial;
    private String [] estados_finales;
    private ArrayList<String []> transiciones;
    private String [] estados;

    public Automata(String estado_inicial, String[] estados_finales, ArrayList<String[]> transiciones, String[] estados) {
        this.estado_inicial = estado_inicial;
        this.estados_finales = estados_finales;
        this.transiciones = transiciones;
        this.estados = estados;
    }

    Automata() {
        
    }

    public String getEstadoInicial() {
        return estado_inicial;
    }

    public void setEstadoInicial(String estado_inicial) {
        this.estado_inicial = estado_inicial;
    }

    public String[] getEstadosFinales() {
        return estados_finales;
    }

    public void setEstadosFinales(String[] estados_finales) {
        this.estados_finales = estados_finales;
    }

    public ArrayList<String[]> getTransiciones() {
        return transiciones;
    }

    public void setTransiciones(ArrayList<String[]> transiciones) {
        this.transiciones = transiciones;
    }

    public String[] getEstados() {
        return estados;
    }

    public void setEstados(String[] estados) {
        this.estados = estados;
    }
    
    public boolean esFinal( String estado_actual){
        
        boolean encontrado = false;
        int i = 0;
        while(i < estados_finales.length && encontrado == false)
            if(estado_actual.equals(estados_finales[i])){
                System.out.println("estado_final: "+estados_finales[i]);
                encontrado = true;
            }else{
                    i++;
            }               
        return encontrado;
    }
    
    public String estadoSiguiente(String estado_actual , String caracter){
        
        String estado_siguiente = estado_actual;
        
        for(int i = 0 ; i < transiciones.size() ; i++){
            if((transiciones.get(i)[1].equals(estado_actual)) && (transiciones.get(i)[2].equals(caracter))){
                estado_siguiente = transiciones.get(i)[3];
            }
        }
        
        return estado_siguiente;
       
    }
    
    public String representarAutomata(){
        
        String automata = "";
        
        automata += "ESTADOS: ";
        for(int i = 0; i < estados.length ; i++)
            automata += estados[i] + "  "; 
        automata += "\nESTADO INICIAL: "+this.estado_inicial;
        automata += "\nESTADOS FINALES: ";
        for(int j=0;j<estados_finales.length ; j++)
            automata += estados_finales[j]+" ";
        automata += "\nTRANSICIONES: \n";
        for(int k = 0 ; k < transiciones.size() ; k++)
            automata += transiciones.get(k)[1]+" - "+transiciones.get(k)[2]+" - "+transiciones.get(k)[3]+"\n";
        automata += "--------------------------------------\n";
        
        return automata;
                
    }
    
}
