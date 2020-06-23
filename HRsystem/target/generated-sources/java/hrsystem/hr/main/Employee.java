package hrsystem.hr.main;


import hrsystem.Hr;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.Date;


public interface Employee extends IModelInstance<Employee,Hr> {

    // attributes
    public String getFName() throws XtumlException;
    public void setFName( String m_FName ) throws XtumlException;
    public int getNational_ID() throws XtumlException;
    public void setNational_ID( int m_National_ID ) throws XtumlException;
    public Date getBirth_Date() throws XtumlException;
    public void setBirth_Date( Date m_Birth_Date ) throws XtumlException;
    public String getLName() throws XtumlException;
    public void setLName( String m_LName ) throws XtumlException;
    public void setStart_Date( Date m_Start_Date ) throws XtumlException;
    public Date getStart_Date() throws XtumlException;


    // operations
    public void getAge() throws XtumlException;


    // selections


}
