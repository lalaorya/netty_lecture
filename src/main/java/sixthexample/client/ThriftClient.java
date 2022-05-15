package sixthexample.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;
import thrift.BussinessException;
import thrift.Person;
import thrift.PersonService;

/**
 * @Author virtual
 * @Date 2022/4/27 10:40
 * @description：
 */
public class ThriftClient {

    public static void main(String[] args) throws TTransportException {
        TTransport transport = new TFramedTransport(new TSocket("localhost",8086),600);

        TCompactProtocol protocol = new TCompactProtocol(transport);

        PersonService.Client client = new PersonService.Client(protocol);

        try{
            transport.open();


            // 调用远程服务端的实现，但是写法好像是在客户端实现的，实际上是通过网络传输、序列化
            Person person = client.getgPerson("张三");
            System.out.println(person.getName());
            System.out.println(person.getAge());

            client.savePerson("李四",30);


        }catch (BussinessException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
//            transport.close();
        }


    }
}
