
import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    parent = IntArray(N + 1) {
        it
    }

    val priorityQueue = PriorityQueue<Node>(kotlin.Comparator { o1, o2 ->
        o1.cost - o2.cost
    })

    repeat(M) {
        StringTokenizer(readLine()).run {
            priorityQueue.offer(
                Node(
                    nextToken().toInt(),
                    nextToken().toInt(),
                    nextToken().toInt()
                )
            )
        }
    }
    var costSum = 0

    while (priorityQueue.isNotEmpty()) {
        val node = priorityQueue.poll()

        if (find(node.from) != find(node.to)) {
            union(node.from, node.to)
            costSum += node.cost
        }
    }

    println(costSum)
}

data class Node(
    val from: Int,
    val to: Int,
    val cost: Int
)

lateinit var parent: IntArray

fun find(x: Int): Int {
    if (x == parent[x]) {
        return x
    }

    return find(parent[x]).also {
        find(it)
    }
}

fun union(x: Int, y: Int) {
    val newX = find(x)
    val newY = find(y)

    if (x > y) {
        parent[newX] = newY
    } else {
        parent[newY] = newX
    }
}
