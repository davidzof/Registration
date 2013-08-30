Java code to handle registration process for software. This is a prove of concept.
It uses Elliptical Curve cryptography to sign keys in a robust and secure manner.

The workflow is as follows.

Client submits "serial" that has been hashed using something like MD5 or SHA.
We encrypt this with our private key, turn it into a human readable 40 byte
hex string and return it to the client. In reality this process would take
place on a remote server, or by email.

Client enter key into his software. The software decrypts it using the public
key and compares it with a Hash of the software serial number. The public key
is included in the client software but not the private key. So anyone
examining the software and finding the public key will not be able to sign their
own keys.

The serial number is unique for the client, it could be created at install
time, from a MAC network card address but in our case we use a UUID which we
store in a central repository.

We use Elliptic Curve asymetric encryption for encrypting the key. The
registration key is personal and tied to a particular install so can't simply
be passed around. It is hard for a third party to generate keys. As the code
itself can be decompiled and patched out by a skilled user the process
doesn't benefit from too much security. It is just good enough to deter naive
users.

Cryptography uses: Elliptic Curve Cryptography in Java

https://sourceforge.net/projects/jecc/

There are no external dependencies. The JECC source is included with a couple
of modifications to make it easier to use predefined keys.
