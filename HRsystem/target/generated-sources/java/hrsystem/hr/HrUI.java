package hrsystem.hr;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.impl.EmployeeImpl;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;

import ui.shared.IEP;


public class HrUI extends Port<Hr> implements IEP {

    public HrUI( Hr context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Start( final int p_National_ID ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNational_ID() == p_National_ID);
        if ( !employee.isEmpty() ) {
            context().generate(new EmployeeImpl.commencedRcvd(getRunContext(), context().getId()).to(employee));
            context().UI().Reply( "Employee has commenced ", true );
        }
        else {
            context().LOG().LogInfo( "Employee is not registered!" );
            context().UI().Reply( "Employee is not found.", false );
        }
    }

    public void New( final String p_FName,  final String p_LName,  final int p_National_ID ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ( StringUtil.equality( ((Employee)selected).getFName(), p_FName ) && StringUtil.equality( ((Employee)selected).getLName(), p_LName ) ) && ((Employee)selected).getNational_ID() == p_National_ID);
        if ( employee.isEmpty() ) {
            Employee repeater = EmployeeImpl.create( context() );
            context().generate(new EmployeeImpl.newEmployeeRcvd(getRunContext(), context().getId(),  p_FName, p_National_ID, p_LName ).to(employee));
            context().UI().Reply( "Employee added successfully.", true );
        }
        else {
            context().LOG().LogInfo( "Employee already exists!" );
            context().UI().Reply( "Employee already exists", false );
        }
    }



    // outbound messages
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new IEP.Reply(p_msg, p_state));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IEP.SIGNAL_NO_START:
                Start(IntegerUtil.deserialize(message.get(0)));
                break;
            case IEP.SIGNAL_NO_NEW:
                New(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "UI";
    }

}
