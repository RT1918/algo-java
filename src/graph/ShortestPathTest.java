package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathTest {

    @Test
    public void dijkstra() {
        Node A = new Node();
        A.name = "A";
        Node B = new Node();
        B.name = "B";
        Node C = new Node();
        C.name = "C";
        Node D = new Node();
        D.name = "D";
        Node E = new Node();
        E.name = "E";
        Node F = new Node();
        F.name = "F";
        A.adjList.add(new Node.Edge(F, 20));
        A.adjList.add(new Node.Edge(B, 3));
        A.adjList.add(new Node.Edge(E, 2));
        B.adjList.add(new Node.Edge(A, 3));
        B.adjList.add(new Node.Edge(C, 3));
        B.adjList.add(new Node.Edge(F, 10));
        C.adjList.add(new Node.Edge(B, 3));
        C.adjList.add(new Node.Edge(D, 1));
        C.adjList.add(new Node.Edge(F, 1));
        D.adjList.add(new Node.Edge(C, 1));
        D.adjList.add(new Node.Edge(E, 2));
        D.adjList.add(new Node.Edge(F, 4));
        E.adjList.add(new Node.Edge(D, 2));
        E.adjList.add(new Node.Edge(A, 2));
        F.adjList.add(new Node.Edge(A, 20));
        F.adjList.add(new Node.Edge(B, 10));
        F.adjList.add(new Node.Edge(D, 4));
        F.adjList.add(new Node.Edge(C, 1));
        assertEquals(6, ShortestPath.dijkstra(A, F));
        assertEquals(6, ShortestPath.dijkstra(F, A));
        assertEquals(4, ShortestPath.dijkstra(F, E));
        assertEquals(4, ShortestPath.dijkstra(E, F));
        assertEquals(2, ShortestPath.dijkstra(D, F));
        assertEquals(2, ShortestPath.dijkstra(F, D));
        assertEquals(5, ShortestPath.dijkstra(A, C));
        assertEquals(5, ShortestPath.dijkstra(C, A));
    }

    @Test
    public void bellmanFord() {
        Node A = new Node();
        A.name = "A";
        Node B = new Node();
        B.name = "B";
        Node C = new Node();
        C.name = "C";
        Node D = new Node();
        D.name = "D";
        Node E = new Node();
        E.name = "E";
        Node F = new Node();
        F.name = "F";
        A.adjList.add(new Node.Edge(F, 20));
        A.adjList.add(new Node.Edge(B, 3));
        A.adjList.add(new Node.Edge(E, 2));
        B.adjList.add(new Node.Edge(A, 3));
        B.adjList.add(new Node.Edge(C, 3));
        B.adjList.add(new Node.Edge(F, 10));
        C.adjList.add(new Node.Edge(B, 3));
        C.adjList.add(new Node.Edge(D, 1));
        C.adjList.add(new Node.Edge(F, 1));
        D.adjList.add(new Node.Edge(C, 1));
        D.adjList.add(new Node.Edge(E, 2));
        D.adjList.add(new Node.Edge(F, 4));
        E.adjList.add(new Node.Edge(D, 2));
        E.adjList.add(new Node.Edge(A, 2));
        F.adjList.add(new Node.Edge(A, 20));
        F.adjList.add(new Node.Edge(B, 10));
        F.adjList.add(new Node.Edge(D, 4));
        F.adjList.add(new Node.Edge(C, 1));
        assertEquals(6, ShortestPath.bellmanFord(A, F));
        assertEquals(6, ShortestPath.bellmanFord(F, A));
        assertEquals(4, ShortestPath.bellmanFord(F, E));
        assertEquals(4, ShortestPath.bellmanFord(E, F));
        assertEquals(2, ShortestPath.bellmanFord(D, F));
        assertEquals(2, ShortestPath.bellmanFord(F, D));
        assertEquals(5, ShortestPath.bellmanFord(A, C));
        assertEquals(5, ShortestPath.bellmanFord(C, A));
    }

    @Test
    public void bellmanFordNegative() {
        Node A = new Node();
        A.name = "A";
        Node B = new Node();
        B.name = "B";
        Node C = new Node();
        C.name = "C";
        Node D = new Node();
        D.name = "D";
        Node E = new Node();
        E.name = "E";
        Node F = new Node();
        F.name = "F";
//        A.adjList.add(new Node.Edge(F, -20));
        A.adjList.add(new Node.Edge(B, 3));
        A.adjList.add(new Node.Edge(E, 2));
        B.adjList.add(new Node.Edge(A, 3));
        B.adjList.add(new Node.Edge(C, 3));
        B.adjList.add(new Node.Edge(F, 10));
        C.adjList.add(new Node.Edge(B, 3));
        C.adjList.add(new Node.Edge(D, -3));
        C.adjList.add(new Node.Edge(F, 1));
        D.adjList.add(new Node.Edge(C, 10));
        D.adjList.add(new Node.Edge(E, 2));
        D.adjList.add(new Node.Edge(F, 4));
        E.adjList.add(new Node.Edge(D, 2));
        E.adjList.add(new Node.Edge(A, 2));
//        F.adjList.add(new Node.Edge(A, -20));
        F.adjList.add(new Node.Edge(B, 10));
        F.adjList.add(new Node.Edge(D, 4));
        F.adjList.add(new Node.Edge(C, 1));
//        assertEquals(-1, MinimumPath.bellmanFord(A, F));
//        assertEquals(-1, MinimumPath.bellmanFord(F, A));
        assertEquals(3, ShortestPath.bellmanFord(A, D));
    }
}