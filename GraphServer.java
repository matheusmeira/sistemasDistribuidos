import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;

import graph.*;
import java.util.HashMap;

public class GraphServer
{
    //versão multi-thread
    public static void main(String [] args){
        try {
            TServerSocket serverTransport = new TServerSocket(9000);
            GraphHandler handler = new GraphHandler();
            graph.Operations.Processor processor = new graph.Operations.Processor(handler);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Servidor conectado com sucesso!");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}