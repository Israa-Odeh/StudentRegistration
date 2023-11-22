import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

class Student() {
  private var ID: String = ""
  private var name: String = ""
  private var major: String = ""
  private var birthDate: String = ""
  private val courses: ArrayBuffer[Course] = ArrayBuffer.empty

  // Student's courses setter.
  def setStudentCourse(course: Course): Unit = {
    courses += course
  }
  // Student's courses getter.
  def getStudentCourses: ArrayBuffer[Course] = {
    courses
  }
  // Student's courses printer.
  def printStudentCourses: String = {
    courses.map {course =>
      s"Number: ${course.getCourseNo}, Credit Hours: ${course.getCredits}, Grade: ${course.getGrade}"
    }.mkString("\n")
  }

  // Student ID setter.
  protected def setStuID(stuID: String): Unit = {
    ID = stuID
  }
  // Student ID getter.
  def getStuID: String = {
    ID
  }

  // Student name setter.
  protected def setStuName(stuName: String): Unit = {
    name = stuName
  }
  // Student name getter.
  def getStuName: String = {
    name
  }

  // Student major setter.
  protected def setStuMajor(stuMajor: String): Unit = {
    major = stuMajor
  }
  // Student major getter.
  def getStuMajor: String = {
    major
  }

  // Student birthdate setter.
  protected def setStuBirth(stuBirth: String): Unit = {
    birthDate = stuBirth
  }
  // Student birthdate getter.
  def getStuBirth: String = {
    birthDate
  }

  // A function to read a student ID from the user.
  protected def enterID(): Unit = {
    var stuIDInput = ""
    while(stuIDInput.isBlank) {
      print("Please enter a student ID: ")
      stuIDInput = readLine()
      try {
        stuIDInput.toInt
      }
      catch {
        case _: NumberFormatException =>
          println("Invalid ID value!")
          stuIDInput = ""
      }
    }
      setStuID(stuIDInput)
  }

  // A function to ensure that the passed name is of a valid format.
  protected def checkNamePattern(inputName: String): Boolean = {
    val namePattern =  "^[A-Za-z\\s-]+$".r
    namePattern.pattern.matcher(inputName).matches()
  }

  // A function to read the student name from the user.
  protected def enterStuName(): Unit = {
    var stuNameInput = ""
    while(stuNameInput.isBlank) {
      print("Please enter the student name: ")
      stuNameInput = readLine()
      if(!checkNamePattern(stuNameInput)) {
        println("Invalid name format!")
        stuNameInput = ""
      }
    }
      setStuName(stuNameInput)
  }

  // A function to read the student major from the user.
  protected def enterMajor(): Unit = {
    var stuMajorInput = ""
    while(stuMajorInput.isBlank) {
      print("Please enter the student major: ")
      stuMajorInput = readLine()
      if (!checkNamePattern(stuMajorInput)) {
        println("Invalid major format!")
        stuMajorInput = ""
      }
    }
      setStuMajor(stuMajorInput)
  }

  // A function to ensure that the date format is of a valid format.
  protected def checkDateFormat(inputDate: String): Boolean = {
    val datePattern = """^\d{2}/\d{2}/\d{4}$""".r
    datePattern.pattern.matcher(inputDate).matches()
  }

  // A function to read the student birthdate from the user.
  protected def enterBirth(): Unit = {
    var stuBirthInput = ""
    while(stuBirthInput.isBlank) {
      print("Please enter the student birthdate: ")
      stuBirthInput = readLine()
      if (!checkDateFormat(stuBirthInput)) {
        println("Invalid date format: Use DD/MM/YYYY.")
        stuBirthInput= ""
      }
    }
      setStuBirth(stuBirthInput)
  }

  // A public function to fill the necessary student details.
  def insertStudent(): Unit = {
    enterID()
    enterStuName()
    enterMajor()
    enterBirth()
  }
}
