package com.example.godetremy.remy_godet_app_quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.godetremy.remy_godet_app_quizz.Modele.Quizz;

import java.util.List;


public class QuizzActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        AccesLocal accesLocal = new AccesLocal(this);
        listView = findViewById(R.id.listQuizz);

        List<Quizz> list = accesLocal.recupAllQuizz();

        ListViewAdapter  adapter = new ListViewAdapter(this,R.layout.button_quizz,list);
        listView.setAdapter(adapter);


    }
}
