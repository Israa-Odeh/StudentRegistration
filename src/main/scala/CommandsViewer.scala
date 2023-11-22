
class CommandsViewer {

  // A function to display the available commands.
  def displayCommands(): Unit = {
    println("\n----------------------------------------------------")
    println("This is the list of commands that you can deal with:")
    println("----------------------------------------------------")
    println("InsertS: To insert a new student.")
    println("-------------------------------------")
    println("AddC: To add a new course.")
    println("-------------------------------------")
    println("AddCS: To add a course for a student.")
    println("-------------------------------------")
    println("SearchS: To search for a student.")
    println("-------------------------------------")
    println("SearchC: To search for a course.")
    println("-------------------------------------")
    println("Exit: To terminate the program.")
    println("-------------------------------------")
  }
}
