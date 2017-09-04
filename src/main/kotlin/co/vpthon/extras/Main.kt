package co.vpthon.extras

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import spark.Spark
import java.io.IOException
import java.io.StringWriter
import java.net.HttpURLConnection.HTTP_BAD_REQUEST

fun main(args: Array<String>) {

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
      return@post dataToJson(createPeople())
    } catch (jpe: JsonParseException) {
      response.status(HTTP_BAD_REQUEST)
      return@post ""
    }
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
