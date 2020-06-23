package hrm.hr.main;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.InstMapping;


public class Employees extends InstMapping implements IXtumlType {

    public Employees() {
        super();
    }

    public Employees(Object value) throws XtumlException {
        super(value);
    }

    @SuppressWarnings("unchecked")
    public Employees promote(Object o) throws XtumlException {
        return new Employees(cast(o));
    }

}
