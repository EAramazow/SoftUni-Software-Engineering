package com.example.football.models.dto;

import com.example.football.models.enums.Position;

public class BestPlayerDto {

    private String firstName;
    private String lastName;
    private Position position;
    private String teamName;
    private String stadiumName;

    public BestPlayerDto(String firstName, String lastName, Position position, String teamName, String stadiumName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.teamName = teamName;
        this.stadiumName = stadiumName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    @Override
    public String toString() {
        return String.format("""
                        Player - %s %s
                        \tPosition - %s
                        \tTeam - %s
                        \tStadium - %s""",
                firstName, lastName, position, teamName, stadiumName);
    }
}
