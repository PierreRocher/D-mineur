sources = $(wildcard *.java)
classes = $(sources:.java=.class)

all: $(classes)

clean :
	rm -f *.class

run:
	java Main

%.class : %.java
	javac $*.java
	java Main
