package co.vpthon.extras

import spark.Spark

fun main(args: Array<String>) {
  Spark.get("/") {
    req, res ->
    println(req.body())
    res.type("application/json")
    "{ \"response\": Hello }"
  }
}