Write a fortune cookie server that will serve random cookie. The server is started as follows  
```
java -cp fortunecookie.jar fc.Server 12345 cookie_file.txt 
```

This will start the server; the server will now listen on port 12345 (TCP). 
cookie_file.txt is a file containing a list of ‘cookies’. This is a text file. The server 
will randomly return one cookie from this file. 

1) What is a java server ? How to code a java server ?
 1a) How does a server code looks like ? 
 1b) what is the purpose of a java server ? serve client msg
 1c) Which are the following classes and package is needed to form a java server? -> google , stackoverflow

2. How can I generate a jar or archieve , ** jar or maven package ?

3. What are those 2 values after the class program ? argument.. what is this argument used for ?
 3a) Ok so the first is a port number ...how can I assign this value the port to a java server program ? Which class which method which package in JDK?

4. Is the cookie file given to me ? if yes how to read a cookie file using io in java ? Open the cookie file to take a look how data is stored ... discover that the cookies are stored line by line ... how can I read line by line in Java ? BufferedReader ... once I am able to read line by line how can I convert it to a Java object ? is it an rray or list ?

### Line by line
alright sample.txt should be replace by the argument from the java program
```
try {
			Scanner scanner = new Scanner(new File("sample.txt"));

			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
```