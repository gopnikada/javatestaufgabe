package org.example;

import java.util.Objects;

public class Linie {
    private Point startPoint;
    private Point endPoint;

    public Linie(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linie linie = (Linie) o;
        return startPoint.equals(linie.startPoint) && endPoint.equals(linie.endPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        return "Linie{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}
