package hrsystem.ui;


import hrsystem.UI;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.TimeStamp;

import ui.shared.IOps;


public class UIApp_Ops extends Port<UI> implements IOps {

    public UIApp_Ops( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages


    // outbound messages
    public void Employee_Job( final int p_National_ID,  final String p_Name,  final int p_Job_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Employee_Job(p_National_ID, p_Name, p_Job_ID));
        else {
        }
    }
    public void Leave_Return( final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Leave_Return(p_National_ID));
        else {
        }
    }
    public void Employee_Commence( final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Employee_Commence(p_National_ID));
        else {
        }
    }
    public void Employee_Payments() throws XtumlException {
        if ( satisfied() ) send(new IOps.Employee_Payments());
        else {
        }
    }
    public void Employee_Bonus( final int p_National_ID,  final String p_Name ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Employee_Bonus(p_National_ID, p_Name));
        else {
        }
    }
    public void Leave_Request( final TimeStamp p_Starting,  final String p_Ending,  final int p_National_ID,  final String p_Name ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Leave_Request(p_Starting, p_Ending, p_National_ID, p_Name));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "App_Ops";
    }

}
