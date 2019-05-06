package com.example.godetremy.remy_godet_app_quizz.Modele;

import android.widget.ListView;

import java.util.ArrayList;


public class Quizz{

    //propriété

    private Integer numeroQuizz;
    private String titreQuizz;
    //private String question;
    //private String reponseUn;
    //private String reponseDeux;
   // private String reponseTrois;
    //private String reponseQuatre;

    public Quizz(Integer numeroQuizz, String titreQuizz){
        this.numeroQuizz = numeroQuizz;
        this.titreQuizz = titreQuizz;
        //this.question = question;
        //this.reponseUn = reponseUn;
        //this.reponseDeux = reponseDeux;
        //this.reponseTrois = reponseTrois;
        //this.reponseQuatre = reponseQuatre;
    }

    public Integer getNumeroQuizz() {
        return numeroQuizz;
    }

    public String getTitreQuizz(){return titreQuizz;}

    //public String getQuestion() {
      //  return question;
   // }


   // public String getReponseUn() {
        //return reponseUn;
    //}

    //public String getReponseDeux() {
        //return reponseDeux;
   // }

   // public String getReponseTrois() {
        //return reponseTrois;
    //}

    //public String getReponseQuatre() {
        //return reponseQuatre;
    //}


    @Override
    public String toString() {
        return "Quizz{" +
                "numeroQuizz=" + numeroQuizz +
                ", titreQuizz='" + titreQuizz + '\'' +
                '}';
    }
}
