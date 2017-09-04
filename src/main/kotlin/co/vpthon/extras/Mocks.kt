package co.vpthon.extras

fun createPeople() : List<Person>{

  val testPeople = ArrayList<Person>(6)
  testPeople.add(Person("Marcus",  createAttributes(), 12345678L))
  testPeople.add(Person("Kevin",   createAttributes(), 8765432L))
  testPeople.add(Person("Julian",  createAttributes(), 22348790L))
  testPeople.add(Person("Pablo",   createAttributes(), 34212L))
  testPeople.add(Person("Daniel",  createAttributes(), 678902L))
  testPeople.add(Person("Agustin", createAttributes(), 216721812L))
  return testPeople
}

fun createAttributes() : HashSet<Attribute> {
  val attributes = HashSet<Attribute>(12)
  attributes.add(Attribute(AttributeType.BodyType,  "gordo"))
  attributes.add(Attribute(AttributeType.Age,       "20"))
  attributes.add(Attribute(AttributeType.City,      "Medallo!"))
  attributes.add(Attribute(AttributeType.Ethnicity, "Rolo"))
  attributes.add(Attribute(AttributeType.Eyes,      "Azules"))
  attributes.add(Attribute(AttributeType.Gender,    "Masculino"))
  attributes.add(Attribute(AttributeType.HairColor, "purple"))
  attributes.add(Attribute(AttributeType.HairLength,"largo"))
  attributes.add(Attribute(AttributeType.Height,    "chaparro"))
  attributes.add(Attribute(AttributeType.Nose,      "En Garfio"))
  attributes.add(Attribute(AttributeType.Skin,      "Blanco"))
  attributes.add(Attribute(AttributeType.Tatoo,     "All over"))
  return attributes
}
