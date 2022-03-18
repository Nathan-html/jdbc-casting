package fr.hb.casting_agency.model;

public class Casting {

    private Integer id;
    private String appreciation;
    private Integer score;
    private Actor actor;

    public Casting(Integer id, String appreciation, Integer score, Actor actor) {
        this.id = id;
        this.appreciation = appreciation;
        this.score = score;
        this.actor = actor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Casting{" +
                "id=" + id +
                ", appreciation='" + appreciation + '\'' +
                ", score=" + score +
                ", actor=" + actor +
                '}';
    }
}
