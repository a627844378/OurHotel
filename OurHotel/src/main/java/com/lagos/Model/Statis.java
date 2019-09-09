package com.lagos.Model;

public class Statis {
    private int room;
    private int client;

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getRoomHistory() {
        return roomHistory;
    }

    public void setRoomHistory(int roomHistory) {
        this.roomHistory = roomHistory;
    }

    public int getCorder() {
        return corder;
    }

    public void setCorder(int corder) {
        this.corder = corder;
    }

    @Override
    public String toString() {
        return "Statis{" +
                "room=" + room +
                ", client=" + client +
                ", roomHistory=" + roomHistory +
                ", corder=" + corder +
                '}';
    }

    private int roomHistory;
    private int corder;
}
