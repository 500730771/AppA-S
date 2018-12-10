package com.example.melanie.appaens.data;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.activity.ScrollMenuActivity;
import com.example.melanie.appaens.adapter.RecyclerViewAdapter;
import com.example.melanie.appaens.model.Categorie;
import com.example.melanie.appaens.model.Informatie;
import com.example.melanie.appaens.model.Observatie;
import com.example.melanie.appaens.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static Observatie observatie;
    private static Informatie informatie;
    private static List<Categorie> categorieList;
    private static List<Informatie> informatieList;
    private static List<Question> questionList;
    private static boolean firstrun = true;

    public DataSource(){
        if (firstrun){
            setInformatieList();
            setQuestionList();
            setCategorieList();
            firstrun = false;
        }
    }

    public int[] getAnswers(){
        int[] answerList = {
                0,1,2,3,4,5,6,7
        };
        return answerList;
    }

    public int[] getDrawablesCategorie(){
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

    public int[] getDrawablesInformatie(){
        int[] drawableList = {
                R.drawable.negatiefoverspannen,
                R.drawable.negatieflichtgespannen,
                R.drawable.negatiefgespannen,
                R.drawable.neutraal,
                R.drawable.positieflichtgespannen,
                R.drawable.positiefgespannen,
                R.drawable.positiefoverspannen
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
        categorieList.add(new Categorie(0, "Acties", 0, getQuestionListCategorie(0).size(), 0));
        categorieList.add(new Categorie(1, "Armen", 1, getQuestionListCategorie(1).size(), 0));
        categorieList.add(new Categorie(2, "Bovenlichaam", 2, getQuestionListCategorie(2).size(), 0));
        categorieList.add(new Categorie(3, "Gehele lichaam", 3, getQuestionListCategorie(3).size(), 0));
        categorieList.add(new Categorie(4, "Geluid", 4, getQuestionListCategorie(4).size(), 0));
        categorieList.add(new Categorie(5, "Handen", 5, getQuestionListCategorie(5).size(), 0));
        categorieList.add(new Categorie(6, "Hoofd", 6, getQuestionListCategorie(6).size(), 0));
        categorieList.add(new Categorie(7, "Houding", 7, getQuestionListCategorie(7).size(), 0));
        categorieList.add(new Categorie(8, "Mond", 8, getQuestionListCategorie(8).size(), 0));
        categorieList.add(new Categorie(9, "Neus", 9, getQuestionListCategorie(9).size(), 0));
        categorieList.add(new Categorie(10, "Voeten", 10, getQuestionListCategorie(10).size(), 0));
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
        //initialize questionList
        questionList = new ArrayList<Question>();

        questionList.add(new Question(0, "Categorie 0"));

        questionList.add(new Question(1, "Zwaait?"));
        questionList.add(new Question(1, "Legt arm(en) om andere persoon?"));
        questionList.add(new Question(1, "Beweegt arm(en) van de ander?"));

        questionList.add(new Question(2, "Categorie 2"));
        questionList.add(new Question(3, "Categorie 3"));
        questionList.add(new Question(4, "Categorie 4"));
        questionList.add(new Question(5, "Categorie 5"));
        questionList.add(new Question(6, "Categorie 6"));
        questionList.add(new Question(7, "Categorie 7"));
        questionList.add(new Question(8, "Categorie 8"));
        questionList.add(new Question(9, "Categorie 9"));
        questionList.add(new Question(10, "Categorie 10"));
    }

    public void setQuestion(Question question){
        for (Question q : questionList) {
            if (q.getId() == question.getId()){
                q = question;
                //set categorie + 1 answered question
                categorieList.get(question.getCategorieId()).setBeantwoordeVragen(categorieList.get(question.getCategorieId()).getBeantwoordeVragen() + 1);
            }
        }
    }

    public List<Categorie> getCategories(){
        return categorieList;
    }
    public List<Informatie> getInformatieList(){
        return informatieList;
    }
    public List<Question> getQuestionList(){
        return questionList;
    }

    public List<Question> getQuestionListCategorie(int categorie){
        List<Question> list = new ArrayList<Question>();
        for (Question q : questionList) {
            if (q.getCategorieId() == categorie){
                list.add(q);
            }
        }
        return list;
    }
}

