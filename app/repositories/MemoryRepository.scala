package repositories

import javax.inject.Singleton
import models.{Memory}

@Singleton
class MemoryRepository {
  private var memories = List(
    Memory(5, 2, List(5, 10), List("Multiply", "Divide")),
    Memory(4, 15, List(1, 5, 11), List("Subtract", "Add")),
    Memory(3, 9, List(1, 3, 3), List("Multiply", "Multiply")),
    Memory(2, 0, List(1, 1), List("Subtract")),
    Memory(1, 2, List(1, 1), List("Add"))
  )

  def getAllMemory: List[Memory] = memories

  def getMemory(id: Int): Option[Memory] = {
    memories.collectFirst {
      case m if m.id == id => m
    }    
  }

  def removeMemory: Option[List[Memory]] = {
    memories match {
      case m if !m.isEmpty => {
        memories = memories.tail
        Option(memories)
      }
      case m => None
    }
  }

  def insertMemory: List[Memory] = {
    val newMemory = Memory(memories.length + 1, 0, List(), List())
    memories = newMemory :: memories 
    memories
  }

  def insertValue(id: Int, value: Int): List[Int] = {
    var newValues = List[Int]()

    memories = memories.map(memory => {
      if (memory.id == id) {
        newValues = memory.values
        newValues ::= value

        if (memory.values.isEmpty) {
          memory.copy(currentValue = value, values = newValues)
        } else {
          memory.copy(values = newValues)
        }
      } else {
        memory
      }
    })

    newValues
  }

  def insertOperator(id: Int, operator: String): List[String] = {
    var newOperators = List[String]()

    memories = memories.map(memory => {
      if (memory.id == id) {
        newOperators = memory.operators
        newOperators ::= operator

        memory.copy(operators = newOperators)
      } else {
        memory
      }
    })

    newOperators
  }
}