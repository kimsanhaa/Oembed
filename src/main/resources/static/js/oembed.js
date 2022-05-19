
function search(){
    const url = document.getElementById("search").value;
    $.ajax({
        type: 'GET',
        url: "/search",
       data:{"url":url}
    })

}