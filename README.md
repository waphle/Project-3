# Project 3
In this project, you will use a data file of dog rescue advertisements to design a user interface. Much like the previous homework, you will be designing classes that interact with each other. This data file contains all of the data used in The Pudding essay [Finding Forever Homes](https://pudding.cool/2019/10/shelters/) published in October 2019.

## The Data
You are being provided with a link to a data set of 58180 advertisements collected from the PetFinder API for all adoptable dogs in each state on September 20, 2019. This is a comma-separated value file (.csv) which is a human-readable file type in which each line contains data. Pieces of data are separated by a comma, and for this data set, there are thirty-six pieces of data (i.e., fields) per line. You can open up the file in any text editor (e.g., Sublime) or even Excel if you want to look at the data directly (and you should always inspect your data!).

| Header           | Description                                                                                                                                                  | Data Type |
| :--------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------- | :-------- |
| id               | The unique PetFinder identification number for each animal                                                                                                   | integer   |
| org\_id          | The unique identification number for each shelter or rescue                                                                                                  | character |
| url              | The URL for each animal’s listing                                                                                                                            | character |
| species          | Species of animal                                                                                                                                            | character |
| breed\_primary   | The primary (assumed) breed assigned by the shelter or rescue                                                                                                | character |
| breed\_secondary | The secondary (assumed) breed assigned by the shelter or rescue                                                                                              | character |
| breed\_mixed     | Whether or not an animal is presumed to be mixed breed                                                                                                       | logical   |
| breed\_unknown   | Whether or not the animal’s breed is completely unknown                                                                                                      | logical   |
| color\_primary   | The most prevalent color of an animal                                                                                                                        | character |
| color\_secondary | The second most prevalent color of an animal                                                                                                                 | character |
| color\_tertiary  | The third most prevalent color of an animal                                                                                                                  | character |
| age              | The assumed age class of an animal (`Baby`, `Young`, `Adult`, or `Senior`)                                                                                   | character |
| sex              | The sex of an animal (`Female`, `Male`, or `Unknown`)                                                                                                        | character |
| size             | The general size class of an animal (`Small`, `Medium`, `Large`, `Extra Large`)                                                                              | character |
| coat             | Coat Length for each animal (`Curly`, `Hairless`, `Long`, `Medium`, `Short`, `Wire`)                                                                         | character |
| fixed            | Whether or not an animal has been spayed/neutered                                                                                                            | logical   |
| house\_trained   | Whether or not an animal is trained to not go to the bathroom in the house                                                                                   | logical   |
| declawed         | Whether or not the animal has had its dewclaws removed                                                                                                       | logical   |
| special\_needs   | Whether or not the animal is considered to have special needs (this can be a long-term medical condition or particular temperament that requires extra care) | logical   |
| shots\_current   | Whether or not the animal is up to date on all of their vaccines and other shots                                                                             | logical   |
| env\_children    | Whether or not the animal is recommended for a home with children                                                                                            | logical   |
| env\_dogs        | Whether or not the animal is recommended for a home with other dogs                                                                                          | logical   |
| env\_cats        | Whether or not the animal is recommended for a home with cats                                                                                                | logical   |
| name             | The animal’s name (as given by the shelter/rescue)                                                                                                           | character |
| tags             | Any tags given to the dog by the shelter rescue (pipe `\|` separated)                                                                                        | character |
| photo            | The URL to the animal’s primary photo                                                                                                                        | character |
| status           | Whether the animal is `adoptable` or not                                                                                                                     | character |
| posted           | The date that this animal was first listed on PetFinder                                                                                                      | character |
| contact\_city    | The rescue/shelter’s listed city                                                                                                                             | character |
| contact\_state   | The rescue/shelter’s listed state                                                                                                                            | character |
| contact\_zip     | The rescue/shelter’s listed zip code                                                                                                                         | character |
| contact\_country | The rescue/shelter’s listed country                                                                                                                          | character |
| stateQ           | The state abbreviation queried in the API to return this result                                                                                              | character |
| accessed         | The date that this data was acquired from the PetFinder API                                                                                                  | character |
| type             | The type of animal                                                                                                                                           | character |
| description      | The full description of an animal, as entered by the rescue or shelter. This is the only field returned by the V1 API                                        | character |

## The Goal
For this project you will be designing an application containing at least one class: `RescueGUI`. The exact contents of each of this class is largely up to you, though there is functionality that is required. Some guidelines are given below for how to structure your code, but a major component of this assignment is to design classes and methods that achieve the desired results. At minimum, it is required that your application should start when the RescueGUI class is launched. It should display a simple GUI consisting of a bar chart, a text input field, and a search button. When a user types a word into the field and clicks the button, the bar chart should show how many dogs for each state have a description that includes that word.

Detailed class designs and recommendations are described below.

# Teams
You may partner with another student on this project to discuss code and strategies for completing the various parts of the assignment. You may share code with your partner, but you should still write much of your own code in your own repository. You should still update your repository (by pushing) incrementally as you make progress. It is up to teammates to ensure that their partner adheres to the <a href="https://www.american.edu/academics/integrity/code.cfm">American University Honor Code.</a> You may use [pair programming](https://en.wikipedia.org/wiki/Pair_programming), however, you must each take turns in the driver role on your own laptop. I should see commits and a submission on Github for each of you to get full credit for this assignment. If you decide to work with a partner, modify the statement below:

- [ ] I worked with [insert partner name] on this project.
- [x] I worked on my own.

## Step 1 - Import and Clone the Repo.
1. Clone the repository to your local machine.
1. As a reference for how to use git, I suggest <a href='http://codingdomain.com/git/'>this site</a>, as it avoids some of the more complicated theory behind git and focuses on the bare minimum practicalities.

## Step 1.5 - Verify that JavaFX works on your machine
Early in the class you were instructed to download a JDK, and version 8 was recommended. If you followed that recommendation, you should be all good here. However, if not, you might have some problems running JavaFX. If you do not remember what you installed, you can type `java -version` into the command line, which will give you output like the following:

> **Project-3-Dogs> java -version**<br>
> java version "10.0.2" 2018-07-17 <br>
> Java(TM) SE Runtime Environment 18.3 (build 10.0.2+13) <br>
> Java HotSpot(TM) 64-Bit Server VM 18.3 (build 10.0.2+13, mixed mode)

Included in this project repo is a test application that you can use to determine if JavaFX will run for you. This test application, `MyJavaFX.java`, is not intended to be part of your submission. It is one of the simple applications that we looked at in class.

Which version of Java do you have? In your command line, type `java -version`. If you see something like the following:

> **Project-3-Dogs> java -version**<br>
> java version "1.8.0_201" <br>
> Java(TM) SE Runtime Environment (build 1.8.0_201-b09) <br>
> Java HotSpot(TM) Server VM (build 25.201-b09, mixed mode)

Then you have Java 8 installed, and it comes with JavaFX. You do not really have to do anything else. If, however, you see the following:

> **Project-3-Dogs> java -version**<br>
> java version "11.0.1" 2018-10-16 LTS<br>
> Java(TM) SE Runtime Environment 18.9 (build 11.0.1+13-LTS)<br>
> Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.1+13-LTS, mixed mode)

That means that youI have installed Java 11. If you have installed Java 11 (or really anything after 10), then JavaFX is no longer included by default and you have some extra steps. These are detailed at the following link:  [https://openjfx.io/openjfx-docs/](https://openjfx.io/openjfx-docs/).

The short version of this is that you need to:

1. Download JavaFX and unzip it
1. Create a new environment variable pointing to the place that you unzipped JavaFX (think of this like a shortcut)
1. Compile JavaFX code with some extra commands between javac and the name of the .java source file.
1. Run JavaFX code with some extra commands between java and the name of the class with the main method.
1. The extra commands between javac/java and the name of the file/class tell Java that to use this code we need to load the JavaFX module and where it is located. The environment variable lets us do this without typing out the full address of the location we unzipped it. The link provides a complete description of the commands necessary to get this to work. There is one gotcha - if you are using PowerShell on a Windows machine, you do not use percent signs around a variable (e.g.,  %PATH_TO_FX%) you use $env:PATH_TO_FX. It accomplishes the same thing. When I type echo $env:PATH_TO_FX, I see the following:

> `C:\Program Files\Java\javafx-sdk-11.0.2\lib`

Why use Java 11 at all? I get it - you already have a lot of new information coming at you, and this is just one more thing to have to master. Why not just install Java 8? Well, it does make it easier to use JavaFX, but Java 8 is not really being updated any more by Oracle. There are security vulnerabilities that will persist, and no new features will be added. Java has moved to a much more modular system - rather than having everything built in, frameworks like JavaFX are separated and you only include them in your build if you need them. For good or bad, this is how Java is structured, and it's useful to have an understanding of how this works.

However, since you are just starting out learning Java, if you decide that this is all just too much, it is completely understandable to switch back to version 8.

## Step 2 - Download the Data
This is a big data file, so it is not being distributed with the repo for this project. You need to go to a different online repo to obtain the data, which is available at [https://github.com/the-pudding/data/tree/master/dog-shelters](https://github.com/the-pudding/data/tree/master/dog-shelters). You need to download the file marked `allDogDescriptions.csv`. For this project, .csv files have been added to the .gitignore file, so they should not be pushed to your shared repo.

## Step 3 - Have a Plan
No matter what methods and fields are in your classes, you need to be able to ensure that you have a plan for the overall design. We have talked in class about UML diagrams, and you should be quite comfortable at this stage documenting what should be contained in each of the classes you will create. As with the previous project, you can use an online editor, text file, or diagramming tool (e.g., even Powerpoint). Unlike the previous project, this does not have to be a full UML diagram - even a short written description of what you intend will suffice for this project. I **strongly** recommend you employ top-down, bottom-up, or some combination of the two design strategies for this project.

## Step 4 - Write the code for a Class to store the data for each dog
Your first priority should be to write the code that defines the fields and methods in that class. While you have some flexibility in how you define things, the class must store and provide access to the important contents of the advertisements for each row (i.e., `contact_state` and `description`).

Some important considerations:
1. The way that data is stored in objects of this class **heavily** influences the performance of the search. If you keep the description as a String, you absolutely can determine if the description contains a search term. However, it will be slow.
1. Not all dogs have descriptions. Objects should still be created for them, but you can potentially mark them as empty to speed up the process.

## Step 5 - Write code to Parse the Data File
Now that you have a way to store data in objects, your next task is to write code to read the data into the program from the .csv file. You have already done this for a previous project, so you should be quite comfortable at this stage parsing a .csv file. The most important fields to include are `contact_state` and `description`, though you may include other fields if you wish.

Some important considerations:

1. Where will the code for this go? It could, potentially, be in any of the classes.
1. Is it static or non-static?
1. Does it go into a main method, or some other method? Will there even be a main method in your program?

Regardless of your choices, all of the data should be converted into objects and made available in your program for use by the `RescueGUI` application.

## Step 6 - Write the code for the RescueGUI layout
The RescueGUI consists of three major parts:
1. A search button
1. A field for entering the text to search for
1. A bar chart of the results by state

 Start by thinking about how to position each of these elements into the appropriate spot by following the guideline below:

![Mockup for RescueGUI](RescueGUI_mockup.png)

## Step 7 - Write the code for the Search button
When the search button is clicked, you should check each of descriptions that you have imported for the search term. You will keep track of the number of matches by state - if the description of a dog contains the search term, then you should increment the counter for that state.

There are a number of ways to accomplish this, and how you search the descriptions depends heavily on how you have stored the data. Linear search will be incredibly slow, and binary search will be much faster. However, to perform a binary search, you must have already prepared the data. How you design this is up to you, but your search must accomplish the following:
1. It must use the text that is typed into the text input field. This is expected to be a single word, and you should ignore case
1. It must accomplish the search within a few seconds - I'm wording this loosely, as performance on your individual machine may vary.
1. It must pass the results to the Bar Chart so that the bar chart can be updated.

You may find it easier to design additional classes to support this, and I encourage you to feel free to design as many as you feel you need. If you find, for example, that you are having trouble passing back both state names and search term counts from a method, you can always create a class that contains a string and an int, passing back a list of these objects instead.

## Step 8 - Write the code for the Bar Chart.
When the search button is clicked, the results will be passed to the Bar chart. For each state, a rectangle will be drawn. The height of the rectangle indicates the number of records for that state that contains the search term. Below each bar is the two-letter abbreviation for the state (e.g., MD, VA, DC).

1. The height of the rectangles should be scaled to the number of pixels in your chart. If the chart is 400 pixels high, and you are using 20 pixels for the lettering, then that leaves 380 for the tallest bar. If a state contains 100 records matching the search term, and 100 is the highest possible result, then the bar for that state should be 380 pixels high. If a different state matches only 50 records, then that bar should be 190 pixels high.
1. The default placement for states is alphabetical by state name. If you want to get fancy and allow for other sorts through menu controls (e.g., by bar height), that is fine, but you must include the default alphabetical sorting.
1. You do not need to create a labeled y-axis, but the maximum value for the tallest bar should be indicated in the chart on the left side at the top.
1. The styling of the bar (color, etc.) and fonts is up to you. Choose a design that you find aesthetically pleasing.

## Step 9 - Push to Github
Do not forget to push your final submission to Github before the deadline.

# Grading
Grading will be assigned according to the following categories. As described in the syllabus, each category can receive a  &#10003; (satisfactory); a &#10003;+ (above and beyond); a &#10003;- (incorrect, incomplete, or sloppy); or in the worst case an &#10005;, meaning it was incorrect in several ways. A category assigned an &#10005; can carry significant grade penalties for this assignment, but usually does not receive more than 50% of the possible credit for an task.

Missing components receive a score of zero, but it is better to be missing a component (or comment it out) instead of submitting code that does not compile. Code that does not compile will not be graded, and a zero will be assigned for the project. Submitted code that contains runtime errors will be graded at the instructor's discretion.

1. **5%** Multiple commits were made throughout the project as progress was made, not just one big upload at the end. Multiple branches were created throughout the course of the project and were merged as progress was made on individual features.
1. **5%** The code is easy to follow and understand, and a plan is included.
1. **10%** The data file is parsed correctly and made available to the other classes in some way.
1. **20%** A class is created to store and organize the data for each dog.
1. **20%** RescueGUI layout follows the provided design.
1. **20%** Search button quickly searches for the entered field and passes the results to the bar chart.
1. **20%** Bar chart displays the results of the search according to the required functionality.

## Acknowledgment
Data for this assignment comes from Amber Thomas of The Pudding, and is compiled (among other places) in a [Github repo](https://github.com/the-pudding/data/tree/master/dog-shelters).