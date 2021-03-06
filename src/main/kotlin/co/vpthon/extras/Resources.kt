package co.vpthon.extras

import spark.Spark.*


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
    path("/people", {
      post("", { req, res ->
        res.status(201)

        val person = gson.fromJson(req.body(), Person::class.java)
        PeopleController().createPerson(person)
      }, gson::toJson)

      path("/:dni", {
        get("/attributes", { req, _ ->
          PeopleController().personAttributes(req.params("dni"))
        }, gson::toJson)
      })
    })
  }
}

class AttributesResources {
  fun load() {
    path("/attributes", {
      get("", { _, _ ->
        Neo4jSessionFactory.instance.openSession().loadAll(Attribute::class.java)
          .groupBy { it.type }
      }, gson::toJson)
    })
  }
}
