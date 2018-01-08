$(document).ready(function() {
    $("#list-program").click(function() {
        showPanel1();
        showPanel2();
        
    });
    function showPanel1() {
        if(document.getElementById('panel1').style.display === "block")
            document.getElementById('panel1').style.display = "none";
        else
            document.getElementById('panel1').style.display = "block";

    }
    function showPanel2() {
        if(document.getElementById('panel2').style.display === "block")
            document.getElementById('panel2').style.display = "none";
        else
            document.getElementById('panel2').style.display = "block";

    }
});