package ru.otus.algos.hw1

import zio.Scope
import zio.test.{ Spec, TestEnvironment, ZIOSpecDefault, assertTrue }

import scala.io.Source
import scala.math.floorDiv
import scala.util.Using

object SpellsSpec extends ZIOSpecDefault {
  override def spec: Spec[TestEnvironment & Scope, Any] =
    suiteAll("Square spells spec") {
      test("square1 -> x > y") {
        assertTrue {
          readResourceFile("square1.txt").map { contents =>
            contents sameElements getMatrixAsLines(_ > _)
          }.getOrElse(false)
        }
      }

      test("square2 -> x == y") {
        assertTrue {
          readResourceFile("square2.txt").map { contents =>
            contents sameElements getMatrixAsLines(_ == _)
          }.getOrElse(false)
        }
      }

      test("square3 -> x == matrix_size - 1 - y") {
        assertTrue {
          readResourceFile("square3.txt").map { contents =>
            contents sameElements getMatrixAsLines(_ == 24 - _)
          }.getOrElse(false)
        }
      }

      test("square4 -> x < 10 || y < 10") {
        assertTrue {
          readResourceFile("square4.txt").map { contents =>
            contents sameElements getMatrixAsLines(_ < 10 || _ < 10)
          }.getOrElse(false)
        }
      }

      test("square5 -> x > 15 && y > 15") {
        assertTrue {
          readResourceFile("square5.txt").map { contents =>
            contents sameElements getMatrixAsLines(_ > 15 && _ > 15)
          }.getOrElse(false)
        }
      }

      test("square6 -> x == 0 || y == 0") {
        assertTrue {
          readResourceFile("square6.txt").map { contents =>
            contents sameElements getMatrixAsLines(_ == 0 || _ == 0)
          }.getOrElse(false)
        }
      }

      test("square7 -> x == 1 || y == 1 || x == (matrix_size - 2) || y == (matrix_size - 2)") {
        assertTrue {
          readResourceFile("square7.txt").map { contents =>
            contents sameElements getMatrixAsLines { (x, y) => x == 1 || y == 1 || x == 23 || y == 23 }
          }.getOrElse(false)
        }
      }

      test("square8 -> x == 0 || y == 0 || x == (matrix_size - 1) || y == (matrix_size - 1)") {
        assertTrue {
          readResourceFile("square8.txt").map { contents =>
            contents sameElements getMatrixAsLines { (x, y) => x == 0 || y == 0 || x == 24 || y == 24 }
          }.getOrElse(false)
        }
      }

      test("square9 -> x == y || x == matrix_size - 1 - y") {
        assertTrue {
          readResourceFile("square9.txt").map { contents =>
            contents sameElements getMatrixAsLines { (x, y) => x == y || x == 24 - y }
          }.getOrElse(false)
        }
      }

      test("square10 -> x % 6 == 0 || y % 6 == 0") {
        assertTrue {
          readResourceFile("square10.txt").map { contents =>
            contents sameElements getMatrixAsLines { _ % 6 == 0 || _ % 6 == 0 }
          }.getOrElse(false)
        }
      }

      test("square11 -> x < 30 - y") {
        assertTrue {
          readResourceFile("square11.txt").map { contents =>
            contents sameElements getMatrixAsLines { _ < 30 - _ }
          }.getOrElse(false)
        }
      }

      test("square12 -> floor(x/2) == y") {
        assertTrue {
          readResourceFile("square12.txt").map { contents =>
            contents sameElements getMatrixAsLines { (x, y) => floorDiv(x, 2) == y }
          }.getOrElse(false)
        }
      }

      test("square13 -> x > 10 + y || y > 10 + x") {
        assertTrue {
          readResourceFile("square13.txt").map { contents =>
            contents sameElements getMatrixAsLines { (x, y) => x > 10 + y || y > 10 + x }
          }.getOrElse(false)
        }
      }

      test("square14 -> (x > 0 && y < 2) || (y > 0 && x < 2)") {
        assertTrue {
          readResourceFile("square14.txt").map { contents =>
            contents sameElements getMatrixAsLines { (x, y) => (x > 0 && y < 2) || (y > 0 && x < 2) }
          }.getOrElse(false)
        }
      }

      test("square15 -> (x > 10 + y && x < 21 + y) || (y > 10 + x && y < 21 + x)") {
        assertTrue {
          readResourceFile("square15.txt").map { contents =>
            contents sameElements getMatrixAsLines
              { (x, y) => (x > 10 + y && x < 21 + y) || (y > 10 + x && y < 21 + x) }
          }.getOrElse(false)
        }
      }

      test("square16 -> (x - y) % 2 == 0") {
        assertTrue {
          readResourceFile("square16.txt").map { contents =>
            contents sameElements getMatrixAsLines { (x, y) => (x - y) % 2 == 0 }
          }.getOrElse(false)
        }
      }

      test("square17 -> x > y && x <= 2*y + 1") {
        assertTrue {
          readResourceFile("square17.txt").map { contents =>
            contents sameElements getMatrixAsLines { (x, y) => x > y && x <= 2 * y + 1 }
          }.getOrElse(false)
        }
      }
    }

  private def getMatrixAsLines(p: (Int, Int) => Boolean) =
    Spells.fillMatrixBasedOn
          .andThen(Spells.matrix2Lines)
          .apply(p)

  private def readResourceFile(fileName: String) =
    Using(Source.fromResource(s"hw1/$fileName")) { src =>
      src.getLines().toArray[String]
    }
}
