<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Fibonacci wiecznie żywy</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body onload="myOnload()">
<br><br><br><br>
<form name="fibonacciForm" method="post">
    <div class="container" align="center">
        <div class="row">
            <h3>Podaj, który wyraz ciągu Fibonacciego chcesz wyświetlić:</h3>
            <br><br>
        </div>
        <div class="row">

            <div class="form-inline">
                <input type="number" class="form-control form-inline" id="f1" name="fibonacci"
                       placeholder="podaj wyraz ciągu">
                <button type="submit" class="btn btn-success" onclick="verBeforeSend()">Oblicz</button>
                <button type="reset" class="btn btn-warning" onclick="myReset()">Wyczyść</button>
            </div>
        </div>
    </div>
</form>


<br><br><br>
<div class="container" align="center" id="servletContent">
    <#if last??>
        <div class="row">
            <h4>Szukałeś ${requested?c!} słowa ciągu Fibonacciego, jego wartość to ${last?c!}. Pełny ciąg do
                wyrazu ${requested?c!} poniżej:</h4>
            <br><br>
        </div>

        <div align="center">
            <table>
                <tr align="left">
                    <#list fibAll! as fibs>
                <tr>
                    <td>${fibs!}</td>
                </tr>
                </#list>
                </tr>
            </table>
        </div>
    </#if>
</div>


<script type="text/javascript">

    function myOnload(){

        document.getElementById("f1").focus();
    }

    function verBeforeSend() {

        var fib = document.forms["fibonacciForm"]["f1"].value;

        if (fib < 0 || fib > 96) {
            window.alert("Błędny wyraz ciągu: " + fib + ". Musi zawierać się w przedziale [0,96]");
            myReset();
        } else if (fib == null || fib == "") {
            window.alert("Coś poszło nie tak, spróbuj ponownie");
            myReset();
        } else {
            form.action("/");
        }
    }

    function myReset() {

        document.forms["fibonacciForm"].reset();
        document.getElementById("servletContent").remove();
        document.getElementById("f1").focus();
    }

</script>
</body>
</html>