package L02Encapsulation.Exercise.P05FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;


    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        checkIfInRange(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        checkIfInRange(sprint, "Spring");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        checkIfInRange(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        checkIfInRange(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        checkIfInRange(shooting, "Shooting");
        this.shooting = shooting;
    }

    private void checkIfInRange(int statValue, String statName) {
        if (statValue < 0 || statValue > 100) {
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
        }

    }

    public double overallSkillLevel() {
        return (this.endurance + this.dribble + this.passing + this.shooting + this.sprint) / 5.0;
    }

    public String getName() {
        return name;
    }
}
