package co.vpthon.extras

data class Person(val id: Long, val name: String)

data class Attribute(val id: Long, val type: String, val value: String)

enum class AttributeType {
    Gender,	City, Eyes, Ethnicity, Height, Build, HairColor, HairLength, Nose, Skin, Age, Tatoo
}