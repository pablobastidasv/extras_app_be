package co.vpthon.extras

import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.session.SessionFactory

class Neo4JConfig {
  val config: Configuration = Configuration()

  init {
    val password: String = System.getenv("NEO4J_PASS")
    val server: String = System.getenv("NEO4J_SERVER")

    config.driverConfiguration()
    config.driverConfiguration().driverClassName = "org.neo4j.ogm.drivers.bolt.driver.BoltDriver"
    config.driverConfiguration().uri = "bolt://$server"
    config.driverConfiguration().connectionPoolSize = 150
    config.driverConfiguration().setCredentials("neo4j", password)
  }
}

class Neo4jSessionFactory private constructor() {
  private object Holder {
    val INSTANCE = SessionFactory(Neo4JConfig().config, "co.vpthon.extras")
  }

  companion object {
    val instance: SessionFactory by lazy { Holder.INSTANCE }
  }
}
