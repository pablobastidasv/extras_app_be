package co.vpthon.extras

import com.google.gson.Gson
import spark.Spark.before
import spark.Spark.port

val gson: Gson = Gson()

fun main(args: Array<String>) {

  port(obtainPort())

  before("*", { _, res -> res.type("application/json") })

  SearchResources().load()
  PeopleResources().load()
  AttributesResources().load()
}

fun obtainPort(): Int = ProcessBuilder().environment()["PORT"]?.toInt() ?: 4567
