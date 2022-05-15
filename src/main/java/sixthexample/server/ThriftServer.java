package sixthexample.server;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportFactory;
import org.apache.thrift.transport.layered.TFramedTransport;
import thrift.PersonService;

/**
 * @Author virtual
 * @Date 2022/4/27 10:30
 * @description：使用rpc框架thrift实现远程调用
 */
public class ThriftServer {
    public static void main(String[] args) throws Exception{
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8086);
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        // thrift构造的service
        // 泛型传入真正实现类
        PersonService.Processor<PersonServiceImpl> personServiceProcessor = new PersonService.Processor<>(new PersonServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(personServiceProcessor));

        THsHaServer server = new THsHaServer(arg);

        System.out.println("Server started!!");
        // 死循环
        server.serve();


    }

}
