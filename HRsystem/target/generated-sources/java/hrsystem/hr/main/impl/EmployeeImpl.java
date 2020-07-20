package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Bonus_PaymentSet;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.Overtime;
import hrsystem.hr.main.OvertimeSet;
import hrsystem.hr.main.Payment;
import hrsystem.hr.main.PaymentSet;
import hrsystem.hr.main.impl.Bonus_PaymentSetImpl;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.Employee_JobSetImpl;
import hrsystem.hr.main.impl.Employee_LeaveSetImpl;
import hrsystem.hr.main.impl.OvertimeSetImpl;
import hrsystem.hr.main.impl.PaymentSetImpl;

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
import io.ciera.runtime.summit.statemachine.Event;
import io.ciera.runtime.summit.statemachine.IEvent;
import io.ciera.runtime.summit.types.Date;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.types.UniqueId;


public class EmployeeImpl extends ModelInstance<Employee,Hr> implements Employee {

    public static final String KEY_LETTERS = "EM";
    public static final Employee EMPTY_EMPLOYEE = new EmptyEmployee();

    private Hr context;

    // constructors
    private EmployeeImpl( Hr context ) {
        this.context = context;
        m_FName = "";
        m_National_ID = 0;
        m_LName = "";
        m_Start_Date = new Date();
        R1_Employee_Leave_set = new Employee_LeaveSetImpl();
        R2_recieves_Employee_Job_set = new Employee_JobSetImpl();
        R4_Payment_set = new PaymentSetImpl();
        R5_Bonus_Payment_set = new Bonus_PaymentSetImpl();
        R6_Overtime_set = new OvertimeSetImpl();
        statemachine = new EmployeeStateMachine(this, context());
    }

    private EmployeeImpl( Hr context, UniqueId instanceId, String m_FName, int m_National_ID, String m_LName, Date m_Start_Date, int initialState ) {
        super(instanceId);
        this.context = context;
        this.m_FName = m_FName;
        this.m_National_ID = m_National_ID;
        this.m_LName = m_LName;
        this.m_Start_Date = m_Start_Date;
        R1_Employee_Leave_set = new Employee_LeaveSetImpl();
        R2_recieves_Employee_Job_set = new Employee_JobSetImpl();
        R4_Payment_set = new PaymentSetImpl();
        R5_Bonus_Payment_set = new Bonus_PaymentSetImpl();
        R6_Overtime_set = new OvertimeSetImpl();
        statemachine = new EmployeeStateMachine(this, context(), initialState);
    }

    public static Employee create( Hr context ) throws XtumlException {
        Employee newEmployee = new EmployeeImpl( context );
        if ( context.addInstance( newEmployee ) ) {
            newEmployee.getRunContext().addChange(new InstanceCreatedDelta(newEmployee, KEY_LETTERS));
            return newEmployee;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Employee create( Hr context, UniqueId instanceId, String m_FName, int m_National_ID, String m_LName, Date m_Start_Date, int initialState ) throws XtumlException {
        Employee newEmployee = new EmployeeImpl( context, instanceId, m_FName, m_National_ID, m_LName, m_Start_Date, initialState );
        if ( context.addInstance( newEmployee ) ) {
            return newEmployee;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    private final EmployeeStateMachine statemachine;
    
    @Override
    public void accept(IEvent event) throws XtumlException {
        statemachine.transition(event);
    }

    @Override
    public int getCurrentState() {
        return statemachine.getCurrentState();
    }


    // attributes
    private String m_FName;
    @Override
    public String getFName() throws XtumlException {
        checkLiving();
        return m_FName;
    }
    @Override
    public void setFName(String m_FName) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_FName, this.m_FName)) {
            final String oldValue = this.m_FName;
            this.m_FName = m_FName;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_FName", oldValue, this.m_FName));
        }
    }
    private int m_National_ID;
    @Override
    public int getNational_ID() throws XtumlException {
        checkLiving();
        return m_National_ID;
    }
    @Override
    public void setNational_ID(int m_National_ID) throws XtumlException {
        checkLiving();
        if (m_National_ID != this.m_National_ID) {
            final int oldValue = this.m_National_ID;
            this.m_National_ID = m_National_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_National_ID", oldValue, this.m_National_ID));
        }
    }
    private String m_LName;
    @Override
    public void setLName(String m_LName) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_LName, this.m_LName)) {
            final String oldValue = this.m_LName;
            this.m_LName = m_LName;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_LName", oldValue, this.m_LName));
        }
    }
    @Override
    public String getLName() throws XtumlException {
        checkLiving();
        return m_LName;
    }
    private Date m_Start_Date;
    @Override
    public void setStart_Date(Date m_Start_Date) throws XtumlException {
        checkLiving();
        if (m_Start_Date.inequality( this.m_Start_Date)) {
            final Date oldValue = this.m_Start_Date;
            this.m_Start_Date = m_Start_Date;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Start_Date", oldValue, this.m_Start_Date));
        }
    }
    @Override
    public Date getStart_Date() throws XtumlException {
        checkLiving();
        return m_Start_Date;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getNational_ID());
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

        public void commenceEmployee( final int p_National_ID ) throws XtumlException {
            context().LOG().LogInfo( "An employee attempts to commence." );
            Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNational_ID() == p_National_ID);
            if ( !employee.isEmpty() ) {
                context().generate(new EmployeeImpl.commencedRcvd(getRunContext(), context().getId()).to(employee));
                employee.setStart_Date(context().TIM().current_date());
            }
            else {
                context().LOG().LogInfo( "Employee is not registered!" );
            }
        }

        public void crudEmployee( final String p_FName,  final String p_LName,  final int p_National_ID,  final String p_Action ) throws XtumlException {
            context().LOG().LogInfo( "Attempting to add a new Employee." );
            Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNational_ID() == p_National_ID);
            if ( employee.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                employee = EmployeeImpl.create( context() );
                employee.setFName(p_FName);
                employee.setLName(p_LName);
                employee.setNational_ID(p_National_ID);
                context().SQL().serialize();
                context().UI().Reply( "Employee added successfully.", true );
            }
            else if ( !employee.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Employee already exists." );
                context().UI().Reply( "Employee already exists", false );
            }
            else if ( !employee.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                employee.setFName(p_FName);
                employee.setLName(p_LName);
                employee.setNational_ID(p_National_ID);
                context().LOG().LogInfo( "Employee updated successfully." );
                context().UI().Reply( "Employee updated successfully", true );
            }
            else if ( !employee.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Employee deleted successfully." );
                context().UI().Reply( "Employee delete unsuccessful", false );
            }
            else if ( employee.isEmpty() ) {
                context().LOG().LogInfo( "Employee does not exist." );
                context().UI().Reply( "Employee does not exist.", false );
            }
        }



    }


    // events
    public static class commencedRcvd extends Event {
        public commencedRcvd(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 2;
        }
        @Override
        public String getClassName() {
            return "Employee";
        }
    }
    public static class employeeUpdateRcvd extends Event {
        public employeeUpdateRcvd(IRunContext runContext, int populationId,  final String p_FName,  final String p_LName ) {
            super(runContext, populationId, new Object[]{p_FName,  p_LName});
        }
        @Override
        public int getId() {
            return 0;
        }
        @Override
        public String getClassName() {
            return "Employee";
        }
    }
    public static class requestLeave extends Event {
        public requestLeave(IRunContext runContext, int populationId,  final long p_Starting,  final String p_Ending,  final int p_National_ID,  final String p_Name ) {
            super(runContext, populationId, new Object[]{p_Starting,  p_Ending,  p_National_ID,  p_Name});
        }
        @Override
        public int getId() {
            return 3;
        }
        @Override
        public String getClassName() {
            return "Employee";
        }
    }
    public static class returnFromLeave extends Event {
        public returnFromLeave(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 1;
        }
        @Override
        public String getClassName() {
            return "Employee";
        }
    }


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
    private Employee_JobSet R2_recieves_Employee_Job_set;
    @Override
    public void addR2_recieves_Employee_Job( Employee_Job inst ) {
        R2_recieves_Employee_Job_set.add(inst);
    }
    @Override
    public void removeR2_recieves_Employee_Job( Employee_Job inst ) {
        R2_recieves_Employee_Job_set.remove(inst);
    }
    @Override
    public Employee_JobSet R2_recieves_Employee_Job() throws XtumlException {
        return R2_recieves_Employee_Job_set;
    }
    private PaymentSet R4_Payment_set;
    @Override
    public void addR4_Payment( Payment inst ) {
        R4_Payment_set.add(inst);
    }
    @Override
    public void removeR4_Payment( Payment inst ) {
        R4_Payment_set.remove(inst);
    }
    @Override
    public PaymentSet R4_Payment() throws XtumlException {
        return R4_Payment_set;
    }
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
    private OvertimeSet R6_Overtime_set;
    @Override
    public void addR6_Overtime( Overtime inst ) {
        R6_Overtime_set.add(inst);
    }
    @Override
    public void removeR6_Overtime( Overtime inst ) {
        R6_Overtime_set.remove(inst);
    }
    @Override
    public OvertimeSet R6_Overtime() throws XtumlException {
        return R6_Overtime_set;
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
    public Employee self() {
        return this;
    }

    @Override
    public Employee oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_EMPLOYEE;
    }

}

class EmptyEmployee extends ModelInstance<Employee,Hr> implements Employee {

    // attributes
    public String getFName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setFName( String m_FName ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getNational_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setNational_ID( int m_National_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setLName( String m_LName ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getLName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setStart_Date( Date m_Start_Date ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public Date getStart_Date() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee_LeaveSet R1_Employee_Leave() {
        return (new Employee_LeaveSetImpl());
    }
    @Override
    public Employee_JobSet R2_recieves_Employee_Job() {
        return (new Employee_JobSetImpl());
    }
    @Override
    public PaymentSet R4_Payment() {
        return (new PaymentSetImpl());
    }
    @Override
    public Bonus_PaymentSet R5_Bonus_Payment() {
        return (new Bonus_PaymentSetImpl());
    }
    @Override
    public OvertimeSet R6_Overtime() {
        return (new OvertimeSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return EmployeeImpl.KEY_LETTERS;
    }

    @Override
    public Employee self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Employee oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }

}
