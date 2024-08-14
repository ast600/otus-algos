package ru.otus.algos.hw2

import scala.math.pow

case class LuckyTickets(numDigits: Int):
  self =>

  def validateEven(): LuckyTickets =
    if numDigits % 2 == 0 then self
    else throw new IllegalArgumentException("Uneven number of digits")

  def validatePositive(): LuckyTickets =
    if numDigits > 0 then self
    else throw new IllegalArgumentException("Negative number of digits")

  def count: Long =
    if numDigits == 2 then baseCase.sum
    else
      var fromNumDigits = 4
      var result = baseCase
      while (fromNumDigits <= numDigits) {
        result = computeSums(fromNumDigits, result)
        fromNumDigits += 2
      }
      halfCombinations(result)
      result.sum

  private def computeSums(numDigits: Int, previousStepSums: Array[Long]): Array[Long] =
    val maxPossibleSum = numDigits / 2 * 9
    val matrix = Array.ofDim[Long](10, maxPossibleSum + 1)
    matrix.indices.foreach(j => Array.copy(previousStepSums, 0, matrix(j), j, previousStepSums.length))
    matrix.transpose.map(_.sum)

  private def baseCase: Array[Long] =
    Array.fill(10)(1L)

  private def halfCombinations(halfSums: Array[Long]): Unit =
    halfSums.indices.foreach(i => halfSums(i) = pow(halfSums(i), 2).toLong)