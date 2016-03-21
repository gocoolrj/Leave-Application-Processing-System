package com.project.ca.repository;

import java.sql.Date;
import java.util.List;









import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.ca.model.*;

public interface LeaveFormRepository extends JpaRepository<LeaveForm, Integer> {

	@Query("SELECT s FROM LeaveForm s where s.lstatus = :n")
	public List<LeaveForm> getAppliedLeaveForms(@Param("n") String key);
		//public List<LeaveForm> getAppliedLeaveForms(@Param("n") Integer key);
	
	@Query("SELECT L FROM LeaveForm L WHERE (L.lstatus='Applied' or L.lstatus='Cancelled') and L.staffid=(:n)")
	public List<LeaveForm> find(@Param("n") String staffid);
    
	
	 @Query("SELECT s FROM LeaveForm s WHERE s.leaveid = :n AND s.startdate between :m and :o")
	 public List<LeaveForm> findReportList(@Param("n") int leaveid, @Param("m") Date startdate, @Param("o") Date enddate);

	

}
