package co.vpthon.extras

fun createPeople() : List<Person>{

  val testPeople = ArrayList<Person>(6)
  testPeople.add(Person("Marcus"))
  testPeople.add(Person("Kevin"))
  testPeople.add(Person("Julian"))
  testPeople.add(Person("Pablo"))
  testPeople.add(Person("Daniel"))
  testPeople.add(Person("Agustin"))
  return testPeople
}
