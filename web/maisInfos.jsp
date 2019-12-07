<%@page import="br.com.listadecasamento.model.Convidado"%>
<!DOCTYPE html>
<jsp:useBean id="User" type="Convidado" scope="session"/>
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
			<h3 class="text-center">
				Mais Informações
			</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
		</div>
		<div class="col-md-6">
			<form role="form" action="./atualizaInfo" method="POST">
                                <div class="form-group">
					${User.name}, só faltam algumas informações para finalizar o pedido.
				</div>
				<div class="form-group">
					Email: <input type="text" class="form-control" type="email" id="fullName" name="txtemail">
				</div>
                                <div class="form-group">
                                    Digite uma menssagem para o casal:<br>
                                    <textarea name="txtmsg" rows="10" cols="97.5"></textarea>
				</div>
				
				<button type="submit" class="btn btn-primary" formaction="./atualizaInfo">
					Entrar
				</button>
			</form>
		</div>
		<div class="col-md-3">
		</div>
	</div>

    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>