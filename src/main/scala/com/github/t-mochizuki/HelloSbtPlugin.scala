import sbt._
import Keys._

import java.io.{File, FileWriter}
import scala.sys.process.Process

object HelloSbtPlugin extends AutoPlugin {
  val cs = Seq(
    hello,
    world,
    createFile,
    showListDirectoryContents
  )
  override lazy val projectSettings = Seq(commands ++= cs)
  lazy val hello = Command.command("hello") { state =>
    println("hello")
    state
  }
  lazy val world = Command.command("world") { state =>
    println("world")
    state
  }
  lazy val createFile = Command.command("createFile") { state =>
    val file = new File("./newFile")
    val fileWriter = new FileWriter(file, false)
    fileWriter.write("")
    fileWriter.close()
    state
  }
  lazy val showListDirectoryContents = Command.command("showListDirectoryContents") { state =>
    Process("ls").run()
    state
  }
}
