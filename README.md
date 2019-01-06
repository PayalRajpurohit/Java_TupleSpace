# Java_TupleSpace
In this program we implemented a system based on tuple spaces. We implemented a tuple space as a single server to which multiple clients connect, chose the implementation that you prefer 

The processes are able to perform the operations, write, read, and take from the tuple space. It is able to write a matching function that matches tuples that contain any combinations of Strings, Integers, and Booleans. We assumed that a maximum of 3 entries in each tuple but it can be any combination of any of the three types mentioned <String, Integer, Boolean>, <Boolean, String, Integer> … etc. The matching also should include be able to specify all fields or match a specific type, for example <String, 124, true> or <”XYZ”, Boolean, 7>, … etc.  

This implementation also demonstrates capabilities of tuple spaces such as the ability to update a value. 
