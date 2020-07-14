package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Bonus_PaymentSet;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.Overtime;
import hrsystem.hr.main.OvertimeSet;
import hrsystem.hr.main.Payment;
import hrsystem.hr.main.PaymentSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.Date;


public interface Employee extends IModelInstance<Employee,Hr> {

    // attributes
    public void setFName( String m_FName ) throws XtumlException;
    public String getFName() throws XtumlException;
    public int getNational_ID() throws XtumlException;
    public void setNational_ID( int m_National_ID ) throws XtumlException;
    public void setLName( String m_LName ) throws XtumlException;
    public String getLName() throws XtumlException;
    public Date getStart_Date() throws XtumlException;
    public void setStart_Date( Date m_Start_Date ) throws XtumlException;


    // operations


    // selections
    default public void addR1_Employee_Leave( Employee_Leave inst ) {}
    default public void removeR1_Employee_Leave( Employee_Leave inst ) {}
    public Employee_LeaveSet R1_Employee_Leave() throws XtumlException;
    default public void addR2_recieves_Employee_Job( Employee_Job inst ) {}
    default public void removeR2_recieves_Employee_Job( Employee_Job inst ) {}
    public Employee_JobSet R2_recieves_Employee_Job() throws XtumlException;
    default public void addR4_Payment( Payment inst ) {}
    default public void removeR4_Payment( Payment inst ) {}
    public PaymentSet R4_Payment() throws XtumlException;
    default public void addR5_Bonus_Payment( Bonus_Payment inst ) {}
    default public void removeR5_Bonus_Payment( Bonus_Payment inst ) {}
    public Bonus_PaymentSet R5_Bonus_Payment() throws XtumlException;
    default public void addR6_Overtime( Overtime inst ) {}
    default public void removeR6_Overtime( Overtime inst ) {}
    public OvertimeSet R6_Overtime() throws XtumlException;


}
