import graph.*;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TBinaryProtocol;
import java.util.Scanner;

public class GraphClient
{
    public static void main(String [] args)
    {
        try {
            TTransport transport = new TSocket("localhost",9000);
            transport.open();


            TProtocol protocol = new TBinaryProtocol(transport);

            Operations.Client client = new Operations.Client ( protocol ) ;

            int op = 0;
            Scanner readKey = new Scanner(System.in);
            while(op != 15)
            {
                op = 0;
                System.out.println("Bem-Vindo ao cliente do Grafos Server");
                System.out.println("O que você deseja fazer?");
                System.out.println("1 - Inserir vértice");
                System.out.println("2 - Inserir Edge");
                System.out.println("3 - Deletar vértice");
                System.out.println("4 - Deletar Edge");
                System.out.println("5 - Atualizar vértice");
                System.out.println("6 - Atualizar Edge");
                System.out.println("7 - Exibir Grafo");
                System.out.println("8 - Exibir Vértices");
                System.out.println("9 - Exibir Edges");
                System.out.println("10 - Exibir Edges de um vértice");
                System.out.println("11 - Exibir vértices de uma aresta");
                System.out.println("12 - Exibir Vizinhança");
                System.out.println("0 - Encerrar");
                op = readKey.nextInt();
                switch(op){
                    case 1:
                        Vertex vertex = new Vertex();
                        System.out.println("Nome do vértice: ");
                        vertex.name = readKey.nextInt();
                        System.out.println("Peso: ");
                        vertex.weight = readKey.nextDouble();
                        System.out.println("Descrição: ");
                        readKey.nextLine();
                        vertex.desc = readKey.nextLine();
                        vertex.color = 1;
                        if(!client.newVertex(vertex.name,vertex.color,vertex.weight,vertex.desc))
                            System.out.println("Ocorreu algum erro ao inserir seu vértice, tente novamente!");
                        else
                            System.out.println("vértice inserido com sucesso!");
                        System.out.println("Tecle enter");
                        readKey.nextLine();
                        break;
                    case 2:
                        Edge edge = new Edge();
                        System.out.println("Primeiro Vértice: ");
                        edge.v1 = readKey.nextInt();
                        System.out.println("Segundo Vértice: ");
                        edge.v2 = readKey.nextInt();
                        System.out.println("Peso: ");
                        edge.weight = readKey.nextDouble();
                        System.out.println("Descrição: ");
                        readKey.nextLine();
                        edge.desc = readKey.nextLine();
                        System.out.println("1 - Direcionado(Do primeiro para o segundo), 2 - Bidirecionado");
                        edge.flag = readKey.nextInt();
                        if(!client.newEdge(edge.v1,edge.v2,edge.weight,edge.flag,edge.desc))
                            System.out.println("Ocorreu algum erro ao inserir sua aresta, tente novamente!");
                        else
                            System.out.println("Edge inserida com sucesso!");
                        System.out.println("Tecle enter");
                        readKey.nextLine();
                        break;
                    case 3:
                        int del;
                        System.out.println(client.listVertex());
                        System.out.println("Digite o nome do vertice que deseja deletar: ");
                        del = readKey.nextInt();
                        if(!client.removeVertex(del))
                            System.out.println("Impossível encontrar o elemento desejado!!!");
                        else
                            System.out.println("Elemento removido com sucesso!");
                        break;
                    case 4:
                        int del2;
                        int del1;
                        System.out.println(client.listEdge());
                        System.out.println("Digite os vertices da aresta que deseja deletar: ");
                        del1 = readKey.nextInt();
                        del2 = readKey.nextInt();
                        if(!client.removeEdge(del1,del2))
                            System.out.println("Impossível encontrar o elemento desejado!!!");
                        else
                            System.out.println("Elemento removido com sucesso!");
                        break;
                    case 5:
                        System.out.println(client.listVertex());
                        Vertex vertexUpdate = new Vertex();
                        System.out.println("Digite o nome do vértice que será atualizado: ");
                        vertexUpdate.name = readKey.nextInt();
                        System.out.println("Peso: ");
                        vertexUpdate.weight = readKey.nextDouble();
                        System.out.println("Descrição: ");
                        readKey.nextLine();
                        vertexUpdate.desc = readKey.nextLine();
                        vertexUpdate.color = 1;
                        if(!client.updateVertex(vertexUpdate,vertexUpdate.name))
                            System.out.println("Falha ao realizar atualização, vertice não encontrado!");
                        else
                            System.out.println("Atualizado com sucesso");
                        System.out.println("Tecle enter");
                        readKey.nextLine();
                        break;
                    case 6:
                        Edge edgeUpdate = new Edge();
                        System.out.println("Primeiro Vértice da aresta que será modificada: ");
                        edgeUpdate.v1 = readKey.nextInt();
                        System.out.println("Segundo Vértice da aresta que será modificada:: ");
                        edgeUpdate.v2 = readKey.nextInt();
                        System.out.println("Peso: ");
                        edgeUpdate.weight = readKey.nextDouble();
                        System.out.println("Descrição: ");
                        readKey.nextLine();
                        edgeUpdate.desc = readKey.nextLine();
                        System.out.println("1 - Direcionado(Do primeiro para o segundo), 2 - Bidirecionado");
                        edgeUpdate.flag = readKey.nextInt();
                        if(!client.updateEdge(edgeUpdate,edgeUpdate.v1,edgeUpdate.v2))
                            System.out.println("Falha ao realizar atualização, aresta não encontrada!");
                        else
                            System.out.println("Atualizado com sucesso");
                        System.out.println("Tecle enter");
                        readKey.nextLine();
                        System.out.println(client.listEdge());
                        break;
                    case 7:
                        System.out.println(client.viewGraph());
                        try {
                            Thread.sleep(5000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        break;
                    case 8:
                        System.out.println(client.listVertex());
                        try {
                            Thread.sleep(5000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        break;
                    case 9:
                        System.out.println(client.listEdge());
                        try {
                            Thread.sleep(5000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        break;
                    case 10:
                        System.out.println("Digite o nome do vértice: ");
                        int vertexInEdge = readKey.nextInt();
                        System.out.println(client.ListEdgeInVertex(vertexInEdge));
                        break;
                    case 11:
                        System.out.println("Digite o nome do vértice1: ");
                        int vertex1 = readKey.nextInt();
                        System.out.println("Digite o nome do vértice2: ");
                        int vertex2 = readKey.nextInt();
                        System.out.println(client.ListVertexInEdge(vertex1,vertex2));
                        break;
                    case 12:
                        System.out.println("Digite o vértice que deseja conferir os vizinhos: ");
                        int neighboringVertex = readKey.nextInt();
                        System.out.println(client.listNeighboringVertex(neighboringVertex));
                        try {
                            Thread.sleep(5000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        break;
                    case 0:
                        System.out.println("Falow");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            }
            transport.close();
        }catch (TException x){
            x.printStackTrace();
        }
    }

}