<%@page import="br.com.listadecasamento.model.Carrinho"%>
<%@page import="br.com.listadecasamento.model.Convidado"%>
<%@page import="br.com.listadecasamento.model.Pedido"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>


<jsp:useBean id="Pedido" type="Pedido" scope="session"/>
<jsp:useBean id="User" type="Convidado" scope="session"/>
<jsp:useBean id="Carrinho" type="Carrinho" scope="session"/>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
            <div class="col-md-12" align="center">
                &nbsp;
            </div>
        </div>
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			
                    <h4 class="text-left">
                        Pedido Concluído com Sucesso! <br>
                        Os noivos ficarão muito felizes com seu presente!
		    </h4>
                    <br>
                  
        
		<div class="col-md-2">
		</div>
	</div>

    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>