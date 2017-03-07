/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodes;

import static metodes.Numeros.longitudNumero;
import static metodes.Numeros.numVector;
import static metodes.Numeros.vectorDigits;

/**
 *
 * @author profe
 */
public class FetsPerAlumnes {
 
    //Eric García
    public static int[] girarVectorEG(int[] vector){
        int j;
        boolean negatiu=false;
        for (int compt=0,i = vector.length-1; i > 0; i--,compt++) {
            j = vector[compt];
            vector[compt]=vector[i];
            vector[i]=j;
            if (compt==0 && j<0){
                negatiu=true;
                vector[i]*=-1;
            }            
        }
        if (negatiu)vector[0]*=-1;
        return vector;
    }
    
    //Ferran Bonet
    public static int revesNumerov2FB(int num) {
        boolean negatiu;
        if (num < 0) {
            num *= -1;
            negatiu = true;
        }
        int[] invers = new int[longitudNumero(num)];
        for (int i = 0, j = longitudNumero(num) - 1; i < longitudNumero(num); i++, j--) {
            invers[j] = vectorDigits(num)[i];
        }
        int resultat = numVector(invers);
        if (negatiu = true) {
            resultat *= -1;
        }
        return resultat;
    }
    
    //Ait Ayub
    public static int[] girarVectorAA(int[] vector){
         
         int[] aux= new int[vector.length];
         
         for (int i = 0, j=aux.length-1; i < vector.length; i++, j--) {
             
            aux[i]= vector[j];
         }
         return aux;
    }
    
    //Alex Sorribes
    public static int[] giraVectorAS(int[] vector){
        boolean negatiu = false;
        if(vector.length == 0) return null;
        if(vector.length == 1) return vector;
        if(vector[0] < 0){
            vector[0] *= -1;
            negatiu = true;
        }
        
        int[] aux = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            aux[i] = vector[i];
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] = aux[vector.length -i-1];
        }
        if(negatiu) vector[0] *= -1;
        return vector;
    }
}
