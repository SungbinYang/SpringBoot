$(function() {
    $.ajax("http://localhost:8080/hello")
        .done(function(msg) {
            alert(msg);
        })
        .fail(function() {
            alert("fail")
        });
});