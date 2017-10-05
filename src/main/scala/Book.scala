package book

class Book(var title: String = "Default Title", val ISBN: Int) {
  val pubDate = {
    val d = new java.util.Date(1506999666)
    d.toString()
  }

  def printInfo() {
    println("Title: " + title)
    println("ISBN: " + ISBN.toString())
    println("Publication Date: " + pubDate)
  }

}
