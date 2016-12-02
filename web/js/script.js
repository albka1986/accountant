$(document).ready(function()

{
    $("#myTable").tablesorter();
}

);
$(document).ready(function() {

    $("#myTable").liveFilter('slide');

});

$(document).keydown(function (e) {
    // ESCAPE key pressed
    if (e.keyCode == 27) {
        window.location.href = "#";
    }
});

