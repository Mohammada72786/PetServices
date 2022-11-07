<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> Animal Management</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<form action="DogServlet" method="post">
    <table class="table bg-info">
		<tr>
		    <td> Name </td>
		    <td> <input type="text" name="name" placeholder="Enter name of dog"></td>
		</tr>
		<tr>
		    <td> Weight</td>
		    <td><input type="Number" name="weight" placeholder="Enter weight in Kgs"></td>
		</tr>
		<tr>
		    <td>colour</td>
		    <td> <input type="text" name="colour" placeholder="Enter color of your dog"></td>
		</tr>
           <tr>
			<td>Gender</td>
			<td><select name = "gender">
				<option value="MALE">MALE</option>
				<option value="FEMALE">FEMALE</option>
				</select>
			</td>
		 </tr>
		 <tr>
			 <td> Date of Birth</td>
			<td> <input type="date" name="dateofbirth" required  /></td>
		    </tr>
		    <tr>
			 <td>Speed</td>
			 <td> <input type="number" name="speed" placeholder="Enter speed in Km/h"></td>
		    </tr>	     
</table>
<input type="submit" value="submit" name="submit">
</form>
</body>
</html>