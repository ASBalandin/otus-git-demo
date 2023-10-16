package ru.otus.balandinas.first.project;

public class Box {

    //fields
    private int length;
    private int width;
    private int height;
    private String color;
    private String objInside;
    private boolean isOpen;

    //setters
    public void repaint(String color) {
        this.color = color;
        System.out.println("цвет : " + color);
    }

    public void setOpen() {
        this.isOpen = true;
        System.out.println( "Открыта" );
    }

    public Box(int length, int width, int height, String color ){
      this.length = length;
      this.width = width;
      this.height = height;
      this.color = color;
      this.objInside = "";
      this.boxInfo();
    }

    //methods
    public void toBox(String txt) {
        if (objInside.length() == 0 && isOpen) {
            this.objInside = txt;
            System.out.println("положили " + txt);
        } else if(!isOpen){
            System.out.println("Не получится! Закрыта");
        } else {
            System.out.println("Не получится! Объект" + objInside + "внутри");
        }
    }
    //methods
    public void fromBox() {
        if (objInside.length() != 0 && isOpen) {
            this.objInside = "";
            System.out.println("Теперь пусто");
        } else {
            System.out.println("Не получится! Пусто внутри");
        }
    }

    public void boxInfo() {
        System.out.println(String.format("ДхШхВ : %d %d %d",length, width, height));
        System.out.println("цвет : " + color);
        if(objInside.length() != 0  ){
            System.out.println("внутри" + objInside);
        } else {
            System.out.println("внутри пусто");
        }


    }


}
