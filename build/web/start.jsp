<%-- 
    Document   : start
    Created on : Nov 23, 2019, 11:40:37 PM
    Author     : felipery03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="User" type="br.com.listadecasamento.model.Convidado" scope="session"/>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bem vindo a Lista de Casamento</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
                    <p id="credits" align="right"> Developed by Felipe Rigo Yoshimura </p>
		</div>
	</div>
        <div class="row">
		<div class="col-md-12">
			<h3 class="text-center">
				Casamento Bea e Felipe
			</h3>
		</div>
        </div>
        <div class="row">
            <div class="col-md-12" align="center">
                    <img src="images/noivos.jpeg" align="center" width="200"/>
            </div>
        </div>
	
        <div class="row">
            <div class="col-md-12" align="center">
                &nbsp;
            </div>
        </div>
        <div class="row">
            <div class="col-md-12" align="center">
                &nbsp;
            </div>
        </div>
	<div class="row">
		<div class="col-md-12">
			<h4 class="text-center">
				Bem vindo ${User.name}!
			</h4>
		</div>
	</div>
         <div class="row">
            <div class="col-md-12" align="center">
                &nbsp;
            </div>
        </div>
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<form role="form" action="homeservlet" method="GET">
				<div class="form-group">

				<button type="submit" class="btn btn-primary">
					Voltar
				</button>
			</form>
		</div>
		<div class="col-md-2">
		</div>
	</div>

    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>