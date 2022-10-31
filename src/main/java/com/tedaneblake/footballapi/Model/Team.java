package com.tedaneblake.footballapi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team {

    @Column(name = "TEAM_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TEAM_LONG_NAME")
    private String longName;

    @Column(name = "TEAM_SHORT_NAME")
    private String shortName;

    @Column(name = "TEAM_LOGO")
    private String logo;

    @Column(name = "LEAGUE_ID")
    private int leagueId;

    public Team() {
    }

    public Team(int id, String longName, String shortName, String logo, int leagueId) {
        this.id = id;
        this.longName = longName;
        this.shortName = shortName;
        this.logo = logo;
        this.leagueId = leagueId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongName() {
        return this.longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getLeagueId() {
        return this.leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", longName='" + getLongName() + "'" +
                ", shortName='" + getShortName() + "'" +
                ", logo='" + getLogo() + "'" +
                ", leagueId='" + getLeagueId() + "'" +
                "}";
    }

}
