object Lists extends App {

  // BASIC METHODS FOR MANIPULATING LISTS
  val lst = List(7, 4, 6, 3, 9, 1)
  val names = List("Joe", "Alonso", "Mason", "Mane", "Joe", "Salah")

  // 1. METHODS THAT GIVE PART OF A LIST

  // a) Drop -> returns new list with n items dropped from list
  val drop: List[Int] = lst.drop(2)
  println(drop)

  // b) Init -> returns all elements except from the last item in list
  val init: List[Int] = lst.init
  println(init)

  // c) Last -> last – Takes no arguments and produces the last element in the collection
  val last: Int = lst.last
  println(last)

  // d) Slice -> returns new collection with all the elements beginning with the
  // index of the first argument and ending with the one before the index of the
  // second value.

  val slice: List[Int] = lst.slice(2, 4)
  println(slice)

  // e) SplitAt -> produces a tuple of two new collections where the first has the first n
  // elements and the second has the rest.
  val splitAt: (List[Int], List[Int]) = lst.splitAt(3)
  println(splitAt)

  // f) Take -> returns new collection with first n elements selected
  val take: List[Int] = lst.take(3)
  println(take)

  // g) TakeRight -> returns new collection with n last elements selected
  val takeRight: List[Int] = lst.takeRight(3)
  println(takeRight)

  ///////////////////////////////////////////////////////////////
  // 2. BOOLEAN TESTS
  //////////////////////////////////////////////////////////////

  // a) Contains -> Takes an element and gives the result of whether or not
  // the collection contains an element equal to it
  val contains: Boolean = lst.contains(8)
  println(contains)

  // b) EndsWith -> takes collection of elements and tells whether the
  // current collection ends with elements equal to those in the collection passed in.
  val endsWith: Boolean = lst.endsWith(List(1, 8, 1))
  println(endsWith)

  val endsWithName: Boolean = names.endsWith(List("Salah"))
  println(s"Names end with Salah: $endsWithName")

  // c) startsWith -> takes a collection of elements and tells whether the current collection
  // starts with elements equal to those in the collection passed in.
  val startsWith: Boolean = names.startsWith(List("Joe"))
  println(startsWith)

  // d) isEmpty – Tells whether or not the collection is empty.
  val isEmpty: Boolean = names.isEmpty
  println(isEmpty)

  // e) nonEmpty – The opposite of isEmpty
  val nonEmpty: Boolean = names.nonEmpty
  println(nonEmpty)


  //////////////////////////////////////////
  // 3. SEARCH FROM A LIST

  // a) indexOf -> Takes an element and returns the index of the FIRST element in the collection equal
  // to the value passed in. Returns -1 if no matching element is found.
  val indexOf: Int = names.indexOf("Mason")
  println(indexOf)

  // b) lastIndexOf -> Takes an element and returns the index of the LAST element in the collection equal
  // to the value passed in. Returns -1 if no matching element is found.
  val lastIndexOf: Int = names.lastIndexOf("Joe")
  println(lastIndexOf)

  /////////////////////////////////////////////
  // 4. SPECIAL USE CASES

  // a) distinct -> Removes all duplicates from a collection
  val distinct: List[String] = names.distinct
  println(distinct)

  // b) diff -> returns all elements that were in the original collection that do not have a
  // match in the argument collection
  val diff: List[Int] = lst.diff(List(4, 5, 6)) // List(7, 4, 6, 3, 9, 1)
  println(diff)

  // c) mkString -> takes either zero, one or three arguments
  // It builds a single long string from the string representations of the elements.

  // 1. If one argument is specified, it should be a string that is used to separate the element strings
  val oneArgMkString: String = names.mkString(" - ")
  println(oneArgMkString)

  // 2. If three arguments are specified the middle is a separator and the first and last are
  // strings to put before and after the elements.
  val threeArgMkString: String = names.mkString("[", " -> ", "]")
  println(threeArgMkString)

  // d) patch -> returns new collection where elements have been REMOVED from and INSERTED into the original collection.
  val patchOne = names.patch(2, List("Xabi", "Stevie"), 2) // replaces 2 elements from index 2 with provided elements
  println(patchOne)

  val patchTwo: List[String] = names.patch(2, List("Henderson"), 0) // adds one element at index two. Doesn't remove element
  println(patchTwo)

  val patchThree: List[String] = names.patch(3, Nil, 2) // removes two elements from index three. No additions.
  println(patchThree)

  // e) reverse -> Returns a new collection with the elements in the reverse order
  val reverse: List[String] = names.reverse
  println(reverse)

  // f) toArray, toList – Returns a new collection of the type specified with the elements in the current collection.
  val namesArray: Array[String] = names.toArray
  println(namesArray.mkString("Array(", ", ", ")"))

  // g) zipWithIndex - returns a new collection of tuples where the first is an element from the collection
  // and the second is its index.
  val zipWithIndex: Unit = for ((n, i) <- names.zipWithIndex)
    println(s"$i -> $n")


  ///////////////////////////////////////////////
  // HIGHER ORDER METHODS
  //////////////////////////////////////////////

  // a) Count - Returns the number of elements in the collection for which this returns true.
  val count: Int = lst.count(_ > 5)
  println(count)

  val count2: Int = names.count(_ == "Joe")
  println(count2)

  // b) dropWhile - Returns a new collection that contains all elements starting
  // with the first one for which that function is false.
  val dropWhile: List[Int] = lst.dropWhile(_ > 5)
  println(dropWhile)

  // c) exists - Returns true if there is some element in the collection for which the function is true.
  val exists: Boolean = names.exists(_ startsWith("J"))
  println(exists)

  val exists2: Boolean = lst.exists(_ % 2 == 0)
  println(exists2)

  // d) filter - Returns a new collection that contains only the elements for which the function is TRUE.
  val filter = names.filter(_ startsWith("M"))
  println(filter)

  // e) filterNot - Returns a new collection that contains only the elements for which the function is FALSE.
  val filterNot = names.filterNot(_ startsWith("J"))
  println(filterNot)

  // f) flatMap - Returns a new collection built from all the result collections appended together
  // It flattens the resulting list of strings into a sequence of characters (Seq[Char])
  val flatMap = names.flatMap(_.toUpperCase())
  println(flatMap)
}
