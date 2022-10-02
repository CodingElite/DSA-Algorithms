class Vertex(object):
    # This is the vertex class
    def __init__(self, name):
        # We define the name and the node which the vertex is in
        self.name = name
        self.node = None


class Node(object):
    # We have the nodeId(representative value), height, parent node to backtrack
    def __init__(self, height, nodeId, parentNode):
        self.height = height
        self.nodeId = nodeId
        self.parentNode = parentNode


class Edge(object):
    # Every edge will have weight, starting vertex and a target vertex
    def __init__(self, weight, startingVertex, targetVertex):
        self.weight = weight
        self.startVertex = startingVertex
        self.targetVertex = targetVertex

    # We use the comparator function to compare the edges with their weights
    def __cmp__(self, other):
        return self.cmp(self.weight, other.weight)

    # This less than method is defined to compare the edges and returns a boolean
    # if self weight is less than the other weight
    def __lt__(self, other):
        selfPriority = self.weight
        otherPriority = other.weight
        return selfPriority < otherPriority


class DisjointSets(object):
    # We define the parameters
    def __init__(self, vertexList):
        self.vertexList = vertexList
        self.rootNodes = []
        self.setCount = 0
        self.nodeCount = 0
        self.makeSets(vertexList)

    def find(self, node):
        # We get the node to the current node
        currentNode = node
        # We loop through the tree until we find the root node
        while currentNode.parentNode is not None:
            currentNode = currentNode.parentNode
        # we set the root and the current node to the node we are looking for
        root = currentNode
        currentNode = node
        # We make the current node to be the child of the root node
        # We swap the values
        while currentNode is not root:
            temp = currentNode.parentNode
            currentNode.parentNode = root
            currentNode = temp
        # Finally we return the node Id of the root node
        return root.nodeId

    def merge(self, node1, node2):
        index1 = self.find(node1)
        index2 = self.find(node2)
        # if both the indices are equal we know that they are in the same subset
        if index1 == index2:
            return

        root1 = self.rootNodes[index1]
        root2 = self.rootNodes[index2]
        # Case 1: the rank of the root 1 is less than the root 2
        # So the parent will be root2
        if root1.height < root2.height:
            root1.parentNode = root2
        # Case 2: the rank of the root 1 greater than the root 1
        # So the parent of the root 2 is root 1
        elif root1.height > root2.height:
            root2.parentNode = root1
        # We know the heights are the same
        # So we can assign the root to be either root1 or root2
        else:
            root2.parentNode = root1
            # We increment the height of the current root node
            root1.height += 1

    def makeSets(self, vertexList):
        # We iterate through the vertex list and call the function makeSet
        for v in vertexList:
            self.makeSet(v)

    def makeSet(self, vertex):
        # We create a node
        node = Node(0, len(self.rootNodes), None)
        # We assign the vertex node to be node
        vertex.node = node
        # We get the disjoint nodes in the root nodes
        self.rootNodes.append(node)
        # We increment the node and the set counts
        self.nodeCount += 1
        self.setCount += 1


class kruskalAlgorithm(object):
    def spanning_tree(self, vertexList, edgeList):
        # First we define the disjoint set by passing the vertex list
        # By the above function each vertices are going to be a disjoint set
        disjointset = DisjointSets(vertexList)
        # We have the spanning tree array
        # We will append the edges to this tree
        spanningTree = []
        # We can call the sort method here because we have already defined the comparator and less than method
        # To consider its weight
        edgeList.sort()
        # We shall iterate through the list
        for edge in edgeList:
            # We assign the starting vertex and the target vertex to these parameters
            u = edge.startVertex
            v = edge.targetVertex
            # Here we check whether those two nodes are in the same set or not
            # This will return the nodeId which is the representative of the set
            if disjointset.find(u.node) is not disjointset.find(v.node):
                # if the following condition satisfies we append them to our spanning tree
                spanningTree.append(edge)
                # Also we will merge them together
                disjointset.merge(u.node, v.node)
        print("Minimum Spanning Tree order")
        weight = 0
        for edge in spanningTree:
            print("{} - {}, weight = {}".format(edge.startVertex.name, edge.targetVertex.name, edge.weight))
            weight += edge.weight
        print("The weight of the MST is ", weight)


vertex1 = Vertex("a")
vertex2 = Vertex("b")
vertex3 = Vertex("c")
vertex4 = Vertex("d")
vertex5 = Vertex("e")
vertex6 = Vertex("f")
vertex7 = Vertex("g")

edge1 = Edge(2, vertex1, vertex2)
edge2 = Edge(6, vertex1, vertex3)
edge3 = Edge(5, vertex1, vertex5)
edge4 = Edge(10, vertex1, vertex6)
edge5 = Edge(3, vertex2, vertex4)
edge6 = Edge(3, vertex2, vertex5)
edge7 = Edge(1, vertex3, vertex4)
edge8 = Edge(2, vertex3, vertex6)
edge9 = Edge(4, vertex4, vertex5)
edge10 = Edge(5, vertex4, vertex7)
edge11 = Edge(5, vertex6, vertex7)

vertexList = [vertex1, vertex2, vertex3, vertex4, vertex5, vertex6, vertex7]

edgeList = [edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10, edge11]

algorithm = kruskalAlgorithm()
algorithm.spanning_tree(vertexList, edgeList)