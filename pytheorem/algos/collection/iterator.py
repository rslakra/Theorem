#
# Author: Rohtash Lakra
#

class Iterator:
    pass


"""
    enumerate
    ---------
    The enumerate object yields pairs containing a count (from start, which
    defaults to zero) and a value yielded by the iterable argument.
    enumerate is useful for obtaining an indexed list:
        (0, seq[0]), (1, seq[1]), (2, seq[2]), ...
"""

obj = enumerate([2,7,11,15])
print(f"obj={obj}")
for index, value in obj:
    print(index, value)


print()
alpha = {'a': 1, 'b': 2, 'c': 3}
alpha_object = enumerate(alpha)
print(f"alpha_object={alpha_object}")
for index, value in alpha_object:
    print(index, value)

print()
set_object = set([2,7,11,15])
print(f"set_object={set_object}")
for index, value in enumerate(set_object):
    print(index, value)
