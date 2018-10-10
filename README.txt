## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf neha_naik_assign_2.tar.gz neha_naik_assign_2

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 06/20/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

O(n)

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

-----------------------------------------------------------------------

Command line validations

1. The code accepts only 2 arguments, if argument length doesn’t match this criteria, the code throws an error saying: Incorrect number of arguments.\nPlease provide input and output file path only.

2. If the input text file path is invalid, the code throws an error saying: Invalid file path.\nPlease enter a valid input file path.

3. If the input text file is blank, the code throws an error saying: File is empty.

-----------------------------------------------------------------------


![alt text](https://raw.githubusercontent.com/nehanaik/Microwave-State-Pattern/branch/path/to/state_diagram.png)

