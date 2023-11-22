import scala.io.StdIn.readLine

class Course {
  // Class Fields.
  private var courseNo: String = ""
  private var creditHours: Int = 0
  private var grade: Int = 0

  // Course number setter.
  protected def setCourseNo(numValue: String): Unit = {
    courseNo = numValue
  }
  // Course number getter.
  def getCourseNo: String = {
    courseNo
  }

  // Credit hours setter.
  protected def setCredits(credits: Int): Unit = {
    creditHours = credits
  }
  // Credit hours getter.
  def getCredits: Int = {
    creditHours
  }

  // Grade setter.
  protected def setGrade(gradeValue: Int): Unit = {
    grade = gradeValue
  }
  // Grade getter.
  def getGrade: Int = {
    grade
  }

  // A function to read a course number from the user.
  protected def enterCourseNo(): Unit = {
    var courseNum = ""
    while(courseNum.isBlank) {
      print("Please enter a course number: ")
      courseNum  = readLine()
      try {
        courseNum.toInt
      }
      catch {
        case _: NumberFormatException =>
          println("Invalid course number!")
          courseNum = ""
      }
    }
      setCourseNo(courseNum)
  }

  // A function to ensure that the course credit hours are in range of [0,9].
  protected def checkCreditsPattern(inputCredits: String): Boolean = {
    val creditsPattern = "^[0-9]$".r
    creditsPattern.pattern.matcher(inputCredits).matches()
  }

  // A function to read the course credit hours from the user.
  protected def enterCredits(): Unit = {
    var creditsInput = ""
    while (creditsInput.isBlank) {
      print("Please enter the course credit hours: ")
      creditsInput = readLine()
      if(!checkCreditsPattern(creditsInput)) {
        println("Invalid credit hours: 0-9 range required!")
        creditsInput = ""
      }
    }
      setCredits(creditsInput.toInt)
  }

  // A function to ensure that the course grade is in range of [0,100].
  protected def checkGradePattern(inputGrade: String): Boolean = {
    val gradePattern = "^100$|^[0-9]{1,2}$".r
    gradePattern.pattern.matcher(inputGrade).matches()
  }

  // A function to read the course grade from the user.
  def enterGrade(): Unit = {
    var gradeInput = ""
    while (gradeInput.isBlank) {
      print("Please enter a grade for this student: ")
      gradeInput = readLine()
      if(!checkGradePattern(gradeInput)) {
        println("Invalid grade: 0-99 range required!")
        gradeInput = ""
      }
    }
      setGrade(gradeInput.toInt)
  }

  // A public function to fill the necessary course details.
  def addCourse(): Unit = {
    println()
    enterCourseNo()
    enterCredits()
  }
}
