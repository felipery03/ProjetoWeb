<%@page import="br.com.listadecasamento.model.Convidado"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>


<jsp:useBean id="ListaConvidados" type="ArrayList<Convidado>" scope="request"/>
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
                        Página do ADMIN
		    </h4>
                    <br>
                    <h5> Digite o nome que deseja incluir/remover da lista </h5>
                         <div class="row">
            <div class="col-md-4" align="center">
            </div>
        </div>
        <form role="form" method="POST">
        <div class="row">
            <div class="col-md-4" align="right">
                <input type="text" class="form-control" id="fullName" name="txtName">
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-4" align="center">
            </div>
        </div>
                    
			   <ul class="nav">
                                
                               <li class="nav-item">
                                                       
				<button type="submit" class="btn btn-primary" formaction="adicionaconvidadoservlet" method="POST">
					Adicionar
				</button>
                              
                                </li>
                                <li class="nav-item">
                                                
				<button type="submit" class="btn btn-primary" formaction="removeconvidadoservlet" method="POST" >
					Remover
				</button>
                               </form>
                                </li>
                                </ul>
                               <%--    
                                <a class="nav-link active" href="listaconvidadosservlet" > Adicionar </a>
                                 
                               </li>
                                
                               <li class="nav-item">
                                   <a class="nav-link active" href=""> Remover </a>
                            </li>                       
                             </ul>     --%>
                    <br>
	<%--<form role="form" action="loginservlet" method="POST">			
            <button type="submit" class="btn btn-primary">
		Adicionar
	    </button>
	</form>       
            
	<form role="form" action="loginservlet" method="POST">			 
            <button type="submit" class="btn btn-primary">
		Remover
	    </button>
	</form>
	         --%>
                <h3> Lista de Convidados</h3>
                
                <c:forEach var="convidado" items="${ListaConvidados}">
               <%-- <div class="row">
                    <div class="col-md-2"> &nbsp; </div>
                    <div class="col-md-8">--%>
                        <ul>
                        <li><strong>${convidado.name}</strong></li>
                        
                        </ul>    
                   <%--  </div>
                    <div class="col-md-2"> &nbsp; </div>
                </div> --%>
                </c:forEach> 
                                
                                
                        <form role="form" action="homeservlet" method="GET">
                            <br>
                            <br>
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