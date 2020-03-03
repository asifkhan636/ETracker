package com.scudderapps.e_tracker.DATA;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "attendance_details")
public class AttendanceDetails {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ForeignKey(entity = EmployeeData.class, parentColumns = "emp_code", childColumns = "emp_code")
    private String Code;
    private String createdAt;
    private String Status;
    
    public String getCheckInStatus() {
        if (checkInStatus == null){
            return "";
        }
        return checkInStatus;
    }
    
    public void setCheckInStatus(String checkInStatus) {
        this.checkInStatus = checkInStatus;
    }
    
    public String getCheckOutStatus() {
        if (checkOutStatus == null){
            return "";
        }
        return checkOutStatus;
    }
    
    public void setCheckOutStatus(String checkOutStatus) {
        this.checkOutStatus = checkOutStatus;
    }
    
    private String checkInStatus;
    private String checkOutStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
