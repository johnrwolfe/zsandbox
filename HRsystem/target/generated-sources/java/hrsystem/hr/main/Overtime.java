package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.UniqueId;


public interface Overtime extends IModelInstance<Overtime,Hr> {

    // attributes
    public UniqueId getID() throws XtumlException;
    public void setID( UniqueId m_ID ) throws XtumlException;
    public int getStart() throws XtumlException;
    public void setStart( int m_Start ) throws XtumlException;
    public int getEnd() throws XtumlException;
    public void setEnd( int m_End ) throws XtumlException;


    // operations
    public void createOvertime() throws XtumlException;


    // selections
    default public void setR6_Employee( Employee inst ) {}
    public Employee R6_Employee() throws XtumlException;


}
