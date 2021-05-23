object SortingLists extends App {

  // Sorting lists using the Insertion method
  def sort(list: List[Int]): List[Int] = {
    def insert(number: Int, sortedList: List[Int]): List[Int] = {
      // assert if list is empty and that number is less than the first number in the sorted list, if its empty and
      // number is less than the first element in the sorted list, then we append that number as the first element
      if (sortedList.isEmpty || number <= sortedList.head) {
        number :: sortedList
      } else {
        // at this point, the first element of the sorted list should always remain as first element and
        // we recursively call insert to go through same process until our element (number) matches the "if" check
        sortedList.head :: insert(number, sortedList.tail)
      }
    }

    if (list.isEmpty || list.tail.isEmpty) list
    else insert(list.head, sort(list.tail))
  }

  val unorderedList = List(1,7,5,7,4,2,3)
  val orderedList = sort(unorderedList)
  println(orderedList)

}
