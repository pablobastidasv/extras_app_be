package co.vpthon.extras

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import spark.Spark
import java.io.IOException
import java.io.StringWriter
import java.net.HttpURLConnection.HTTP_BAD_REQUEST
import java.net.URL
import javax.imageio.ImageIO


fun main(args: Array<String>) {

  Spark.get("/hola") { request, response ->
    return@get "Hola Mundo"
  }

  Spark.post("/search") { request, response ->
    try {
      val mapper = ObjectMapper()
      val creation = mapper.readValue(request.body(), Query::class.java)
      if (!creation.isValid()) {
        response.status(HTTP_BAD_REQUEST)
        return@post ""
      }
      response.status(200)
      response.type("application/json")
      return@post dataToJson(Controller().matchPeople(creation))
    } catch (jpe: JsonParseException) {
      response.status(HTTP_BAD_REQUEST)
      return@post ""
    }
  }

  Spark.post("/person") { request, response ->
    try {
      val mapper = ObjectMapper()
      val person = mapper.readValue(request.body(), PersonCreation::class.java)
      if (!person.isValid()) {
        response.status(HTTP_BAD_REQUEST)
        return@post ""
      }
      response.status(200)
      response.type("application/json")
      return@post dataToJson(Controller().createPerson(person))
    } catch (e: Exception) {
      response.status(HTTP_BAD_REQUEST)
      return@post ""
    }
  }

  Spark.get("/img/:profile") { req, res ->
    val profile = req.params(":profile")
    val image = ImageIO.read(URL("http://r.ddmcdn.com/s_f/o_1/cx_462/cy_245/cw_1349/ch_1349/w_720/APL/uploads/2015/06/caturday-shutterstock_149320799.jpg"))
    try {
      res.status(200)          // set status code to 401
      res.type("image/jpg")     // set content type to text/xml
      res.body(image.toString())
    } catch (ex: IOException) {
      res.status(500)          // set status code to 401
      res.type("image/jpg")     // set content type to text/xml
      res.body(image.toString())
    }
    image
  }
}

fun dataToJson(data: Any): String {
  try {
    val mapper = ObjectMapper()
    mapper.enable(SerializationFeature.INDENT_OUTPUT)
    val sw = StringWriter()
    mapper.writeValue(sw, data)
    return sw.toString()
  } catch (e: IOException) {
    throw RuntimeException("IOException from a StringWriter")
  }
}

fun latexTemplate(formula: String): String {
  return StringBuilder()
          .append("$$$formula$$\n").toString()

}
