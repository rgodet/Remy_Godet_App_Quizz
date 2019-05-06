package com.example.godetremy.remy_godet_app_quizz.Modele;

public class Question {

    private Integer numeroQuizz;
    private String question;
    private String reponse;
    private String choix1;
    private String choix2;
    private String choix3;
    private String choix4;

    public Question(Integer numeroQuizz, String question, String reponse, String choix1, String choix2, String choix3, String choix4) {
        this.numeroQuizz = numeroQuizz;
        this.question = question;
        this.reponse = reponse;
        this.choix1 = choix1;
        this.choix2 = choix2;
        this.choix3 = choix3;
        this.choix4 = choix4;
    }

    public Integer getNumeroQuizz() {
        return numeroQuizz;
    }

    public void setNumeroQuizz(Integer numeroQuizz) {
        this.numeroQuizz = numeroQuizz;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getChoix1() {
        return choix1;
    }

    public void setChoix1(String choix1) {
        this.choix1 = choix1;
    }

    public String getChoix2() {
        return choix2;
    }

    public void setChoix2(String choix2) {
        this.choix2 = choix2;
    }

    public String getChoix3() {
        return choix3;
    }

    public void setChoix3(String choix3) {
        this.choix3 = choix3;
    }

    public String getChoix4() {
        return choix4;
    }

    public void setChoix4(String choix4) {
        this.choix4 = choix4;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", reponse='" + reponse + '\'' +
                ", choix1='" + choix1 + '\'' +
                ", choix2='" + choix2 + '\'' +
                ", choix3='" + choix3 + '\'' +
                ", choix4='" + choix4 + '\'' +
                '}';
    }
}
