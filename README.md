# SeatingChart

In order to use the Seating Chart application, you have to create  a csv file and place it in the the PAC folder.
Within the csv file, each line should contain the name of the teacher, the number of students in the class, and their grade.
There should be no spaces on each line. For example,

Cintas,24,11
Pirie,34,11
Kalinski,32,11
Norman,30,11
Thrasher,35,11
Malone,29,11
Rainaldi,30,11

Then, save the file as teachers.csv
Double click the file named PAC.jar
The program should output a file called SeatingChart.txt located within the PAC folder.
When you open this file, it will contain the seating chart.



//Advanced Information
The Seating Chart algorithim automatically sorts teachers by grade placing seniors in the front and freshman in the back. It is difficult to
change this functionality. However, one thing you should note is that within the grade, teachers are organized by the order they appear in the csv file. If 
you want a teacher to sit closer to the front, put them at the top of the file. The PAC folder also contains a file called PAC.zip . This file is meant
to be loaded into Eclipse or some other java editor just in case you want to edit the code. 