JAVAC = javac
JAVA = java
MAIN_CLASS = Main
ARGS = arg1 arg2 arg3 args4

all: compile 

compile:\
    $(JAVAC) $(MAIN_CLASS).java

run:\
    $(JAVA) $(MAIN_CLASS) 

clean:\
    rm -f *.class