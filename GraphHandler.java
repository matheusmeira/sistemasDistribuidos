import org.apache.thrift.TException;

import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import graph.*;

public class GraphHandler implements Operations.Iface {

    private Graph graph = new Graph(new ArrayList<Vertex>(), new ArrayList<Edge>());

    public boolean newVertex(int name, int color, double weight, String desc) {
        Vertex newVertexToGraph = new Vertex();

        if ( newVertexToGraph == null ) return false;

        if (graph.getA().isEmpty()) {
            newVertexToGraph.name = name;
            newVertexToGraph.color = color;
            newVertexToGraph.weight = weight;
            newVertexToGraph.desc = desc;

            graph.addToV(newVertexToGraph);
        } else {
            for ( Vertex vertexAux: graph.getV() ) {
                if ( vertexAux.name == name ) {
                    return false;
                }
            }

            newVertexToGraph.name = name;
            newVertexToGraph.color = color;
            newVertexToGraph.weight = weight;
            newVertexToGraph.desc = desc;

            graph.addToV(newVertexToGraph);
        }
        return true; // TODO
    }

    public boolean newEdge(int v1, int v2, double weight, int flag, String desc) {
        return true; // TODO
    }

    public boolean removeVertex(int name) {
        return true; // TODO
    }

    public boolean removeEdge(int v1, int v2) {
        return true; // TODO
    }

    public boolean updateVertex(Vertex v, int name) {
        return true; // TODO
    }

    public boolean updateEdge(Edge a, int v1, int v2) {
        return true; // TODO
    }

    public Edge getEdge(int v1, int v2) {
        for (Edge edgeAux: graph.getA()) {
            if (edgeAux.v1 == v1 && edgeAux.v2 == v2) {
                System.out.println( "Aresta formada pelos verices: (" + edgeAux.v1 + ")");
                return edgeAux;
            }
        }
        return null;
    }

    public Vertex getVertex(int name) {
        for (Vertex vertexAux: graph.getV()) {
            if (vertexAux.name == name) {
                System.out.println( "Vertice de nome: " + vertexAux.name );
                return vertexAux;
            }
        }
        return null;
    }

    public String viewGraph() {
        String graphInformation = "Grafo: \n";
        graphInformation = graphInformation + listVertex();
        graphInformation = graphInformation + listEdge();
        return graphInformation;
    }

    public String listVertex() {
        String listCompleteOfVertex = "vértices: \n";

        for (Vertex vertexAux: graph.getV()) {
            listCompleteOfVertex = listCompleteOfVertex + "Nome: " + vertexAux.name + ", " +
                                                            "Cor: " + vertexAux.color + ", " +
                                                            "Peso: " + vertexAux.weight + ", " +
                                                            "Descrição: " + vertexAux.desc + "\n";
        }
        return listCompleteOfVertex;
    }

    public String listEdge() {
        String listCompleteOfEdge = "Arestas: \n";

        for (Edge edgeAux: graph.getA()) {
            listCompleteOfEdge = listCompleteOfEdge + "V1: " + edgeAux.v1 + ", " +
                                                    "V2: " + edgeAux.v2 + ", " +
                                                    "Flag: " + edgeAux.flag + ", " +
                                                    "Peso: " + edgeAux.weight + ", " +
                                                    "Descrição: " + edgeAux.desc + "\n";
        }
        return listCompleteOfEdge;
    }

    public String ListEdgeInVertex(int nameVertex) {
        String listOfEdgeOfAVertex = "As Arestas de um vertice: " + nameVertex + " são: \n";

        for ( Edge edgeAux: graph.getA() ) {
            if ( edgeAux.v1 == nameVertex || edgeAux.v2 == nameVertex) {
                listOfEdgeOfAVertex = listOfEdgeOfAVertex + "V1: " + edgeAux.v1 + ", " +
                                                        "V2: " + edgeAux.v2 + ", " +
                                                        "Flag: " + edgeAux.flag + ", " +
                                                        "Peso: " + edgeAux.weight + ", " +
                                                        "Descrição: " + edgeAux.desc + "\n";
            }
        }
        return listOfEdgeOfAVertex;
    }

    public String ListVertexInEdge(int v1, int v2) {
        String vertexInEdge = "Vertices";
        return vertexInEdge;
    }

    public String listNeighboringVertex(int nameVertex) {
        String listOfNeighboring = "Os vértices vizinhos de : " + nameVertex + " são: \n";

        for ( Edge edgeAux: graph.getA() ){
            if ( edgeAux.v1 == nameVertex ) {
                Vertex v = getVertex(edgeAux.v2);
                listOfNeighboring = listOfNeighboring + "Nome: " + v.name + ", " +
                                                        "Cor: " + v.color + ", " +
                                                        "Peso: " + v.weight + ", " +
                                                        "Descrição: " + v.desc + "\n";
            } else if ( edgeAux.v2 == nameVertex ) {
                Vertex v = getVertex(edgeAux.v1);
                listOfNeighboring = listOfNeighboring + "Nome: " + v.name + ", " +
                                                        "Cor: " + v.color + ", " +
                                                        "Peso: " + v.weight + ", " +
                                                        "Descrição: " + v.desc + "\n";
            }
        }
        return listOfNeighboring;
    }
}