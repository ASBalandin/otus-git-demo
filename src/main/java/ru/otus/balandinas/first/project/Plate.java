package ru.otus.balandinas.first.project;

public class Plate {
    private int volume;
    private int remainder;

    public Plate(int volume) {
        this.volume = volume;
        this.remainder = volume;
    }

    public void addFood(int addCount) {

        if (remainder + addCount < volume) {
            remainder += addCount;
        } else {
            System.out.println("Переполнится, объём " + volume + " заполнение " + remainder);
        }

    }









































    public boolean eat(int count) {

        if (remainder - count >= 0) {
          remainder -= count;
          return true;
      }

      return false;
    }

}
