package GM;

public class Budget {

    public RankedAttribute TicketPrice, Scouting, Coaching, Health, Facilities;

    public Budget() {}

    public Budget(RankedAttribute ticketPrice, RankedAttribute scouting, RankedAttribute coaching, RankedAttribute health, RankedAttribute facilities) {
        TicketPrice = ticketPrice;
        Scouting = scouting;
        Coaching = coaching;
        Health = health;
        Facilities = facilities;
    }

    public RankedAttribute getTicketPrice() {
        return TicketPrice;
    }

    public RankedAttribute getScouting() {
        return Scouting;
    }

    public RankedAttribute getCoaching() {
        return Coaching;
    }

    public RankedAttribute getHealth() {
        return Health;
    }

    public RankedAttribute getFacilities() {
        return Facilities;
    }
}
