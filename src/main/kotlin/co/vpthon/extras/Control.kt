package co.vpthon.extras

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Controller {

  fun matchPeople(query: Query): List<Person> {

    val params: HashMap<String, Object> = HashMap<String, Object>();
    val cypher = StringJoiner(", ", "MATCH ", " RETURN person")

    if (!query.data.gender.isNullOrEmpty()) {
      cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.Gender.name}', value: '${query.data.gender}' })")
    }
    if (!query.data.city.isNullOrEmpty()) {
      cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.City.name}', value: '${query.data.city}' })")
    }
    if (!query.data.eyes.isNullOrEmpty()) {
      cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.Eyes.name}', value: '${query.data.eyes}' })")
    }
    if (!query.data.ethnicity.isNullOrEmpty()) {
      cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.Ethnicity.name}', value: '${query.data.ethnicity}' })")
    }

    if (!query.data.bodyType.isNullOrEmpty()) {
      cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.BodyType.name}', value: '${query.data.bodyType}' })")
    }

    if (!query.data.tattoo.isNullOrEmpty()) {
      cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.Tattoo.name}', value: '${query.data.tattoo}' })")
    }

    if (!query.data.skin.isNullOrEmpty()) {
      cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.Skin.name}', value: '${query.data.skin}' })")
    }

    if (!query.data.nose.isNullOrEmpty()) {
      cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.Nose.name}', value: '${query.data.nose}' })")
    }

    if (!query.data.hairColor.isNullOrEmpty()) {
      cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.HairColor.name}', value: '${query.data.hairColor}' })")
    }

    if (!query.data.hairLength.isNullOrEmpty()) {
      cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.HairLength.name}', value: '${query.data.hairLength}' })")
    }

      println(cypher.toString())

    var people = Neo4jSessionFactory.instance.openSession().query(Person::class.java, cypher.toString(), params)

    var list : ArrayList<Person> = ArrayList<Person>()

    people.forEach { p ->
        val person = Neo4jSessionFactory.instance.openSession().load(Person::class.java, p.id)
        list.add(person)
    }
    return list
  }

}
