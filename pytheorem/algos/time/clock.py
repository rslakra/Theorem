#
# Author: Rohtash Lakra
#
from adts.lang.math import Math


class LogicalClock:
    pass


class LamportLogicalClock(LogicalClock):
    """
    It is a procedure to determine the order of events occurring.
    It provides a basis for the more advanced Vector Clock Algorithm. Due to the absence of a Global Clock in a
    Distributed Operating System Lamport Logical Clock is needed.

    <code>https://www.geeksforgeeks.org/lamports-logical-clock/</code>

    Illustration of the Lamport's Logical Clock
    """

    @staticmethod
    def init(e1: int, e2: int):
        m = [[0] * 3 for i in range(0, 5)]
        # dep[i][j] = 1, if message is sent from ei to ej
        # dep[i][j] = -1, if message is received by ei from ej
        # dep[i][j] = 0, otherwise
        for row in range(e1):
            for col in range(e2):
                m[row][col] = 0

        m[1][2] = 1
        m[4][1] = -1

        return m

    @staticmethod
    def displayLogicalTimestamp(e1, e2, p1, p2):
        """Displays the logical timestamp"""
        print()
        print("The time stamps of events in P1:")
        for i in range(0, e1):
            print(p1[i], end=" ")

        print()
        print("The time stamps of events in P2:")

        # Print the array p2[]
        for i in range(0, e2):
            print(p2[i], end=" ")

    @staticmethod
    def lamportLogicalClock(e1, e2, m):
        """Finds the timestamp of events"""
        p1 = [0] * e1
        p2 = [0] * e2

        # Initialize p1[] and p2[]
        for i in range(0, e1):
            p1[i] = i + 1

        for i in range(0, e2):
            p2[i] = i + 1

        for i in range(0, e2):
            print(end='\t')
            print("e2", end="")
            print(i + 1, end="")

        for i in range(0, e1):
            print()
            print("e1", end="")
            print(i + 1, end="\t")

            for j in range(0, e2):
                print(m[i][j], end="\t")

        for i in range(0, e1):

            for j in range(0, e2):

                # Change the timestamp if the message is sent
                if (m[i][j] == 1):
                    p2[j] = Math.max(p2[j], p1[i] + 1)
                    for i in range(j + 1, e2):
                        p2[k] = p2[k - 1] + 1

                # Change the timestamp if the message is received
                if (m[i][j] == -1):
                    p1[i] = Math.max(p1[i], p2[j] + 1)
                    for k in range(i + 1, e1):
                        p1[k] = p1[k - 1] + 1

        # Function Call
        LamportLogicalClock.displayLogicalTimestamp(e1, e2, p1, p2)


# Driver Code
if __name__ == "__main__":
    e1 = 5
    e2 = 3
    m = LamportLogicalClock.init(e1, e2)
    # m = [[0] * 3 for i in range(0, 5)]
    # dep[i][j] = 1, if message is sent from ei to ej
    # dep[i][j] = -1, if message is received by ei from ej
    # dep[i][j] = 0, otherwise
    # m[0][0] = 0
    # m[0][1] = 0
    # m[0][2] = 0
    # m[1][0] = 0
    # m[1][1] = 0
    # m[1][2] = 1
    # m[2][0] = 0
    # m[2][1] = 0
    # m[2][2] = 0
    # m[3][0] = 0
    # m[3][1] = 0
    # m[3][2] = 0
    # m[4][0] = 0
    # m[4][1] = -1
    # m[4][2] = 0

    # Function Call
    LamportLogicalClock.lamportLogicalClock(e1, e2, m)
