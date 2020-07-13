package hrsystem.hr.main;


import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.EmployeeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Bonus_PaymentSet extends IInstanceSet<Bonus_PaymentSet,Bonus_Payment> {

    // attributes


    // selections
    public BonusSet R5_Bonus() throws XtumlException;
    public EmployeeSet R5_Employee() throws XtumlException;


}
