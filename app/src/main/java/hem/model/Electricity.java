package hem.model;

import javafx.beans.property.*;

public class Electricity {
    private final IntegerProperty id;
    private final StringProperty name;
    private final DoubleProperty jam;
    private final DoubleProperty watt;

    public Electricity(String name, double jam, double watt) {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty(name);
        this.jam = new SimpleDoubleProperty(jam);
        this.watt = new SimpleDoubleProperty(watt);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public double getJam() {
        return jam.get();
    }

    public void setJam(double jam) {
        this.jam.set(jam);
    }

    public DoubleProperty jamProperty() {
        return jam;
    }

    public double getWatt() {
        return watt.get();
    }

    public void setWatt(double watt) {
        this.watt.set(watt);
    }

    public DoubleProperty wattProperty() {
        return watt;
    }

    public double getTotalConsumption() {
        return getJam() * getWatt();
    }
}
