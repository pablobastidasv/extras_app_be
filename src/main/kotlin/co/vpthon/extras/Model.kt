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

data class Pagination(val page: Int, val size: Int){
  fun toNeo4jLimit(): String = org.neo4j.ogm.cypher.query.Pagination(page, size).toString()
}

data class Data(val gender: String?,
                val city: String?,
                val eyes: String?,
                val ethnicity: String?,
                val height: String?,
                val bodyType: String?,
                val hairColor: String?,
                val hairLength: String?,
                val nose: String?,
                val skin: String?,
                val age: String?,
                val tattoo: String?)

data class Query(val data: Data, val pagination: Pagination)

enum class AttributeType {
  Gender, City, Eyes, Ethnicity, Height, BodyType, HairColor, HairLength, Nose, Skin, Age, Tattoo
}

