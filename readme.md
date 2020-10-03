link to github : https://github.com/lauyu10/tp-1-algo-distribuee.git
Part 1 question 1 - 2

With Putty
This code will create a socket that will listen to the port 5555
When there is a connection, the server display some information (the question) 
The user can type some number in order to have his result of the addition
The connection will be closed at the end

Attention, Here the server can not receive more than one client
If a second client tries to connect it, the connection will be refused

Part 1 question 3
With the client code
This code needs to be launched after the server
Here, the description for the question 1 - 2, is the same for this question
 
Part 1 question 4 
Here the client will read a file that is in the resources folder. 
We will use FileInputStream in order to read a file and the BufferedWriter to write in the socket
while the fileinputstream.read() still has some caracters, we will write into the bufferedWriter

The server will read the socket and will Write into a file with FileOutputStream.
While the bufferedReader.read() still has some caracters, we will write into the FileOutputStream

Part 2 
Create a thread for the addition server
In order to create a server that accepts more than one client, we need to implements Runnable
When a client connects into the server, we will create a thread that will communicate with the client
The calculation will be done on the run function

Part 3 
Create a chat => With given code mychat.java from Moodle
In MyChat, we will create a Thread ReadChatClient that will only read the data from the socket. 
If we don't do that, the code will be block. 
On the server part, Each connection will be save into a static list
The server will implement Runnable in order to have more than one client
When a thread reads something, then he will put on each socket's output the receive data
  



