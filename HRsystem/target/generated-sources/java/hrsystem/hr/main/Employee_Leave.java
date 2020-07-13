package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Leave;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Employee_Leave extends IModelInstance<Employee_Leave,Hr> {

    // attributes
    public void setStarting( String m_Starting ) throws XtumlException;
    public String getStarting() throws XtumlException;
    public void setEnding( String m_Ending ) throws XtumlException;
    public String getEnding() throws XtumlException;
    public void setApproved( boolean m_Approved ) throws XtumlException;
    public boolean getApproved() throws XtumlException;


    // operations


    // selections
    default public void setR1_Employee( Employee inst ) {}
    public Employee R1_Employee() throws XtumlException;
    default public void setR1_Leave( Leave inst ) {}
    public Leave R1_Leave() throws XtumlException;


}
