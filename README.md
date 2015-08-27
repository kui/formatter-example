~~~~~~~~~~~~~~~~~~~~~~~~sh
$ ./gradlew fatJar
$ java -jar ./build/libs/fatjar-1.0.jar **/JavaFormatter.java | diff **/JavaFormatter.java -
~~~~~~~~~~~~~~~~~~~~~~~~
