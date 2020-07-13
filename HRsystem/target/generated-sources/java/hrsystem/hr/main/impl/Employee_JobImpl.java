package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.JobImpl;

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
import io.ciera.runtime.summit.types.UniqueId;


public class Employee_JobImpl extends ModelInstance<Employee_Job,Hr> implements Employee_Job {

    public static final String KEY_LETTERS = "Employee_Job";
    public static final Employee_Job EMPTY_EMPLOYEE_JOB = new EmptyEmployee_Job();

    private Hr context;

    // constructors
    private Employee_JobImpl( Hr context ) {
        this.context = context;
        m_Date_of_Appointment = 0;
        m_Active = false;
        R2_earned_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R2_recieves_Job_inst = JobImpl.EMPTY_JOB;
    }

    private Employee_JobImpl( Hr context, UniqueId instanceId, int m_Date_of_Appointment, boolean m_Active ) {
        super(instanceId);
        this.context = context;
        this.m_Date_of_Appointment = m_Date_of_Appointment;
        this.m_Active = m_Active;
        R2_earned_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R2_recieves_Job_inst = JobImpl.EMPTY_JOB;
    }

    public static Employee_Job create( Hr context ) throws XtumlException {
        Employee_Job newEmployee_Job = new Employee_JobImpl( context );
        if ( context.addInstance( newEmployee_Job ) ) {
            newEmployee_Job.getRunContext().addChange(new InstanceCreatedDelta(newEmployee_Job, KEY_LETTERS));
            return newEmployee_Job;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Employee_Job create( Hr context, UniqueId instanceId, int m_Date_of_Appointment, boolean m_Active ) throws XtumlException {
        Employee_Job newEmployee_Job = new Employee_JobImpl( context, instanceId, m_Date_of_Appointment, m_Active );
        if ( context.addInstance( newEmployee_Job ) ) {
            return newEmployee_Job;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private int m_Date_of_Appointment;
    @Override
    public void setDate_of_Appointment( int m_Date_of_Appointment ) throws XtumlException {
        checkLiving();
        if ( m_Date_of_Appointment != this.m_Date_of_Appointment ) {
            final int oldValue = this.m_Date_of_Appointment;
            this.m_Date_of_Appointment = m_Date_of_Appointment;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Date_of_Appointment", oldValue, this.m_Date_of_Appointment));
        }
    }
    @Override
    public int getDate_of_Appointment() throws XtumlException {
        checkLiving();
                return m_Date_of_Appointment;
    }
    private boolean m_Active;
    @Override
    public boolean getActive() throws XtumlException {
        checkLiving();
                return m_Active;
    }
    @Override
    public void setActive( boolean m_Active ) throws XtumlException {
        checkLiving();
        if ( m_Active != this.m_Active ) {
            final boolean oldValue = this.m_Active;
            this.m_Active = m_Active;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Active", oldValue, this.m_Active));
        }
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private Employee R2_earned_Employee_inst;
    @Override
    public void setR2_earned_Employee( Employee inst ) {
        R2_earned_Employee_inst = inst;
    }
    @Override
    public Employee R2_earned_Employee() throws XtumlException {
        return R2_earned_Employee_inst;
    }
    private Job R2_recieves_Job_inst;
    @Override
    public void setR2_recieves_Job( Job inst ) {
        R2_recieves_Job_inst = inst;
    }
    @Override
    public Job R2_recieves_Job() throws XtumlException {
        return R2_recieves_Job_inst;
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
    public Employee_Job self() {
        return this;
    }

    @Override
    public Employee_Job oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_EMPLOYEE_JOB;
    }

}

class EmptyEmployee_Job extends ModelInstance<Employee_Job,Hr> implements Employee_Job {

    // attributes
    public void setDate_of_Appointment( int m_Date_of_Appointment ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getDate_of_Appointment() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public boolean getActive() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setActive( boolean m_Active ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee R2_earned_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }
    @Override
    public Job R2_recieves_Job() {
        return JobImpl.EMPTY_JOB;
    }


    @Override
    public String getKeyLetters() {
        return Employee_JobImpl.KEY_LETTERS;
    }

    @Override
    public Employee_Job self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Employee_Job oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return Employee_JobImpl.EMPTY_EMPLOYEE_JOB;
    }

}
