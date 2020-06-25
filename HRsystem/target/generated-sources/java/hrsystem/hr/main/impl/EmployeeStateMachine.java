package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;

import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.ITransition;
import io.ciera.runtime.summit.statemachine.StateMachine;


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
    }

    private void Working_entry_action() throws XtumlException {
        context().TIM().current_date();
        context().LOG().LogInfo( "New employee has commenced" );
    }



    @Override
    public ITransition[][] getStateEventMatrix() {
        return new ITransition[][] {
            { CANT_HAPPEN,
              (event) -> {Working_entry_action(); return Working;}
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
