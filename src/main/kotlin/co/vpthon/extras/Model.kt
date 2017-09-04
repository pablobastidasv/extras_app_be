package co.vpthon.extras

import org.neo4j.ogm.annotation.GraphId
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class Person(val name: String) {

    @GraphId val id: Long = 0

    @Relationship(type = "HAS", direction = "OUTGOING")
    private val attributes = HashSet<Attribute>()

    fun attributesIn(attribute: Attribute) {
        attributes.add(attribute)
        attribute.getPeople().add(this)
    }
}

@NodeEntity
data class Attribute(val type: String, val value: String) {

    @GraphId val id: Long = 0

    @Relationship(type = "HAS", direction = "INCOMING")
    private val people = HashSet<Person>()

    fun getPeople () : HashSet<Person> {
        return people
    }

}

data class Query(val gender: String,
                 val city: String,
                 val eyes: String,
                 val ethnicity: String,
                 val height: String,
                 val bodyType: String,
                 val hairColor: String,
                 val hairLength: String,
                 val nose: String,
                 val skin: String,
                 val age: String,
                 val tattoo: String) {

  constructor() : this("", "", "", "", "", "", "", "", "", "", "0", "")

  fun isValid():Boolean {
    return true
  }
}

enum class AttributeType {
  Gender, City, Eyes, Ethnicity, Height, BodyType, HairColor, HairLength, Nose, Skin, Age, Tatoo
}
