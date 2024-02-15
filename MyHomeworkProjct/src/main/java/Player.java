public class Player {
    private String surename;
    private String club;

    public Player(String surename, String club) {
        this.surename = surename;
        this.club = club;
    }

    public String getSurename() {
        return surename;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}