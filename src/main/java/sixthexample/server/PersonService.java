package sixthexample.server;

import org.apache.thrift.TException;
import thrift.BussinessException;
import thrift.Person;

/**
 * @Author virtual
 * @Date 2022/4/27 10:24
 * @description£º
 */
public interface PersonService {

    public Person getgPerson(String name)throws BussinessException, TException;

    public void savePerson(String name,int age)throws BussinessException, TException;
}
