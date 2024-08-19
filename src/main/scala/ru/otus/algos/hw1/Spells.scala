package ru.otus.algos.hw1

object Spells {
  def fillMatrixBasedOn(predicate: (Int, Int) => Boolean): Array[Array[Char]] =
    val matrix = Array.ofDim[Char](25, 25)
    for
      columnIndex <- matrix.indices
      valueIndex <- matrix(columnIndex).indices
    do matrix(columnIndex)(valueIndex) = if predicate(columnIndex, valueIndex) then '#' else '.'
    matrix

  def matrix2Lines(matrix: Array[Array[Char]]): Array[String] =
    matrix.transpose.map(_.mkString)

  def printMatrix(predicate: (Int, Int) => Boolean): Unit =
    fillMatrixBasedOn.andThen { matrix2Lines }
                     .andThen { _.foreach(println) }
                     .apply(predicate)
}
