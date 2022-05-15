package sixthexample.server;

import org.apache.thrift.TException;
import sixthexample.server.PersonService;
import thrift.BussinessException;
import thrift.Person;

/**
 * @Author virtual
 * @Date 2022/4/27 10:23
 * @description£º
 */
public class PersonServiceImpl implements PersonService, thrift.PersonService.Iface {
    @Override
    public Person getgPerson(String name) throws BussinessException, TException {
        System.out.println("client invest get:");
        Person person = new Person();
        person.setName(name);
        person.setAge(20);

        return person;
    }


    @Override
    public void savePerson(String name, int age) throws BussinessException,TException {
        System.out.println("client invest save:");
        System.out.println(name);
        System.out.println(age);

    }
}
