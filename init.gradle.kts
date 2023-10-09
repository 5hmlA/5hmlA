fun RepositoryHandler.enableMirror(project:Project) {
  var has5hmlARepo = false
  all {
    if (this is MavenArtifactRepository) {
	  if(this.url.toString().contains("5hmlA/sparkj")){
		has5hmlARepo = true
	  }
	  println("init.gradle.kts-> 【${project.name}】 Repository: ${this.url}")
      val originalUrl = this.url.toString().removeSuffix("/")
      urlMappings[originalUrl]?.let {
        //logger.lifecycle("Repository[$url] is mirrored to $it")
		println("init.gradle.kts-> 【${project.name}】 Repository[$url] is mirrored to $it")
        this.setUrl(it)
      }
    }
  }
  if(has5hmlARepo){
	return
  }
  // 添加新的仓库
  maven {
      isAllowInsecureProtocol = true
      url = uri("https://maven.pkg.github.com/5hmlA/sparkj")
      credentials {
          // https://www.sojson.com/ascii.html
          username = """\u005a\u0075\u0059\u0075\u006e"""
          password = """\u0067\u0068\u0070\u005f\u0031\u0063\u0062\u0064\u004d\u004a\u0073\u005a\u0042\u0057\u0033\u006a\u0077\u0057\u0053\u004b\u006e\u0066\u0037\u0042\u0053\u0069\u0044\u006d\u0061\u0030\u0066\u0044\u0048\u0076\u0031\u007a\u0059\u0050\u0073\u0044"""
      }
  }
}
val urlMappings = mapOf(
  "https://repo.maven.apache.org/maven2" to "https://mirrors.tencent.com/nexus/repository/maven-public/",
  "https://dl.google.com/dl/android/maven2" to "https://mirrors.tencent.com/nexus/repository/maven-public/",
  "https://plugins.gradle.org/m2" to "https://mirrors.tencent.com/nexus/repository/gradle-plugins/"
)
gradle.allprojects {
  println("init.gradle.kts-> 【${project.name}】 allprojects ==============================")
  buildscript {
    repositories.enableMirror(project)
  }
//  repositories.enableMirror()
  //https://github.com/gradle/gradle/issues/20210
  //https://docs.gradle.org/current/userguide/upgrading_version_8.html#deprecations
  project.layout.buildDirectory.set(File("E:/0buildCache/${rootProject.name}/${project.name}"))
  println("init.gradle.kts-> 【${project.name}】 buildDir is relocated to -> ${project.layout.buildDirectory.asFile.get()} 🥱")
  //buildDir = File("E:/0buildCache/${rootProject.name}/${project.name}")
  println("init.gradle.kts-> 【${project.name}】 allprojects ==============================")
}

gradle.beforeSettings {
  println("init.gradle.kts-> project:${rootProject.name} beforeSettings ==============================")
//  pluginManagement.repositories.enableMirror()
//  dependencyResolutionManagement.repositories.enableMirror()
}