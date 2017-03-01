/**
 * Created by skyereh on 28.02.17.
 */
$(document).ready( function () {

    $("#content").empty();

    var refresh = function () {

        $.get("http://localhost:8080/guestbook/", function (data) {

            for (var i = 0; i < data.length; i++) {
                var tr = $("<tr />");
                var td = $("<td />");

                td.append($("<div class='lead' />").text(data[i].title));
                td.append($("<div />").text(data[i].comment));
                td.append($("<div class='small text-muted' />").text(data[i].date + " von " + data[i].commenter));

                tr.append(td);
                $("#content").append(tr);
            }
        });
    };

    refresh();
    $("#refresh").on("click", refresh);
});