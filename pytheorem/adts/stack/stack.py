#
# Author: Rohtash Lakra
#
from collections import deque
from typing import Any


class Stack:

    def __init__(self):
        self.items = deque()

    def add(self, item: Any):
        self.items.append(item)

    def remove(self) -> Any:
        return self.items.pop()

    def __len__(self):
        return len(self.items)

    def __contains__(self, item):
        return item in self.items

    def __iter__(self):
        yield from self.items

    def __reversed__(self):
        yield from reversed(self.items)

    def __repr__(self):
        return f"Queue: {list(self.items)}"


stack = Stack()
print(stack)
for i in range(1, 5):
    stack.add(i)
    
print(stack)
stack.remove()
print(stack)
stack.add(5)
stack.add(6)
print(f"{stack}, length={len(stack)}")
print(f"{stack}, contains={5 in stack}")
print(f"{stack}, iter={list(iter(stack))}")
print(f"{stack}, reversed={list(reversed(stack))}")
