package com.ys.demo.po;

/**
 * Created by yangshe on 2016/9/8.
 */
public class PerSon {
    private int id;
    private String name;
    private String addre;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddre() {
        return addre;
    }

    public void setAddre(String addre) {
        this.addre = addre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PerSon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addre='" + addre + '\'' +
                ", age=" + age +
                '}';
    }
}
