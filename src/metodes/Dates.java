/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodes;

/**
 *
 * @author profe
 */
public class Dates {
    
     /**
     *
     * @param any
     * @return
     */
    //Exercici 5
    public static boolean bixest(int any){

        //return (any>=1584) && (any%400==0 || (any%4==0 && any%100!=0));
        if(any<1584) return false;
        else
            if(any%400==0 || (any%4==0 && any%100!=0)) return true;
            else return false;
    
    }
    
    //Exercici 38
    public static boolean dataCorrecta(int dia, int mes ,int any){
        int [] mesos={31,28,31,30,31,30,31,31,30,31,30,31};
        
        if(bixest(any)) mesos[1]=29;
        
        if(mes<1 || mes>12) return false;
        else{
            if(dia<1 || dia>mesos[mes-1]) return false;
            else  return true;
        }
    }
    
    //Exercici 39
    public static int[] diaSeguent(int dia, int mes ,int any){
        
        //Si la data no és correcta retornem null i acabem
        if(!dataCorrecta(dia,mes,any)) return null;
        
        //Nota: el papa Gregorio XIII, asesorado por el astrónomo jesuita 
        //Christopher Clavius, el 24 de febrero de 1582 promulgó la bula Inter 
        //Gravissimas, en la que establecía que tras el jueves 4 de octubre de 
        //1582 seguiría el viernes 15 de octubre de 1582.
        if(dia==4 && mes==10 && any==1582) return new int[]{15, mes, any};

        //Si podem sumar un dia retornem la data, sinó estavem a final de mes
        if(dataCorrecta(dia+1,mes,any)) return new int[]{dia+1, mes, any};
        
        //Si podem passar al dia 1 del mes següent la retornem, sinó estavem a final d'any
        if(dataCorrecta(1,mes+1,any)) return new int[]{1, mes+1, any};
        
        //Per últim retornem l'1 de gener de l'any següent
        return new int[]{1, 1, any+1};
    }  
    
    public static int comparaDates(int dia1, int mes1, int any1, int dia2, int mes2, int any2){
    
        //Si alguna data no és correcta retornem -2
        if(!dataCorrecta(dia1,mes1,any1) || !dataCorrecta(dia2,mes2,any2)) return -2;
    
        //Mirem els anys
        if(any1>any2) return 1;
        if(any1<any2) return -1;
    
        //Estem al mateix any. Mirem els mesos
        if(mes1>mes2) return 1;
        if(mes1<mes2) return -1;
        
        //Estem al mateix any i al mateix mes. Mirem els dies
        if(dia1>dia2) return 1;
        if(dia1<dia2) return -1;
        return 0;
        
    }

    public static int diferenciaDies(int dia1, int mes1, int any1, int dia2, int mes2, int any2){
    
        int dies=0;     //Comptador de diferència de dies 
        
        switch(comparaDates(dia1,mes1,any1,dia2,mes2,any2)){
            //Si alguna data no és correcta retornem -1
            case -2:
                return -1;
            //La primera data és inferior que la segona    
            case -1:
                //Ordenem o no fem res si volem que la primera data sigue la menuda 
                break;
            //Si són la mateixa data retornem 0    
            case 0:
                return 0;
            //La primera data és superior que la segona    
            case 1:
                //Ordenem o no fem res si volem que la primera data sigue la gran 
                int temporal=0;
                temporal=dia1;
                dia1=dia2;
                dia2=temporal;
                temporal=mes1;
                mes1=mes2;
                mes2=temporal;
                temporal=any1;
                any1=any2;
                any2=temporal;
                break;
        }
        
        //Passem del dia inferior al superior incrementant dia a dia fins que siguen iguals
        while(comparaDates(dia1,mes1,any1,dia2,mes2,any2)!=0){
            //passem al dia següent
            int[] dema=diaSeguent(dia1, mes1 , any1);
            dia1=dema[0];
            mes1=dema[1];
            any1=dema[2];
            dies++;         //Comptem un dia més
        }
        
        //Retornem el número de dies que hem hagut d'incrementar
        return dies;
        
    }

}
