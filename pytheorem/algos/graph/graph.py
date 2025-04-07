#
# Author: Rohtash Lakra
#
import json


class Graph:

    def __init__(self, graph: dict = None, directed: bool = False):
        """Init the graph object"""
        self.graph = graph if graph else dict()
        self.direct = directed

    def build(self, graph: dict):
        """Builds the graph"""
        self.graph.update(graph)

    def _contains(self, graph: dict, node: str) -> bool:
        """Returns true if the graph contains the node otherwise false."""
        # return node in graph
        # return node in graph.keys()
        # return list(graph.keys()).count(node) == 1
        # return graph.get(node) is not None
        # try:
        #     graph.get(node)
        #     return True
        # except KeyError as ex:
        #     return False
        return graph.__contains__(node)

    def contains(self, node: str) -> bool:
        """Returns true if the graph contains the node otherwise false."""
        return self._contains(self.graph, node)

    def _find_path(self, graph: dict, source: str, target: str, path=[]):
        """Returns the path from source node to target node if exists"""
        print(f"_find_path({source}, {target})")
        if source in graph:
            # add current node in the path
            path.append(source)
            if source == target:
                return path

            # iterate graph
            for node in graph[source]:
                if node not in path:
                    new_path = self._find_path(graph, node, target, path)
                    if new_path:
                        return new_path

        return None

    def find_path(self, source: str, target: str):
        """Returns the path from source node to target node if exists"""
        return self._find_path(self.graph, source, target)

    def display(self):
        print(json.dumps(self.graph))
        pass


data = {"A": ["B", "C"], "B": ["C", "D"], "C": ["D"], "D": ["C"], "E": ["F"], "F": ["C"]}
graph = Graph(data)
graph.display()
print(graph.contains("C"))
print(graph.find_path("A", "D"))
print()

data = {"A": ["B", "C"], "B": ["C", "D"], "C": ["D"], "D": ["C"], "E": ["F"], "F": ["C"]}
graph = Graph()
graph.build(data)
graph.display()
print(graph.contains("E"))
print(graph.find_path("A", "E"))
print()
