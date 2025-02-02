#Makefile
run-dist:
	./build/install/app/bin/app
clean:
	./gradlew clean
build:
	./gradlew build
installDist:
	./gradlew installDist
run:
	./gradlew run
check:
	./gradlew check
lint:
	./gradlew checkstyleMain
lintTest:
	./gradlew checkstyleTest
test:
	./gradlew test
build-run:
	build run
.PHONY: build

run-dist1:
	./build/install/app/bin/app -h
run-dist2:
	./build/install/app/bin/app -h -f=upper ./f1 ./f2
run-dist3:
	./build/install/app/bin/app -f=upper ~/play_brain/java-project-71/app/src/test/resources/file1.json ~/play_brain/java-project-71/app/src/test/resources/file2.json
run-dist4:
	./build/install/app/bin/app /home/hexlet/play_brain/java-project-71/app/src/test/resources/file1.json  /home/hexlet/play_brain/java-project-71/app/src/test/resources/file2.json