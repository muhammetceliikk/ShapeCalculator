<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Shape Calculator</title>
</head>

<body>
<form action="/getShape" class="marginForm" method="post">
    <h2>Shape Calculator</h2><br>
    <label for="shape"><b>Shape:</b></label>
    <select name="shape" id="shape" required><br>
        <option value="rectangle">Rectangle</option>
        <option value="square">Square</option>
        <option value="sphere">Sphere</option>
    </select>
    <br><br>
    <b>Length:  </b><input id="length" type="text" name="length"/><br><br>
    <b>Width:   </b><input id="width" type="text" name="width"/><br><br>
    <b>Radius:  </b><input id="radius" type="text" name="radius"/><br><br>
    <br><br>
    <input type="submit" value="SAVE" onclick="alert('Shape Created')">
    <input type="button" onclick="location.href='/showShape';" value="Show List of Shapes" />
</form>
</body>

<script type="text/javascript">
    var shapeMenu = document.getElementById('shape');
    var length = document.getElementById('length');
    var width = document.getElementById('width');
    var radius = document.getElementById('radius')
    radius.disabled=true;

    shapeMenu.onchange = function(){

        var enableLength = false, enableWidth = false, enableRadius=false;
        switch(shapeMenu.options.selectedIndex){
            case 0:
                enableLength = true;
                enableWidth =  true;
                enableRadius= false;
                break;
            case 1:
                enableLength = true;
                enableWidth =  false;
                enableRadius= false;
                break;
            case 2:
                enableLength=false;
                enableWidth=false;
                enableRadius=true;
                break;
            default:
                break;
        }
        length.disabled = !enableLength;
        width.disabled = !enableWidth;
        radius.disabled=!enableRadius;
    }
</script>

</html>
