package co.vpthon.extras

import java.util.*

class SearchController {

  fun matchPeople(query: Query): List<Person> {

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

    val cypherQuery = cypher.toString() + " ${query.pagination.toNeo4jLimit()}"
    val people = Neo4jSessionFactory.instance.openSession().query(Person::class.java, cypherQuery, HashMap<String, Any>())

    return people.toList()
  }
}

class PeopleController{

  fun personAttributes(dni: String): List<Attribute> {

    val cypherQuery = "MATCH (attribute:Attribute)-[:HAS]-(:Person {dni: '$dni'}) RETURN attribute"
    val attributes = Neo4jSessionFactory.instance.openSession().query(Attribute::class.java, cypherQuery, HashMap<String, Any>())

    return attributes.toList()

  }

}
