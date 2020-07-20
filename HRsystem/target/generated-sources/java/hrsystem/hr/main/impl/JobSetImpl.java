package hrsystem.hr.main.impl;


import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.StepSet;
import hrsystem.hr.main.impl.Employee_JobSetImpl;
import hrsystem.hr.main.impl.GradeSetImpl;
import hrsystem.hr.main.impl.StepSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.UniqueId;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class JobSetImpl extends InstanceSet<JobSet,Job> implements JobSet {

    public JobSetImpl() {
    }

    public JobSetImpl(Comparator<? super Job> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setAmount( double m_Amount ) throws XtumlException {
        for ( Job job : this ) job.setAmount( m_Amount );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Job job : this ) job.setName( m_Name );
    }
    @Override
    public void setJob_ID( UniqueId m_Job_ID ) throws XtumlException {
        for ( Job job : this ) job.setJob_ID( m_Job_ID );
    }


    // selections
    @Override
    public Employee_JobSet R2_earned_Employee_Job() throws XtumlException {
        Employee_JobSet employee_jobset = new Employee_JobSetImpl();
        for ( Job job : this ) employee_jobset.addAll( job.R2_earned_Employee_Job() );
        return employee_jobset;
    }
    @Override
    public GradeSet R3_Grade() throws XtumlException {
        GradeSet gradeset = new GradeSetImpl();
        for ( Job job : this ) gradeset.add( job.R3_Grade() );
        return gradeset;
    }
    @Override
    public StepSet R3_Step() throws XtumlException {
        StepSet stepset = new StepSetImpl();
        for ( Job job : this ) stepset.add( job.R3_Step() );
        return stepset;
    }


    @Override
    public Job nullElement() {
        return JobImpl.EMPTY_JOB;
    }

    @Override
    public JobSet emptySet() {
      return new JobSetImpl();
    }

    @Override
    public JobSet emptySet(Comparator<? super Job> comp) {
      return new JobSetImpl(comp);
    }

    @Override
    public List<Job> elements() {
        return Arrays.asList(toArray(new Job[0]));
    }

}
