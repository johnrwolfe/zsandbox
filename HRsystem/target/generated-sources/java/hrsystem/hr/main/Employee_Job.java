package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Job;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Employee_Job extends IModelInstance<Employee_Job,Hr> {

    // attributes
    public void setDate_of_Appointment( int m_Date_of_Appointment ) throws XtumlException;
    public int getDate_of_Appointment() throws XtumlException;
    public boolean getActive() throws XtumlException;
    public void setActive( boolean m_Active ) throws XtumlException;


    // operations


    // selections
    default public void setR2_earned_Employee( Employee inst ) {}
    public Employee R2_earned_Employee() throws XtumlException;
    default public void setR2_recieves_Job( Job inst ) {}
    public Job R2_recieves_Job() throws XtumlException;


}
