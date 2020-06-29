package hrsystem.ui;


import hrsystem.UI;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.Date;

import ui.shared.ILeave;


public class UIApp_Leave extends Port<UI> implements ILeave {

    public UIApp_Leave( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages


    // outbound messages
    public void New_Leave( final String p_Name,  final int p_NumberOfAllowedDays ) throws XtumlException {
        if ( satisfied() ) send(new ILeave.New_Leave(p_Name, p_NumberOfAllowedDays));
        else {
        }
    }
    public void Request( final Date p_Starting,  final Date p_Ending,  final int p_National_ID,  final String p_Name ) throws XtumlException {
        if ( satisfied() ) send(new ILeave.Request(p_Starting, p_Ending, p_National_ID, p_Name));
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
        return "App_Leave";
    }

}
