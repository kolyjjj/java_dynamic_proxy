apply<JavaPlugin>()

configure<JavaPluginConvention> {
    setSourceCompatibility(1.8)
    setTargetCompatibility(1.8)
    version = "0.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit:junit:4.12")
}