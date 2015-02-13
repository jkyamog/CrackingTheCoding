package cracking.the.coding

case class SLNode(value: Int, var next: SLNode)

object ReversePairNodes extends App {

  val nodes = Seq(1, 2, 3, 4).foldRight(SLNode(5, null))( (n, tail) => SLNode(n, tail) )

  var node = pairReverse(nodes)

  while (node != null) {
    println(node.value)
    node = node.next
  }

  def pairReverse(head: SLNode): SLNode = {
    if (head.next == null) head
    else {
      val next = head.next
      val tail = next.next

      next.next = head
      head.next = tail

      val newTail = pairReverse(tail)

      head.next = newTail
      next
    }
  }
}
