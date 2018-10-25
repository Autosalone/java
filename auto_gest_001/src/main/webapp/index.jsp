<html>
<head>
<title>AutoGest.com</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<div id="formId"><!-- div form -->

<div id="bodyId"><!-- div body -->


<div class="container-fluid">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">AutoGest</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Registrati</a>
      </li>
    </ul>
  </div>
</nav>
<div class="row"><!-- header -->
<div class="col-sm">
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="immagini/migliori-citycar-2017-2018-offerte-fiat-panda.jpg" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="immagini/sportscar.jpg" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="immagini/Volkswagen-Cina-gamma-SUV.jpg" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div><!-- col-sm -->
</div><!-- row --><!-- /header -->
</div>

<div class="container-fluid">
<div class="row"><!-- middle -->
<div class="col-sm"><!-- filtroQuery -->
<h6 class="mt-3">---Applica filtri di ricerca---</h6>
<hr>
</div><!-- col-sm --><!-- /filtroQuery -->
<div class="col-sm">2</div><!-- col-sm -->
<div class="col-sm">3</div><!-- col-sm -->
<div class="col-sm">4</div><!-- col-sm -->
<div class="col-sm text-center"><!-- col-sm indice -->
<h6 class="mt-3">---Indice analitico---</h6>
<hr>
<!-- 
<form action="ServIndice" method="post">
<button type="submit" class="btn btn-button">Vedi tutto</button>
</form>
 -->
 <%@ page import ="com.auto_gest_001.model.Auto"%>
 <%@ page import ="com.auto_gest_001.implement.AutoImpl"%>
 <%@ page import ="java.util.ArrayList"%>
 <%@ page import ="java.io.PrintWriter"%>
 <form method="post" action="FiltroServlet">
 <input type = "hidden" name = "h" value = 1>
 <% 
 	AutoImpl autoImp = new AutoImpl();
	ArrayList<Auto> automobili1 = autoImp.select();
	
	for( Auto auto : automobili1 ) {
		out.println("<input href='#'>"+auto.getCasaProduttrice()+"</a><br>");
	}
%>
</form>
</div><!-- /col-sm indice -->
</div><!-- /middle -->
</div>



</div><!-- /div body -->
</div><!-- /div form -->

<script>
$(document)ready.(function () {
	
} );
</script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>