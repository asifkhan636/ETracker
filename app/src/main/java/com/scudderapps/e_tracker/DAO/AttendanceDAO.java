package com.scudderapps.e_tracker.DAO;

import com.scudderapps.e_tracker.DATA.AttendanceDetails;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface AttendanceDAO {

    @Insert
    void addAttendance(AttendanceDetails attendanceDetails);

    @Query("SELECT * FROM attendance_details WHERE Code = :code " +
            "AND createdAt = :timestamp " +
            "AND Status = 'Checked In' " +
            "OR Status = 'Checked Out'")

    List<AttendanceDetails> statusDetail(String code, String timestamp);

//    @Query("SELECT * FROM attendance_details WHERE Code = :code  AND Status = 'Checked In' OR Status = 'Checked Out'")
//    List<AttendanceDetails> statusDetail(String code);

}
