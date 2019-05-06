package com.example.godetremy.remy_godet_app_quizz;

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

public class AjoutQuizz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_quizz);
        init();
        this.controle = Controle.getInstance(getApplicationContext());
    }

    //propriété
    private EditText txtNumeroQuizz;
    private EditText txtTitreQuizz;
    private Controle controle;



    //Initialisation des liens avec les objets graphique
    private void init() {
        txtNumeroQuizz = (EditText) findViewById(R.id.txtNumeroQuizz);
        txtTitreQuizz = (EditText) findViewById(R.id.txtTitre);
        ecouteQuizz();
    }


    //Ecoute événement sur bouton création de quizz
    private void ecouteQuizz() {

        ((Button) findViewById(R.id.valideQuizz)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(), "prout", Toast.LENGTH_SHORT).show();
                Integer numeroQuizz = 0;
                String titre = "";

                //Récupération des données saisie

                try{
                    numeroQuizz = Integer.parseInt(txtNumeroQuizz.getText().toString());
                    titre = txtTitreQuizz.getText().toString();

                    Log.i("affichage","" + numeroQuizz + " § " +titre);
                    //question = txtQuestion.getText().toString();"
                    //reponseUn = txtReponseUn.getText().toString();
                    //reponseDeux = txtReponseDeux.getText().toString();
                    //reponseTrois = txtReponseTrois.getText().toString();
                    //reponseQuatre = txtReponseQuatre.getText().toString();

                }catch(Exception e){}
                //Test des saisie
                if (numeroQuizz == 0 || titre.isEmpty()){
                    Toast.makeText(getApplicationContext(), "La saisie est invalide, Veuillez remplir des valeurs correctes", Toast.LENGTH_SHORT).show();
                }else{
                    afficheResult(numeroQuizz, titre);


                }
            }
        });
    }

    //Affihage de la question et de la reponse
    private void afficheResult(Integer numeroQuizz, String titreQuizz){
        //creation du quizz et récupération des informations
        this.controle.creerQuizz(numeroQuizz, titreQuizz);

        //affichage
        Intent intent;
        intent = new Intent(this,QuizzActivity.class);
        startActivity(intent);


    }
}
