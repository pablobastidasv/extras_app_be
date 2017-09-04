package co.vpthon.extras

fun createPeople() : List<Person>{

  val testPeople = ArrayList<Person>(6)
  testPeople.add(Person(name="Marcus",  attributes = createAttributes(), id = 12345678L))
  testPeople.add(Person(name="Kevin",   attributes = createAttributes(), id = 8765432L))
  testPeople.add(Person(name="Julian",  attributes = createAttributes(), id = 22348790L))
  testPeople.add(Person(name="Pablo",   attributes = createAttributes(), id = 34212L))
  testPeople.add(Person(name="Daniel",  attributes = createAttributes(), id = 678902L))
  testPeople.add(Person(name="Agustin", attributes = createAttributes(), id = 216721812L))
  return testPeople
}

fun createAttributes() : HashSet<Attribute> {
  val attributes = HashSet<Attribute>(12)
  attributes.add(Attribute(type = AttributeType.BodyType,  value = "gordo"))
  attributes.add(Attribute(type = AttributeType.Age,       value = "20"))
  attributes.add(Attribute(type = AttributeType.City,      value = "Medallo!"))
  attributes.add(Attribute(type = AttributeType.Ethnicity, value = "Rolo"))
  attributes.add(Attribute(type = AttributeType.Eyes,      value = "Azules"))
  attributes.add(Attribute(type = AttributeType.Gender,    value = "Masculino"))
  attributes.add(Attribute(type = AttributeType.HairColor, value = "purple"))
  attributes.add(Attribute(type = AttributeType.HairLength,value = "largo"))
  attributes.add(Attribute(type = AttributeType.Height,    value = "chaparro"))
  attributes.add(Attribute(type = AttributeType.Nose,      value = "En Garfio"))
  attributes.add(Attribute(type = AttributeType.Skin,      value = "Blanco"))
  attributes.add(Attribute(type = AttributeType.Tatoo,     value = "All over"))
  return attributes
}
