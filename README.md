MaxSatisfactionCalculator

Assumptions:

The algo / program has been written taking into consideration that total time given is measured in minutes and time required to eat each item is measured 
in minutes

Algorithmic Approach for Calculation

The way this is optimally solved is using dynamic programming - solving for smaller sets of knapsack problems and then expanding them for the bigger problem

Time Complexity:

Analyzing the complexity of the solution is pretty straight-forward. We just have a loop for time to eat each item(W) within a loop of number of items(N) => O (NW)

Input

Input to the program contains the three things : 1. The time to eat 2. The number of dishes 3. The list of dishes in the form of Satisfaction Values in time

Output: Maximum Satisfaction value

Steps to creat the Project:

Create a spring boot version 1.4.2 Gradle Project from http://www.start.spring.io
Download and import as gradle project in IDE(STS) 
Create classes InputDataReader and satisfaction calculator service
Autowire the same in the Application.java.

Steps to the Run the Project:

Run the application by clicking on the file Application.java and Run as Java Application.
Output can be seen on the console.

To Run the test cases:
To Run Individual Test Files , Click on Files having pattern *Tests.java and run as JUNIT Tests.
