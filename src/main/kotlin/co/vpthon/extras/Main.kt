package co.vpthon.extras

import com.google.gson.Gson
import spark.Spark.before

val gson: Gson = Gson()

fun main(args: Array<String>) {

  before("*", { _, res -> res.type("application/json") })

  ExceptionsHandling().load()

  SearchResources().load()
  PeopleResources().load()
  AttributesResources().load()
}
