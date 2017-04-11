package E34

import fi.kajstrom.efpscala.E34.EmployeeManager
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Kaitsu on 11.4.2017.
  */
class EmployeeManagerSpec extends FlatSpec with Matchers{
  it should "remove employee from the list after calling remove" in {
    val empManager = new EmployeeManager

    empManager.remove("John Smith")
    empManager.getEmployees.contains("John Smith") should be (false)
  }
}
