import sbt._
import Keys._

object HelloSbtPlugin extends AutoPlugin {
  override lazy val projectSettings = Seq(commands ++= Seq(hello, world))
  lazy val hello = Command.command("hello") { state =>
    println("hello")
    state
  }
  lazy val world = Command.command("world") { state =>
    println("world")
    state
  }
}
