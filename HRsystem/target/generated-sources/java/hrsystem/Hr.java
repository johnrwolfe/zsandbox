package hrsystem;


import hrsystem.hr.HrUI;
import hrsystem.hr.HrUI_Leave;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.main.impl.Employee_LeaveImpl;
import hrsystem.hr.main.impl.Employee_LeaveSetImpl;
import hrsystem.hr.main.impl.LeaveImpl;
import hrsystem.hr.main.impl.LeaveSetImpl;

import io.ciera.runtime.summit.application.IApplication;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.classes.IRelationshipSet;
import io.ciera.runtime.summit.classes.Relationship;
import io.ciera.runtime.summit.classes.RelationshipSet;
import io.ciera.runtime.summit.components.Component;
import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.ModelIntegrityException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.util.LOG;
import io.ciera.runtime.summit.util.TIM;
import io.ciera.runtime.summit.util.impl.LOGImpl;
import io.ciera.runtime.summit.util.impl.TIMImpl;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class Hr extends Component<Hr> {

    private Map<String, Class<?>> classDirectory;

    public Hr(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);
        Employee_extent = new EmployeeSetImpl();
        Employee_Leave_extent = new Employee_LeaveSetImpl();
        Leave_extent = new LeaveSetImpl();
        R1_Employee_Leave_Employee_extent = new RelationshipSet();
        R1_Employee_Leave_Leave_extent = new RelationshipSet();
        TIM = null;
        LOG = null;
        classDirectory = new TreeMap<>();
        classDirectory.put("EM", EmployeeImpl.class);
        classDirectory.put("Employee_Leave", Employee_LeaveImpl.class);
        classDirectory.put("Leave", LeaveImpl.class);
    }

    // domain functions


    // relates and unrelates
    public void relate_R1_Employee_Leave_Employee( Employee_Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_Employee_Leave_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_Employee_Leave(form);
            form.setR1_Employee(part);
            form.setNational_ID( part.getNational_ID() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_Employee_Leave_Employee( Employee_Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_Employee_Leave_Employee_extent.remove( R1_Employee_Leave_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_Employee_Leave(form);
            form.setR1_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R1_Employee_Leave_Leave( Employee_Leave form, Leave part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_Employee_Leave_Leave_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_Employee_Leave(form);
            form.setR1_Leave(part);
            form.setLeave_ID( part.getLeave_ID() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_Employee_Leave_Leave( Employee_Leave form, Leave part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_Employee_Leave_Leave_extent.remove( R1_Employee_Leave_Leave_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_Employee_Leave(form);
            form.setR1_Leave(LeaveImpl.EMPTY_LEAVE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }


    // instance selections
    private Employee_LeaveSet Employee_Leave_extent;
    public Employee_LeaveSet Employee_Leave_instances() {
        return Employee_Leave_extent;
    }
    private EmployeeSet Employee_extent;
    public EmployeeSet Employee_instances() {
        return Employee_extent;
    }
    private LeaveSet Leave_extent;
    public LeaveSet Leave_instances() {
        return Leave_extent;
    }


    // relationship selections
    private IRelationshipSet R1_Employee_Leave_Employee_extent;
    public IRelationshipSet R1_Employee_Leave_Employees() throws XtumlException {
        return R1_Employee_Leave_Employee_extent;
    }
    private IRelationshipSet R1_Employee_Leave_Leave_extent;
    public IRelationshipSet R1_Employee_Leave_Leaves() throws XtumlException {
        return R1_Employee_Leave_Leave_extent;
    }


    // ports
    private HrUI HrUI;
    public HrUI UI() {
        if ( null == HrUI ) HrUI = new HrUI( this, null );
        return HrUI;
    }
    private HrUI_Leave HrUI_Leave;
    public HrUI_Leave UI_Leave() {
        if ( null == HrUI_Leave ) HrUI_Leave = new HrUI_Leave( this, null );
        return HrUI_Leave;
    }


    // utilities
    private TIM TIM;
    public TIM TIM() {
        if ( null == TIM ) TIM = new TIMImpl<>( this );
        return TIM;
    }
    private LOG LOG;
    public LOG LOG() {
        if ( null == LOG ) LOG = new LOGImpl<>( this );
        return LOG;
    }


    // component initialization function
    @Override
    public void initialize() throws XtumlException {

    }

    @Override
    public String getVersion() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("HrProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version", "Unknown");
    }
    @Override
    public String getVersionDate() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("HrProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version_date", "Unknown");
    }

    @Override
    public boolean addInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot add empty instance to population." );
        if ( instance instanceof Employee ) return Employee_extent.add( (Employee)instance );
        else if ( instance instanceof Employee_Leave ) return Employee_Leave_extent.add( (Employee_Leave)instance );
        else if ( instance instanceof Leave ) return Leave_extent.add( (Leave)instance );
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof Employee ) return Employee_extent.remove( (Employee)instance );
        else if ( instance instanceof Employee_Leave ) return Employee_Leave_extent.remove( (Employee_Leave)instance );
        else if ( instance instanceof Leave ) return Leave_extent.remove( (Leave)instance );
        return false;
    }

    @Override
    public Hr context() {
        return this;
    }

    @Override
    public Class<?> getClassByKeyLetters(String keyLetters) {
        return classDirectory.get(keyLetters);
    }

}
