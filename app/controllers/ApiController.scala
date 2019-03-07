package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import play.api.libs.json.Json
import repositories.MemoryRepository

@Singleton
class ApiController @Inject()(cc: ControllerComponents, memoryRepository: MemoryRepository) extends AbstractController(cc) {
  def getAllMemory = Action { implicit request => 
    Status(200)(Json.toJson(memoryRepository.getAllMemory))
  }

  def getMemory(id: Int) = Action { implicit request =>
    memoryRepository.getMemory(id) match {
      case Some(memory) => Status(200)(Json.toJson(memory))
      case None => Status(404)
    }
  }

  def removeMemory = Action { implicit request => 
    memoryRepository.removeMemory match {
      case Some(memory) => Status(200)(Json.toJson(memory))
      case None => Status(400)
    }
  }

  def insertMemory = Action { implicit request => 
    Status(200)(Json.toJson(memoryRepository.insertMemory))
  }

  def insertValue(id: Int, value: Int) = Action { implicit request => 
    Status(200)(Json.toJson(memoryRepository.insertValue(id, value)))
  }

  def insertOperator(id: Int, operator: String) = Action { implicit request => 
    Status(200)(Json.toJson(memoryRepository.insertOperator(id, operator)))
  }

  // PUT - /api/memory/:id/:value/:operation
  // creates 1st memory slot, returns the calculated value

  // POST - /api/memory/:value/:operation
  // creates new memory slot, returns the calculated value

}