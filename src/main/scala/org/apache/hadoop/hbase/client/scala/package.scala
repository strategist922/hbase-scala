package org.apache.hadoop.hbase.client

/**
 * Package object for org.apache.hadoop.hbase.client.scala.
 */
package object scala {
	/**
	 * Converts a Scala Get instance into a standard Get instance.
	 * @param scalaGet the Scala Get instance to convert
	 * @return a standard HBase Get instance
	 */
	implicit def scalaGet2HBaseGet[T](scalaGet: org.apache.hadoop.hbase.client.scala.Get[T]): org.apache.hadoop.hbase.client.Get = org.apache.hadoop.hbase.client.scala.Get.scalaGet2HBaseGet(scalaGet)
}
