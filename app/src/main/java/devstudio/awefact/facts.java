package devstudio.awefact;

public class facts {
    private static String fact;

    public facts(String fact) {
        super();
        this.fact = fact;
    }

    public static String getName() {
        return fact;
    }

    public void setName(String fact) {
        this.fact = fact;
    }
}