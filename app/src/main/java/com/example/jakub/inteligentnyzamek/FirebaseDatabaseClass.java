package com.example.jakub.inteligentnyzamek;

public class FirebaseDatabaseClass {

    int cardsBlocked;

    int colorBlue;

    int colorRed;

    int colorGreen;

    int openByApp;

    int openByCard;

    public FirebaseDatabaseClass() {
    }

    public int getCardsBlocked() {
        return cardsBlocked;
    }

    public void setCardsBlocked(int cardsBlocked) {
        this.cardsBlocked = cardsBlocked;
    }

    int getColorBlue() {
        return colorBlue;
    }

    void setColorBlue(int colorBlue) {
        this.colorBlue = colorBlue;
    }

    int getColorRed() {
        return colorRed;
    }

    void setColorRed(int colorRed) {
        this.colorRed = colorRed;
    }

    public int getColorGreen() {
        return colorGreen;
    }

    public void setColorGreen(int colorGreen) {
        this.colorGreen = colorGreen;
    }

    public int getOpenByApp() {
        return openByApp;
    }

    public void setOpenByApp(int openByApp) {
        this.openByApp = openByApp;
    }

    int getOpenByCard() {
        return openByCard;
    }

    void setOpenByCard(int openByCard) {
        this.openByCard = openByCard;
    }

    @Override
    public String toString() {
        return "FirebaseDatabaseClass{" +
                "cardsBlocked=" + cardsBlocked + "\n" +
                ", colorBlue=" + colorBlue + "\n" +
                ", colorRed=" + colorRed + "\n" +
                ", colorGreen=" + colorGreen + "\n" +
                ", openByApp=" + openByApp + "\n" +
                ", openByCard=" + openByCard +
                '}';
    }
}
