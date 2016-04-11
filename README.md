MyApps:
- Please consider the whole application has been implemented by using: Spring, JUnit, Mockito.
- Please go to TriangleController.java in order to run the application (Spring Boot has been used in order to create an embedded server).
-  Once run, please try the application by accessing the REST services as follows:
http://localhost:8080/triangle/side1/{side1}/side2/{side2}/side3/{side3}
- It will return something like this:
When requesting: 
http://localhost:8080/triangle/side1/10/side2/10/side3/10
It will return:<p>
{<p>
	"sideOne": 10.0,<p>
	"sideTwo": 10.0,<p>
	"sideThree": 10.0,<p>
	"triangleType": "EQUILATERAL"<p>
}<p>
- When requesting for a non-valid triangle and exception will be thrown. Example:
http://localhost:8080/triangle/side1/10/side2/0/side3/10<p>
Will return:<p>
There was an unexpected error (type=Internal Server Error, status=500).
<b>Invalid size length</b> 
- In order to check the evidence about testing please consider the following integration test class: 
TriangleServiceIntegrationTest.java
- It has been developed by considering a kind of service layer represented by: TriangleOperationsServiceImpl.java
- All operations and validation has been implemented in a separate class: TriangleHelper.java
- In order to check how each class works please consider its test class related.

