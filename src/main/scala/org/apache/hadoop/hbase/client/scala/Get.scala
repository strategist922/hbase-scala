package org.apache.hadoop.hbase.client.scala

import org.apache.hadoop.hbase.client.RowLock

/**
 * Used to perform Get operations on a single row.
 * @param row row key
 * @param rowEncoder encoder to use to transform the row key into a byte array
 * @param rowLock previously acquired row lock, or null
 */
class Get[T](val row: T, val rowEncoder: (T => Array[Byte]), val rowLock: RowLock) {
	lazy val rowBytes = rowEncoder(row)

	/**
	 * Creates a Get operation for the specified row.
	 * @param row row key
	 * @param rowEncoder encoder to use to transform the row key into a byte array
	 */
	def this(row: T, rowEncoder: (T => Array[Byte])) = this(row, rowEncoder, null)
}

/**
 * Get companion object containing factory methods.
 */
object Get {
	/**
	 * Factory method for creating Get instances.
	 * @param row row key
	 * @param rowEncoder encoder to use to transform the row key into a byte array
	 * @return a Get instance
	 */
	def apply[T](row: T, rowEncoder: (T => Array[Byte])) = new Get(row, rowEncoder)

	/**
	 * Factory method for creating Get instances.
	 * @param row row key 
	 * @param rowEncoder encoder to use to transform the row key into a byte array
	 * @param rowLock previously acquired row lock, or null
	 * @return a Get instance
	 */
	def apply[T](row: T, rowEncoder: (T => Array[Byte]), rowLock: RowLock) = new Get(row, rowEncoder, rowLock)

	/**
	 * Converts a Scala Get instance into a standard Get instance.
	 * @param scalaGet the Scala Get instance to convert
	 * @return a standard HBase Get instance
	 */
	implicit def scalaGet2HBaseGet[T](scalaGet: Get[T]): org.apache.hadoop.hbase.client.Get = {
		new org.apache.hadoop.hbase.client.Get(scalaGet.rowBytes, scalaGet.rowLock)
	}
}
