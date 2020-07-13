package hrsystem.hr.main.impl;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Payment;
import hrsystem.hr.main.PaymentSet;
import hrsystem.hr.main.impl.EmployeeSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class PaymentSetImpl extends InstanceSet<PaymentSet,Payment> implements PaymentSet {

    public PaymentSetImpl() {
    }

    public PaymentSetImpl(Comparator<? super Payment> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setAmount( double m_Amount ) throws XtumlException {
        for ( Payment payment : this ) payment.setAmount( m_Amount );
    }


    // selections
    @Override
    public EmployeeSet R4_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Payment payment : this ) employeeset.add( payment.R4_Employee() );
        return employeeset;
    }


    @Override
    public Payment nullElement() {
        return PaymentImpl.EMPTY_PAYMENT;
    }

    @Override
    public PaymentSet emptySet() {
      return new PaymentSetImpl();
    }

    @Override
    public PaymentSet emptySet(Comparator<? super Payment> comp) {
      return new PaymentSetImpl(comp);
    }

    @Override
    public List<Payment> elements() {
        return Arrays.asList(toArray(new Payment[0]));
    }

}
