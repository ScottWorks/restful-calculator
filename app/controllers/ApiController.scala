package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{AbstractController, ControllerComponents}
import play.api.libs.json.Json

import repositories.MemoryRepository

@Singleton
class ApiController @Inject()(cc: ControllerComponents, memoryRepository: MemoryRepository) extends AbstractController(cc) {
  def getAllCalculations = Action { implicit request => 
    Ok(Json.toJson(memoryRepository.getAllCalculations))
  }
}