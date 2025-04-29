# Makefile para Etapa 1: T1Stage1

# Variables
JAVAC = javac
JAVA = java
MAIN = T1Stage1
SOURCES = $(wildcard *.java)
CLASSES = $(SOURCES:.java=.class)

# Reglas
all: $(CLASSES)

$(CLASSES): $(SOURCES)
	$(JAVAC) $(SOURCES)

run: all
	$(JAVA) $(MAIN)

clean:
	rm -f *.class

