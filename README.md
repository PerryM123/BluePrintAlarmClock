# BluePrintAlarmClock
Software Engineering class project <p>
Android Application <p> 
Project length: 2 months <p>
# Software Engineering Ideologies and Patterns: 
<b>Agile Programming: </b> <p>
-Weekly Meetings <p>
-Set short term goals <p>
<b>SCRUM (4 members) </b> <p>
-SCRUM team consisted of SCRUM MASTER, Development team, and Product Owner
-1 week sprints<p>
-Before each sprint, team members set and explains goals for the sprint
-At the end of the sprint, we conduct a code review
<b>Model-View-Controller Pattern(MVC) </b> <p>
-Focused on utilizing MVC pattern

#  Goal <p>
At the time of being a university student, I noticed many students had a lot of difficulties with waking up early for class. Many students rely 
on cell phone alarm systems, but the major flaw for this lies in the "Shut off alarm". After a normal cell phone alarm
rings, many students are successful awakened but on the other hand, countless students make the mistake of shutting
off the alarm and falling back to sleep. As a result, the student misses class. <p> <p>

This is where we come in. The BluePrintAlarmClock will function like a normal alarm clock but with one catch. In order 
to stop our users from falling back to sleep after turning off the alarm, we have set up a challenge where the 
user would be forced to solve an easy simple or difficult mathematical problem and spelling puzzles to shut off the alarm. <p> <p>

The idea is: <p>
we want to force the user to wake up and use brain power to shut off the alarm. With the help of a difficult math 
problem, the user will be unable to solve the problem quickly and will be forced to find a pen and paper to solve the math problem. After the user uses brain power 
and successfully shuts off the alarm, the user will be FULLY awakened and be unable to fall back asleep.

# Screenshots
![alt tag](https://raw.githubusercontent.com/PerryM123/BluePrintAlarmClock/master/screenshots/MainScreen.png)
<p>
![alt tag](https://raw.githubusercontent.com/PerryM123/BluePrintAlarmClock/master/screenshots/CreateAlarmScreen.png)
<p>
![alt tag](https://raw.githubusercontent.com/PerryM123/BluePrintAlarmClock/master/screenshots/MathProblemEasy.png)
<p>
![alt tag](https://raw.githubusercontent.com/PerryM123/BluePrintAlarmClock/master/screenshots/MathProblemHard.png)
<p>
![alt tag](https://raw.githubusercontent.com/PerryM123/BluePrintAlarmClock/master/screenshots/AfterSolving.png)
<p>

# Regrets/Things we wished improved on/Lessons learned
-Unfortunately, due to time constraints, our final sprint was incredibly hectic. We made a lot of desperate fixes and
ugly ugly ugly design decisions to push our product out for the user. <p>
Evidence of this is in: <p>
-AlarmSetting.java <p>
-GlobalVariables.java  <p>
-Main.java <p>
-NormalAlarmReceiver <p>
-MathProblems <p>

-Also, due to time constraints, we were forced to remove the Word problem and Word Spelling Problems for the project
leaving the application only with a Math Problem Alarm. <p>

-<b>A very big lack of proper documentation</b>:  <p>
   Because the deadline was closing in very fast, we disregarded using JavaDoc or any sort of documentation. This ended
   up hurting us in the long run. It made our code unreadable and difficult to follow. Running into this problem
   made me realize how <b> incredibly important</b> it is to properly document work for future works.

# Contributors<p>
<b>AlarmSetting.java</b> - worked on by Perry and Travis <p>
<b>GlobalVariables.java</b> - Nick, Rameet <p>
<b>Main</b> - Perry, Nick, Travis, Rameet <p>
<b>MathProblem</b> - Perry <p>
<b>MathScreen</b> - Perry <p>
<b>NormalAlarmReceiver</b> - Perry, Nick, Travis, Rameet <p>
<b>SnoozeDismiss</b> - Perry and Travis <p>
<b>SoundService</b> - Travis <p>
<b>WordProbWorker</b> - Perry <p>
<b>generateWords</b> - Perry <p>

## About Us/ Authors
A team of programmers working on the same goal during our school semester <p>
Author: <p>
Perry Miranda - perrymiranda1@yahoo.com <p>
