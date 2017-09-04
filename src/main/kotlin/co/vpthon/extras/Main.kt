package co.vpthon.extras

import spark.Spark

fun main(args: Array<String>) {
  Spark.get("/q") {
    req, res ->
    println(req.body())
    res.type("application/json")
    "{ \n" +
     "\"response\":\n" +
     "\"hairLength\": " + req.queryMap().get("hairLength").value()+ "\",\n" +
     "\"hairColor\": " + req.queryMap().get("hairColor").value() + " ,\n" +
     "\"nose\": " + req.queryMap().get("nose").value() + "\",\n" +
     "\"bodyType\": " + req.queryMap().get("bodyType").value() + "\",\n" +
     "\"gender\": " + req.queryMap().get("gender").value() + "\",\n" +
     "\"city\": " + req.queryMap().get("city").value() + "\",\n" +
     "\"eyes\": " + req.queryMap().get("eyes").value() + "\",\n" +
     "\"ethnicity\": " + req.queryMap().get("ethnicity").value() + "\",\n" +
     "\"height\": " + req.queryMap().get("height").value() + "\"\n" +
    "}"
  }
}