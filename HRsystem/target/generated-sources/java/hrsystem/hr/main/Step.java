package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Step extends IModelInstance<Step,Hr> {

    // attributes
    public int getSValue() throws XtumlException;
    public void setSValue( int m_SValue ) throws XtumlException;


    // operations


    // selections
    default public void addR3_Job( Job inst ) {}
    default public void removeR3_Job( Job inst ) {}
    public JobSet R3_Job() throws XtumlException;


}
