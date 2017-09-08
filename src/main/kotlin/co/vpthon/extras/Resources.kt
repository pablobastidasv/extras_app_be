package co.vpthon.extras

import spark.Spark.post
import spark.Spark.path
import spark.Spark.get


class SearchResources {
  fun load() {
    post("/search", { req, _ ->
      val creation = gson.fromJson(req.body(), Query::class.java)
      SearchController().matchPeople(creation)
    }, gson::toJson)
  }
}

class PeopleResources {
  fun load() {
    path("/people",{
      post("", { req, res ->
        res.status(201)

        val person = gson.fromJson(req.body(), Person::class.java)
        Neo4jSessionFactory.instance.openSession().save(person)
        person
      }, gson::toJson)
    })
  }
}

class AttributesResources {
  fun load() {
    path("/attributes",{
      get("", { _, _ ->
        Neo4jSessionFactory.instance.openSession().loadAll(Attribute::class.java)
          .groupBy { it.type }
      }, gson::toJson)
    })
  }
}
