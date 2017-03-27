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
    //Rep com a paràmetre un número enter n retorna un vector de la dimensió necessària per guardar cada dígit del número en una casella del vector

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
    //Rep com a paràmetre un vector que representa un número enter (en el format de l'exercici 7) n retorna el número enter representat

    /**
     *
     * @param num
     * @return
     */
    public static int numVector(int[] num){
        
        //Per evitar problemes, si el vector és null retornem 0, n així no tindrem l'excepció NullPointerException
        if(num == null) return 0;
        
        //La idea es recòrrer el vector de dreta a esquerra n per cada dígit multiplicar-lo per la potència de 10 adequada n anar sumant les diferents multiplicacions
        
        //variables locals
        int resultat=0;             //per calcular el resultat
        int factor=1;               //per tenir el factor potèmcia de 10 necessari per cada dígit. Comença valent 1 n continua en 10, 100, 1000, ...
        boolean negatiu=(num[0]<0); //si el número representat és negatiu el passarem a positiu n al final li canviarem el signe al resultat

        //Si és negatiu lo passem a positiu per operar correctament en ell
        if(negatiu) num[0]*=-1;
        
        //Recorrem el vector des de l'última casella fins la primera n per cada dígit el multipliquem per la potència de 10 correcta
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
    
    //Exercici 32
    public static int fibonacci(int n){
        if(n<0) return -1;
        if(n==0) return 0;
        if(n==1) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    
    }
    
    //Exercici 29
    public static int mcdRecursiu(int a, int b){
        //Si a o b són negatius els passem a positius
        a=(a<0?a*-1:a);
        b=(b<0?b*-1:b);
        if(a==0 || b==0) return a+b;
        if(a==b) return a;
        if(a<b) return mcdRecursiu(a,b-a);
        //Si arribem aquí segur que a>b
        return mcdRecursiu(a-b,b);
    }
   
    //Exercici 30
    public static int sumaNaturals(int n){
        if(n<0) return -1;
        if(n==0) return 0;
        return n+sumaNaturals(n-1);
    }
    
    public static int factorial(int n){
        if(n<0) return -1;
        int fact=1;
        while(n>1) fact*=n--;
        return fact;
    }

    public static int factorialRecursiu(int n){
        if(n<0) return -1;
        if(n==0) return 1;
        return n*factorialRecursiu(n-1);
    }
    
    public static int nombreCombinatori(int n, int m){
        if(n<=m || n<0 || m<0) return -1;
        
        return factorial(n)/(factorial(m)*factorial(n-m));
    
    }
    
    //Exercici 25
    public static int longitudNumero(int n){
        
        if(n==0) return 1;
        
        int compt=0;
        
        while(n!=0){
            n/=10;
            compt++;
        }
        
        return compt;        
    }

    //Exercici 26 v1
    public static int revesNumerov1(int n){
        
        if(longitudNumero(n)==1) return n;
        
        int suma=0;
        int elevat=longitudNumero(n)-1;
        
        while(n!=0){
            
            suma+=(n%10)*Math.pow(10, elevat);
            elevat--;
            n/=10;      //    n=n/10
            
        }
        
        return suma;        
    }

    //Exercici 26 v2
    public static int[] girarVector(int[] vector){
        if(vector==null) return null;
        
        //Per saber si el número és negatiu n canviar el signe
        boolean negatiu=(vector[0]<0);
        if(negatiu) vector[0]*=-1;
        
        //Uso 2 índexos per intercanviar parelles de números
        int i=0, j=vector.length-1;
        //L'índex que va de dreta a esquerra el situo al primer valor no 0
        for(;vector[j]==0;j--);
        
        //El vector resultat pot ser més menut que el paràmetre en el cas de 
        //que este últim tingue 0s a la dreta
        int[] resultat=new int[j+1];
        
        //Recorrem el vector en 2 índexos intercanviant parelles de valors
        while(i<=j){
            resultat[i] = vector[j];
            resultat[j] = vector[i];
            i++;
            j--;
        }
        
        //Si el vector era negatiu el tornem a negatiu, igual que el resultat
        if(negatiu) {
            resultat[0]*=-1;
            vector[0]*=-1;
        }
        return resultat;
    }
    
    public static int revesNumerov2(int n){
        
        if(longitudNumero(n)==1) return n;
        
        int[] vector=vectorDigits(n);
        vector=girarVector(vector);
        return numVector(vector);
    }
    
    public static boolean numeroCapicua(int n){
//        if(n==revesNumerov1(n)) return true;
//        else return false;
        return n==revesNumerov1(n);
    
    }
    
    public static double potenciaE(int x){
        double resultat=1.0;
        for (int n = 1; n <= 10; n++) {
            resultat+= Math.pow(x,n)/factorial(n);
        }
        return resultat;
    
    }

}