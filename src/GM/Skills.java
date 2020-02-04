package GM;

import java.util.List;

public class Skills {

    public List<String> skill;

    public Skills(List<String> skill) {
        this.skill = skill;
    }

    public String toSQL()
    {
        return  (skill.contains("A") ? "22" : "22") +
                ", " + (skill.contains("B") ? 1 : 0) +
                ", " + (skill.contains("Di") ? 1 : 0) +
                ", " + (skill.contains("Dp") ? 1 : 0) +
                ", " + (skill.contains("Po") ? 1 : 0) +
                ", " + (skill.contains("Pa") ? 1 : 0) +
                ", " + (skill.contains("R") ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Skills{" +
                "skill=" + skill +
                '}';
    }
}


