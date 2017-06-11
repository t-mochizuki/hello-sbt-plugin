import sbt._
import Keys._

import java.io.{File, FileWriter}

object HelloSbtPlugin extends AutoPlugin {
  override lazy val projectSettings = Seq(commands ++= Seq(hello, world, createFile))
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
}
