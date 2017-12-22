- title: Http Revisited
- tags: java, android, app, Volley, Networking

# Objectives
- Learn alternate ways for downloading information
- Identify the steps in an Http request

# Lecture
## HTTPS and SSL
Https represents a secure alternative to http. It means all communication over http
will be encrypted, protecting sensitive data. It works by using to keys to encrypt
data, a public key and a private key. Anything encrypted by the public key can only
be decrypted by the private key. When using https, the webserver should hold the
private key, and the client will use the public key to encrypt data sent to the server.
When the client connects to a server, the server will send an SSL certificate, which
contains the public key.

All communication in http is plain text, and is routed through multiple computers on
the way to its destination. Any of those computers can pretend to be the website you
actually want to visit. Hence SSL provides a way to verify that you are communicating
with the server you expect to, and no one can eavesdrop on the conversation.

SSL depends on trusted SSL providers. These are authorities that issue SSL certificates,
which a server will distribute to clients that connect to it. Your web browser has a
list of trusted SSL providers, and will issue a warning when it receives a certificate
from an organization not on that list.

## HttpUrlConnection
https://github.com/lighterletter/Dual-level-API-request<br>
HttpUrlConnection is the built in class used to perform http interactions in Android. It
is no longer used too often, in favor of more advanced libraries maintained by teams of
engineers, such as Retrofit or Volley. It is possible to build a complete networking 
library yourself, using this class, but you will have to handle error responses,
secure connections, and parsing data in more fine grained than a library.  

## Running Network Operations
https://developer.android.com/training/basics/network-ops/connecting.html<br>
When your app wants to run a network operation, you need to
- Verify you are online
- Run the operation on a background thread
- Convert the received object into the desired format
- Communicate with the foreground thread the result if necessary
- Verify the operation responds to the android lifecycle correctly

## Volley
https://developer.android.com/training/volley/simple.html<br>
Volley is the http library supplied by Android Open Source Project, the official
Android organization. Volley is sure to be supported in the future, and a lot of
modifications are made to it regarding efficient networking and power savings.
