<h1>Simple Search Engine</h1>
This is my web application created using java and it contains 2 features,Search and History, for its users. Search feature helps in querying and History helps in viewing past queries of user.
<h1>Technologies used</h1>
This web application follows is 3-tire architecture.<br>
<b>Frontend: </b>HTML, CSS<br>
<b>Backend: </b>Java servlets
<b>Database: </b>MySQL server
<h1>Innernal working of Simple Search Engine</h1>
<h3>Feature1 - Search</h3>
When user enters his query,named as keyword, in textbox and clicks Serach button, then this keyword is transfered to Search servlet in backend. Search servlet has two function to perform:<br>
1) It inserts keyword and its webpage link to history table of database.<br>
2) It performs ranking algorithm on database for keyword and prepares .jsp file and returns it to frontend.<br>
When frontend receives webpage, it displays in user interface.
<h3>Feature2 - History</h3>
When user clicks History button, control will to History servlet in backend. This servlet will create history.jsp file with entries from history table of database. This file is sent to frontend amd it displays it.
<h3>Working of Crawler</h3>
Code in Crawler is used to fill database used by SearchEngine. This code will crawl across www with starting point as <b>https://www.javatpoint.com</b>. I implemented this crawling using limited dfs algorithm.  
<h1>Softwares required to run this project</h1>
1) IntelliJ Idea(Community version is enough)<br>
2) MySQL server with MySQL shell or MySQL Workbench
<h1>How to execute this project</h1>
<h3>Dependencies used:</h3>
1) Apache Tomcat Server - used as host server of this web application. Change configuration of webserver to this server for SearchEngine folder.<br> 
2) Smart Tomcat Plugin in IDE - helps to auto config classpath of tomcat<br>
3) JavaSE - it is for JDBC<br>
4) Library to integrate java servlets from Maven repository - javax.servlet:javax.sevlet-api:4.0.1<br>
5) MySqlconector/J for connecting java and MySQL database<br>
6) JSoup library from Maven Repository - org.jsoup:jsoup:1.15.4  --helps in parsing html objects to java objects
<h3>Executing this query in MySQL server</h3>
Create database searchengineapp;<br>
use searchengineapp;<br>
create table pages(
	pageTitle varchar(200),
	pageLink text,
    pageText mediumtext
);<br>
create table history(
	keyword text,
    link text
);
<h3>Steps for running this project</h3>
1) Add JSoup and MySqlconector/J libraries to Crawler.<br>
2) Give user-name and passowrd of MySQLServer in DatabaseConnection.java file in both folders of WebCrawler and SearchEngine.<br>
3) Run this code. This code will create database for this project<br>
4) Integrate java servlets into SearchEngine folder.<br>
5) After configuring out host server as Tomcat, we can just run this project.



