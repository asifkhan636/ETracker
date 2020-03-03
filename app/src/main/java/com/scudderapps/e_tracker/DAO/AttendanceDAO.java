package com.scudderapps.e_tracker.DAO;

import com.scudderapps.e_tracker.DATA.AttendanceDetails;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AttendanceDAO {

    @Insert
    void addAttendance(AttendanceDetails attendanceDetails);
    
    @Update
    void updateAttendance(AttendanceDetails attendanceDetails);

    @Query("SELECT * FROM attendance_details WHERE Code = :code " +
            "AND createdAt = :timestamp " +
            "AND Status = 'Checked In' " +
            "OR Status = 'Checked Out'")

    List<AttendanceDetails> statusDetail(String code, String timestamp);
    
    @Query("SELECT * FROM attendance_details WHERE Code = :code " +
            "AND createdAt = :timestamp ")
    
    List<AttendanceDetails> statusAll(String code, String timestamp);
    

}
