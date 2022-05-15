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
 * @description��ʹ��rpc���thriftʵ��Զ�̵���
 */
public class ThriftServer {
    public static void main(String[] args) throws Exception{
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8086);
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        // thrift�����service
        // ���ʹ�������ʵ����
        PersonService.Processor<PersonServiceImpl> personServiceProcessor = new PersonService.Processor<>(new PersonServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(personServiceProcessor));

        THsHaServer server = new THsHaServer(arg);

        System.out.println("Server started!!");
        // ��ѭ��
        server.serve();


    }

}
