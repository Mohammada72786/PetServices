<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnimalManagement</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style>
		.container{
			width: 70%;
			border:1px solid black;
			margin:auto;
			padding:2px;
			font-size: 20px;
			font-optical-sizing: red; 
		}
		.redish{
			font-color:red;
		}
		</style>	
</head>
<body>
	<div class="jumbotron">
		<div class="text-center">
		<h3 class="bg-info">A pet is the only thing on earth that loves you more than you love yourself.</h3>
		</div>
	</div>
	<div class="container">
  <ul class="nav nav-pills nav-justified">
    <li class="active"><a href="index.jsp">Home</a></li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Dog <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="adddog.jsp"><button class = "btn-sm btn-success">Add Dog<span class="glyphicon glyphicon-arrow-right"></span></button></a></li>
        <li><a href="RemoveDog.html">Remove Dog</a></li>
        <li><a href="Update.html">Update Dog</a></li>  
        <li><a herf="DisplayDogs.html"> Display Dogs</a></li>                      
      </ul>
    </li>
    <li class="dropdown">
		<a class="dropdown-toggle" data-toggle="dropdown" href ="#">Food<span class="caret"></span></a>
	    <ul class="dropdown-menu">
            <li><a href="AddFood.html"><button class = "btn-sm btn-success">Add Food</button></a></li>
            <li><a href="RemovFood.html">Remove Food</a></li>
            <li><a href="UpdateFood.html">Update Food</a></li>  
            <li><a herf="DisplayFoods.html"> Display Foods</a></li>                      
        </ul>
	   </li>
	 <li class="dropdown">
		<a class="dropdown-toggle" data-toggle="dropdown" href ="#">Pet Store<span class="caret"></span></a>
	    <ul class="dropdown-menu">
            <li><a href="AddPetStore.html">Add Pet Store</a></li>
            <li><a href="RemovPetStore.html">Remove Pet Store</a></li>
            <li><a href="UpdatePetStore.html">Update Pet Store</a></li>  
            <li><a herf="DisplayPetStores.html"> Display Pet Stores</a></li>                      
        </ul>
	   </li>
    <li class="dropdown">
		<a class="dropdown-toggle" data-toggle="dropdown" href ="#">Breed<span class="caret"></span></a>
	    <ul class="dropdown-menu">
            <li><a href="AddBreed.html">Add Breed</a></li>
            <li><a href="RemovBreed.html">Remove breed</a></li>
            <li><a href="UpdateBreed.html">Update Breed</a></li>  
            <li><a herf="DisplayBreeds.html"> Display Breeds</a></li>                      
        </ul>
	   </li>
  </ul>
      <div>
		<img src="https://image.shutterstock.com/image-photo/sun-conure-parrot-bird-beautiful-260nw-2099915854.jpg" class="img-responsive img-circle" alt="Parrot">
	  </div>
		<img src="https://imgmediagumlet.lbb.in/media/2020/11/5facfc1680b36513e1ac8da1_1605172246688.jpg?fm=webp&w=750&h=500&dpr=2" width="500" height="400" class="img-responsive">
		

</body>
</html>



