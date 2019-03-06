package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{AbstractController, ControllerComponents}
import play.api.libs.json.Json

@Singleton
class ApiController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def getCalculations = Action {implicit request => 
    Ok("Okie Dokie")
  }
}