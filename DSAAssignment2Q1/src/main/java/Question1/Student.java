package Question1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shawn
 * @param <E>
 */
public class Student<E extends Comparable> implements Comparable<Student> {

    private String name;
    private int mark;
    private E key;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public int compareTo(Student student) {
        if (student.getKey() == this.key) {
            return 0;
        }
        if (student.key instanceof Integer) {
            return (Integer) student.getKey() - (Integer) this.key;
        }
        if (student.key instanceof String) {
            return student.key.compareTo(this.key);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student name: " + this.name + " Mark: " + this.mark + "\n\n";
    }
}
