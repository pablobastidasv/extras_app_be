package co.vpthon.extras

import com.fasterxml.jackson.annotation.JsonIgnore
import org.neo4j.ogm.annotation.GraphId
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class Person(val name: String,
                  @Relationship(type = "HAS", direction = "OUTGOING") val attributes: HashSet<Attribute>,
                  @GraphId val id: Long = 0) {

    fun attributesIn(attribute: Attribute) {
        attributes.add(attribute)
        attribute.getPeople().add(this)
    }
}

@NodeEntity
data class Attribute(val type: AttributeType, val value: String) {

    @JsonIgnore
    @GraphId val id: Long = 0

    @JsonIgnore
    @Relationship(type = "HAS", direction = "INCOMING")
    private val people = HashSet<Person>()

    fun getPeople () : HashSet<Person> {
        return people
    }

}

data class Pagination (val page: Integer, val size: Integer) {
  constructor() : this(Integer(0), Integer(0))
}

data class Data( val gender:     String,
                 val city:       String,
                 val eyes:       String,
                 val ethnicity:  String,
                 val height:     String,
                 val bodyType:   String,
                 val hairColor:  String,
                 val hairLength: String,
                 val nose:       String,
                 val skin:       String,
                 val age:        String,
                 val tattoo:     String)
{
  constructor() : this("", "", "", "", "", "", "", "", "", "", "0", "")
}

data class Query (val data: Data, val pagination: Pagination) {

  constructor() : this(Data(), Pagination())

  fun isValid():Boolean {
    return true
  }
}

enum class AttributeType {
  Gender, City, Eyes, Ethnicity, Height, BodyType, HairColor, HairLength, Nose, Skin, Age, Tatoo
}
