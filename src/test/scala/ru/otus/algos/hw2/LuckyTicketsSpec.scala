package ru.otus.algos.hw2

import zio.Scope
import zio.test.{ Spec, TestEnvironment, ZIOSpecDefault, assertTrue }

object LuckyTicketsSpec extends ZIOSpecDefault {
  override def spec: Spec[TestEnvironment with Scope, Any] =
    suiteAll("Lucky tickets spec") {
      test("Number of ticket digits == 2") {
        assertTrue {
          LuckyTickets(2).validateEven()
                         .validatePositive()
                         .count == 10L
        }
      }

      test("Number of ticket digits == 4") {
        assertTrue {
          LuckyTickets(4).validateEven()
                         .validatePositive()
                         .count == 670L
        }
      }

      test("Number of ticket digits == 6") {
        assertTrue {
          LuckyTickets(6).validateEven()
                         .validatePositive()
                         .count == 55252L
        }
      }

      test("Number of ticket digits == 8") {
        assertTrue {
          LuckyTickets(8).validateEven()
                         .validatePositive()
                         .count == 4816030L
        }
      }

      test("Number of ticket digits == 10") {
        assertTrue {
          LuckyTickets(10).validateEven()
                          .validatePositive()
                          .count == 432457640L
        }
      }

      test("Number of ticket digits == 10") {
        assertTrue {
          LuckyTickets(10).validateEven()
                          .validatePositive()
                          .count == 432457640L
        }
      }

      test("Number of ticket digits == 12") {
        assertTrue {
          LuckyTickets(12).validateEven()
                          .validatePositive()
                          .count == 39581170420L
        }
      }

      test("Number of ticket digits == 14") {
        assertTrue {
          LuckyTickets(14).validateEven()
                          .validatePositive()
                          .count == 3671331273480L
        }
      }

      test("Number of ticket digits == 16") {
        assertTrue {
          LuckyTickets(16).validateEven()
                          .validatePositive()
                          .count == 343900019857310L
        }
      }

      test("Number of ticket digits == 18") {
        assertTrue {
          LuckyTickets(18).validateEven()
                          .validatePositive()
                          .count == 32458256583753952L
        }
      }

      test("Number of ticket digits == 20") {
        assertTrue {
          LuckyTickets(20).validateEven()
                          .validatePositive()
                          .count == 3081918923741896816L // not 3081918923741896840L
        }
      }
    }
}
