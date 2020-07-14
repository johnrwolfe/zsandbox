package hrsystem.hr.main.impl;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Overtime;
import hrsystem.hr.main.OvertimeSet;
import hrsystem.hr.main.impl.EmployeeSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.UniqueId;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class OvertimeSetImpl extends InstanceSet<OvertimeSet,Overtime> implements OvertimeSet {

    public OvertimeSetImpl() {
    }

    public OvertimeSetImpl(Comparator<? super Overtime> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setID( UniqueId m_ID ) throws XtumlException {
        for ( Overtime overtime : this ) overtime.setID( m_ID );
    }
    @Override
    public void setStart( int m_Start ) throws XtumlException {
        for ( Overtime overtime : this ) overtime.setStart( m_Start );
    }
    @Override
    public void setEnd( int m_End ) throws XtumlException {
        for ( Overtime overtime : this ) overtime.setEnd( m_End );
    }


    // selections
    @Override
    public EmployeeSet R6_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Overtime overtime : this ) employeeset.add( overtime.R6_Employee() );
        return employeeset;
    }


    @Override
    public Overtime nullElement() {
        return OvertimeImpl.EMPTY_OVERTIME;
    }

    @Override
    public OvertimeSet emptySet() {
      return new OvertimeSetImpl();
    }

    @Override
    public OvertimeSet emptySet(Comparator<? super Overtime> comp) {
      return new OvertimeSetImpl(comp);
    }

    @Override
    public List<Overtime> elements() {
        return Arrays.asList(toArray(new Overtime[0]));
    }

}
