package hrsystem;


import hrsystem.hr.HrUI;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.EmployeeSetImpl;

import io.ciera.runtime.summit.application.IApplication;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.components.Component;
import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.util.LOG;
import io.ciera.runtime.summit.util.impl.LOGImpl;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class Hr extends Component<Hr> {

    private Map<String, Class<?>> classDirectory;

    public Hr(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);
        Employee_extent = new EmployeeSetImpl();

        LOG = null;
        classDirectory = new TreeMap<>();
        classDirectory.put("Employee", EmployeeImpl.class);
    }

    // domain functions


    // relates and unrelates


    // instance selections
    private EmployeeSet Employee_extent;
    public EmployeeSet Employee_instances() {
        return Employee_extent;
    }


    // relationship selections


    // ports
    private HrUI HrUI;
    public HrUI UI() {
        if ( null == HrUI ) HrUI = new HrUI( this, null );
        return HrUI;
    }


    // utilities
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
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof Employee ) return Employee_extent.remove( (Employee)instance );
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
