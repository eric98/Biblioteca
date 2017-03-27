/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodes;

import java.util.Arrays;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author profe
 */
public class GUI_UF3 {
    
    

    /**
     * Mètode que ompli la taula en les columnes i dades rebudes
     * @param nomCols array que conté el nom de les columnes de la taula
     * @param dades matriu que conté les dades de la taula
     * @param taula on mostrarem les columnes i dades
     */
    public static void carregaTaula(String[] nomCols, Object[][] dades, JTable taula) {

        //Mirem si han passat columnes i dades. En cas contrari sortim
        if (nomCols == null || dades == null) {
            return;
        }

        //Variables locals
        Vector columnNames = new Vector();
        Vector data = new Vector();
        DefaultTableModel model;

        //Anotem el nº de columnes a mostrar
        int ncamps = nomCols.length;

        //Recorrem l'array de noms de columna i els posem com a columnes de la taula
        for (String s : nomCols) {
            columnNames.addElement(s);
        }

        //Si hi ha algun element a l'array de dades omplim la taula
        if (dades.length != 0) {

            for (int i = 0; i < dades.length; i++) {
                Vector row = new Vector(ncamps);
                for (int j = 0; j < dades[i].length; j++) {
                    row.add(dades[i][j]);
                }
                data.addElement(row);
            }
        }

        //Per no poder modificar les cel·les de la taula
        model = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        taula.setModel(model);

        TableColumn column;
        for (int i = 0; i < taula.getColumnCount(); i++) {
            column = taula.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
        }
    }

    /**
     * Mètode que transforma l'array de pilots en una matriu
     * @param dades array que conté les dades a transformar
     * @return una matriu d'objectes que conté les dades que ens interessen dels pilots
     */
    public static Object[][] transformaDades(Pilot[] dades){
        Object[][] resultat=new Object[dades.length][5];
        //Variable per comptar el número de pilots en dades que hi ha a l'array de dades
        int omplits=0;
        
        for (int i = 0; i < dades.length; i++) {
            if(dades[i].isOmplit()){
                resultat[omplits][0]=i;
                resultat[omplits][1]=dades[i].getNom();
                resultat[omplits][2]=dades[i].getDorsal();
                resultat[omplits][3]=dades[i].getDinersGuanyats();
                resultat[omplits][4]=dades[i].isHome();
                omplits++;
            }
        }
        //Retornem només els pilots plens
        return Arrays.copyOf(resultat,omplits);
    
    }

    
}

class Pilot{
    
    // Les meues propietats
    private String nom="";
    private int dorsal;
    private boolean home;
    private double dinersGuanyats;
    private boolean omplit;

    public Pilot(String nom, int dorsal, boolean home, double dinersGuanyats, boolean omplit) {
        this.nom = nom;
        this.dorsal = dorsal;
        this.home = home;
        this.dinersGuanyats = dinersGuanyats;
        this.omplit = omplit;
    }

    public Pilot() {
    }
    
    public Pilot(String nom) {
        this.nom=nom;
    }
    
    public Pilot(String nom, int dorsal) {
        this.nom=nom;
        this.dorsal=dorsal;
    }

    @Override
    public String toString() {
        
        return "\nNom: "+nom+
               "\nDorsal: "+dorsal+
               "\nDiners guanyats: "+dinersGuanyats+
               (home?"\nÉs home":"\nÉs dona");
    }
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDorsal() { 
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        if(dorsal<0) System.out.println("El dorsal ha de ser positiu o zero!!");
        else this.dorsal = dorsal;
    }

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public double getDinersGuanyats() {
        return dinersGuanyats;
    }

    public void setDinersGuanyats(double dinersGuanyats) {
        if(dinersGuanyats<0) System.out.println("Els diners no poden ser negatius!!");
        else this.dinersGuanyats = dinersGuanyats;
    }

    public boolean isOmplit() {
        return omplit;
    }

    public void setOmplit(boolean omplit) {
        this.omplit = omplit;
    }

}

        
        