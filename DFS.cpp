//DFS
#include <iostream>
using namespace std;

const int MAX = 100;

struct Node {
  int data;
  Node *next;
};

Node *adj[MAX];

void addEdge(int u, int v) {
  Node *newNode = new Node();
  newNode->data = v;
  newNode->next = adj[u];
  adj[u] = newNode;

  newNode = new Node();
  newNode->data = u;
  newNode->next = adj[v];
  adj[v] = newNode;
}

void dfs(int node, bool visited[]) {
  visited[node] = true;
  cout << node << " ";

  Node *temp = adj[node];

  while (temp != NULL) {
    int neighbor = temp->data;

    if (!visited[neighbor]) {
      dfs(neighbor, visited);
    }
    temp = temp->next;
  }
}

int main() {
  int V = 5;

  for (int i = 0; i < MAX; i++)
    adj[i] = NULL;

  addEdge(0, 1);
  addEdge(0, 2);
  addEdge(1, 3);
  addEdge(1, 4);

  bool visited[MAX] = {false};

  cout << "DFS Traversal: ";
  dfs(0, visited);

  return 0;
}