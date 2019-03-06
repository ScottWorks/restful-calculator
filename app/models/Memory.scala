package models

import play.api.libs.json.Json

case class Memory(id: Int, currentValue: Int, values: List[Int], operation: List[String])

object Memory{
  implicit val format = Json.format[Memory]
}