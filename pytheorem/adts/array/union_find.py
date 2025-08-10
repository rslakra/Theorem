#
# Author: Rohtash Lakra
#
class UnionFind:

    def __init__(self, n):
        self.parents = list(range(n))

    def find(self, node):
        if self.parents[node] == node:
            return node

        return self.find(self.parents[node])

    def union(self, node1, node2):
        root_node1 = self.find(node1)
        root_node2 = self.find(node2)
        if root_node1 != root_node2:
            self.parents[root_node2] = root_node1
