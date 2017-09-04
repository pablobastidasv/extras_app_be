package co.vpthon.extras

class Controller {

    fun matchPeople(query: Query) : List<Person> ?{
        return null
    }


}


fun main(args: Array<String>) {
    val params : HashMap<String, Object> = HashMap<String, Object>();
    val cypher = "MATCH (people:Person) RETURN people";
    val people = Neo4jSessionFactory.instance.openSession().query(Person::class.java, cypher, params);

/*
    for (item in people.queryResults()) {
        println(item["name"])
    }
*/
}
