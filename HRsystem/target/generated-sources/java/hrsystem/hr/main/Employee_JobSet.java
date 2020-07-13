package hrsystem.hr.main;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.JobSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Employee_JobSet extends IInstanceSet<Employee_JobSet,Employee_Job> {

    // attributes
    public void setDate_of_Appointment( int m_Date_of_Appointment ) throws XtumlException;
    public void setActive( boolean m_Active ) throws XtumlException;


    // selections
    public EmployeeSet R2_earned_Employee() throws XtumlException;
    public JobSet R2_recieves_Job() throws XtumlException;


}
