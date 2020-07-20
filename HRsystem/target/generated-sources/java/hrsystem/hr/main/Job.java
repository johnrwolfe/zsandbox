package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.Step;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.UniqueId;


public interface Job extends IModelInstance<Job,Hr> {

    // attributes
    public void setJob_ID( UniqueId m_Job_ID ) throws XtumlException;
    public UniqueId getJob_ID() throws XtumlException;
    public double getAmount() throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // operations


    // selections
    default public void addR2_earned_Employee_Job( Employee_Job inst ) {}
    default public void removeR2_earned_Employee_Job( Employee_Job inst ) {}
    public Employee_JobSet R2_earned_Employee_Job() throws XtumlException;
    default public void setR3_Grade( Grade inst ) {}
    public Grade R3_Grade() throws XtumlException;
    default public void setR3_Step( Step inst ) {}
    public Step R3_Step() throws XtumlException;


}
