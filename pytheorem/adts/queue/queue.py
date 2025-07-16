#
# Author: Rohtash Lakra
#
from collections import deque
from typing import Any


class Queue:

    def __init__(self):
        self.items = deque()

    def enqueue(self, item: Any):
        self.items.append(item)

    def dequeue(self) -> Any:
        return self.items.popleft()

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


queue = Queue()
print(queue)
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)
print(queue)
queue.dequeue()
print(queue)
queue.enqueue(5)
queue.enqueue(6)
print(f"{queue}, length={len(queue)}")
print(f"{queue}, contains={5 in queue}")
print(f"{queue}, iter={list(iter(queue))}")
print(f"{queue}, reversed={list(reversed(queue))}")
