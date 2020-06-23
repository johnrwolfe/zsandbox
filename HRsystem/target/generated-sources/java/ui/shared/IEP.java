package ui.shared;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;
import io.ciera.runtime.summit.types.Date;


public interface IEP {

    // to provider messages
    public static final int SIGNAL_NO_NEW = 1;
    public static class New extends Message {
        public New( final String p_FName,  final String p_LName,  final int p_National_ID,  final Date p_Birth_Date ) {
            super(new Object[]{p_FName,  p_LName,  p_National_ID,  p_Birth_Date});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_NEW;
        }
 
    }
    public void New( final String p_FName,  final String p_LName,  final int p_National_ID,  final Date p_Birth_Date ) throws XtumlException;
    public static final int SIGNAL_NO_START = 3;
    public static class Start extends Message {
        public Start( final Date p_date,  final int p_National_ID ) {
            super(new Object[]{p_date,  p_National_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_START;
        }
 
    }
    public void Start( final Date p_date,  final int p_National_ID ) throws XtumlException;


    // from provider messages
    public static final int SIGNAL_NO_REPLY = 2;
    public static class Reply extends Message {
        public Reply( final String p_msg,  final boolean p_state ) {
            super(new Object[]{p_msg,  p_state});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_REPLY;
        }
 
    }
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException;


}
