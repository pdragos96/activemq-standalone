This app works by using a standalone activemq instance as a message broker.

To run it, first make sure you have activemq installed. go to the directory where activemq is unzipped, and enter the 'bin' directory
from the command prompt and type 'activemq start'.

Then run the app by running the 'ActivemqStandaloneApplication' class. You will see that both consumers receive the same messsage. Also, to
see a history of the messages sent and picked up by consumers or messages waiting to be picked up go to
'http://localhost:8161/admin/topics.jsp' (username and password are by default 'admin').
