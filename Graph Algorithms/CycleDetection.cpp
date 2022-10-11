#include <bits/stdc++.h>

using namespace std;

// 0-> unvisited
// 1-> processing
// 2-> exited
vector<int> visited;
bool found = false;
vector<int> ans;
vector<int> curStack;

void DFS(vector<int> graph[], int node){
    if (visited[node] != 0) return;

    visited[node] = 1;
    curStack.push_back(node);

    for (int neighbour: graph[node]){
        if (visited[neighbour] == 1){
            // Found a cycle
            found = true;
            ans.push_back(neighbour);
            while (curStack.back() != neighbour){
                ans.push_back(curStack.back());
                curStack.pop_back();
            }
            ans.push_back(neighbour);
            reverse(ans.begin(), ans.end());
            return;
        }

        else if (visited[neighbour] == 0){
            DFS(graph, neighbour);
        }
        if (found) return;
    }

    curStack.pop_back();
    visited[node] = 2; // Done processing
}

void solve(vector<int> graph[], int n){
    for (int i=0; i<n; i++){
        if (!visited[i]){
            DFS(graph, i);
            if (found) break;
        }
    }
    if (! found){
        cout << "NO" << endl;
    }
    else{
        cout << "YES" << endl;
        cout << ans.size() << endl;
        for (int ele: ans){
            cout << ele + 1 << " ";
        }
        cout << "\n";
    }
}

int main(){
    int n, m;
    cin >> n >> m;

    vector<int> graph[n];
    visited.resize(n+1);
    fill(visited.begin(), visited.end(), false);

    while (m--){
        int u, v;
        cin >> u >> v;
        u--; v--;
        graph[u].push_back(v);
    }
    solve(graph, n);

    
    return 0;
}