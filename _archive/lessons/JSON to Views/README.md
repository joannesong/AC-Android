- title: Displaying JSON on the screen
- tags: android, json

# Objectives

- Create a website locally on your computer
- Connect to your website from an Android App

# Lecture

Today we will run a Jetty Server from our local machines.
We will then add JSON data to the server response, and have our Android app
parse that response

## Creating-A-Jetty-Server-In-IntelliJ

A tutorial that shows how you can quickly develop embedded code against the Jetty API.

## Preface
Here are some technical terms used in this article and their definitions:

[wget](http://www.computerhope.com/unix/wget.htm) - weget stands for "web get". It is a command-line utility which downloads files over a network.

[curl](https://curl.haxx.se/docs/manpage.html) - curl is a tool to transfer data from or to a server, using one of the supported protocols (DICT, FILE, FTP, FTPS, GOPHER, HTTP, HTTPS, IMAP, IMAPS, LDAP, LDAPS, POP3, POP3S, RTMP, RTSP, SCP, SFTP, SMB, SMBS, SMTP, SMTPS, TELNET and TFTP). The command is designed to work without user interaction.

* You can use the man command followed by another command line command, i.e., ```man wget```, to a more detailed description of the command.


[JAR](https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jarGuide.html) -JAR stands for Java ARchive. It's a file format based on the popular ZIP file format and is used for aggregating many files into one. Although JAR can be used as a general archiving tool, the primary motivation for its development was so that Java applets and their requisite components (.class files, images and sounds) can be downloaded to a browser in a single HTTP transaction, rather than opening a new connection for each piece. This greatly improves the speed with which an applet can be loaded onto a web page and begin functioning. The JAR format also supports compression, which reduces the size of the file and improves download time still further. Additionally, individual entries in a JAR file may be digitally signed by the applet author to authenticate their origin.

[Maven](https://maven.apache.org/what-is-maven.html) -
Maven is a  tool that can now be used for building and managing any Java-based project.
Maven’s primary goal is to allow a developer to comprehend the complete state of a development effort in the shortest period of time.

## I. Downloading the Jars

[Download the latest version of Jetty](http://www.eclipse.org/jetty/download.html)

Jetty is decomposed into many jars and dependencies to achieve a minimal footprint by selecting the minimal set of jars. Typically it is best to use something like Maven to manage jars, however this tutorial uses an aggregate Jar that contains all of the Jetty classes in one Jar. You can manually download the aggregate jetty-all.jar using curl) or a browser.

* Note: The central Maven repository has started to aggressively reject/deny access to the repository from the wget command line tool (due to abusive use of the tool by some groups). The administrators of the central maven repository have stated that the recommended command line download tool is now curl.*

Use curl as follows:

```
> mkdir Demo

> cd Demo

> curl -o jetty-all-uber.jar http://central.maven.org/maven2/org/eclipse/jetty/aggregate/jetty-all/9.3.12.v20160915/jetty-all-9.3.12.v20160915-uber.jar
```

## II. Writing a HelloWorld Example
The Embedding Jetty section contains many examples of writing against the Jetty API. This tutorial uses a simple HelloWorld handler with a main method to run the server. You create in an editor the file HelloWorld.java with the following content:

```

package nyc.c4q;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloWorld extends AbstractHandler
{
    @Override
    public void handle( String target,
                        Request baseRequest,
                        HttpServletRequest request,
                        HttpServletResponse response ) throws IOException,
                                                      ServletException
    {
        // Declare response encoding and types
        response.setContentType("text/html; charset=utf-8");

        // Declare response status code
        response.setStatus(HttpServletResponse.SC_OK);

        // Write back response
        response.getWriter().println("<h1>Hello World</h1>");

        // Inform jetty that this request has now been handled
        baseRequest.setHandled(true);
    }

    public static void main( String[] args ) throws Exception
    {
        Server server = new Server(8080);
        server.setHandler(new HelloWorld());

        server.start();
        server.join();
    }
}
```


## III. Compiling the HelloWord example
The following command compiles the HelloWorld class:

```
> mkdir classes

> javac -d classes -cp jetty-all-uber.jar HelloWorld.java
```


## IV. Running the Handler and Server

The following command runs the HelloWorld example:

```
> java -cp classes:jetty-all-uber.jar nyc.c4q.HelloWorld
```

You can now point your browser at [http://locathost:8080](http://localhost:8080) to see your hello world page.

## V. Adding jetty-all-uber.jar to our project in IntelliJ

In IntelliJ:

1. Click File from File menu
2. Project Structure (CTRL + SHIFT + ALT + S on Windows/Linux, ⌘ + ; on Mac OS X)
3. Select Modules at the left panel
4. Dependencies tab
5. '+' → JARs or directories
6. Select jetty-all-uber-.jar

*Source: http://www.eclipse.org/jetty/documentation/current/advanced-embedding.html*

## Update Android App

After setting up and running your jetty server, we need to connect to an Android app.
- Create a new android app
- Add retrofit library
- Write java code to connect to your website
- Verify that you can receive text data from your website

## Sending and receiving JSON
- Add a JSON object to your website response. For example, a list of colors
- Write Android code to parse the JSON and display the list in a view
