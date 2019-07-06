package com.example.capstoneshs;

public class LeaveClass {
    private String start_date,return_date,reason,address,user_id,reason_of_leave,status;

    public LeaveClass(String start_date, String return_date, String reason, String address, String user_id, String reason_of_leave, String status) {
        this.start_date = start_date;
        this.return_date = return_date;
        this.reason = reason;
        this.address = address;
        this.user_id = user_id;
        this.reason_of_leave = reason_of_leave;
        this.status = status;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReason_of_leave() {
        return reason_of_leave;
    }

    public void setReason_of_leave(String reason_of_leave) {
        this.reason_of_leave = reason_of_leave;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
