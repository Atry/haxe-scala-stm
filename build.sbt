haxeSettings

haxeJavaSettings

for (c <- Seq(Compile, Test)) yield {
  haxeOptions in c ++=
    Seq("-D", "scala")
}

for (c <- Seq(Compile, Test)) yield {
  haxeOptions in c ++=
    Seq(
      "-D", "no-root",
      "-D", "json_stream_no_dot",
      "-lib", "continuation")
}

haxeOptions in Compile ++= Seq("-dce", "no")

haxeOptions in Test ++= Seq("-dce", "no")

javacOptions in Compile in compile += "-Xlint:-deprecation"

libraryDependencies += "org.scala-stm" %% "scala-stm" % "0.7"

libraryDependencies += "com.qifun" %% "haxe-scala-library" % "0.2.0" % HaxeJava classifier "haxe-java"

organization := "com.qifun"

name := "haxe-scala-stm"

version := "0.1.1"

homepage := Some(url(s"https://github.com/qifun/${name.value}"))

startYear := Some(2014)

licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

publishTo <<= (isSnapshot) { isSnapshot: Boolean =>
  if (isSnapshot)
    Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
  else
    Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}

scmInfo := Some(ScmInfo(
  url(s"https://github.com/qifun/${name.value}"),
  s"scm:git:git://github.com/qifun/${name.value}.git",
  Some(s"scm:git:git@github.com:qifun/${name.value}.git")))

pomExtra :=
  <developers>
    <developer>
      <id>Atry</id>
      <name>杨博 (Yang Bo)</name>
      <timezone>+8</timezone>
      <email>pop.atry@gmail.com</email>
    </developer>
    <developer>
      <id>zxiy</id>
      <name>张修羽 (Zhang Xiuyu)</name>
      <timezone>+8</timezone>
      <email>95850845@qq.com</email>
    </developer>
    <developer>
      <id>chank</id>
      <name>方里权 (Fang Liquan)</name>
      <timezone>+8</timezone>
      <email>fangliquan@qq.com</email>
    </developer>
  </developers>

