package hrsystem.ui;


import hrsystem.UI;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;

import ui.shared.ICRUD;


public class UIApp extends Port<UI> implements ICRUD {

    public UIApp( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Employee_Read( final String p_FName,  final String p_LName,  final int p_National_ID ) throws XtumlException {
    }

    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        context().Reply( p_msg, p_state );
    }



    // outbound messages
    public void Payment() throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Payment());
        else {
        }
    }
    public void Grade( final int p_Value,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Grade(p_Value, p_Action));
        else {
        }
    }
    public void Employee( final String p_FName,  final String p_LName,  final int p_National_ID,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Employee(p_FName, p_LName, p_National_ID, p_Action));
        else {
        }
    }
    public void Overtime( final int p_Start,  final int p_End,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Overtime(p_Start, p_End, p_Action));
        else {
        }
    }
    public void Step( final int p_Value,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Step(p_Value, p_Action));
        else {
        }
    }
    public void Bonus( final String p_Name,  final int p_Amount,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Bonus(p_Name, p_Amount, p_Action));
        else {
        }
    }
    public void Leave( final String p_Name,  final int p_MaximumDays,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Leave(p_Name, p_MaximumDays, p_Action));
        else {
        }
    }
    public void Job( final int p_Step,  final int p_Grade,  final int p_Amount,  final String p_Action,  final String p_Name ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Job(p_Step, p_Grade, p_Amount, p_Action, p_Name));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case ICRUD.SIGNAL_NO_EMPLOYEE_READ:
                Employee_Read(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)));
                break;
            case ICRUD.SIGNAL_NO_REPLY:
                Reply(StringUtil.deserialize(message.get(0)), BooleanUtil.deserialize(message.get(1)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "App";
    }

}
