package co.vpthon.extras

import org.neo4j.ogm.annotation.GraphId
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
class Person(
  @GraphId
  var id: Long? = null,
  var name: String? = null,
  var dni: String? = null,
  @Relationship(type = "HAS")
  var attributes: Set<Attribute>? = null
)

@NodeEntity
class Attribute(
  @GraphId
  var id: Long? = null,
  var type: AttributeType? = null,
  var value: String? = null
)

data class Pagination(val page: Int = 0, val size: Int = 10)

data class Data(var gender: String? = null,
                var city: String? = null,
                var eyes: String? = null,
                var ethnicity: String? = null,
                var height: String? = null,
                var bodyType: String? = null,
                var hairColor: String? = null,
                var hairLength: String? = null,
                var nose: String? = null,
                var skin: String? = null,
                var age: String? = null,
                var tattoo: String? = null)

data class Query(val data: Data = Data(), val pagination: Pagination = Pagination())

enum class AttributeType {
  Gender, City, Eyes, Ethnicity, Height, BodyType, HairColor, HairLength, Nose, Skin, Age, Tattoo
}


data class PersonCreation(val name: String, val dni: String, val attributes: ArrayList<AttributeCreation>)

data class AttributeCreation(val value: String, val type: String)

