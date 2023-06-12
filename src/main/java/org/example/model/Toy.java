package org.example.model;

public class Toy {
    private int id;
    private String name;
    double weight;

    public Toy(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public Toy(String name) {
        this(0, name, 0);
    }

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toFile() { return id + "\n" + name + "\n" + weight + "\n"; }
    @Override
    public String toString() {
        return String.format("%-4d%-20s%.2f", id, name, weight);
    }
}

