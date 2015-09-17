cd C:
javac -cp .:/Users/Nathan/tic-tac-toe/acceptance TicTacToeKeywords.java
java -cp .:\Users\Nathan\tic-tac-toe\build\classes\main\edu\jsu\mcis::DEV/robotframework/robotframework-2.9.1.jar org.robotframework.RobotFramework TicTacToeTests.txt
pause