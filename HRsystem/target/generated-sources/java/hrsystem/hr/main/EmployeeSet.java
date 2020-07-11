package hrsystem.hr.main;


import hrsystem.hr.main.Bonus_PaymentSet;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.OvertimeSet;
import hrsystem.hr.main.PaymentSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.Date;


public interface EmployeeSet extends IInstanceSet<EmployeeSet,Employee> {

    // attributes
    public void setNational_ID( int m_National_ID ) throws XtumlException;
    public void setLName( String m_LName ) throws XtumlException;
    public void setFName( String m_FName ) throws XtumlException;
    public void setStart_Date( Date m_Start_Date ) throws XtumlException;


    // selections
    public Employee_LeaveSet R1_Employee_Leave() throws XtumlException;
    public Employee_JobSet R2_recieves_Employee_Job() throws XtumlException;
    public PaymentSet R4_Payment() throws XtumlException;
    public Bonus_PaymentSet R5_Bonus_Payment() throws XtumlException;
    public OvertimeSet R6_Overtime() throws XtumlException;


}
