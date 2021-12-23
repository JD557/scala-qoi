import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

name := "qoi"

organization := "eu.joaocosta"

version := "1.0"

scalaVersion := "2.13.7"

ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"

lazy val root =
  crossProject(JVMPlatform, NativePlatform)
    .in(file("."))
    .settings(
      Seq(
        scalaVersion := "2.13.7",
        libraryDependencies ++= List(
          "eu.joaocosta"   %%% "minart-core" % "0.3.2",
          "eu.joaocosta"   %%% "minart-pure" % "0.3.2"
        ),
        scalafmtOnCompile := true,
        semanticdbEnabled := true,
        semanticdbVersion := scalafixSemanticdb.revision,
        scalafixOnCompile := true
      )
    )
    .nativeSettings(
      Seq(
        nativeLinkStubs := true,
        nativeMode      := "release-full",
        nativeLTO       := "thin",
        nativeGC        := "immix"
      )
    )
    .settings(name := "qoi Root")
