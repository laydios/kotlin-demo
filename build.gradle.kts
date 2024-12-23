import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.4.32"

	id("org.springframework.boot") version "2.5.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.31"
	kotlin("kapt") version kotlinVersion
	kotlin("plugin.spring") version "1.5.31"
	kotlin("plugin.jpa") version kotlinVersion
	kotlin("plugin.allopen") version kotlinVersion
	idea
}

group = "com.iron.kotlin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

object DependencyVersions {
	const val AWS_SDK_VERSION = "1.12.130"
	const val KOTLIN_LOGGING_VERSION = "2.1.16"
	const val KINESIS_CLIENT = "2.3.5"
	const val QUERYDSL = "4.4.0"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
//	implementation("org.springframework.boot:spring-boot-starter-web")
	kapt("org.springframework.boot:spring-boot-configuration-processor")

	// jackson
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

	// aws
	implementation(platform("com.amazonaws:aws-java-sdk-bom:${DependencyVersions.AWS_SDK_VERSION}"))
	implementation("com.amazonaws:aws-java-sdk-sts")
	implementation(platform("software.amazon.awssdk:bom:2.17.99"))
	implementation("software.amazon.awssdk:sts:2.17.99")

	// logging
	implementation("io.github.microutils:kotlin-logging:${DependencyVersions.KOTLIN_LOGGING_VERSION}")
	implementation("net.logstash.logback:logstash-logback-encoder:7.0.1")

	// db
	runtimeOnly("mysql:mysql-connector-java")

	// jpa
//	implementation ("com.vladmihalcea:hibernate-types-52:2.14.0")
//	implementation("com.querydsl:querydsl-jpa:${DependencyVersions.QUERYDSL}")
//	kapt("com.querydsl:querydsl-apt:${DependencyVersions.QUERYDSL}:jpa")

	implementation("io.springfox:springfox-boot-starter:3.0.0")
	implementation("io.springfox:springfox-swagger-ui:3.0.0")

	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

	testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
	testImplementation("org.mockito:mockito-inline:4.2.0")
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}

idea {
	module {
		val kaptMain = file("build/generated/source/kapt/main")
		sourceDirs.add(kaptMain)
		generatedSourceDirs.add(kaptMain)
	}
}

springBoot.buildInfo { properties {  } }

configurations.all {
	resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<Wrapper> {
	gradleVersion = "7.1.1"
}

defaultTasks("bootRun")

//if (project.hasProperty("prod")) {
//	println("Profile: prod")
//	apply {
//		from("profile_prod.gradle")
//	}
//} else if (project.hasProperty("staging")) {
//	println("Profile: staging")
//	apply {
//		from("profile_staging.gradle")
//	}
//} else {
//	println("Profile: dev")
//	apply {
//		from("profile_dev.gradle")
//	}
//}