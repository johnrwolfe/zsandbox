package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.impl.BonusImpl;
import hrsystem.hr.main.impl.EmployeeImpl;

import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IInstanceIdentifier;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.classes.ModelInstance;
import io.ciera.runtime.summit.exceptions.InstancePopulationException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.UniqueId;


public class Bonus_PaymentImpl extends ModelInstance<Bonus_Payment,Hr> implements Bonus_Payment {

    public static final String KEY_LETTERS = "Bonus_Payment";
    public static final Bonus_Payment EMPTY_BONUS_PAYMENT = new EmptyBonus_Payment();

    private Hr context;

    // constructors
    private Bonus_PaymentImpl( Hr context ) {
        this.context = context;
        R5_Bonus_inst = BonusImpl.EMPTY_BONUS;
        R5_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    private Bonus_PaymentImpl( Hr context, UniqueId instanceId ) {
        super(instanceId);
        this.context = context;
        R5_Bonus_inst = BonusImpl.EMPTY_BONUS;
        R5_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    public static Bonus_Payment create( Hr context ) throws XtumlException {
        Bonus_Payment newBonus_Payment = new Bonus_PaymentImpl( context );
        if ( context.addInstance( newBonus_Payment ) ) {
            newBonus_Payment.getRunContext().addChange(new InstanceCreatedDelta(newBonus_Payment, KEY_LETTERS));
            return newBonus_Payment;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Bonus_Payment create( Hr context, UniqueId instanceId ) throws XtumlException {
        Bonus_Payment newBonus_Payment = new Bonus_PaymentImpl( context, instanceId );
        if ( context.addInstance( newBonus_Payment ) ) {
            return newBonus_Payment;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private Bonus R5_Bonus_inst;
    @Override
    public void setR5_Bonus( Bonus inst ) {
        R5_Bonus_inst = inst;
    }
    @Override
    public Bonus R5_Bonus() throws XtumlException {
        return R5_Bonus_inst;
    }
    private Employee R5_Employee_inst;
    @Override
    public void setR5_Employee( Employee inst ) {
        R5_Employee_inst = inst;
    }
    @Override
    public Employee R5_Employee() throws XtumlException {
        return R5_Employee_inst;
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
    public Bonus_Payment self() {
        return this;
    }

    @Override
    public Bonus_Payment oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_BONUS_PAYMENT;
    }

}

class EmptyBonus_Payment extends ModelInstance<Bonus_Payment,Hr> implements Bonus_Payment {

    // attributes


    // operations


    // selections
    @Override
    public Bonus R5_Bonus() {
        return BonusImpl.EMPTY_BONUS;
    }
    @Override
    public Employee R5_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return Bonus_PaymentImpl.KEY_LETTERS;
    }

    @Override
    public Bonus_Payment self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Bonus_Payment oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return Bonus_PaymentImpl.EMPTY_BONUS_PAYMENT;
    }

}
