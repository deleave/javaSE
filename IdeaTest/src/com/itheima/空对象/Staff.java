package com.itheima.空对象;

import java.util.ArrayList;

class Person{
    public final String first;
    public final String last;
    public final String address;
    public Person(String first,String last,String address){
        this.first=first;
        this.last=last;
        this.address=address;
    }
    public String toString(){
        return "Person: "+first+" "+last+" "+address;
    }
    public static class NullPerson extends Person implements Null{
        private NullPerson(){
            super("None","None","None");
        }
    }
    public  static final Person NULL=new NullPerson();//空对象实例
}
class Position{
    private String title;
    private Person person;
    public Position(String jobTitle,Person employee){
        title=jobTitle;
        person=employee;
        //若为空 则引用为空对象
        if (person==null){
            person=Person.NULL;
        }
    }
    public Position(String jobTitle){
        title=jobTitle;
        person=Person.NULL;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String newTitle){
        title=newTitle;
    }
    public Person getPerson(){return person;}
    public void setPerson(Person newPerson){
        person=newPerson;
        if(person==null)
            person=Person.NULL;
    }
    public String toString(){
        return "Position: "+title+" "+person;
    }
}
//u
public class Staff extends ArrayList<Position> {
    public void add(String title,Person person){
        add(new Position(title,person));
    }
    public void add(String...titles){
        for (String title:titles
             ) {
            add(new Position(title));
        }
    }
    public Staff(String...titles){add(titles);}
    public boolean positionAvailable(String title){
        for (Position position: this
             ) {
            if (position.getTitle().equals(title)&&position.getPerson()==Person.NULL)
                return true;
        }
        return false;
    }
    public void fillPosition(String title,Person hire){
        for (Position position: this
             ) {
            if (position.getTitle().equals(title)&&position.getPerson()==Person.NULL) {
                position.setPerson(hire);
                return;
            }
        }throw new RuntimeException("Position "+title+" not available");
    }

    public static void main(String[] args) {
        Staff staff=new Staff("President","CTO","Product Manger","Software Engineer");
        staff.fillPosition("President",new Person("Me","Last","The top,Lonely At"));
        staff.fillPosition("CTO",new Person("Janet","Planner","The Burbs"));
        staff.fillPosition("Software Engineer",new Person("Marry","Lebron","Bright Light City"));
        System.out.println(staff);
    }

}
