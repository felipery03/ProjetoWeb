<%@page import="br.com.listadecasamento.model.Passeio"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<jsp:useBean id="ListaPasseios" type="ArrayList<Passeio>" scope="request"/>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 4, from LayoutIt!</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>
      
      <script>
function myFunction() {
  var txt;
  if (confirm("Press a button!")) {
    txt = "You pressed OK!";
  } else {
    txt = "You pressed Cancel!";
  }
  document.getElementById("demo").innerHTML = txt;
}
</script>

	<div class="row">
               <div class="col-md-4">                
                </div>
		<div class="col-md-4">
			<h3 class="text-center">
				Casamento Bea e Felipe
			</h3>
                </div>
                <div class="col-md-2">                
                </div>
      
        </div>    
		<div class="row">
                    <div class="col-md-3">
                       
		    </div>
                    <div class="col-md-6" align="center"><p>
                        <h5> 
                        <p>
                        Como a maioria já sabe, nós há algum tempo já temos o nosso ninho montadinho.
                        Então queremos aproveitar para realizar um sonho nosso, viajar pelo mundo.
                        Para isso criamos as cotas de lua de mel com diversos passeios durante a viagem.
                        </p> 
                        </h5>
                    </div>
                    <div class="col-md-3">
                       
		    </div>
                </div>
        <br>
        <div class="row">
		<div class="col-md-12">
			<h3 class="text-center">
				Africa do Sul e Ilhas Maurício
			</h3>
                </div>
        </div>   
                    
        <br>
            
		<div class="row"> 
                    <div class="col-md-3">
                       
		    </div>
                    <div class="col-md-6">
                        <div class="columns">
                        <div class="row">
                            
            
                <c:forEach var="item" items="${ListaPasseios}">
                    <div class="column">
                    <img alt="Bootstrap Image Preview" src="${item.urlFoto}" align="center"  width="200">
                                <div  max-width="20" word-wrap="break-word">
                                  ${item.titulo} 
                                </div>
                                R$ ${item.preco}0 <br>
                                <a href="adicionaCarrinho?id=${item.id}">Comprar</a>
                             
                    </div> <br><br>
                                
                </c:forEach>
                            </div>
                            
                        </div>
		    </div>
                    <div class="col-md-3">
                       
		    </div>    
                   
                </div>    

        <br><br>
        <div class="row"> 
                    <div class="col-md-3">
                       
		    </div>
                    <div class="col-md-6"><
               
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


