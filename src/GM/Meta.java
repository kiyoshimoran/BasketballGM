package GM;

public class Meta {

    public String phaseText, name;

    public Meta() {}

    public Meta(String phasetext, String name) {
        this.phaseText = phasetext;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "phasetext='" + phaseText + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getPhasetext() {
        return phaseText;
    }

    public String getName() {
        return name;
    }
}
