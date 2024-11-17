import java.util.Map;

public class Node<T> {
    private String species;
    private Map<String, T> properties;

    public Node(String species, Map<String, T> properties) {
        this.species = species;
        this.properties = properties;
    }

    public String getSpecies() {
        return species;
    }

    public T getProperty(String key) {
        return properties.get(key);
    }

    public Map<String, T> getProperties() {
        return properties;
    }

    public String getPropertyAsString(String key) {
        T value = properties.get(key);
        return value != null ? value.toString() : null;
    }
}
