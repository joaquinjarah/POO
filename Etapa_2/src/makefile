# Variables
JFLAGS = -g -encoding ISO8859_1
JC = javac
JVM = java
CONFIG = config.txt  # Archivo de configuración

# Archivos de clases del proyecto
CLASSES = T1Stage2.java Broker.java Topic.java \
          Publisher.java Subscriber.java \
          Recorder.java Seguidor.java Ruta.java

# Clase principal
MAIN = T1Stage2

# Reglas
# Regla predeterminada
default: classes

# Regla para compilar todos los archivos .java
classes: $(CLASSES:.java=.class)

# Regla para ejecutar el programa
run: classes
	$(JVM) $(MAIN) $(CONFIG)

# Limpiar los archivos .class generados
clean:
	$(RM) *.class
