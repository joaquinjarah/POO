# Compiler and flags
JFLAGS = -g -encoding ISO8859_1
JC = javac
JVM = java

# Source and output directories
SRC_DIR = src
BIN_DIR = bin
OUT_DIR = out

# Classes with full paths
CLASSES = \
	$(SRC_DIR)/app/Program.java \
	$(SRC_DIR)/broker/Broker.java \
	$(SRC_DIR)/broker/Topic.java \
	$(SRC_DIR)/component/Component.java \
	$(SRC_DIR)/component/publisher/Publisher.java \
	$(SRC_DIR)/component/subscriber/Subscriber.java \
	$(SRC_DIR)/component/subscriber/Follower.java

MAIN = app.Program

# Targets
default: classes

classes:
	mkdir -p $(BIN_DIR)
	mkdir -p $(OUT_DIR)
	$(JC) $(JFLAGS) -d $(BIN_DIR) $(CLASSES)

run:
	$(JVM) -cp $(BIN_DIR) $(MAIN)

clean:
	rm -rf $(BIN_DIR)/*
	rm -f $(OUT_DIR)/*.txt
