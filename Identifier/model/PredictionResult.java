public class PredictionResult {
    private String species;
    private double confidence;

    public PredictionResult(String species, double confidence) {
        this.species = species;
        this.confidence = confidence;
    }

    public String getSpecies() {
        return species;
    }

    public double getConfidence() {
        return confidence;
    }

    @Override
    public String toString() {
        return "Species: " + species + ", Confidence: " + String.format("%.2f", confidence) + "%";
    }
}
