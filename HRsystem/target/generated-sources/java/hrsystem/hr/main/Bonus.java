package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Bonus_PaymentSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Bonus extends IModelInstance<Bonus,Hr> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setAmount( int m_Amount ) throws XtumlException;
    public int getAmount() throws XtumlException;


    // operations


    // selections
    default public void addR5_Bonus_Payment( Bonus_Payment inst ) {}
    default public void removeR5_Bonus_Payment( Bonus_Payment inst ) {}
    public Bonus_PaymentSet R5_Bonus_Payment() throws XtumlException;


}
