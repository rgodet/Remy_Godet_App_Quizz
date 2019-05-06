package com.example.godetremy.remy_godet_app_quizz.AccesClass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {


    //Création des deux tables

    private String creationTableQuizz = "create table quizz ("
            + "numeroQuizz INTEGER PRIMARY KEY,"
            + "titreQuizz TEXT NOT NULL);";

    private String creationTableQuestion = "create table questionQuizz ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "question TEXT NOT NULL,"
            + "reponse TEXT NOT NULL,"
            + "choix1 TEXT NOT NULL,"
            + "choix2 TEXT NOT NULL,"
            + "choix3 TEXT NOT NULL,"
            + "choix4 TEXT NOT NULL,"
            + "idQuestionnaire INTEGER,"
            + "FOREIGN KEY(idQuestionnaire)"
            + "REFERENCES quizz(id));";

    //Drop des deux tables

    private String dropTableQuizz = "DROP TABLE IF EXISTS quizz;";
    private String dropTableQuestion = "DROP TABLE IF EXISTS questionQuizz;";

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);


    }

    // Éxécution des requêtes ci-dessus
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(creationTableQuizz);
        db.execSQL(creationTableQuestion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(dropTableQuizz);
        db.execSQL(dropTableQuestion);

        onCreate(db);

    }
}
