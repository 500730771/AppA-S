package com.example.melanie.appaens.data;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.model.Categorie;
import com.example.melanie.appaens.model.Informatie;
import com.example.melanie.appaens.model.Observatie;
import com.example.melanie.appaens.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static Observatie observatie;
    private static List<Categorie> categorieList;
    private static List<Informatie> informatieList;
    private static List<Question> questionList;

    private static int[] drawablesCategorieList;

    private static boolean video;

    public DataSource(){

    }

    public void setData(boolean video){
        this.video = video;
        setInformatieList();
        setQuestionList();
        setCategorieList();
        setDrawablesCategorieList();
        if (video){
            addExtraCategorie();
        }
    }

    public void clearData(){
        if (categorieList != null)
            categorieList.clear();
        if (questionList != null)
            questionList.clear();
        drawablesCategorieList = new int[]{};
    }

    public void setObservatie(Observatie observatie){
        this.observatie = observatie;
    }

    public Observatie getObservatie(){return observatie;}

    public int[] getAnswers(){
        int[] answerList = {
                0,1,2,3,4,5,6,7
        };
        return answerList;
    }

    public int[] getDrawablesCategorie(){
        return drawablesCategorieList;
    }

    private void setDrawablesCategorieList(){
        if (video){
            int[] drawableList = {
                    R.drawable.acties,
                    R.drawable.geluid,
                    R.drawable.houding,
                    R.drawable.gehelelichaam,
                    R.drawable.bovenlichaam,
                    R.drawable.armen,
                    R.drawable.handen,
                    R.drawable.onderlichaam,
                    R.drawable.voeten,
                    R.drawable.hoofd,
                    R.drawable.ogen,
                    R.drawable.neus,
                    R.drawable.mond,
                    R.drawable.andergedrag,
                    R.drawable.klaar
            };drawablesCategorieList = drawableList;
        }else{
            int[] drawableList = {
                    R.drawable.acties,
                    R.drawable.geluid,
                    R.drawable.houding,
                    R.drawable.gehelelichaam,
                    R.drawable.bovenlichaam,
                    R.drawable.armen,
                    R.drawable.handen,
                    R.drawable.onderlichaam,
                    R.drawable.voeten,
                    R.drawable.hoofd,
                    R.drawable.ogen,
                    R.drawable.neus,
                    R.drawable.mond,
                    R.drawable.klaar
            };drawablesCategorieList = drawableList;
        }
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

    public int[] getAdviesImages(){
        int[] advieslist = {
                R.drawable.adviesno,
                R.drawable.adviesng,
                R.drawable.adviesnlg,
                R.drawable.adviesn,
                R.drawable.adviesplg,
                R.drawable.adviespg,
                R.drawable.adviespo
        };
        return advieslist;
    }

    private void setCategorieList() {
        //initialize categorielist
        categorieList = new ArrayList<Categorie>();
        categorieList.add(new Categorie(3, "Acties", 0, getQuestionListCategorie(3).size(), 0));
        categorieList.add(new Categorie(4, "Geluid", 1, getQuestionListCategorie(4).size(), 0));
        categorieList.add(new Categorie(1, "Houding", 2, getQuestionListCategorie(1).size(), 0));
        categorieList.add(new Categorie(0, "Gehele lichaam", 3, getQuestionListCategorie(0).size(), 0));
        categorieList.add(new Categorie(5, "Bovenlichaam", 4, getQuestionListCategorie(5).size(), 0));
        categorieList.add(new Categorie(11, "Armen", 5, getQuestionListCategorie(11).size(), 0));
        categorieList.add(new Categorie(2, "Handen", 6, getQuestionListCategorie(2).size(), 0));
        categorieList.add(new Categorie(6, "Onderlichaam", 7, getQuestionListCategorie(6).size(), 0));
        categorieList.add(new Categorie(7, "Voeten", 8, getQuestionListCategorie(7).size(), 0));
        categorieList.add(new Categorie(8, "Hoofd", 9, getQuestionListCategorie(8).size(), 0));
        categorieList.add(new Categorie(9, "Ogen", 10, getQuestionListCategorie(9).size(), 0));
        categorieList.add(new Categorie(12, "Neus", 11, getQuestionListCategorie(12).size(), 0));
        categorieList.add(new Categorie(10, "Mond", 12, getQuestionListCategorie(10).size(), 0));

        if (video) {
            categorieList.add(new Categorie(13, "Ander gedrag O/B", 13, 3, 0));
            categorieList.add(new Categorie(14, "Klaar", 14, 0, 0));
        } else{
            categorieList.add(new Categorie(13, "Klaar", 13, 0, 0));
        }
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

// Gehele lichaam
        questionList.add(new Question(0, "Draait met het lichaam"));
        questionList.add(new Question(0, "Beweegt / rolt hele lichaam mee met ander"));
        questionList.add(new Question(0, "Zoekt de ander"));
        questionList.add(new Question(0, "Plaatst de ander dichter bij zichzelf"));
        questionList.add(new Question(0, "Plaatst zichzelf dichterbij de ander"));
        questionList.add(new Question(0, "Maakt zich los van de ander"));
        questionList.add(new Question(0, "Ontwijkt de ander"));
        questionList.add(new Question(0, "Loopt / Loopt op tenen"));
        questionList.add(new Question(0, "Springt (op en neer)"));
        questionList.add(new Question(0, "Strekt het lichaam uit"));
        questionList.add(new Question(0, "Danst, beweegt ritmisch"));
        questionList.add(new Question(0, "Laat zich vallen"));
        questionList.add(new Question(0, "Schrikt, maakt een geschrokken indruk"));

// Houding
        questionList.add(new Question(1, "Ligt op de buik / zij / rug"));
        questionList.add(new Question(1, "Ligt tegen andere persoon aan"));
        questionList.add(new Question(1, "Zit op zitvlak"));
        questionList.add(new Question(1, "Zit op schoot van de ander"));
        questionList.add(new Question(1, "Zit opgetrokken knieën / kleermakershouding"));
        questionList.add(new Question(1, "zit gehurkt / op knieën"));
        questionList.add(new Question(1, "Staat"));
// Handen
        questionList.add(new Question(2, "Speelt met handen"));
        questionList.add(new Question(2, "Klappen"));
        questionList.add(new Question(2, "Legt hand(en) over / bij oren"));
        questionList.add(new Question(2, "Stopt / handen in / voor mond"));
        questionList.add(new Question(2, "Wrijft ogen / krabt"));
        questionList.add(new Question(2, "Hand(en) op bovenlichaam / neus"));
        questionList.add(new Question(2, "Handen voor / bij ogen / hoofd ander"));
        questionList.add(new Question(2, "Houdt hand(en) op boven/onderl. ander"));
        questionList.add(new Question(2, "Legt hand(en) om middel van ander"));
        questionList.add(new Question(2, "Voelt / controleert tanden van ander"));
        questionList.add(new Question(2, "Aait / voelt / friemelt aan ander / zelf"));
        questionList.add(new Question(2, "Aait / wrijft ander met druk"));
        questionList.add(new Question(2, "Zacht kriebelen van ander"));
        questionList.add(new Question(2, "Pakt de handen van de ander"));
        questionList.add(new Question(2, "Biedt handen aan de ander aan"));
        questionList.add(new Question(2, "Trekt handen terugTikt / klopt op ander / voorwerp"));
        questionList.add(new Question(2, "Duwt de ander / voorwerp"));
        questionList.add(new Question(2, "Slaat zichzelf / voorwerp / ander"));
        questionList.add(new Question(2, "Kleedt zichzelf aan/uit"));
        questionList.add(new Question(2, "Bij ander kleding aan / uit doen"));

// Acties
        questionList.add(new Question(3, "Spelen / rollenspel"));
        questionList.add(new Question(3, "Ondersteunt bij spel"));
        questionList.add(new Question(3, "Speelt met voorwerp"));
        questionList.add(new Question(3, "Gooit voorwerp"));
        questionList.add(new Question(3, "Weigert voorwerp"));
        questionList.add(new Question(3, "Pakt voorwerp af"));
        questionList.add(new Question(3, "Zet muziek aan / luistert muziek"));
        questionList.add(new Question(3, "Zet ander persoon rechtop"));
        questionList.add(new Question(3, "Verricht medische handeling"));

// Geluid
        questionList.add(new Question(4, "Praten"));
        questionList.add(new Question(4, "Fluisteren"));
        questionList.add(new Question(4, "Neuriën / zingen"));
        questionList.add(new Question(4, "Fluiten"));
        questionList.add(new Question(4, "Lachen"));
        questionList.add(new Question(4, "Hoesten / boeren"));
        questionList.add(new Question(4, "Tandenknarsen"));
        questionList.add(new Question(4, "Zuchten"));
        questionList.add(new Question(4, "Gapen / geeuwen"));
        questionList.add(new Question(4, "Hijgen / zware duidelijke ademhaling"));
        questionList.add(new Question(4, "Mopperen"));
        questionList.add(new Question(4, "Huilen / snikken"));
        questionList.add(new Question(4, "Kreet slaken"));
        questionList.add(new Question(4, "Brommen / grommen"));
        questionList.add(new Question(4, "Schreeuwen / vloeken"));

// Bovenlichaam
        questionList.add(new Question(5, "Leunt achterover"));
        questionList.add(new Question(5, "Omhelst/knuffelt de ander"));
        questionList.add(new Question(5, "Schommelt (voor-achter)"));
        questionList.add(new Question(5, "Leunt voorover"));
        questionList.add(new Question(5, "Wiegt (links-rechts)"));
        questionList.add(new Question(5, "Categorie 5"));

// Onderlichaam
        questionList.add(new Question(6, "Strekt benen"));
        questionList.add(new Question(6, "Legt benen op die van ander"));
        questionList.add(new Question(6, "Speelt met voorwerp met benen / voeten"));
        questionList.add(new Question(6, "Schopt met benen / voeten"));

// Voeten
        questionList.add(new Question(7, "Doet voeten omhoog"));
        questionList.add(new Question(7, "Speelt met voeten"));
        questionList.add(new Question(7, "Wipt op voeten"));
        questionList.add(new Question(7, "Stampt met voeten"));

// Hoofd
        questionList.add(new Question(8, "Heft het hoofd"));
        questionList.add(new Question(8, "Buigt hoofd"));
        questionList.add(new Question(8, "Draait hoofd weg"));
        questionList.add(new Question(8, "Knikt hoofd"));
        questionList.add(new Question(8, "Schudt hoofd"));
        questionList.add(new Question(8, "Laat hoofd hangen / rusten in hand(en)"));
        questionList.add(new Question(8, "Biedt hoofd / wang aan de ander aan"));
        questionList.add(new Question(8, "Bonkt hoofd tegen muur / voorwerp"));

// Ogen
        questionList.add(new Question(9, "Kijkt ander aan / in richting van de ander"));
        questionList.add(new Question(9, "Houdt ogen gesloten"));
        questionList.add(new Question(9, "Is aan het staren"));

// Mond
        questionList.add(new Question(10, "Glimlachen"));
        questionList.add(new Question(10, "Kus(jes) geven"));
        questionList.add(new Question(10, "Blaast naar de ander / voorwerp / richting"));
        questionList.add(new Question(10, "Steekt tong uit"));
        questionList.add(new Question(10, "Likt voorwerp / ander / zichzelf"));
        questionList.add(new Question(10, "Stopt voorwerp in / tegen mond"));
        questionList.add(new Question(10, "Zuigt op vinger(s) / hand"));
        questionList.add(new Question(10, "Bijt in voorwerp"));
        questionList.add(new Question(10, "Glimlachen"));
        questionList.add(new Question(10, "Bijt in ander / zichzelf"));
        questionList.add(new Question(10, "Doet mond open / laat tanden zijn"));

// Armen
        questionList.add(new Question(11, "Legt arm(en) om de andere persoon"));
        questionList.add(new Question(11, "Beweegt arm(en) van de ander"));

// Neus
        questionList.add(new Question(12, "Ruikt aan voorwerp / ander / richting"));
    }
// Ander gedrag O/B
    public void addExtraCategorie(){
        questionList.add(new Question(13, "Bijten"));
        questionList.add(new Question(13, "Hard kietelen"));
        questionList.add(new Question(13, "Knijpen"));
    }

    public void setQuestion(Question question){
        for (Question q : questionList) {
            if (q.getId() == question.getId()){
                q = question;
                //set categorie + 1 answered question
//                categorieList.get(question.getCategorieId()).setBeantwoordeVragen(categorieList.get(question.getCategorieId()).getBeantwoordeVragen() + 1);
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

    public int getScoreButton(int kleurid){
        int aantal = 0;
        for (Question q : questionList){
            if (q.getAnswerClient() == kleurid){
                aantal++;
            }
        }
        return aantal;
    }
}

