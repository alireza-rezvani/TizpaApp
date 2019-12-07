package ir.maktab32.java.projects.tizpa.model;

public class TripMethod {
    private String title;
    private int basePrice;
    private double rainAndTrafficCoefficient;
    private double trafficCoefficient;
    private double rainCoefficient;

    public TripMethod(String title, int basePrice, double rainAndTrafficCoefficient, double trafficCoefficient, double rainCoefficient) {
        this.title = title;
        this.basePrice = basePrice;
        this.rainAndTrafficCoefficient = rainAndTrafficCoefficient;
        this.trafficCoefficient = trafficCoefficient;
        this.rainCoefficient = rainCoefficient;
    }

    public String getTitle() {
        return title;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public double getRainAndTrafficCoefficient() {
        return rainAndTrafficCoefficient;
    }

    public double getTrafficCoefficient() {
        return trafficCoefficient;
    }

    public double getRainCoefficient() {
        return rainCoefficient;
    }
}