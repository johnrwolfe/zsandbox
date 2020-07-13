package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.Step;
import hrsystem.hr.main.impl.Employee_JobSetImpl;
import hrsystem.hr.main.impl.GradeImpl;
import hrsystem.hr.main.impl.StepImpl;

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


public class JobImpl extends ModelInstance<Job,Hr> implements Job {

    public static final String KEY_LETTERS = "Job";
    public static final Job EMPTY_JOB = new EmptyJob();

    private Hr context;

    // constructors
    private JobImpl( Hr context ) {
        this.context = context;
        m_Job_ID = UniqueId.random();
        m_Amount = 0d;
        m_Name = "";
        R2_earned_Employee_Job_set = new Employee_JobSetImpl();
        R3_Grade_inst = GradeImpl.EMPTY_GRADE;
        R3_Step_inst = StepImpl.EMPTY_STEP;
    }

    private JobImpl( Hr context, UniqueId instanceId, UniqueId m_Job_ID, double m_Amount, String m_Name ) {
        super(instanceId);
        this.context = context;
        this.m_Job_ID = m_Job_ID;
        this.m_Amount = m_Amount;
        this.m_Name = m_Name;
        R2_earned_Employee_Job_set = new Employee_JobSetImpl();
        R3_Grade_inst = GradeImpl.EMPTY_GRADE;
        R3_Step_inst = StepImpl.EMPTY_STEP;
    }

    public static Job create( Hr context ) throws XtumlException {
        Job newJob = new JobImpl( context );
        if ( context.addInstance( newJob ) ) {
            newJob.getRunContext().addChange(new InstanceCreatedDelta(newJob, KEY_LETTERS));
            return newJob;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Job create( Hr context, UniqueId instanceId, UniqueId m_Job_ID, double m_Amount, String m_Name ) throws XtumlException {
        Job newJob = new JobImpl( context, instanceId, m_Job_ID, m_Amount, m_Name );
        if ( context.addInstance( newJob ) ) {
            return newJob;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private UniqueId m_Job_ID;
    @Override
    public UniqueId getJob_ID() throws XtumlException {
        checkLiving();
                return m_Job_ID;
    }
    @Override
    public void setJob_ID( UniqueId m_Job_ID ) throws XtumlException {
        checkLiving();
        if ( m_Job_ID.inequality( this.m_Job_ID ) ) {
            final UniqueId oldValue = this.m_Job_ID;
            this.m_Job_ID = m_Job_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Job_ID", oldValue, this.m_Job_ID));
        }
    }
    private double m_Amount;
    @Override
    public double getAmount() throws XtumlException {
        checkLiving();
                return m_Amount;
    }
    @Override
    public void setAmount( double m_Amount ) throws XtumlException {
        checkLiving();
        if ( m_Amount != this.m_Amount ) {
            final double oldValue = this.m_Amount;
            this.m_Amount = m_Amount;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Amount", oldValue, this.m_Amount));
        }
    }
    private String m_Name;
    @Override
    public void setName( String m_Name ) throws XtumlException {
        checkLiving();
        if ( StringUtil.inequality( m_Name, this.m_Name ) ) {
            final String oldValue = this.m_Name;
            this.m_Name = m_Name;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Name", oldValue, this.m_Name));
        }
    }
    @Override
    public String getName() throws XtumlException {
        checkLiving();
                return m_Name;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getJob_ID());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }

    // operations


    // static operations


    // events


    // selections
    private Employee_JobSet R2_earned_Employee_Job_set;
    @Override
    public void addR2_earned_Employee_Job( Employee_Job inst ) {
        R2_earned_Employee_Job_set.add(inst);
    }
    @Override
    public void removeR2_earned_Employee_Job( Employee_Job inst ) {
        R2_earned_Employee_Job_set.remove(inst);
    }
    @Override
    public Employee_JobSet R2_earned_Employee_Job() throws XtumlException {
        return R2_earned_Employee_Job_set;
    }
    private Grade R3_Grade_inst;
    @Override
    public void setR3_Grade( Grade inst ) {
        R3_Grade_inst = inst;
    }
    @Override
    public Grade R3_Grade() throws XtumlException {
        return R3_Grade_inst;
    }
    private Step R3_Step_inst;
    @Override
    public void setR3_Step( Step inst ) {
        R3_Step_inst = inst;
    }
    @Override
    public Step R3_Step() throws XtumlException {
        return R3_Step_inst;
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
    public Job self() {
        return this;
    }

    @Override
    public Job oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_JOB;
    }

}

class EmptyJob extends ModelInstance<Job,Hr> implements Job {

    // attributes
    public UniqueId getJob_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setJob_ID( UniqueId m_Job_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getAmount() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setAmount( double m_Amount ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee_JobSet R2_earned_Employee_Job() {
        return (new Employee_JobSetImpl());
    }
    @Override
    public Grade R3_Grade() {
        return GradeImpl.EMPTY_GRADE;
    }
    @Override
    public Step R3_Step() {
        return StepImpl.EMPTY_STEP;
    }


    @Override
    public String getKeyLetters() {
        return JobImpl.KEY_LETTERS;
    }

    @Override
    public Job self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Job oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return JobImpl.EMPTY_JOB;
    }

}
