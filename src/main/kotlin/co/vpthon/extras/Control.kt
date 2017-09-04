package co.vpthon.extras

import java.util.*

class Controller {

    fun matchPeople(query: Query) : List<Person>{

        val params : HashMap<String, Object> = HashMap<String, Object>();
        val cypher = StringJoiner(",", "MATCH ", " RETURN person")


        //Gender, City, Eyes, Ethnicity, Height, BodyType,
        if (!query.data.gender.isNullOrEmpty()) {
            cypher.add("(person:Person)-[:HAS]-(:Attribute{type: '${AttributeType.Gender.name}', value: '${query.data.gender}' }),");
        }


        val people = Neo4jSessionFactory.instance.openSession().query(cypher.toString(), params);

        return ArrayList<Person>()
    }

}
