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
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			
                    <h4 class="text-left">
                        Informações do Pedido
		    </h4>
                    <br>
                </div>
                <div class="col-md-2">
		</div>
	</div>
        <div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			
                    <div class="text-left">
                        Nome: ${User.name}<br><br>
                    </div>
                </div>
                    <br>
                <div class="col-md-2">
		</div>
	</div>
        <div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			
                    <div class="text-left">
                        Mensagem:<br>
                        ${Pedido.mensagem}
		    </div><br><br><br> 
                </div>
                    <br>
                <div class="col-md-2">
		</div>
	</div> 
         <div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			
                    <div class="text-left">
                       <h5> Presentes do Pedido</h5>
		    </div>
                    <br>
                </div>
                <div class="col-md-2">
		</div>
	</div>   
             
                
        <div class="row">
            <div class="col-md-2">
            </div>
            <div class="col-md-4">
                <div class="text-left">
                Passeio
                </div>
	    </div>
            <div class="col-md-2">
                Quantidade
	    </div>
            <br>
            <div class="col-md-2">
                Preço unitário
            </div>
            <div class="col-md-2">
            </div>
        </div>            
         <c:forEach var="item" items="${Pedido.carrinho.itens}">            
        <div class="row">
            <div class="col-md-2">
            </div>
		<div class="col-md-4">
                    <strong>${item.passeio.titulo}</strong>
		</div>
		<div class="col-md-2">
			
                    <div class="text-left">
                       ${item.qtde}
		    </div>
                </div>  <br>
        <div class="col-md-2">
            ${item.passeio.preco}
	</div>
        <div class="col-md-2">
        </div>
        </div>
        </c:forEach>
         <div class="row">
		<div class="col-md-2">
		</div>
             <div class="col-md-8"><br>
			
                <div class="text-left">
                    <strong>Valor total: ${Carrinho.total}</strong><br>
		</div>
                <br>
                </div>
               <div class="col-md-2">
          
		</div>  
         </div><br>
         <div class="row">
            <div class="col-md-12" align="center">
                &nbsp;
            </div>
        </div>
           <div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			
                    <ul class="nav">
                                <form role="form" method="GET"> 
                              <%-- <li class="nav-item">
                                                      
				<button type="submit" class="btn btn-primary" formaction=window.history.back() method="GET">
					Voltar
				</button>
                              
                                </li>--%>
                                <li class="nav-item">
                                                
				<button type="submit" class="btn btn-primary" formaction="finalizaPedido" method="GET" >
					Finaliza Pedido
				</button>
                               
                                </li>
                                
                                </ul>
                        
                </div>
                <div class="col-md-2">
		</div>
	</div> 
        
    </div>
    <script>
        function cancl() {
        window.history.go(-2);
    }
</script>
  <script>
function multiply (price, qtd) {
    return price*shipping;
    </script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>