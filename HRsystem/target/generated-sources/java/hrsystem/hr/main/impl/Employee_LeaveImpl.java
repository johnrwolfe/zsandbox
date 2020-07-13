package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.LeaveImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IInstanceIdentifier;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.classes.ModelInstance;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.InstancePopulationException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.types.UniqueId;


public class Employee_LeaveImpl extends ModelInstance<Employee_Leave,Hr> implements Employee_Leave {

    public static final String KEY_LETTERS = "Employee_Leave";
    public static final Employee_Leave EMPTY_EMPLOYEE_LEAVE = new EmptyEmployee_Leave();

    private Hr context;

    // constructors
    private Employee_LeaveImpl( Hr context ) {
        this.context = context;
        m_Starting = "";
        m_Ending = "";
        m_Approved = false;
        R1_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R1_Leave_inst = LeaveImpl.EMPTY_LEAVE;
    }

    private Employee_LeaveImpl( Hr context, UniqueId instanceId, String m_Starting, String m_Ending, boolean m_Approved ) {
        super(instanceId);
        this.context = context;
        this.m_Starting = m_Starting;
        this.m_Ending = m_Ending;
        this.m_Approved = m_Approved;
        R1_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R1_Leave_inst = LeaveImpl.EMPTY_LEAVE;
    }

    public static Employee_Leave create( Hr context ) throws XtumlException {
        Employee_Leave newEmployee_Leave = new Employee_LeaveImpl( context );
        if ( context.addInstance( newEmployee_Leave ) ) {
            newEmployee_Leave.getRunContext().addChange(new InstanceCreatedDelta(newEmployee_Leave, KEY_LETTERS));
            return newEmployee_Leave;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Employee_Leave create( Hr context, UniqueId instanceId, String m_Starting, String m_Ending, boolean m_Approved ) throws XtumlException {
        Employee_Leave newEmployee_Leave = new Employee_LeaveImpl( context, instanceId, m_Starting, m_Ending, m_Approved );
        if ( context.addInstance( newEmployee_Leave ) ) {
            return newEmployee_Leave;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Starting;
    @Override
    public String getStarting() throws XtumlException {
        checkLiving();
                return m_Starting;
    }
    @Override
    public void setStarting( String m_Starting ) throws XtumlException {
        checkLiving();
        if ( StringUtil.inequality( m_Starting, this.m_Starting ) ) {
            final String oldValue = this.m_Starting;
            this.m_Starting = m_Starting;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Starting", oldValue, this.m_Starting));
        }
    }
    private String m_Ending;
    @Override
    public void setEnding( String m_Ending ) throws XtumlException {
        checkLiving();
        if ( StringUtil.inequality( m_Ending, this.m_Ending ) ) {
            final String oldValue = this.m_Ending;
            this.m_Ending = m_Ending;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Ending", oldValue, this.m_Ending));
        }
    }
    @Override
    public String getEnding() throws XtumlException {
        checkLiving();
                return m_Ending;
    }
    private boolean m_Approved;
    @Override
    public void setApproved( boolean m_Approved ) throws XtumlException {
        checkLiving();
        if ( m_Approved != this.m_Approved ) {
            final boolean oldValue = this.m_Approved;
            this.m_Approved = m_Approved;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Approved", oldValue, this.m_Approved));
        }
    }
    @Override
    public boolean getApproved() throws XtumlException {
        checkLiving();
                return m_Approved;
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private Employee R1_Employee_inst;
    @Override
    public void setR1_Employee( Employee inst ) {
        R1_Employee_inst = inst;
    }
    @Override
    public Employee R1_Employee() throws XtumlException {
        return R1_Employee_inst;
    }
    private Leave R1_Leave_inst;
    @Override
    public void setR1_Leave( Leave inst ) {
        R1_Leave_inst = inst;
    }
    @Override
    public Leave R1_Leave() throws XtumlException {
        return R1_Leave_inst;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Hr context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public Employee_Leave self() {
        return this;
    }

    @Override
    public Employee_Leave oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_EMPLOYEE_LEAVE;
    }

}

class EmptyEmployee_Leave extends ModelInstance<Employee_Leave,Hr> implements Employee_Leave {

    // attributes
    public String getStarting() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setStarting( String m_Starting ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setEnding( String m_Ending ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getEnding() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setApproved( boolean m_Approved ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public boolean getApproved() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee R1_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }
    @Override
    public Leave R1_Leave() {
        return LeaveImpl.EMPTY_LEAVE;
    }


    @Override
    public String getKeyLetters() {
        return Employee_LeaveImpl.KEY_LETTERS;
    }

    @Override
    public Employee_Leave self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Employee_Leave oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return Employee_LeaveImpl.EMPTY_EMPLOYEE_LEAVE;
    }

}
