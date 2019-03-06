package repositories

import javax.inject.Singleton
import models.{Memory}

@Singleton
class MemoryRepository {
  private var memory = Seq(
    Memory(1, 2, List(1, 1), List("Add", "Add"))
  )

  def getAllCalculations: Seq[Memory] = memory
}