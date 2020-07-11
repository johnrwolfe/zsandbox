package hrsystem.hr.main;


import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.StepSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.UniqueId;


public interface JobSet extends IInstanceSet<JobSet,Job> {

    // attributes
    public void setJob_ID( UniqueId m_Job_ID ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;


    // selections
    public Employee_JobSet R2_earned_Employee_Job() throws XtumlException;
    public GradeSet R3_Grade() throws XtumlException;
    public StepSet R3_Step() throws XtumlException;


}
