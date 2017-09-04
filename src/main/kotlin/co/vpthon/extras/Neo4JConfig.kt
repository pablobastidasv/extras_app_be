package co.vpthon.extras

import org.neo4j.ogm.session.SessionFactory

class Neo4jSessionFactory private constructor(){
    private object Holder {
        val INSTANCE = SessionFactory("co.vpnthon.extras")
    }

    companion object {
        val instance: SessionFactory by lazy { Holder.INSTANCE}
    }
}