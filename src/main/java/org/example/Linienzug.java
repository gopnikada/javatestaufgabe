package org.example;

import java.util.ArrayList;

public class Linienzug {
    private ArrayList<Linie> linien = new ArrayList<>();

    public Linienzug(ArrayList<Linie> linien) {
        this.linien = linien;
    }
    public Linienzug(Linie linie) {
        this.linien.add(linie);
    }
    public Linienzug() {}

    public ArrayList<Linie> getLinien() {
        return linien;
    }

    public void setLinien(ArrayList<Linie> linien) {
        this.linien = linien;
    }
    public void addLine(Linie linie){
        this.linien.add(linie);
    }
}
