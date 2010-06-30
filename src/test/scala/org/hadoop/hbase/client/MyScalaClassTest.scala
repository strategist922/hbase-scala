package org.hadoop.hbase.client

import org.specs._
import org.specs.runner._

class MyScalaClassTest extends SpecificationWithJUnit {
	"Creating MyScalaClass with greeting" should {
		"say hello world" in {
			val msc = MyScalaClass("Hello, World!")
			msc.myVal mustEqual "Hello, World!"
		}
	}
}
