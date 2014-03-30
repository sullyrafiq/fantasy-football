name := "fantasy-football"

version := "1.0-SNAPSHOT"

resolvers += Resolver.url("Objectify Play Repository", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns)

resolvers += Resolver.url("Objectify Play Snapshot Repository", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "be.objectify" %% "deadbolt-java" % "2.2-RC4",
  "be.objectify" %% "deadbolt-scala" % "2.2-RC2"
)     

play.Project.playJavaSettings
