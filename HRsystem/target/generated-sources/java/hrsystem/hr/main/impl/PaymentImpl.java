package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Payment;
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


public class PaymentImpl extends ModelInstance<Payment,Hr> implements Payment {

    public static final String KEY_LETTERS = "Payment";
    public static final Payment EMPTY_PAYMENT = new EmptyPayment();

    private Hr context;

    // constructors
    private PaymentImpl( Hr context ) {
        this.context = context;
        m_Amount = 0d;
        R4_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    private PaymentImpl( Hr context, UniqueId instanceId, double m_Amount ) {
        super(instanceId);
        this.context = context;
        this.m_Amount = m_Amount;
        R4_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    public static Payment create( Hr context ) throws XtumlException {
        Payment newPayment = new PaymentImpl( context );
        if ( context.addInstance( newPayment ) ) {
            newPayment.getRunContext().addChange(new InstanceCreatedDelta(newPayment, KEY_LETTERS));
            return newPayment;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Payment create( Hr context, UniqueId instanceId, double m_Amount ) throws XtumlException {
        Payment newPayment = new PaymentImpl( context, instanceId, m_Amount );
        if ( context.addInstance( newPayment ) ) {
            return newPayment;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private double m_Amount;
    @Override
    public void setAmount( double m_Amount ) throws XtumlException {
        checkLiving();
        if ( m_Amount != this.m_Amount ) {
            final double oldValue = this.m_Amount;
            this.m_Amount = m_Amount;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Amount", oldValue, this.m_Amount));
        }
    }
    @Override
    public double getAmount() throws XtumlException {
        checkLiving();
                return m_Amount;
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private Employee R4_Employee_inst;
    @Override
    public void setR4_Employee( Employee inst ) {
        R4_Employee_inst = inst;
    }
    @Override
    public Employee R4_Employee() throws XtumlException {
        return R4_Employee_inst;
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
    public Payment self() {
        return this;
    }

    @Override
    public Payment oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_PAYMENT;
    }

}

class EmptyPayment extends ModelInstance<Payment,Hr> implements Payment {

    // attributes
    public void setAmount( double m_Amount ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getAmount() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee R4_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return PaymentImpl.KEY_LETTERS;
    }

    @Override
    public Payment self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Payment oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return PaymentImpl.EMPTY_PAYMENT;
    }

}
