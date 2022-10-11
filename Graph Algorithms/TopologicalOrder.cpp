/*
Topological ordering => 
    an ordering of each nodes in a directed graph where for each directed edge
    from node A to node B, node A appears before the node B in the ordering

Topological Sort => 
    Algorithm to find a topological ordering in O(V + E) time.
    Topological ordering is not unique

ONLY DIRECTED ACYCLIC GRAPHS ONLY HAVE A VALID TOPOLOGICAL ORDERING
*/

#include<bits/stdc++.h>

using namespace std;

stack<int> topoOrder;
vector<bool> visited;

void topologicalSort(vector<int> graph[], int src){

    visited[src] = true;
    for (int neighbour: graph[src]){
        if (!visited[neighbour]) 
            topologicalSort(graph, neighbour);
    }

    topoOrder.push(src);
}

int main(){
    int n, m;
    cin >> n >> m;
    
    vector<int> graph[n];
    visited.resize(n, 0);

    while (m--){
        int u, v;
        cin >> u >> v;
        u--;
        v--;
        graph[u].push_back(v);
    }

    for (int node=0; node<n; node++){
        if (!visited[node])
            topologicalSort(graph, node);
    }
    
    for (int i=0; i<n; i++){
        cout << topoOrder.top() << " ";
        topoOrder.pop();
    }
    cout << endl;
       
    return 0;
}

