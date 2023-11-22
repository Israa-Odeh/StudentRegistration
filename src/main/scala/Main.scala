import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

object Main extends App {
  val studentsLog = ArrayBuffer.empty[Student]
  val coursesLog = ArrayBuffer.empty[Course]
  var commandViewer = new CommandsViewer

  while(true) {
    commandViewer.displayCommands()
    readCommand()
  }

  // A function to read the entered command from the user.
  private def readCommand(): Unit = {
    print("\nPlease enter the command you want: ")
    val userInput = readLine()

    // The entered command is to insert a new student.
    if (userInput.equalsIgnoreCase("InsertS")) {
      var stu = new Student
      stu.insertStudent()
      if (checkStudentExistence(stu.getStuID)) {
        stu = null
        println("This student is already added.")
      }
      else {
        studentsLog += stu
        println("The student is successfully added.")
      }
    }
    // The entered command is to add a new course.
    else if (userInput.equalsIgnoreCase("AddC")) {
      var course = new Course
      course.addCourse()
      if(checkCourseExistence(course.getCourseNo)) {
        course = null
        println("This course is already added.")
      }
      else {
        coursesLog += course
        println("The course is successfully added.")
      }
    }
    // The entered command is for adding a course to a student.
    else if (userInput.equalsIgnoreCase("AddCS")) {
      addCourseToStudent()
    }
    // The entered command is for searching for a specific student.
    else if (userInput.equalsIgnoreCase("SearchS")) {
      val enteredStudentID = checkStuID()
      studentsLog.find(_.getStuID.equals(enteredStudentID)) match {
        case Some(student) =>
          println("Student Details are as follows: ")
          println("Student ID: " + student.getStuID)
          println("Student Name: " + student.getStuName)
          println("Student Major: " + student.getStuMajor)
          println("Student BirthDate: " + student.getStuBirth)
          println("Student Courses: " + student.printStudentCourses)
        case none =>
          println("The entered student doesn't exist.")
      }
    }
    // The entered command is for searching for a specific course.
    else if (userInput.equalsIgnoreCase("SearchC")) {
      val enteredCourseNo = checkCourseNo()
      coursesLog.find(_.getCourseNo.equals(enteredCourseNo)) match {
        case Some(course) =>
          println("Course Details are as follows: ")
          println("Course Number: " + course.getCourseNo)
          println("Credit Hours: " + course.getCredits)
        case none =>
          println("The entered course doesn't exist.")
      }
    }
    // The entered command is for terminating the program.
    else if (userInput.equalsIgnoreCase("Exit")) {
      sys.exit(0)
    }
    else {
      println("Invalid Command, try again!")
    }
  }

  // A function to determine if the student exists.
  private def checkStudentExistence(stuID: String): Boolean = {
    for(student <- studentsLog) {
      if(student.getStuID.equals(stuID)) {
        return true
      }
    }
    false
  }

  // A function to determine if the course exists.
  private def checkCourseExistence(courseNo: String): Boolean = {
    for(course <- coursesLog) {
      if(course.getCourseNo.equals(courseNo)) {
        return true
      }
    }
    false
  }

  // A function for adding a course to a student.
  private def addCourseToStudent(): Unit = {
    var (enteredStudentID, enteredCourseNum) = (checkStuID(), checkCourseNo())
    studentsLog.find(_.getStuID.equals(enteredStudentID)) match {
      case Some(student) =>
        coursesLog.find(_.getCourseNo.equals(enteredCourseNum)) match {
          case Some(course) =>
            student.getStudentCourses.find(_.getCourseNo.equals(course.getCourseNo)) match {
              case Some(stuCourse) => println("The course is already added to this student.")
              case none =>
                course.enterGrade()
                student.setStudentCourse(course)
                println("The course is successfully added to this student.")
            }
          case none => println("The entered course doesn't exist.")
        }
      case none => println("The entered student doesn't exist.")
    }
  }

  // A function to Check whether the entered student ID is valid.
  private def checkStuID(): String = {
    // Check if the entered student ID is a valid integer.
    var enteredStudentID = ""
    while (enteredStudentID.isBlank) {
      print("Enter the student ID: ")
      enteredStudentID = readLine()
      try {
        enteredStudentID.toInt
      }
      catch {
        case _: NumberFormatException =>
          println("Invalid student ID!")
          enteredStudentID = ""
      }
    }
    enteredStudentID
  }

  // A function to Check whether the entered course number is valid.
  private def checkCourseNo(): String = {
    // Check if the entered course number is a valid integer.
    var enteredSCourseNum = ""
    while (enteredSCourseNum.isBlank) {
      print("Enter the course Number: ")
      enteredSCourseNum = readLine()
      try {
        enteredSCourseNum.toInt
      }
      catch {
        case _: NumberFormatException =>
          println("Invalid course number!")
          enteredSCourseNum = ""
      }
    }
    enteredSCourseNum
  }
}





