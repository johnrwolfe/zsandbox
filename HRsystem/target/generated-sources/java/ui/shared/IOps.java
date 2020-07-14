package ui.shared;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;
import io.ciera.runtime.summit.types.TimeStamp;


public interface IOps {

    // to provider messages
    public static final int SIGNAL_NO_EMPLOYEE_BONUS = 1;
    public static class Employee_Bonus extends Message {
        public Employee_Bonus( final int p_National_ID,  final String p_Name ) {
            super(new Object[]{p_National_ID,  p_Name});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_EMPLOYEE_BONUS;
        }
 
    }
    public void Employee_Bonus( final int p_National_ID,  final String p_Name ) throws XtumlException;
    public static final int SIGNAL_NO_EMPLOYEE_COMMENCE = 2;
    public static class Employee_Commence extends Message {
        public Employee_Commence( final int p_National_ID ) {
            super(new Object[]{p_National_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_EMPLOYEE_COMMENCE;
        }
 
    }
    public void Employee_Commence( final int p_National_ID ) throws XtumlException;
    public static final int SIGNAL_NO_EMPLOYEE_JOB = 3;
    public static class Employee_Job extends Message {
        public Employee_Job( final int p_National_ID,  final String p_Name,  final int p_Job_ID ) {
            super(new Object[]{p_National_ID,  p_Name,  p_Job_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_EMPLOYEE_JOB;
        }
 
    }
    public void Employee_Job( final int p_National_ID,  final String p_Name,  final int p_Job_ID ) throws XtumlException;
    public static final int SIGNAL_NO_EMPLOYEE_PAYMENTS = 4;
    public static class Employee_Payments extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_EMPLOYEE_PAYMENTS;
        }
 
    }
    public void Employee_Payments() throws XtumlException;
    public static final int SIGNAL_NO_LEAVE_REQUEST = 5;
    public static class Leave_Request extends Message {
        public Leave_Request( final TimeStamp p_Starting,  final String p_Ending,  final int p_National_ID,  final String p_Name ) {
            super(new Object[]{p_Starting,  p_Ending,  p_National_ID,  p_Name});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_LEAVE_REQUEST;
        }
 
    }
    public void Leave_Request( final TimeStamp p_Starting,  final String p_Ending,  final int p_National_ID,  final String p_Name ) throws XtumlException;
    public static final int SIGNAL_NO_LEAVE_RETURN = 6;
    public static class Leave_Return extends Message {
        public Leave_Return( final int p_National_ID ) {
            super(new Object[]{p_National_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_LEAVE_RETURN;
        }
 
    }
    public void Leave_Return( final int p_National_ID ) throws XtumlException;


    // from provider messages


}
