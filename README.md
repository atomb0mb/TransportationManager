This project involves
  
1. Vertex/Vertices
2. Edge/Edges
3. Adjacent list
4. Disjoint-set/Union
5. Heaps/Priority Queues
6. Acyclic undirected graph
7. Kruskal algorithm

Steps to find the minimum cost of connected highway (From Destination A to Destination B)

1. Find all weighted edges (Find all vertices and caculate the weighted edge)
2. Store all weighted edges Priority Queues (Minimum spanning tree)
3. Dequeue the Priority Queues (The first will be the smallest or cheapest connection)
4. Unions or subset the edges that did not have similar parent vertex or node. (To avoid cycle)
5. Repeat untill the edges are connected to from destination A to destination B.
