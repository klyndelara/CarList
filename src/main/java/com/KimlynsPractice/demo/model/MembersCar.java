package com.KimlynsPractice.demo.model;

public class MembersCar {
    private int memberCarId;
    private int memberId;
    private int carId;

    private String color;

    public MembersCar(int memberCarId, int memberId, int carId, String color) {
        this.memberCarId = memberCarId;
        this.memberId = memberId;
        this.carId = carId;
        this.color = color;
    }

    public MembersCar() {

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

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
