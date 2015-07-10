package cracking.the.coding

object DjikStra extends App {

  val edges: Map[(Char, Char), Int] = Map(
    ('A', 'B') -> 4,
    ('A', 'C') -> 2,
    ('B', 'C') -> 3,
    ('B', 'E') -> 3,
    ('B', 'D') -> 2,
    ('C', 'B') -> 1,
    ('C', 'D') -> 4,
    ('C', 'E') -> 5,
    ('E', 'D') -> 1
  )

  def notOptimal(edges: Map[(Char, Char), Int]) = {

    val unseen = collection.mutable.HashSet('B', 'C', 'D', 'E')
    val seen = collection.mutable.HashSet('A')

    val distances = collection.mutable.Map(
      'A' -> 10000,
      'B' -> 10000,
      'C' -> 10000,
      'D' -> 10000,
      'E' -> 10000
    )
    distances('A') = 0 // init

    while (unseen.nonEmpty) {
      val adjacent = edges.flatMap {
        case ((head, tail), distance) if seen.contains(head) && unseen.contains(tail) =>
          val totalDistance = distance + distances(head)
          Some((head, tail), totalDistance)
        case _ => None
      }.toSeq

      val ((head, tail), distance) = adjacent.sortBy { case (_, distance) => distance}.head // get the shortest

      if (distances(tail) > distance)
        distances(tail) = distance

      seen.add(tail)
      unseen.remove(tail)
    }

    distances
  }

  notOptimal(edges) foreach println
}
