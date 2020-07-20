package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Overtime;
import hrsystem.hr.main.impl.EmployeeImpl;

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


public class OvertimeImpl extends ModelInstance<Overtime,Hr> implements Overtime {

    public static final String KEY_LETTERS = "Overtime";
    public static final Overtime EMPTY_OVERTIME = new EmptyOvertime();

    private Hr context;

    // constructors
    private OvertimeImpl( Hr context ) {
        this.context = context;
        m_ID = UniqueId.random();
        m_Start = 0;
        m_End = 0;
        R6_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    private OvertimeImpl( Hr context, UniqueId instanceId, UniqueId m_ID, int m_Start, int m_End ) {
        super(instanceId);
        this.context = context;
        this.m_ID = m_ID;
        this.m_Start = m_Start;
        this.m_End = m_End;
        R6_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    public static Overtime create( Hr context ) throws XtumlException {
        Overtime newOvertime = new OvertimeImpl( context );
        if ( context.addInstance( newOvertime ) ) {
            newOvertime.getRunContext().addChange(new InstanceCreatedDelta(newOvertime, KEY_LETTERS));
            return newOvertime;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Overtime create( Hr context, UniqueId instanceId, UniqueId m_ID, int m_Start, int m_End ) throws XtumlException {
        Overtime newOvertime = new OvertimeImpl( context, instanceId, m_ID, m_Start, m_End );
        if ( context.addInstance( newOvertime ) ) {
            return newOvertime;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private UniqueId m_ID;
    @Override
    public void setID(UniqueId m_ID) throws XtumlException {
        checkLiving();
        if (m_ID.inequality( this.m_ID)) {
            final UniqueId oldValue = this.m_ID;
            this.m_ID = m_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_ID", oldValue, this.m_ID));
        }
    }
    @Override
    public UniqueId getID() throws XtumlException {
        checkLiving();
        return m_ID;
    }
    private int m_Start;
    @Override
    public int getStart() throws XtumlException {
        checkLiving();
        return m_Start;
    }
    @Override
    public void setStart(int m_Start) throws XtumlException {
        checkLiving();
        if (m_Start != this.m_Start) {
            final int oldValue = this.m_Start;
            this.m_Start = m_Start;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Start", oldValue, this.m_Start));
        }
    }
    private int m_End;
    @Override
    public void setEnd(int m_End) throws XtumlException {
        checkLiving();
        if (m_End != this.m_End) {
            final int oldValue = this.m_End;
            this.m_End = m_End;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_End", oldValue, this.m_End));
        }
    }
    @Override
    public int getEnd() throws XtumlException {
        checkLiving();
        return m_End;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getID());
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
    private Employee R6_Employee_inst;
    @Override
    public void setR6_Employee( Employee inst ) {
        R6_Employee_inst = inst;
    }
    @Override
    public Employee R6_Employee() throws XtumlException {
        return R6_Employee_inst;
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
    public Overtime self() {
        return this;
    }

    @Override
    public Overtime oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_OVERTIME;
    }

}

class EmptyOvertime extends ModelInstance<Overtime,Hr> implements Overtime {

    // attributes
    public void setID( UniqueId m_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public UniqueId getID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getStart() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setStart( int m_Start ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setEnd( int m_End ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getEnd() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee R6_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return OvertimeImpl.KEY_LETTERS;
    }

    @Override
    public Overtime self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Overtime oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return OvertimeImpl.EMPTY_OVERTIME;
    }

}
