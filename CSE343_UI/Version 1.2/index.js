$(document).ready(function() {
    $("#list-program").click(function() {
        showPanel1();
    });
    function showPanel1() {
        if(document.getElementById('panel1').style.display === "block")
            document.getElementById('panel1').style.display = "none";
        else
            document.getElementById('panel1').style.display = "block";
        console.log("SELAMUN ALEYKÜM");
    }
});