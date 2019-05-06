package com.example.godetremy.remy_godet_app_quizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.godetremy.remy_godet_app_quizz.Controleur.Controle;
import com.example.godetremy.remy_godet_app_quizz.Modele.Question;

import java.util.List;

public class AfficheQuestionQuizz extends AppCompatActivity implements View.OnClickListener
{

    private TextView txtLibelleQuestion;
    private TextView txtScore;
    private RadioGroup txtRadioGroup;
    private RadioButton txtChoix1;
    private RadioButton txtChoix2;
    private RadioButton txtChoix3;
    private RadioButton txtChoix4;
    private Button valideQuestion;
    private int score = 0;
    int position = 0;
    List<Question> questionList;

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

        txtChoix1.setText(questionList.get(position).getChoix1());
        txtChoix2.setText(questionList.get(position).getChoix2());
        txtChoix3.setText(questionList.get(position).getChoix3());
        txtChoix4.setText(questionList.get(position).getChoix4());
        txtLibelleQuestion.setText (questionList.get(position).getQuestion());


    }
    private void init() {

        txtLibelleQuestion = (TextView) findViewById(R.id.txtLibelleQuestion);
        txtRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtChoix1 = (RadioButton) findViewById(R.id.choix1);
        txtChoix2 = (RadioButton) findViewById(R.id.choix2);
        txtChoix3 = (RadioButton) findViewById(R.id.choix3);
        txtChoix4 = (RadioButton) findViewById(R.id.choix4);
        valideQuestion = (Button) findViewById(R.id.valideQuestion);
        valideQuestion.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        int id = txtRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(id);
        if (radioButton.getText().toString().equalsIgnoreCase(questionList.get(position).getReponse())){
            score++;
        }

        if (!(position == questionList.size() - 1)){
            position++;
        }

        txtChoix1.setText(questionList.get(position).getChoix1());
        txtChoix2.setText(questionList.get(position).getChoix2());
        txtChoix3.setText(questionList.get(position).getChoix3());
        txtChoix4.setText(questionList.get(position).getChoix4());
        //txtScore.setText(questionList.get(position).get);
        txtLibelleQuestion.setText (questionList.get(position).getQuestion());
    }
}
