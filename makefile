JAVAC = javac
JAVA = java
MAIN_CLASS = Main

all: compile 

compile:\
    $(JAVAC) $(MAIN_CLASS).java

run:\
    $(JAVA) $(MAIN_CLASS) 

clean:\
    rm -f *.class