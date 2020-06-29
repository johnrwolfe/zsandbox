package hrsystem.hr.main.impl;


import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.impl.Employee_LeaveSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.Date;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class EmployeeSetImpl extends InstanceSet<EmployeeSet,Employee> implements EmployeeSet {

    public EmployeeSetImpl() {
    }

    public EmployeeSetImpl(Comparator<? super Employee> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setFName( String m_FName ) throws XtumlException {
        for ( Employee employee : this ) employee.setFName( m_FName );
    }
    @Override
    public void setLName( String m_LName ) throws XtumlException {
        for ( Employee employee : this ) employee.setLName( m_LName );
    }
    @Override
    public void setNational_ID( int m_National_ID ) throws XtumlException {
        for ( Employee employee : this ) employee.setNational_ID( m_National_ID );
    }
    @Override
    public void setStart_Date( Date m_Start_Date ) throws XtumlException {
        for ( Employee employee : this ) employee.setStart_Date( m_Start_Date );
    }


    // selections
    @Override
    public Employee_LeaveSet R1_Employee_Leave() throws XtumlException {
        Employee_LeaveSet employee_leaveset = new Employee_LeaveSetImpl();
        for ( Employee employee : this ) employee_leaveset.addAll( employee.R1_Employee_Leave() );
        return employee_leaveset;
    }


    @Override
    public Employee nullElement() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }

    @Override
    public EmployeeSet emptySet() {
      return new EmployeeSetImpl();
    }

    @Override
    public EmployeeSet emptySet(Comparator<? super Employee> comp) {
      return new EmployeeSetImpl(comp);
    }

    @Override
    public List<Employee> elements() {
        return Arrays.asList(toArray(new Employee[0]));
    }

}
