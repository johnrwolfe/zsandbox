package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.Employee;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Bonus_Payment extends IModelInstance<Bonus_Payment,Hr> {

    // attributes


    // operations


    // selections
    default public void setR5_Bonus( Bonus inst ) {}
    public Bonus R5_Bonus() throws XtumlException;
    default public void setR5_Employee( Employee inst ) {}
    public Employee R5_Employee() throws XtumlException;


}
