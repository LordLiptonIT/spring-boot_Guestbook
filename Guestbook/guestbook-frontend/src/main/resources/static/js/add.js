/**
 * Created by skyereh on 28.02.17.
 */
$(document).ready( function () {
    $(".successarea").hide();

    $("#send").on("click", function () {

        var data = {
                title: $("#title").val(),
                comment: $("#comment").val(),
                commenter: $("#commenter").val()
        };
        
        $.ajax({
            
            url:"http://localhost:8080/guestbook/",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (data) {
                $(".successarea").show();
                $("form").hide();
            },
            error: function (data) {
                alert("Bei unserem AJAX ist ein Fehler unterlaufen.");
            }
        });
    });
})