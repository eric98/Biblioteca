/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodes;

import java.util.Arrays;
import static metodes.Numeros.eliminaNoMultiples;

/**
 *
 * @author profe
 */
public class Numeros {
    
    /**
     *
     * @param any
     * @return
     */
    public static boolean bixest(int any){

        //return (any>=1584) && (any%400==0 || (any%4==0 && any%100!=0));
        if(any<1584) return false;
        else
            if(any%400==0 || (any%4==0 && any%100!=0)) return true;
            else return false;
    
    }
    
    /**
     *
     * @param numero
     * @return
     */
    public static boolean primer(int numero){
        int candidat=2;
        int cDivisors=0;
        if(numero<=1) return false;

        for (; candidat <= numero && cDivisors<1; candidat++) {
            if(numero%candidat==0) cDivisors++;            
        }
        //for equivalent que no utiliza la variable cDivisors
        //for (; candidat <= numero && numero%candidat!=0; candidat++);
        return numero==(candidat-1);
        
    }
    
    //Mètode de l'exercici 7
    //Rep com a paràmetre un número enter i retorna un vector de la dimensió necessària per guardar cada dígit del número en una casella del vector

    /**
     *
     * @param num
     * @return
     */
        public static int[] vectorDigits(int num){
        
        //Per saber la grandària del vector ho haguessem pogut fer comptant les vegades que es pot dividir a num entre 10 fins arribar a valdre 0
        //però hem usat el mètode length() dels Strings, convertint prèviament el paràmetre enter a String usant el mètode String.valueOf()
        int[] resultat=new int[String.valueOf(num).length()-(num>=0?0:1)];
        
        //Booleà que em servirà per saber si el paràmetre era negatiu, ja que en este cas lo passo a positiu
        boolean negatiu=(num<0);
        if(negatiu) num*=-1;
        
        //Omplim el vector des de l'última casella fins la primera en els successius mòduls de la divisió entre 10
        for (int i = resultat.length-1; i >=0 ; i--) {
            resultat[i]=num%10;
            //A cada iteració hem de dividir num entre 10
            num/=10;
        }
        //Finalment, si el paràmetre era negatiu, canviem el signe de la primera casella del vector
        if(negatiu) resultat[0]*=-1;
        
        //Retornem el vector omplit correctament com a resultat
        return resultat;
    
    }
    
    //Mètode de l'exercici 13
    //Rep com a paràmetre un vector que representa un número enter (en el format de l'exercici 7) i retorna el número enter representat

    /**
     *
     * @param num
     * @return
     */
    public static int numVector(int[] num){
        
        //Per evitar problemes, si el vector és null retornem 0, i així no tindrem l'excepció NullPointerException
        if(num == null) return 0;
        
        //La idea es recòrrer el vector de dreta a esquerra i per cada dígit multiplicar-lo per la potència de 10 adequada i anar sumant les diferents multiplicacions
        
        //variables locals
        int resultat=0;             //per calcular el resultat
        int factor=1;               //per tenir el factor potèmcia de 10 necessari per cada dígit. Comença valent 1 i continua en 10, 100, 1000, ...
        boolean negatiu=(num[0]<0); //si el núm ero representat és negatiu el passarem a positiu i al final li canviarem el signe al resultat
        
        //Si és negatiu lo passem a positiu per operar correctament en ell
        if(negatiu) num[0]*=-1;
        
        //Recorrem el vector des de l'última casella fins la primera i per cada dígit el multipliquem per la potència de 10 correcta
        for (int i = num.length-1; i >=0 ; i--) {
            resultat+=num[i]*factor;
            //A cada iteració hem de multiplicar el factor per 10
            factor*=10;
        }
        
	//Si és negatiu lo dixem com estava inicialment
        if(negatiu) num[0]*=-1;

        //Retornem el resultat obtingut, però en negatiu si cal
        return negatiu?resultat*-1:resultat;
    
    }
        
    /**
     *
     * @param params
     * @return
     */
    public static int[] tractaParametres(int... params){
        
        //Tractament de no rebre cap paràmetre. retornem null
        if(params.length==0) return null;
        
        int[] resultat={0, params.length,0, 0};
        
        int suma, maxim, minim;
        
        suma=maxim=minim=params[0];
        
        for (int i = 1; i < params.length; i++) {
            if(params[i]>maxim) maxim=params[i];
            if(params[i]<minim) minim=params[i];
            suma+=params[i];
        }
        
        resultat[0]=suma;
        resultat[2]=maxim;
        resultat[3]=minim;

        return resultat;
    }
    
    /**
     *
     * @param params
     * @return
     */
    public static float[] ompleVectorFloats(float... params){
        
        if(params.length==0) return null;
        
        return params;
    
    }
    
    /**
     *
     * @param vector
     * @param num
     */
    public static void eliminaNoMultiples(int[] vector, int num){
        if(vector!=null & num!=0){
            int multiplo=0;
            for (int i = 0; i < vector.length; i++) {
                if(vector[i]%num==0){
                    vector[multiplo++]=vector[i];
                }
                if(i!=multiplo-1) vector[i]=-1;
                
            }
        }
    }
    
    /**
     *
     * @param vector
     * @param num
     * @return
     */
    public static int[] eliminaNoMultiplesV2_1(int[] vector, int num){
        
        //int[] copia = Arrays.copyOf(vector, vector.length);
        
        int[] copia=new int[vector.length];
        for (int i = 0; i < copia.length; i++) {
            copia[i]=vector[i];
            
        }
        eliminaNoMultiples(copia, num);
        return copia;
        
    }
   
    /**
     *
     * @param vector
     * @param num
     * @return
     */
    public static int[] eliminaNoMultiplesV2_2(int[] vector, int num){
        if(vector!=null & num!=0){
            //fem la còpia del vector
            int[] copia=new int[vector.length];
            
            int multiplo=0;
            for (int i = 0; i < vector.length; i++) {
                if(vector[i]%num==0){
                    copia[multiplo++]=vector[i];
                }
                if(i!=multiplo-1) copia[i]=-1;
                
            }
            return copia;
        }
        return null;
        
    }
   
}