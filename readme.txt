=========================================
==     Accessing CICS with Spring      ==
==         sample application          ==
=========================================

@author Thierry Templier


1. MOTIVATION

The aim of the sample is to show how to use the support
of JCA in Spring to access CICS applications.

2. BUILD AND DEPLOYMENT

This directory contains the standalone app source.
For deployment, it needs to be built with Apache Ant.
The only requirements are JDK >=1.3 and Ant >=1.5.
Before using the build.bat script, you need to set the
JAVA_HOME environment variable.

In order to compile the application, run "build.bat build".

To launch the application, you need to run "build.bat launch"
and to have the following libraries in the classpath:
- Spring library (spring.jar)
- JCA 1.0 library (connector.jar)
- Apache's Commons Logging (commons-logging.jar)
- IBM CICS libraries available with the connector (ccf2.jar,
  cicseci.jar, cicsecitools.jar, cicsframe.jar, ctgclient.jar,
  ctgserver.jar)
- JCics libraries (jcics.jar and recjava.jar).

Note that to start Ant this way, you'll need an XML parser
in your classpath (e.g. in "%JAVA_HOME%/jre/lib/ext"; included in JDK 1.4).

3. WARNING

This code works starting the version 1.2.4 of Spring which corrects a bug
relative to the use of RecordCreator.
See the following issue in JIRA: http://opensource.atlassian.com/projects/spring/browse/SPR-1176
for more informations. This issue provides too a workaround to make work the
RecordCreator feature with the preceding versions of Spring.
