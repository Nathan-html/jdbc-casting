package fr.hb.casting_agency.service;

public enum Menu {
    GET_ACTORS("1", "get all actors"),
    CREATE_ACTOR("2", "create an actor"),
    UPDATE_ACTOR("3", "update an actor"),
    DELETE_ACTOR("4", "delete an actor"),
    CREATE_CASTING("5", "create casting"),
    DELETE_CASTING("6", "delete casting"),
    EXIT("0", "exit");

    private String id;
    private String value;

    Menu(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return id + " > " + value;
    }
}
