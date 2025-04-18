import scala.collection.mutable
import scala.collection.immutable.Vector

object Solution:
  private val INF = Long.MaxValue

  def minimumWeight(n: Int, edges: Array[Array[Int]], src1: Int, src2: Int, dest: Int): Long =
    val g: Vector[Vector[(Int, Long)]] =
      Vector.fill(n)(Vector.empty[(Int, Long)]).zipWithIndex.map { case (_, i) =>
        edges.collect { case Array(f, t, w) if f == i => (t, w.toLong) }.toVector
      }
    val rg: Vector[Vector[(Int, Long)]] =
      Vector.fill(n)(Vector.empty[(Int, Long)]).zipWithIndex.map { case (_, i) =>
        edges.collect { case Array(f, t, w) if t == i => (f, w.toLong) }.toVector
      }
    val d1 = dijkstra(g, src1)
    val d2 = dijkstra(g, src2)
    val d3 = dijkstra(rg, dest)
    (0 until n)
      .collect {
        case i if d1(i) < INF && d2(i) < INF && d3(i) < INF => d1(i) + d2(i) + d3(i)
      }
      .minOption
      .getOrElse(-1L)

  private def dijkstra(graph: Vector[Vector[(Int, Long)]], start: Int): Vector[Long] =
    val n = graph.size
    val dist = Array.fill(n)(INF)
    dist(start) = 0L
    given Ordering[(Long, Int)] = Ordering.by[(Long, Int), Long](_._1)
    val pq = mutable.PriorityQueue.empty[(Long, Int)](using summon[Ordering[(Long, Int)]].reverse)
    pq.enqueue((0L, start))
    while pq.nonEmpty do
      val (d, u) = pq.dequeue()
      if d <= dist(u) then
        for (v, w) <- graph(u) do
          if dist(v) > d + w then
            dist(v) = d + w
            pq.enqueue((dist(v), v))
    dist.toVector

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    q.offer(new Pair<>(dist[v], v));
                }
            }
        }
        return dist;
    }
}