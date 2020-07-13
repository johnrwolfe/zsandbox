package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.impl.Employee_LeaveSetImpl;
import hrsystem.hr.main.impl.LeaveImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.ActionHome;
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


public class LeaveImpl extends ModelInstance<Leave,Hr> implements Leave {

    public static final String KEY_LETTERS = "Leave";
    public static final Leave EMPTY_LEAVE = new EmptyLeave();

    private Hr context;

    // constructors
    private LeaveImpl( Hr context ) {
        this.context = context;
        m_Name = "";
        m_MaximumDays = 0;
        m_Leave_ID = 0;
        R1_Employee_Leave_set = new Employee_LeaveSetImpl();
    }

    private LeaveImpl( Hr context, UniqueId instanceId, String m_Name, int m_MaximumDays, int m_Leave_ID ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_MaximumDays = m_MaximumDays;
        this.m_Leave_ID = m_Leave_ID;
        R1_Employee_Leave_set = new Employee_LeaveSetImpl();
    }

    public static Leave create( Hr context ) throws XtumlException {
        Leave newLeave = new LeaveImpl( context );
        if ( context.addInstance( newLeave ) ) {
            newLeave.getRunContext().addChange(new InstanceCreatedDelta(newLeave, KEY_LETTERS));
            return newLeave;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Leave create( Hr context, UniqueId instanceId, String m_Name, int m_MaximumDays, int m_Leave_ID ) throws XtumlException {
        Leave newLeave = new LeaveImpl( context, instanceId, m_Name, m_MaximumDays, m_Leave_ID );
        if ( context.addInstance( newLeave ) ) {
            return newLeave;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
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
    private int m_MaximumDays;
    @Override
    public void setMaximumDays( int m_MaximumDays ) throws XtumlException {
        checkLiving();
        if ( m_MaximumDays != this.m_MaximumDays ) {
            final int oldValue = this.m_MaximumDays;
            this.m_MaximumDays = m_MaximumDays;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_MaximumDays", oldValue, this.m_MaximumDays));
        }
    }
    @Override
    public int getMaximumDays() throws XtumlException {
        checkLiving();
                return m_MaximumDays;
    }
    private int m_Leave_ID;
    @Override
    public void setLeave_ID( int m_Leave_ID ) throws XtumlException {
        checkLiving();
        if ( m_Leave_ID != this.m_Leave_ID ) {
            final int oldValue = this.m_Leave_ID;
            this.m_Leave_ID = m_Leave_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Leave_ID", oldValue, this.m_Leave_ID));
        }
    }
    @Override
    public int getLeave_ID() throws XtumlException {
        checkLiving();
                return m_Leave_ID;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getLeave_ID());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }
    @Override
    public IInstanceIdentifier getId2() {
        try {
            return new InstanceIdentifier(getName());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }

    // operations


    // static operations
    public static class CLASS extends ActionHome<Hr> {

        public CLASS( Hr context ) {
            super( context );
        }

        public void crudLeave( final String p_Name,  final int p_MaximumDays,  final String p_Action ) throws XtumlException {
            Leave leave = LeaveImpl.create( context() );
            leave.setName( p_Name );
            leave.setMaximumDays( p_MaximumDays );
        }



    }


    // events


    // selections
    private Employee_LeaveSet R1_Employee_Leave_set;
    @Override
    public void addR1_Employee_Leave( Employee_Leave inst ) {
        R1_Employee_Leave_set.add(inst);
    }
    @Override
    public void removeR1_Employee_Leave( Employee_Leave inst ) {
        R1_Employee_Leave_set.remove(inst);
    }
    @Override
    public Employee_LeaveSet R1_Employee_Leave() throws XtumlException {
        return R1_Employee_Leave_set;
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
    public Leave self() {
        return this;
    }

    @Override
    public Leave oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_LEAVE;
    }

}

class EmptyLeave extends ModelInstance<Leave,Hr> implements Leave {

    // attributes
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setMaximumDays( int m_MaximumDays ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getMaximumDays() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setLeave_ID( int m_Leave_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getLeave_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee_LeaveSet R1_Employee_Leave() {
        return (new Employee_LeaveSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return LeaveImpl.KEY_LETTERS;
    }

    @Override
    public Leave self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Leave oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return LeaveImpl.EMPTY_LEAVE;
    }

}
