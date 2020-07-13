package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Bonus_PaymentSet;
import hrsystem.hr.main.impl.BonusImpl;
import hrsystem.hr.main.impl.Bonus_PaymentSetImpl;

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


public class BonusImpl extends ModelInstance<Bonus,Hr> implements Bonus {

    public static final String KEY_LETTERS = "Bonus";
    public static final Bonus EMPTY_BONUS = new EmptyBonus();

    private Hr context;

    // constructors
    private BonusImpl( Hr context ) {
        this.context = context;
        m_Name = "";
        m_Amount = 0;
        R5_Bonus_Payment_set = new Bonus_PaymentSetImpl();
    }

    private BonusImpl( Hr context, UniqueId instanceId, String m_Name, int m_Amount ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Amount = m_Amount;
        R5_Bonus_Payment_set = new Bonus_PaymentSetImpl();
    }

    public static Bonus create( Hr context ) throws XtumlException {
        Bonus newBonus = new BonusImpl( context );
        if ( context.addInstance( newBonus ) ) {
            newBonus.getRunContext().addChange(new InstanceCreatedDelta(newBonus, KEY_LETTERS));
            return newBonus;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Bonus create( Hr context, UniqueId instanceId, String m_Name, int m_Amount ) throws XtumlException {
        Bonus newBonus = new BonusImpl( context, instanceId, m_Name, m_Amount );
        if ( context.addInstance( newBonus ) ) {
            return newBonus;
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
    private int m_Amount;
    @Override
    public void setAmount( int m_Amount ) throws XtumlException {
        checkLiving();
        if ( m_Amount != this.m_Amount ) {
            final int oldValue = this.m_Amount;
            this.m_Amount = m_Amount;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Amount", oldValue, this.m_Amount));
        }
    }
    @Override
    public int getAmount() throws XtumlException {
        checkLiving();
                return m_Amount;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
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

        public void createBonus( final String p_Name,  final int p_Amount ) throws XtumlException {
            context().LOG().LogInfo( "Bonus: Attempting to add a new Bonus." );
            Bonus bonus = context().Bonus_instances().anyWhere(selected -> StringUtil.equality( ((Bonus)selected).getName(), p_Name ));
            if ( bonus.isEmpty() ) {
                Bonus b = BonusImpl.create( context() );
                b.setName( p_Name );
                b.setAmount( p_Amount );
                context().UI().Reply( "Bonus: added successfully.", true );
            }
            else {
                context().LOG().LogInfo( "Bonus: already exists." );
                context().UI().Reply( "Bonus already exists", false );
            }
        }



    }


    // events


    // selections
    private Bonus_PaymentSet R5_Bonus_Payment_set;
    @Override
    public void addR5_Bonus_Payment( Bonus_Payment inst ) {
        R5_Bonus_Payment_set.add(inst);
    }
    @Override
    public void removeR5_Bonus_Payment( Bonus_Payment inst ) {
        R5_Bonus_Payment_set.remove(inst);
    }
    @Override
    public Bonus_PaymentSet R5_Bonus_Payment() throws XtumlException {
        return R5_Bonus_Payment_set;
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
    public Bonus self() {
        return this;
    }

    @Override
    public Bonus oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_BONUS;
    }

}

class EmptyBonus extends ModelInstance<Bonus,Hr> implements Bonus {

    // attributes
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setAmount( int m_Amount ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getAmount() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Bonus_PaymentSet R5_Bonus_Payment() {
        return (new Bonus_PaymentSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return BonusImpl.KEY_LETTERS;
    }

    @Override
    public Bonus self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Bonus oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return BonusImpl.EMPTY_BONUS;
    }

}
