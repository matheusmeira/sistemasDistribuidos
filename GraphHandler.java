import org.apache.thrift.TException;

import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import graph.*;

public class GraphHandler implements Operations.Iface {

    private Graph graph = initialHandler();

    public boolean newVertex(int name, int color, double weight, String desc) {
        Vertex newVertexToGraph = new Vertex();

        if ( newVertexToGraph == null ) return false;

        if (graph.getA().isEmpty()) {
            newVertexToGraph.name = name;
            newVertexToGraph.color = color;
            newVertexToGraph.weight = weight;
            newVertexToGraph.desc = desc;

            graph.addToV(newVertexToGraph);
            saveGraph("dataBase");
        } else {
            synchronized(graph.getV()) {
                for ( Vertex vertexAux: graph.getV() ) {
                    if ( vertexAux.name == name ) {
                        return false;
                    }
                }
            }

            newVertexToGraph.name = name;
            newVertexToGraph.color = color;
            newVertexToGraph.weight = weight;
            newVertexToGraph.desc = desc;

            graph.addToV(newVertexToGraph);
            saveGraph("dataBase");
        }
        return true;
    }

    public boolean newEdge(int v1, int v2, double weight, int flag, String desc) {
        int cont = 0;
        for ( Edge edgeAux: graph.getA() ) {
            if ( edgeAux.v1 == v1 && edgeAux.v2 == v2 ) return false; 
        }

        for ( Vertex vertexAux: graph.getV() ) {
            if ( vertexAux.name == v1 || vertexAux.name == v2 ) cont++;
        }

        if (cont != 2) {
            return false;
        } else {
            if (flag == 2) {
                graph.addToA(new Edge(v2, v1, weight, desc, flag));
                saveGraph("dataBase");
            } else {
                graph.addToA(new Edge(v1, v2, weight, desc, flag));
                saveGraph("dataBase");
            }
        }
        return true;
    }

    public boolean removeVertex(int name) {
        for ( Vertex v : graph.getV() ) {
            synchronized(v) {
                if (v.name == name) {
                    for ( Edge e : graph.getA() ) {
                        synchronized(e) {
                            if (e.v1 == name || e.v2 == name) graph.getA().remove(e);
                        }
                    }
                    graph.getV().remove(v);
                    saveGraph("dataBase");                    
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean removeEdge(int v1, int v2) {
        for ( Edge e : graph.getA() ) {
            synchronized(e) {
                if (e.v1 == v1 && e.v2 == v2) {
                    graph.getA().remove(e);
                    saveGraph("dataBase");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean updateVertex(Vertex v, int name) {
        if (v == null || v.name != name) return false;
        
        for ( Vertex vertexAux : graph.getV() ) {
            if (vertexAux.name == name) {
                vertexAux.desc = v.desc;
                vertexAux.color = v.color;
                vertexAux.weight = v.weight;
                saveGraph("dataBase");
                return true;         
            }
        }
        return false;
    }

    public boolean updateEdge(Edge a, int v1, int v2) {
        if (a == null || a.v1 != v1 || a.v2 != v2) return false;

        for (Edge edgeAux: graph.getA()) {
            if (edgeAux.v1 == v1 && edgeAux.v2 == v2) {
                edgeAux.desc = a.desc;
                edgeAux.weight = a.weight;
                if (a.flag == 2 && edgeAux.flag != 2) {
                    edgeAux.v1 = v2;
                    edgeAux.v2 = v1;
                }
                saveGraph("dataBase");
                return true;
            }
        }
        return false;
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

    private Graph initialHandler() {
        Graph graph = readGraph("dataBase");
        if (graph.getV().isEmpty()) {
            return new Graph(new ArrayList<Vertex>(), new ArrayList<Edge>());
        }
        return graph;
    }

    public synchronized void saveGraph(String filePath) {
        try {
            FileOutputStream saveFile = new FileOutputStream("./" + filePath);
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);
            stream.writeObject((Object)graph);
            stream.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public synchronized Graph readGraph(String filePath) {
        Object obj = null;
        try {
            FileInputStream readFile = new FileInputStream("./" + filePath);
            ObjectInputStream stream = new ObjectInputStream(readFile);
            obj = stream.readObject();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(obj == null) {
            return new Graph(new ArrayList<Vertex>(), new ArrayList<Edge>());
        }
        return (Graph)obj;
    }
}