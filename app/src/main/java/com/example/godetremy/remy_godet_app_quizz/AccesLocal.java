package com.example.godetremy.remy_godet_app_quizz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.godetremy.remy_godet_app_quizz.Modele.Question;
import com.example.godetremy.remy_godet_app_quizz.Modele.Quizz;

import java.util.ArrayList;
import java.util.List;

public class AccesLocal {

    //propriété
    private String nomBase = "bdQuizz.sqlite";
    private Integer versionBase = 3;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;



    //Contructeur
    public AccesLocal(Context contexte){

        accesBD = new MySQLiteOpenHelper(contexte, nomBase, null, versionBase);
    }

    //Ajout d'un quizz dans la BD
    public void ajout(Quizz quizz){

        bd = accesBD.getWritableDatabase();
        //String req = "insert into quizz (numeroQuizz, titreQuizz) values (quizz.getNumeroQuizz(),quizz.getTitreQuizz())";

        ContentValues cv = new ContentValues();
        cv.put("numeroQuizz", quizz.getNumeroQuizz());
        cv.put("titreQuizz", quizz.getTitreQuizz());
        bd.insert("quizz","0",cv);
    }
    public void ajoutQuestion(Question question){

        bd = accesBD.getWritableDatabase();
        //String req = "insert into quizz (numeroQuizz, titreQuizz) values (quizz.getNumeroQuizz(),quizz.getTitreQuizz())";

        ContentValues cv = new ContentValues();
        cv.put("id", 0);
        cv.put("idQuestionnaire", question.getNumeroQuizz());
        cv.put("question", question.getQuestion());
        cv.put("reponse", question.getReponse());
        cv.put("choix1", question.getChoix1());
        cv.put("choix2", question.getChoix2());
        cv.put("choix3", question.getChoix3());
        cv.put("choix4", question.getChoix4());
        bd.insert("questionQuizz","0",cv);
    }


    //Récupération du dernier quizz de la BD
    public ArrayList<Question> getQuestionQuizz(Integer idQuizz){
        bd = accesBD.getReadableDatabase();
        Cursor res =  bd.rawQuery( "SELECT questionQuizz.* from  quizz INNER JOIN questionQuizz ON quizz.numeroQuizz = questionQuizz.idQuestionnaire  where quizz.numeroQuizz= ?", new String[]{idQuizz.toString()});
        res.moveToFirst();
        ArrayList<Question> items = new ArrayList<Question>();

        while(res.isAfterLast() == false){
            items.add(
                    new Question(
                            res.getInt(0),
                            res.getString(res.getColumnIndex("question")),
                            res.getString(res.getColumnIndex("reponse")),
                            res.getString(res.getColumnIndex("choix1")),
                            res.getString(res.getColumnIndex("choix2")),
                            res.getString(res.getColumnIndex("choix3")),
                            res.getString(res.getColumnIndex("choix4"))
                            ));
            res.moveToNext();
        }
        res.close();
        bd.close();
        Log.i(this.getClass().getName(),"Fin Recuperation des données");

        return items;
    }

    public int recupQuizzId(String nomQuizz){
        bd = accesBD.getReadableDatabase();
        Cursor res =  bd.rawQuery( "SELECT numeroQuizz from quizz WHERE quizz.titreQuizz = ?", new String[]{nomQuizz.toString()});
        res.moveToFirst();
        int id = res.getInt(res.getColumnIndex("numeroQuizz"));
        res.close();
        return id;
    }

        public  List<Quizz> recupAllQuizz(){
        bd = accesBD.getReadableDatabase();
        Cursor res =  bd.rawQuery( "SELECT * from  quizz",new String[]{});
        res.moveToFirst();
        ArrayList<Quizz> items = new ArrayList<Quizz>();



        while(res.isAfterLast() == false){
            items.add(
                    new Quizz(
                            res.getInt(res.getColumnIndex("numeroQuizz")),
                            res.getString(res.getColumnIndex("titreQuizz"))

                    ));
            res.moveToNext();
        }
        res.close();
        bd.close();
        Log.i(this.getClass().getName(),"Fin Recuperation des données");

        return items;
    }

}
