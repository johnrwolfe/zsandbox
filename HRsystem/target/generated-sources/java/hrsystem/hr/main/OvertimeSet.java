package hrsystem.hr.main;


import hrsystem.hr.main.EmployeeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.UniqueId;


public interface OvertimeSet extends IInstanceSet<OvertimeSet,Overtime> {

    // attributes
    public void setID( UniqueId m_ID ) throws XtumlException;
    public void setStart( int m_Start ) throws XtumlException;
    public void setEnd( int m_End ) throws XtumlException;


    // selections
    public EmployeeSet R6_Employee() throws XtumlException;


}
