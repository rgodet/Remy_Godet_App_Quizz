package com.example.godetremy.remy_godet_app_quizz.AfficheClass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.godetremy.remy_godet_app_quizz.AccesClass.AccesLocal;
import com.example.godetremy.remy_godet_app_quizz.Modele.Question;
import com.example.godetremy.remy_godet_app_quizz.R;

import java.util.List;

import static java.security.AccessController.getContext;

public class AfficheQuestionQuizz extends AppCompatActivity implements View.OnClickListener
{


    /**
     *
     * @param txtLibelleQuestion
     * @param txtScore
     * @param txtNbQuestion
     * @param txtRadioGroup
     * @param txtChoix1
     * @param txtChoix2
     * @param txtChoix3
     * @param txtChoix4
     * @param valideQuestion
     * @param score
     * @param position
     * @param questionList
     *
     */

    //Propriété
    private TextView txtLibelleQuestion;
    private TextView txtScore;
    private TextView txtNbQuestion;
    private RadioGroup txtRadioGroup;
    private RadioButton txtChoix1;
    private RadioButton txtChoix2;
    private RadioButton txtChoix3;
    private RadioButton txtChoix4;
    private Button valideQuestion;
    private int score = 0;
    int position = 0;
    List<Question> questionList;


    // La Méthode OnCreate va permettre que lorsque l'on démarre l'activité on lance les requetes suivantes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_question_quizz);

        AccesLocal accesLocal = new AccesLocal(this);
        String key = getIntent().getExtras().getString("nomQuizz");
        int idquizz = accesLocal.recupQuizzId(key);
        Log.i("resukt",""+idquizz);
        questionList =accesLocal.getQuestionQuizz(idquizz);
        init();

        updateUI();

        txtChoix1.setText(questionList.get(position).getChoix1());
        txtChoix2.setText(questionList.get(position).getChoix2());
        txtChoix3.setText(questionList.get(position).getChoix3());
        txtChoix4.setText(questionList.get(position).getChoix4());
        txtLibelleQuestion.setText (questionList.get(position).getQuestion());


    }

    private void updateUI() {
        txtLibelleQuestion.setText(questionList.get(position).getQuestion());
        txtChoix1.setText(questionList.get(position).getChoix1());
        txtChoix2.setText(questionList.get(position).getChoix2());
        txtChoix3.setText(questionList.get(position).getChoix3());
        txtChoix4.setText(questionList.get(position).getChoix4());
        txtNbQuestion.setText((position + 1)+ "/" + questionList.size());
        txtScore.setText("Score : "+ score);
    }

    //Récupération des radio Button ect...
    private void init() {

        txtLibelleQuestion = (TextView) findViewById(R.id.txtLibelleQuestion);
        txtRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        txtNbQuestion = (TextView) findViewById(R.id.txtNbQuestion);
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtChoix1 = (RadioButton) findViewById(R.id.choix1);
        txtChoix2 = (RadioButton) findViewById(R.id.choix2);
        txtChoix3 = (RadioButton) findViewById(R.id.choix3);
        txtChoix4 = (RadioButton) findViewById(R.id.choix4);
        valideQuestion = (Button) findViewById(R.id.valideQuestion);
        valideQuestion.setOnClickListener(this);


    }


    //Evenement on click du bouton valider des questions

    @Override
    public void onClick(View v) {



        if (position < questionList.size()){

            int id = txtRadioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(id);
            if (radioButton.getText().toString().equalsIgnoreCase(questionList.get(position).getReponse())){

                score++;
                txtScore.setText(" "+ score);
            }

            position++;

           if (position == questionList.size()){
               Toast.makeText(v.getContext(), "LE QUIZ EST TERMINÉ. Votre score est de : "+ score, Toast.LENGTH_LONG).show();
               return;
           }

           updateUI();

                   // v.getContext(), "Size :" + questionList.size(), Toast.LENGTH_SHORT).show();
        }


    }
}
