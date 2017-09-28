package co.vpthon.extras

import org.neo4j.driver.v1.exceptions.ClientException
import spark.Spark.exception


class ExceptionsHandling{

  fun load(){
    exception(Exception::class.java, { e, _, res ->

      e.printStackTrace() // TODO use logger instead of this

      res.status(500)
      res.body(gson.toJson(Message("Ups!!! Something went wrong.")))
    })

    exception(ClientException::class.java, { _, req, res ->
      val person = gson.fromJson(req.body(), Person::class.java)

      val message = "Dni ${person.dni} already exist."
      System.err.println(message) // TODO use logger instead of this

      res.status(400)
      res.body(gson.toJson(Message(message)))
    })
  }
}

class Message(val message: String)
