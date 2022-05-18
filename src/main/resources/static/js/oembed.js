
function search(){
    const value = document.getElementById("search").value;
    $.ajax({
        type: 'GET',
        url: "/search",
        data: {"value":value}
    })

}