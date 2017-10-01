namespace java graph

exception EdgeNotFound
{

}
exception VertexNotFound
{

}

struct Vertex
{
	1:i32 name,
	2:i32 color,
	3:string desc,
	4:double weight
}
struct Edge
{
	1:i32 v1,
	2:i32 v2,
	3:double weight,
	4:string desc,
	5:i32 flag
}
struct Graph
{
	1:list<Vertex> v,
	2:list<Edge> a
}

service Operations
{
	bool newVertex (1:i32 name,2:i32 color, 3:double weight, 4:string desc),
	bool newEdge(1:i32 v1,2:i32 v2, 3:double weight, 4:i32 flag, 5:string desc),
	bool removeVertex(1:i32 name),
	bool removeEdge(1:i32 v1,2:i32 v2),
	bool updateVertex(1:Vertex v,2:i32 name),
	bool updateEdge(1:Edge a,2:i32 v1,3:i32 v2),

	string viewGraph (),
	string listVertex(),
	string listEdge(),

	string ListEdgeInVertex(1:i32 name),
	string ListVertexInEdge(1:i32 v1, 2:i32 v2),
	string listNeighboringVertex(1:i32 name),

	Vertex getVertex(1:i32 name),
	Edge getEdge(1:i32 v1,2:i32 v2)
 }
