package co.vpthon.extras

import org.neo4j.ogm.session.Session

class Controller {

    fun matchPeople(query: Query) : List<Person>{
        return ArrayList<Person>()
    }


}



fun main(args: Array<String>) {
    val session: Session = Neo4jSessionFactory.instance.openSession()

    val person = session.loadAll(Person::class.java)
    println(person)
    val products = session.loadAll(Attribute::class.java)
    println(products)
}
