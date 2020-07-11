package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Payment extends IModelInstance<Payment,Hr> {

    // attributes
    public double getAmount() throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;


    // operations


    // selections
    default public void setR4_Employee( Employee inst ) {}
    public Employee R4_Employee() throws XtumlException;


}
