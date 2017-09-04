package co.vpthon.extras

import org.neo4j.ogm.session.Session

class Controller {

    fun matchPeople(query: Query) : List<Person>{

        val params : HashMap<String, Object> = HashMap<String, Object>();
        var cypher = "";

        val people = Neo4jSessionFactory.instance.openSession().query(cypher, params);

        if (!query.data.gender.isNullOrEmpty()) {
            cypher+="";
        }


        return ArrayList<Person>()
    }


}
