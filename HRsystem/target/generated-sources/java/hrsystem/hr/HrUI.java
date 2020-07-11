package hrsystem.hr;


import hrsystem.Hr;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.LeaveImpl;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;

import ui.shared.ICRUD;


public class HrUI extends Port<Hr> implements ICRUD {

    public HrUI( Hr context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Step( final int p_Value,  final String p_Action ) throws XtumlException {
    }

    public void Payment() throws XtumlException {
    }

    public void Job( final int p_Step,  final int p_Grade,  final int p_Amount,  final String p_Action,  final String p_Name ) throws XtumlException {
    }

    public void Bonus( final String p_Name,  final int p_Amount,  final String p_Action ) throws XtumlException {
    }

    public void Grade( final int p_Value,  final String p_Action ) throws XtumlException {
    }

    public void Leave( final String p_Name,  final int p_MaximumDays,  final String p_Action ) throws XtumlException {
        new LeaveImpl.CLASS(context()).crudLeave( p_Name, p_MaximumDays, p_Action );
    }

    public void Employee( final String p_FName,  final String p_LName,  final int p_National_ID,  final String p_Action ) throws XtumlException {
        new EmployeeImpl.CLASS(context()).crudEmployee( p_FName, p_LName, p_National_ID, p_Action );
    }

    public void Overtime( final int p_Start,  final int p_End,  final String p_Action ) throws XtumlException {
    }



    // outbound messages
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Reply(p_msg, p_state));
        else {
        }
    }
    public void Employee_Read( final String p_FName,  final String p_LName,  final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Employee_Read(p_FName, p_LName, p_National_ID));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case ICRUD.SIGNAL_NO_STEP:
                Step(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
            case ICRUD.SIGNAL_NO_PAYMENT:
                Payment();
                break;
            case ICRUD.SIGNAL_NO_JOB:
                Job(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)));
                break;
            case ICRUD.SIGNAL_NO_BONUS:
                Bonus(StringUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
            case ICRUD.SIGNAL_NO_GRADE:
                Grade(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
            case ICRUD.SIGNAL_NO_LEAVE:
                Leave(StringUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
            case ICRUD.SIGNAL_NO_EMPLOYEE:
                Employee(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)));
                break;
            case ICRUD.SIGNAL_NO_OVERTIME:
                Overtime(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
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
