package com.example.melanie.appaens.data;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.model.Categorie;
import com.example.melanie.appaens.model.Informatie;
import com.example.melanie.appaens.model.Observatie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static Observatie observatie;
    private static Informatie informatie;
    private static List<Categorie> categorieList;
    private static List<Informatie> informatieList;
    private static boolean firstrun = true;

    public DataSource(){
//        if (firstrun){
            setCategorieList();
            setInformatieList();
//            firstrun = false;
//        }
    }

    public int[] getDrawables(){
        int[] drawableList = {
                R.drawable.acties,
                R.drawable.armen,
                R.drawable.bovenlichaam,
                R.drawable.gehelelichaam,
                R.drawable.geluid,
                R.drawable.handen,
                R.drawable.hoofd,
                R.drawable.houding,
                R.drawable.mond,
                R.drawable.neus,
                R.drawable.voeten
        };
        return drawableList;
    }

    public int[] getColors(){
        int[] colorList = {
                R.color.colorRood,
                R.color.colorOranje,
                R.color.colorGeel,
                R.color.colorBlauw,
                R.color.colorGroen,
                R.color.colorRoze,
                R.color.colorPaars
        };
        return colorList;
    }

    private void setCategorieList(){
        //initialize categorielist
        categorieList = new ArrayList<Categorie>();
        categorieList.add(new Categorie(0, "Acties", 0, 5, 0));
        categorieList.add(new Categorie(0, "Armen", 1, 5, 0));
        categorieList.add(new Categorie(0, "Bovenlichaam", 2, 5, 0));
        categorieList.add(new Categorie(0, "Gehele lichaam", 3, 5, 0));
        categorieList.add(new Categorie(0, "Geluid", 4, 5, 0));
        categorieList.add(new Categorie(0, "Handen", 5, 5, 0));
        categorieList.add(new Categorie(0, "Hoofd", 6, 5, 0));
        categorieList.add(new Categorie(0, "Houding", 7, 5, 0));
        categorieList.add(new Categorie(0, "Mond", 8, 5, 0));
        categorieList.add(new Categorie(0, "Neus", 9, 5, 0));
        categorieList.add(new Categorie(0, "Voeten", 10, 5, 0));
    }

    private void setInformatieList(){
        //initialize informatielist
        informatieList = new ArrayList<Informatie>();
        informatieList.add(new Informatie(0, "-3", "", ""));
        informatieList.add(new Informatie(1, "-2", "", ""));
        informatieList.add(new Informatie(2, "-1", "", ""));
        informatieList.add(new Informatie(3, "0", "", ""));
        informatieList.add(new Informatie(4, "+1", "", ""));
        informatieList.add(new Informatie(5, "+2", "", ""));
        informatieList.add(new Informatie(6, "+3", "", ""));
    }

    private void setQuestionList(){
        
    }

    public List<Categorie> getCategories(){
        return categorieList;
    }

    public List<Informatie> getInformatieList(){
        return informatieList;
    }
}

