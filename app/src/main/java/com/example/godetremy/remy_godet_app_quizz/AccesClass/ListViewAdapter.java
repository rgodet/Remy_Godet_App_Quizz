package com.example.godetremy.remy_godet_app_quizz.AccesClass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.godetremy.remy_godet_app_quizz.AfficheClass.AfficheQuestionQuizz;
import com.example.godetremy.remy_godet_app_quizz.Modele.Quizz;
import com.example.godetremy.remy_godet_app_quizz.R;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Quizz> implements View.OnClickListener {


    /**
     * @param ress
     */

    //propriété ListView listQuizzView;
    private int ress;

    public ListViewAdapter(Context context, int resource, List<Quizz> objects) {

        super(context, resource, objects);
        this.ress = resource;



    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name  = getItem(position).getTitreQuizz();
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(ress,parent,false);

        Button button = convertView.findViewById(R.id.buttonQuizz);
        button.setOnClickListener(this);

        button.setText(name);

        return convertView;
    }


    public void onClick(View v) {
        Button button = v.findViewById(v.getId());
        Intent intent;
        intent = new Intent(v.getContext(), AfficheQuestionQuizz.class);
        intent.putExtra("nomQuizz", button.getText() );
        v.getContext().startActivity(intent);

    }


}