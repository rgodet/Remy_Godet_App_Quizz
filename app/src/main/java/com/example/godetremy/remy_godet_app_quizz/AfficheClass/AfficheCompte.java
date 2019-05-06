package com.example.godetremy.remy_godet_app_quizz.AfficheClass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.godetremy.remy_godet_app_quizz.AjoutClass.AjoutQuestion;
import com.example.godetremy.remy_godet_app_quizz.AjoutClass.AjoutQuizz;
import com.example.godetremy.remy_godet_app_quizz.R;


public class AfficheCompte extends AppCompatActivity {

    private TextView affichePseudo;
    private EditText recupPseudo;
    private Button btn_compte;
    private Button btn_ajoutQuizz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_compte);

        //je recup le textview dans lequel je place le pseudo
        affichePseudo = (TextView) findViewById(R.id.textView);
        //je recup le pseudo
        recupPseudo = (EditText) findViewById(R.id.pseudo);
        savedInstanceState = getIntent().getExtras();
        //je place le text du pseudo dans une variable
        String tonTexte = savedInstanceState.getString("login");
        //j'affiche la variable
        affichePseudo.setText("Bienvenue "+ tonTexte +" !");

        //Bouton permettant d'afficher l'ensemble des quizz avec la possibilité d'en supprimer
        btn_compte = (Button) findViewById(R.id.buttonAfficheCompte);
        btn_compte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AjoutQuestion.class);
                startActivity(intent);
                finish();
            }
        });


        //Bouton pour ajouter un quizz qui redirige vers la page de création de quizz
        btn_ajoutQuizz = findViewById(R.id.ajoutQuizz);
        btn_ajoutQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentQuizz = new Intent(getApplicationContext(), AjoutQuizz.class);
                startActivity(intentQuizz);
                finish();

            }
        });

    }
}
