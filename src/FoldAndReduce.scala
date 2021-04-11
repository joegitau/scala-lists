object FoldAndReduce extends App {
  /*
    Fold and Reduce methods let you traverse a sequence- letting you compare two neighbouring values as you traverse.

   */

  val nums = List(1, 4, 6, 20, 19, 14, 8, 12)
  val names = List("Mane", "Firmino", "Henderson", "Wijnaldum", "Van Dijk", "Salah")

  ////////////////////////////
  // REDUCE METHODS
  ///////////////////////////

  // NOTE: reduceLeft - “The function you supply must return the same data type that’s stored in the collection.
  // This is necessary so reduceLeft can compare the result of your function to the next element in the collection.”

  def sum(x: Int, y: Int): Int = {
    val result = x + y
    println(s"Added $x with $y to get $result")
    result
  }

  // get a complete flow of how each element is compared/ computed with the next element in a sequence
  val sumReduceLeft = nums.reduceLeft(sum)
  println(sumReduceLeft)

  def findMax(x: Int, y: Int): Int = {
    val winner = x max y
    println(s"Compared $x against $y, and winner was $winner")
    winner
  }

  val maxReduceLeft = nums.reduceLeft(findMax)
  println(maxReduceLeft)

  def findLongest(a: String, b: String): String = {
    if (a.length > b.length) {
      println(s"Compared $a against $b, $a is longer")
      a
    }
    else {
      println(s"Compared $a against $b, $b is longer")
      b
    }
  }

  val longestName = names.reduceLeft((a, b) => if (a.length > b.length) a else b)
  val longestName2 = names.reduceLeft((a, b) => findLongest(a, b))
  println(longestName2)
  // println(longestName)


  ////////////////////
  // FOLD METHODS
  ////////////////////

  // foldLeft - foldLeft works the same as reduceLeft does, albeit it lets u set a seed value to be used as the first element
  val sumFoldLeft = nums.foldLeft(20)(_ + _)
  val sumReduceLeft2 = nums.reduceLeft(_ + _)

  println(s"sum for foldLeft: $sumFoldLeft while sum for reduceLeft: $sumReduceLeft2")

  ///////////////////////////
  // FOLD ON SCALA OPTION
  //////////////////////////
  /*
    NOTE: Fold works differently for a scala Option.
    - Fold on scala Option, Option.fold(defaultValue)(f) is EQUAL TO  map(f).getOrElse(defaultValue)
    - As with sequences, the 'seed value' provided acts as the default value to be used if Option returns None
      - If option is a None, the defaultValue is returned, and the function f is ignored.
        Alternatively, if option is a Some, defaultValue is ignored, and the function f is applied to the option value.
   */

  def f(a: Int): Int = a + 1

  val a = Some(14)
  val b = a.fold(20)(f) // the defaultValue (20) is ignored, as a has a value - thus function f is run - resulting in 15
  println(b)

  // NOTE: When fold is used on an empty list, it is analogous to calling fold on a None.

  val emptyList = List()
  val foldOption = emptyList.fold(10)(_ + _)
  println(foldOption) // returns 10 since list is empty thus the function is ignored and thus the default value is returned


  //////////////////
  // SCAN METHODS
  //////////////////

  // “scanLeft and scanRight - They traverse a sequence in a manner similar to foldLeft and foldRight, but they return a SEQUENCE instead of a SINGLE VALUE.”
  val product = (x: Int, y: Int) => {
    val result = x * y
    println(s"multiplied $x by $y to yield $result")
    result
  }

  val array = List(3, 2, 4)
  val scanLeft = array.scanLeft(10)(product) // List((10), (10*3), (30*2), (60*4))
  println(scanLeft)


}
