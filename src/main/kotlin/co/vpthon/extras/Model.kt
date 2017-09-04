package co.vpthon.extras

data class Person(val id: Long, val name: String)

data class Attribute(val id: Long, val type: String, val value: String)

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