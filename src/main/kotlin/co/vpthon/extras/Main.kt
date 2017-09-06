package co.vpthon.extras

import com.google.gson.Gson
import spark.Spark.before
import spark.Spark.post

val gson: Gson = Gson()

fun main(args: Array<String>) {

  before("*", { _, res -> res.type("application/json") })

  post("/search", { req, _ ->
    val creation = gson.fromJson(req.body(), Query::class.java)
    Controller().matchPeople(creation)
  }, gson::toJson)

  post("/person", { req, res ->
    res.status(201)

    val person = gson.fromJson(req.body(), Person::class.java)
    Neo4jSessionFactory.instance.openSession().save(person)
    person
  }, gson::toJson)
}
