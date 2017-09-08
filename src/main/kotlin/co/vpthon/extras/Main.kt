package co.vpthon.extras

import com.google.gson.Gson
import spark.Spark.before

val gson: Gson = Gson()

fun main(args: Array<String>) {

  before("*", { _, res -> res.type("application/json") })

  SearchResources().load()
  PersonResources().load()
  AttributeResources().load()
}
