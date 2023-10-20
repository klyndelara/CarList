package com.KimlynsPractice.demo.model;

public class MembersCar {
    private int memberCarId;
    private int memberId;
    private int car_id;

    private String color;

    public MembersCar(int memberCarId, int memberId, int car_id, String color) {
        this.memberCarId = memberCarId;
        this.memberId = memberId;
        this.car_id = car_id;
        this.color = color;
    }

    public int getMemberCarId() {
        return memberCarId;
    }

    public void setMemberCarId(int memberCarId) {
        this.memberCarId = memberCarId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
