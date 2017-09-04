package co.vpthon.extras

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import spark.Spark
import java.io.IOException
import java.io.StringWriter
import java.net.HttpURLConnection.HTTP_BAD_REQUEST

fun main(args: Array<String>) {
  Spark.get("/q") {
    req, res ->
    println(req.body())
    res.type("application/json")
    "{ \n" +
            "\"hairLength\": \"" + req.queryMap().get("hairLength").value() + "\",\n" +
            "\"hairColor\": \"" + req.queryMap().get("hairColor").value() + " ,\n" +
            "\"nose\": " + req.queryMap().get("nose").value() + "\",\n" +
            "\"bodyType\": \"" + req.queryMap().get("bodyType").value() + "\",\n" +
            "\"gender\": \"" + req.queryMap().get("gender").value() + "\",\n" +
            "\"city\": \"" + req.queryMap().get("city").value() + "\",\n" +
            "\"eyes\": \"" + req.queryMap().get("eyes").value() + "\",\n" +
            "\"ethnicity\": " + req.queryMap().get("ethnicity").value() + "\",\n" +
            "\"height\": " + req.queryMap().get("height").value() + "\"\n" +
            "}"
  }

  Spark.post("/q1") { request, response ->
    try {
      val mapper = ObjectMapper()
      val creation = mapper.readValue(request.body(), Query::class.java)
      if (!creation.isValid()) {
        response.status(HTTP_BAD_REQUEST)
        return@post ""
      }
      val id = 1//model.createPost(creation.getTitle(), creation.getContent(), creation.getCategories())
      response.status(200)
      response.type("application/json")
      return@post dataToJson(creation)
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
    throw RuntimeException("IOException from a StringWriter?")
  }

}