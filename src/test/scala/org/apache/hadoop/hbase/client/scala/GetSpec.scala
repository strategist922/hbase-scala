package org.apache.hadoop.hbase.client.scala

import org.specs._
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.client.HTable

/**
 * Unit test for Get operations.
 */
class GetSpec extends SpecificationWithJUnit with HBaseTestCluster {
	val TABLE_NAME = "TestTable"
	val FAMILY_NAME = "TestFamily"

	// Start Hase
	doBeforeSpec { startMiniCluster }

	"Scala Get" should {
		doFirst {
			if (!hBaseAdmin.tableExists(TABLE_NAME)) {
				hBaseTestingUtility.createTable(Bytes.toBytes(TABLE_NAME), Bytes.toBytes(FAMILY_NAME))
			}
			else {
				hBaseTestingUtility.truncateTable(Bytes.toBytes(TABLE_NAME))
			}
		}
		
		"perform implicit conversion to standard Get" in {
			val hTable = new HTable(configuration, TABLE_NAME)
			val get = Get[String]("TestRow", { rowString: String => Bytes.toBytes(rowString) })
			hTable.get(get)
		}
	}
	
	// Stop HBase
	doAfterSpec { shutdownMiniCluster }
}
