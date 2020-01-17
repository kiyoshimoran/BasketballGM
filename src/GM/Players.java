package GM;

import java.util.ArrayList;
import java.util.List;

public class Players {

    //public String season;
    public List<JsonPG> everyone;

    public Players() {
        everyone = new ArrayList<JsonPG>();
    }

    public Players(List<JsonPG> all)
    {
        this.everyone = all;
    }

    public void printAll()
    {
        if(everyone.isEmpty()) { System.out.println("None"); }

        else
        {
            for (JsonPG j : everyone) {
                System.out.println(j.name);
            }
        }
    }

    @Override
    public String toString() {
        return "Players{" +
                "everyone=" + everyone +
                '}';
    }

    public List<JsonPG> getEveryone() {
        return everyone;
    }

    public void setEveryone(List<JsonPG> everyone) {
        this.everyone = everyone;
    }

}
