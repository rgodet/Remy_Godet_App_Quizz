package com.example.godetremy.remy_godet_app_quizz.AjoutClass;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.godetremy.remy_godet_app_quizz.Controleur.Controle;
import com.example.godetremy.remy_godet_app_quizz.Modele.Quizz;
import com.example.godetremy.remy_godet_app_quizz.QuizzActivity;
import com.example.godetremy.remy_godet_app_quizz.R;

public class AjoutQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_question);
        init();
        this.controle = Controle.getInstance(getApplicationContext());
    }

    /**
     *
     * @param txtNumeroQuizz
     * @param txtLibelleQuestion
     * @param txtReponse
     * @param txtChoix1
     * @param txtChoix2
     * @param txtChoix3
     * @param txtChoix4
     * @param controle
     *
     */

    //propriété
    private EditText txtNumeroQuizz;
    private EditText txtLibelleQuestion;
    private EditText txtReponse;
    private EditText txtChoix1;
    private EditText txtChoix2;
    private EditText txtChoix3;
    private EditText txtChoix4;
    private Controle controle;



    //Initialisation des liens avec les objets graphique
    private void init() {
        txtNumeroQuizz = (EditText) findViewById(R.id.txtNumeroQuizz);
        txtLibelleQuestion = (EditText) findViewById(R.id.txtLibelleQuestion);
        txtReponse = (EditText) findViewById(R.id.txtReponse);
        txtChoix1 = (EditText) findViewById(R.id.txtChoix1);
        txtChoix2 = (EditText) findViewById(R.id.txtChoix2);
        txtChoix3 = (EditText) findViewById(R.id.txtChoix3);
        txtChoix4 = (EditText) findViewById(R.id.txtChoix4);
        ecouteQuestionQuizz();
    }


    //Ecoute événement sur bouton création de quizz
    private void ecouteQuestionQuizz() {

        ((Button) findViewById(R.id.valideQuestionQuizz)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer numeroQuizz = 0;
                String question = "";
                String reponse = "";
                String choix1 = "";
                String choix2 = "";
                String choix3 = "";
                String choix4 = "";

                //Récupération des données saisie

                try{
                    numeroQuizz = Integer.parseInt(txtNumeroQuizz.getText().toString());
                    question = txtLibelleQuestion.getText().toString();
                    reponse = txtReponse.getText().toString();
                    choix1 = txtChoix1.getText().toString();
                    choix2 = txtChoix2.getText().toString();
                    choix3 = txtChoix3.getText().toString();
                    choix4 = txtChoix4.getText().toString();

                }catch(Exception e){}
                //Test des saisie
                if (numeroQuizz == 0 || question.isEmpty() || reponse.isEmpty() || choix1.isEmpty() || choix2.isEmpty() || choix3.isEmpty() || choix4.isEmpty()){
                    Toast.makeText(getApplicationContext(), "La saisie est invalide, Veuillez remplir des valeurs correctes", Toast.LENGTH_SHORT).show();
                }else{
                    afficheResult(numeroQuizz, question, reponse, choix1, choix2, choix3, choix4);


                }
            }
        });
    }

    //Affihage de la question et de la reponse
    private void afficheResult(Integer numeroQuizz, String question, String reponse, String choix1, String choix2, String choix3, String choix4){
        //creation du quizz et récupération des informations
        this.controle.creerQuestionQuizz(numeroQuizz, question, reponse, choix1, choix2, choix3, choix4);

        //affichage
        Intent intent;
        intent = new Intent(this,QuizzActivity.class);
        startActivity(intent);


    }
}

