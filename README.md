# JSPACAL

Java Solar Position Algorithm CALculator. Uses NREL SPA algorithm to calculate solar position.

## USAGE
----------------

###  maven

* configure local/internal maven repo by installing or deploying artifact

install - put artifact in local maven repository: 

	mvn install

deploy - put artifact at remote maven repository:

	mvn deploy -DaltDeploymentRepository=id::layout::url

NOTE: To be able to deploy to a remote repository it must be added to servers tag in `settings.xml`.

* configure the repository - either in `pom.xml` or in `setttings.xml`

`pom.xml` - add this to your `pom.xml` file:

	<repositories>
		<repository>
			<id>repo-id</id>
			<url>repo-url</url>
		</repository>
	</repositories>

`settings.xml` - userwide settings are modified in the active profile by adding the following to `settings.xml` file:

	<profiles>
		<profile>
			<id>myprofile</id>
			<repositories>
				<repository>
					<id>repo-id</id>
					<url>repo-url</url>
				</repository>
			</repositories>
		</profile>
	</profiles>

	<activeProfiles>
		<activeProfile>myprofile</activeProfile>
	</activeProfiles>

* add this to your `pom.xml` file:

<pre>
&lt;dependency&gt;
   &lt;groupId&gt;com.github.jspacal&lt;/groupId&gt;
   &lt;artifactId&gt;jspacal&lt;/artifactId&gt;
   &lt;version&gt;1.0&lt;/version&gt;
&lt;/dependency&gt;
</pre>

### non-maven
Build distribution package of this project using the following command:

	mvn clean package

Distribution packages in zip/tar.gz/tar.bz2 formats should be created in target directory. Add artifact and its dependencies to your classpath.

2. AUTHORS
----------------

Przemyslaw Jacewicz <przemyslaw.jacewicz@gmail.com>