package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;

import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.ITransition;
import io.ciera.runtime.summit.statemachine.StateMachine;
import io.ciera.runtime.summit.types.Date;


public class EmployeeStateMachine extends StateMachine<Employee,Hr> {

    public static final int Recruited = 0;
    public static final int Working = 1;


    private Employee self;

    public EmployeeStateMachine(Employee self, Hr context) {
        this(self, context, Recruited);
    }

    public EmployeeStateMachine(Employee self, Hr context, int initialState) {
        super(context, initialState);
        this.self = self;
    }

    private void Recruited_entry_action() throws XtumlException {
        String FName = p_FName;
        String LName = p_LName;
        int National_ID = p_National_ID;
        Date Birth_Date = p_Birth_Date;
        context().LOG().LogInfo( ( "A new employee is added to the system:" + FName ) + LName );
    }

    private void Working_entry_action( final Date p_date ) throws XtumlException {
        Date Start_Date = p_date;
        context().LOG().LogInfo( "New employee has commenced" );
    }



    @Override
    public ITransition[][] getStateEventMatrix() {
        return new ITransition[][] {
            { (event) -> {Working_entry_action((Date)event.get(0)); return Working;},
              CANT_HAPPEN
            },
            { CANT_HAPPEN,
              CANT_HAPPEN
            }
        };
    }

    @Override
    public Employee self() {
        return self;
    }

    @Override
    public String getClassName() {
        return "Employee";
    }

}
