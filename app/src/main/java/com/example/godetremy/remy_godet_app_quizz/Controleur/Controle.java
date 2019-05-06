package com.example.godetremy.remy_godet_app_quizz.Controleur;

import android.content.Context;
import android.util.Log;

import com.example.godetremy.remy_godet_app_quizz.AccesClass.AccesLocal;
import com.example.godetremy.remy_godet_app_quizz.Modele.Quizz;
import com.example.godetremy.remy_godet_app_quizz.Modele.Question;

public final class Controle {

    private static Controle instance = null;
    private static String nomQuizz = "savequizz";
    private static AccesLocal accesLocal;

    private Controle(){ super(); }

    public static final Controle getInstance(Context context){
        if (Controle.instance == null) {
            accesLocal = new AccesLocal(context);
            Controle.instance = new Controle();
            //accesLocal = new AccesLocal(contexte);
            //quizz = accesLocal.recupDernier();

        }
        return Controle.instance;
    }

    public void creerQuizz(Integer numeroQuizz, String titreQuizz){
        Quizz quizz = new Quizz(numeroQuizz, titreQuizz);
        Log.i("AFFICHAGE QUIZZ ", quizz.toString());
        accesLocal.ajout(quizz);
    }

    public void creerQuestionQuizz(Integer numeroQuizz, String question, String reponse, String choix1, String choix2, String choix3, String choix4){
        Question question1= new Question(numeroQuizz, question, reponse, choix1, choix2, choix3, choix4);
        Log.i("AFFICHAGE QUESTIONQUIZZ", question1.toString());
        accesLocal.ajoutQuestion(question1);
    }
}
