#
# Author: Rohtash Lakra
#
from collections import deque

# create deque object
dq = deque()

# append
dq.append("Hi")
print(f"append dq={dq}")
print()

# clear
dq.clear()

# appendleft
dq.append("Rohtash")
dq.appendleft("Hi, ")
print(f"appendleft dq={dq}")
print()

# copy
dq2 = dq.copy()
print(f"copy dq2={dq2}")
print()

# count
dq = deque([2, 4, 6, 7, 1, 7])
count = dq.count(7)
print(f"dq={dq} count={count}")
print()

# extend
dq.extend([8, 3, 1])
print(f"extend dq={dq}")
print()

# extendleft
dq.extendleft([1, 2, 3])
print(f"extendleft dq={dq}")
print()

# index
index = dq.index(6)
print(f"dq={dq}, index={index} of 6")
print()

# insert
dq.insert(0, 9)
print(f"insert dq={dq}")
print()

# pop
result = dq.pop()
print(f"dq={dq},pop result={result}")
print()

# popleft
result = dq.popleft()
print(f"dq={dq}, popleft result={result}")
print()

# remove
dq.remove(1)
print(f"dq={dq},remove result={result}")
print()

# reverse
result = dq.reverse()
print(f"dq={dq}, reverse result={result}")
print()

# rotate
dq.rotate()
print(f"rotate dq={dq}")
print()
