JCC=javac
CWD=$(shell pwd)

CODE=$(shell find com/company -type f -name "*.java" | tr '\n' ' ')
CLASS_FILES=$(shell find . -type f -name "*.class" | tr '\n' ' ' | sed 's/\$$/\\$$/g')

MAIN=com.company.Main
DEPS=$(CODE)

default: SchedulerOne

SchedulerOne: $(DEPS)
	$(JCC) $(DEPS)

run:
	java -cp $(CWD) $(MAIN)

clean:
	rm $(CLASS_FILES)
