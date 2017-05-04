



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
    <head>

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="bootstrap-3.3.6/docs/favicon.ico">

        <title>Descubre España</title>

        <!-- Bootstrap core CSS -->
        <link href="bootstrap-3.3.6/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="bootstrap-sass-3.3.6/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="navbar-static-top.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="bootstrap-sass-3.3.6/assets/js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <!-- Custom styles for this template -->
        <link href="bootstrap-3.3.6/docs/examples/carousel/carousel.css" rel="stylesheet">
        <link href="style.css" rel="stylesheet">

    </head>
    <style>
        #centrar{




            position: absolute;


            font-size: 5%;
            top:27%;

            left:45%;



            width:500px;



            margin-left:-500px;



            height:500px;



            margin-top:-150px;



            padding:5px;


        }
        #tamano{

            width:1px;
            font-size: 70%;
        }

        #tamano1{
            background: silver;
            opacity: 0.99;
        }

        #imagen{

            padding-top: 8%;
            padding-left: 35%;
            width: 1450px;
        }
    </style>    

    <body style="background-color: #4A7C59;">
        <div class="navbar-wrapper">
            <div class="container">
                <!-- Static navbar -->
                <nav class="navbar navbar-default navbar-static-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" >Descubre Madrid</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="http://localhost:8084/PruebaProyectoMaps/index.jsp">Home</a></li>

                                <li><a href="#contact">Contacto</a></li>

                            </ul>
                            <ul class="nav navbar-nav navbar-right">

                                <li> <a href="http://localhost:8084/PruebaProyectoMaps/mostrarRuta.jsp">Mostrar Ruta</a></li>
                                <li> <a href="http://localhost:8084/PruebaProyectoMaps/muestraLugarjsp">Mostrar lugares</a></li>

                            </ul>
                        </div><!--/.nav-collapse -->
                    </div>
                </nav>
            </div>
        </div>



        <div id="centrar">


            <table class="table table-striped" id="tamano1">
                <th><s:property value="imagenRuta"/></th>
                <th colspan="4">Zona de busqueda <s:property value="imagenRuta"/></th>
                <tr>
                    <td>Tramo  </td>
                    <td>Tiempo</td>
                    <td> Distancia</td>
                    <td> Indicaciones  </td>

                </tr>
                <s:iterator value="ruta">
                    <tr id="tamano">
                        <td ><s:property value="tramo"/></td>
                        <td><s:property value="tiempo"/></td>
                        <td ><s:property value="distancia"/></td>
                        <td><s:property value="indicaciones"/></td>
                    </tr>




                </s:iterator>

            </table>

        </div>
        <div id="imagen">
            <center><img src="foto\saved1.png" alt="no encuentra la imagen" width="50%" height="80%"/></center>
        </div>

        <!-- Bootstrap core JavaScript
       ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="bootstrap-sass-3.3.6/assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="bootstrap-3.3.6/dist/js/bootstrap.min.js"></script>
        <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
        <script src="bootstrap-sass-3.3.6/assets/js/vendor/holder.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="bootstrap-sass-3.3.6/assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
