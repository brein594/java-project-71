#Makefile
run-dist:
	./build/install/app/bin/app
clean:
	./gradlew clean
installDist:
	./gradlew installDist
run:
	./gradlew run
check:
	./gradlew check
run-dist1:
	./build/install/app/bin/app -h
run-dist2:
	./build/install/app/bin/app -h -f=upper ./f1 ./f2
run-dist3:
	./build/install/app/bin/app -f=upper ~/play_brain/java-project-71/file1.json ~/play_brain/java-project-71/file2.json
run-dist4:
	./build/install/app/bin/app -f=upper /home/hexlet/play_brain/java-project-71/file1.json /home/hexlet/play_brain/java-project-71/file2.json